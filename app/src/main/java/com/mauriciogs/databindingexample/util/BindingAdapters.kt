package com.mauriciogs.databindingexample.util

import android.content.Context
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.mauriciogs.databindingexample.R
import com.mauriciogs.databindingexample.data.Disponibility

@BindingAdapter("app:outOfStock")
fun underlineText(view: TextView, stock : Int) {
    if (stock == 0) view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
}

@BindingAdapter("app:stockIcon")
fun popularityIcon(view: ImageView, disponibility: Disponibility) {

    view.setImageDrawable(getDrawablePopularity(disponibility, view.context))
}

private fun getDrawablePopularity(disponibility: Disponibility, context: Context): Drawable? {
    return when (disponibility) {
        Disponibility.LOW -> {
            ContextCompat.getDrawable(context, R.drawable.ic_dot_red)
        }
        Disponibility.NORMAL -> {
            ContextCompat.getDrawable(context, R.drawable.ic_dot_yellow)
        }
        Disponibility.HIGH -> {
            ContextCompat.getDrawable(context, R.drawable.ic_dot_green)
        }
    }
}