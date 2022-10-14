package com.caioernandes.common.widgets

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView(
    context: Context,
    attrs: AttributeSet? = null,
) : AppCompatTextView(context, attrs) {

    fun setBoldText(text: String) {
        this.typeface = Typeface.DEFAULT_BOLD
        this.text = text
    }

    fun setNormalText(text: String) {
        this.typeface = Typeface.DEFAULT
        this.text = text
    }

    fun setTextColorRes(color: Int) {
        this.setTextColor(color)
    }
}