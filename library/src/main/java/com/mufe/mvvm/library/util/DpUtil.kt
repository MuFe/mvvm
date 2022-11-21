package com.mufe.mvvm.library.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class DpUtil {


    fun dpToPx(context: Context, dp:Int):Int{
        return (dp*context.resources.displayMetrics.density-0.5f).toInt()
    }

    fun dp2px(context: Context, dp: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    fun sp2px(context: Context, sp: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (sp * fontScale + 0.5f).toInt()
    }
}
