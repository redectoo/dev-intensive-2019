package ru.skillbranch.devintensive.extensions

import android.view.View
import android.view.inputmethod.InputMethodManager
import  android.app.Activity
import android.graphics.Rect

fun Activity.hideKeyboard() {
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = this.currentFocus

    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.isKeyboardClosed():Boolean{
    val decorView = this.window.decorView

    val rect = Rect()
    decorView.getWindowVisibleDisplayFrame(rect)

    val displayHight = rect.bottom - rect.top
    val hight = decorView.height

    if(displayHight.toDouble() / hight > 0.8){
        return true
    }
        return false



}




fun Activity.isKeyboardOpen()=!isKeyboardClosed()
