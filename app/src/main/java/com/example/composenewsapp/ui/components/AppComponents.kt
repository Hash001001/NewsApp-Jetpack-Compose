package com.example.composenewsapp.ui.components

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composenewsapp.R
import com.example.composenewsapp.data.entity.Article
import com.example.composenewsapp.data.entity.NewResponse
import com.example.utilities.Constants
import com.example.utilities.StorageUtil
import com.example.utilities.WhatsappDocumentContract

@Composable
fun Loader(visible: Boolean = true) {

    Log.d("NextScreen", "Loader: visibility -> ${visible} ")

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        AnimatedVisibility(visible = visible) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .padding(12.dp),
                color = Color.Black
            )
        }
    }
}

@Composable
fun NewsList(res: NewResponse, showNextButton: Boolean = true, onClick: () -> Unit) {
    LazyColumn() {
        items(res.articles) {
            NormalTextComponent(it.description.toString(), showNextButton) {
                onClick()
            }
        }
    }
}

@Composable
fun NormalTextComponent(text: String, showNextButton: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = text, modifier = Modifier
                .wrapContentHeight(),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                color = Color.Gray
            )
        )

        AnimatedVisibility(visible = showNextButton) {
            Button(onClick = { onClick() }) {
                Text(text = "Next")
            }
        }

    }
}

@Composable
fun NewsRowComponent(page: Int, res: Article, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = res.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_menu_active_job),
            error = painterResource(id = R.drawable.ic_menu_active_job)
        )

        Spacer(modifier = Modifier.size(12.dp))


        HeadingTextComponent(res.title.toString())

        Spacer(modifier = Modifier.size(12.dp))

        NormalTextComponent(text = res.description.toString(), showNextButton = false) {}


        Spacer(modifier = Modifier.weight(1f))

        SourceDetailComponent(authorName = res.author ?: "", sourceName = res.source?.name ?: "")


    }

}

@Composable
fun HeadingTextComponent(text: String) {
    Text(
        text = text, modifier = Modifier
            .wrapContentHeight(), style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace
        )
    )
}

@Composable
fun SourceDetailComponent(authorName: String, sourceName: String) {

    Log.d("SourceData", "SourceDetailComponent: -> ${authorName} and Source -> ${sourceName}")
    Row(modifier = Modifier.padding(8.dp)) {
        Text(text = authorName)
        Spacer(modifier = Modifier.weight(1f))

        Text(text = sourceName)
    }
}

@Composable
fun LoadDataButton(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text(text = "Load Data")
    }

}

@Composable
fun WhatsappPath(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    val whatsappPermissionLauncher =
        rememberLauncherForActivityResult(contract = WhatsappDocumentContract(),
            onResult = { result ->
                if (result != null) {
                    val strResult: String =
                        result.toString().substring(result.toString().lastIndexOf("/"))

                    val actualSelectedUri: String = Constants.whatsappUriForMatching.toString()
                        .substring(Constants.whatsappUriForMatching.toString().lastIndexOf("/"))
                    if (actualSelectedUri == strResult) {
                        val takeFlags =
                            (Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                        context.contentResolver.takePersistableUriPermission(result, takeFlags)

                        //Permission Granted Save It In SharedPreference
                        Toast.makeText(context,"Permission Granted",Toast.LENGTH_SHORT).show()
                    } else {
                        //Selected Wrong Locations
                        Toast.makeText(
                            context, "Selected Wrong Whatsapp Locations", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(modifier = Modifier
            .padding(horizontal = 30.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .height(45.dp)
            .clickable {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    if (!StorageUtil.isWhatsappUriPermissionGranted(context)) {
                        whatsappPermissionLauncher.launch(null)
                    } else {
                        //Permission Given Do your work
                        Toast.makeText(context,"Permission Granted",Toast.LENGTH_SHORT).show()
                    }

                } else {
                    //Request For Write External Storage Permission
                }
            }
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFF4CDBC),
                        Color(0xFFCACFF9),
                    )
                )
            ), contentAlignment = Alignment.Center) {
            Text("Allow Permission", color = Color.Black)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    //Loader()
    val article = Article(
        author = "Mr. Jo",
        content = "COntent",
        null,
        null,
        null,
        null,
        null,
        null
    )
    NewsRowComponent(0, article) {

    }
}