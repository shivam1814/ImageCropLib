package com.shivam.imagecrop

import android.app.Activity
import android.content.Intent

object CropContract {
    const val RESULT_URI = "cropped_uri"

    fun startCrop(activity: Activity, requestCode: Int = 101) {
        val intent = Intent(activity, ImageCropperActivity::class.java)
        activity.startActivityForResult(intent, requestCode)
    }
}
