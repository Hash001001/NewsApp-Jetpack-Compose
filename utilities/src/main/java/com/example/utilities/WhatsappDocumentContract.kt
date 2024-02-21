package com.example.utilities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Parcelable
import android.os.storage.StorageManager
import androidx.activity.result.contract.ActivityResultContract
import com.example.utilities.Constants.whatsappUriForMatching

class WhatsappDocumentContract:  ActivityResultContract<Uri?, Uri?>() {


    private fun getRootFolderPath(): String {
        return "Android%2Fmedia%2Fcom.whatsapp%2FWhatsApp%2FMedia%2F.Statuses"
    }

    override fun createIntent(context: Context, input: Uri?): Intent {
        val intent: Intent
        val storageManager = context.getSystemService(Context.STORAGE_SERVICE) as StorageManager
        val yourFolderPath: String = getRootFolderPath()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent = storageManager.primaryStorageVolume.createOpenDocumentTreeIntent()
            val replace =
                (intent.getParcelableExtra(
                    "android.provider.extra.INITIAL_URI",
                    Parcelable::class.java
                ) as Uri).toString()
                    .replace("/root/", "/document/")
            intent.putExtra(
                "android.provider.extra.INITIAL_URI",
                Uri.parse("$replace%3A$yourFolderPath")
            )
            whatsappUriForMatching = Uri.parse("$replace%3A$yourFolderPath")
        }else {
            //for our case this is useless because for P and Q we are using normal scenario
            intent = Intent("android.intent.action.OPEN_DOCUMENT_TREE")
            intent.putExtra(
                "android.provider.extra.INITIAL_URI",
                Uri.parse("content://com.android.externalstorage.documents/document/primary%3A$yourFolderPath")
            )
            whatsappUriForMatching =
                Uri.parse("content://com.android.externalstorage.documents/document/primary%3A$yourFolderPath")
        }
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true)

        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.addFlags(Intent.FLAG_GRANT_PREFIX_URI_PERMISSION)
        intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)

        return intent

    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        return intent?.data
    }

}