package ru.skillbranch.devintensive.extensions

import android.view.View
import android.view.inputmethod.InputMethodManager
import  android.app.Activity

fun Activity.hideKeyboard() {
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = this.currentFocus

    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}