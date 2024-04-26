package com.albert.alberttailoremployees.utils

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

object NavigationUtils {

    fun setUpBackButton(activity: AppCompatActivity, imageView: ImageView) {
        imageView.setOnClickListener {
            activity.onBackPressed()
        }
    }
}