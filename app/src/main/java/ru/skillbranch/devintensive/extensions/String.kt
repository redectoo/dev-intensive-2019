package ru.skillbranch.devintensive.extensions



fun String.truncate(number: Int =16):String{
    var value:String

    when{
        this.isNullOrBlank()-> value=""
        this.length<=number-> value=this
        else->value=this.substring(0,number)

    }

    // val stroke=value.trim(' ')+"..."
    // return value.trim(' ')+"..."

    return if(value=="")"" else value.trim(' ')+"..."



}


//fun String.stripHtml()= Jsoup.parse(this).text()