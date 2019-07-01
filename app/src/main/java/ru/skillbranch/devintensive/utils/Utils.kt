package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder
import kotlin.text.trim as trim1

object Utils {


    fun parseFullName(fullName: String?): Pair<String?, String?> {


        val stroke = fullName?.trim1(' ')?.split(" ")?.filter { it.trim1(' ') != "" }

        val firstName = stroke?.getOrNull(0)
        val lastName = stroke?.getOrNull(1)

        return firstName to lastName



    }


    fun check_translite(variable: String?): String {
        var stringBuilder = StringBuilder("")
        variable?.forEach {
            when (it) {
                'а' -> stringBuilder.append("a")

                'б' -> stringBuilder.append("b")

                'в' -> stringBuilder.append("v")

                'г' -> stringBuilder.append("g")

                'д' -> stringBuilder.append("d")

                'е' -> stringBuilder.append("e")

                'ё' -> stringBuilder.append("e")

                'ж' -> stringBuilder.append("zh")

                'з' -> stringBuilder.append("z")

                'и' -> stringBuilder.append("i")

                'й' -> stringBuilder.append("i")

                'к' -> stringBuilder.append("k")

                'л' -> stringBuilder.append("l")

                'м' -> stringBuilder.append("m")

                'н' -> stringBuilder.append("n")

                'о' -> stringBuilder.append("o")

                'п' -> stringBuilder.append("p")

                'р' -> stringBuilder.append("r")

                'с' -> stringBuilder.append("s")

                'т' -> stringBuilder.append("t")

                'у' -> stringBuilder.append("u")

                'ф' -> stringBuilder.append("f")

                'х' -> stringBuilder.append("h")

                'ц' -> stringBuilder.append("c")

                'ч' -> stringBuilder.append("ch")

                'ш' -> stringBuilder.append("sh")

                'щ' -> stringBuilder.append("sh")

                'ъ' -> stringBuilder.append("")

                'ы' -> stringBuilder.append("i")

                'ь' -> stringBuilder.append("")

                'э' -> stringBuilder.append("e")

                'ю' -> stringBuilder.append("yu")

                'я' -> stringBuilder.append("ya")


                'А' -> stringBuilder.append("A")

                'Б' -> stringBuilder.append("B")

                'В' -> stringBuilder.append("V")

                'Г' -> stringBuilder.append("G")

                'Д' -> stringBuilder.append("D")

                'Е' -> stringBuilder.append("E")

                'Ё' -> stringBuilder.append("E")

                'Ж' -> stringBuilder.append("Zh")

                'З' -> stringBuilder.append("Z")

                'И' -> stringBuilder.append("I")

                'Й' -> stringBuilder.append("I")

                'К' -> stringBuilder.append("K")

                'Л' -> stringBuilder.append("L")

                'М' -> stringBuilder.append("M")

                'Н' -> stringBuilder.append("N")

                'О' -> stringBuilder.append("O")

                'П' -> stringBuilder.append("P")

                'Р' -> stringBuilder.append("R")

                'С' -> stringBuilder.append("S")

                'Т' -> stringBuilder.append("T")

                'У' -> stringBuilder.append("U")

                'Ф' -> stringBuilder.append("F")

                'Х' -> stringBuilder.append("H")

                'Ц' -> stringBuilder.append("C")

                'Ч' -> stringBuilder.append("Ch")

                'Ш' -> stringBuilder.append("Sh")

                'Щ' -> stringBuilder.append("Sh")

                'Ъ' -> stringBuilder.append("")

                'Ы' -> stringBuilder.append("I")

                'Ь' -> stringBuilder.append("")

                'Э' -> stringBuilder.append("E")

                'Ю' -> stringBuilder.append("Yu")

                'Я' -> stringBuilder.append("Ya")
                else -> stringBuilder.append(it)


            }
        }
        return stringBuilder.toString()
    }


    fun transliteration(payload: String, divider: String = " "): String {


        val (firstName, lastName) = parseFullName(payload)

        val strokeFirst = check_translite(firstName)
        val strokeTwo = check_translite(lastName)


        return strokeFirst + divider + strokeTwo
    }


    fun toInitials(firstName: String?, lastName: String?): String? {


        var strokeFirst: String?
        var strokeTwo: String?




        if (firstName == null) {
            strokeFirst = null
        } else if (firstName.isBlank()) {
            strokeFirst = ""
        } else {
            strokeFirst = firstName.trim1(' ').get(0).toUpperCase().toString()

        }

        if (lastName == null) {
            strokeTwo = null
        } else if (lastName.isBlank()) {
            strokeTwo = ""
        } else {

            strokeTwo = lastName.trim1(' ').get(0).toUpperCase().toString()


        }


        if ((strokeFirst == null && strokeTwo == null) || (strokeFirst == "" && strokeTwo == "")) {
            return null
        } else {
            return "${if (strokeFirst != "") strokeFirst else ""}${if (strokeTwo != null) strokeTwo else ""}"
        }

    }


}


