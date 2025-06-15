package com.shivam.imagecrop

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import com.yalantis.ucrop.UCrop
import java.io.File

class ImageCropperActivity : ComponentActivity() {

    private val pickImage =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let { launchCrop(uri) } ?: finish()
        }

    private fun launchCrop(sourceUri: Uri) {
        val destinationUri = Uri.fromFile(File(cacheDir, "cropped.jpg"))

        UCrop.of(sourceUri, destinationUri)
            .withAspectRatio(1f, 1f)
            .start(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pickImage.launch("image/*")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == UCrop.REQUEST_CROP) {
            val resultUri = UCrop.getOutput(data!!)
            val resultIntent = Intent().apply {
                putExtra(CropContract.RESULT_URI, resultUri.toString())
            }
            setResult(RESULT_OK, resultIntent)
        }
        finish()
    }
}
