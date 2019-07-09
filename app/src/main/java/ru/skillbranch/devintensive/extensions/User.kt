package ru.skillbranch.devintensive.extensions

import org.jsoup.Jsoup
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView():UserView{

    val nickname= Utils.transliteration("$firstName $lastName")
        val initials=Utils.toInitials(firstName, lastName)
            val status=if(lastVisit==null)"Еще ни разу не был" else if(isOnline)"online" else "послдений раз был ${lastVisit!!.humanizeDiff()}"


    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName =nickname,
        initials = initials,
        avatar = avatar,
        status =status


    )

}

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


fun String.stripHtml()= Jsoup.parse(this).text()