package ru.skillbranch.devintensive.extensions

import android.view.View
import android.view.inputmethod.InputMethodManager
import  android.app.Activity as ActivityOriginal

fun hideKeyboard(activity: ActivityOriginal) {
    val imm = activity.getSystemService(ActivityOriginal.INPUT_METHOD_SERVICE) as InputMethodManager
    //Find the currently focused view, so we can grab the correct window token from it.
    var view = activity.currentFocus
    //If no view currently has focus, create a new one, just so we can grab a window token from it
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}