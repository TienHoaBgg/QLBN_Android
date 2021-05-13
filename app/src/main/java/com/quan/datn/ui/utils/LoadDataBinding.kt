package com.quan.datn.ui.utils

import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.quan.datn.R

class LoadDataBinding {
    companion object {

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(iv: ImageView, link: String?) {
            if (StringUtils.isNotBlank(link)){
                Glide.with(iv)
                    .load(R.drawable.avatar)
                    .into(iv)
            } else {
                Glide.with(iv)
                    .load(link)
                    .placeholder(R.drawable.avatar)
                    .error(R.drawable.avatar)
                    .into(iv)
            }
        }

        @JvmStatic
        @BindingAdapter("updateText")
        fun updateText(tv: TextView, value: String?) {
            tv.text = value
            if (value == ""){
                tv.visibility = View.GONE
            }
        }

        @JvmStatic
        @BindingAdapter("updateGenderNam")
        fun updateGenderNam(rb: RadioButton, value: String?) {
            if (value != null) {
                rb.isChecked = value.contains("Nam")
            }
        }

        @JvmStatic
        @BindingAdapter("updateGenderNu")
        fun updateGenderNu(rb: RadioButton, value: String?) {
            if (value != null) {
                rb.isChecked = value.contains("Nữ")
            }
        }


    }
}