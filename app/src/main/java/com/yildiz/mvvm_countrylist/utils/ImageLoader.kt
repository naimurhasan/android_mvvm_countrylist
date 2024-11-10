package com.yildiz.mvvm_countrylist.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.decode.SvgDecoder
import coil.load

object ImageLoader {
    fun loadImage(imageView: ImageView, url: String?, context: Context){
        imageView.load(url){
            decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
            placeholder(circularProgress(context))
            error(android.R.drawable.ic_menu_report_image)
            crossfade(true)
        }
    }

    private  fun circularProgress(context: Context) : CircularProgressDrawable {
        return CircularProgressDrawable(context).apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }
    }

}