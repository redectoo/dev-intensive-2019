package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {


    var time = this.time


    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY

    }
    this.time = time
    return this
}


fun Date.humanizeDiff(date: Date = Date()): String {
    val raznica = (date.time - this.time) / 1000

    var stroke: String="Здесь ничиго нет"




    if (raznica in 0 until 1) {
        stroke = "только что"
    } else if (raznica in 1 until 45) {
        stroke = "несколько секунд назад"
    } else if (raznica in 45 until 75) {
        stroke = "минуту назад"
    } else if (raznica in 75 until 2700) {

        val numberWithOutOne = (raznica / 60).toInt()
        val numberOne = numberWithOutOne + 1


        val N = if (raznica % 60 > 0) numberOne else numberWithOutOne

        stroke = if (N % 10 == 1) "$N минуту назад" else if ((N % 10) in 2..4) "$N минуты назад" else "$N минут назад"


    } else if (raznica in 2700 until 4500) {
        stroke = "час назад"
    } else if (raznica in 4500 until 79200) {


        val numberWithOutOne = (raznica / 3600).toInt()
        val numberOne = numberWithOutOne + 1


        val N = if (raznica % 3600 > 0) numberOne else numberWithOutOne

        stroke = if (N % 10 == 1) "$N час назад" else if ((N % 10) in 2..4) "$N часа назад" else "$N часов назад"

    } else if (raznica in 79200 until 93600) {
        stroke = "день назад"
    } else if (raznica in 93600 until 31104000) {

        val numberWithOutOne = (raznica / 86400).toInt()
        val numberOne = numberWithOutOne + 1


        val N = if (raznica % 86400 > 0) numberOne else numberWithOutOne

        stroke = if (N % 10 == 1) "$N день назад" else if ((N % 10) in 2..4) "$N дня назад" else "$N дней назад"

    } else if(raznica>=86400) {
        stroke = "более года назад"
    } else if (raznica in -1 until 0) {   //Начало будущего
        stroke = "секунду до"
    } else if (raznica in -45 until -1) {
        stroke = "через несколько секунд назад"
    } else if (raznica in -75 until -45) {
        stroke = "через минуту"
    } else if (raznica in -2700 until -75 ) {

        val numberWithOutOne = ((-1)*raznica / 60).toInt()
        val numberOne = numberWithOutOne + 1


        val N = if ((-1)*raznica % 60 > 0) numberOne else numberWithOutOne

        stroke = if (N % 10 == 1) "через $N минуту" else if ((N % 10) in 2..4) "через $N минуты" else "через $N минут"


    } else if (raznica in -4500 until -2700 ) {
        stroke = "через час"
    } else if (raznica in -79200 until -4500) {


        val numberWithOutOne = ((-1)*raznica / 3600).toInt()
        val numberOne = numberWithOutOne + 1


        val N = if ((-1)*raznica % 3600 > 0) numberOne else numberWithOutOne

        stroke = if (N % 10 == 1) "через $N час" else if ((N % 10) in 2..4) "через $N часа" else "через $N часов"

    } else if (raznica in -93600 until -79200 ) {
        stroke = "через день"
    } else if (raznica in -31104000 until -93600 ) {

        val numberWithOutOne = ((-1)*raznica / 86400).toInt()
        val numberOne = numberWithOutOne + 1


        val N = if ((-1)*raznica % 86400 > 0) numberOne else numberWithOutOne

        stroke = if (N % 10 == 1) "через $N день" else if ((N % 10) in 2..4) "через $N дня" else "через $N дней"

    } else if(raznica<=-86400) {
        stroke = "более чем через год"
    }





    return stroke

}


enum class TimeUnits(val One:String, val Two:String,val Zero:String) {
    SECOND("секунда","секунды","секунд"),
    MINUTE("минута","минуты","минут"),
    HOUR("час","часа","часов"),
    DAY("день","дня","дней");

    fun plural(value:Int):String{
        return "$value ${if (Math.abs(value%10)==0|| (Math.abs(value%100) in 11..19)||(Math.abs(value%10) in 5..9)) Zero
        else if(Math.abs(value%10) in 2..4)Two else One}"

    }




}