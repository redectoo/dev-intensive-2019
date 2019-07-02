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


    fun transliteration(payload: String, divider: String = " "): String {

        val map = mapOf(
            'а' to "a",
            'б' to "b",
            'в' to "v",
            'г' to "g",
            'д' to "d",
            'е' to "e",
            'ё' to "e",
            'ж' to "zh",
            'з' to "z",
            'и' to "i",
            'й' to "i",
            'к' to "k",
            'л' to "l",
            'м' to "m",
            'н' to "n",
            'о' to "o",
            'п' to "p",
            'р' to "r",
            'с' to "s",
            'т' to "t",
            'у' to "u",
            'ф' to "f",
            'х' to "h",
            'ц' to "c",
            'ч' to "ch",
            'ш' to "sh",
            'щ' to "sh",
            'ъ' to "",
            'ы' to "i",
            'ь' to "",
            'э' to "e",
            'ю' to "yu",
            'я' to "ya"
        )

        val stroke = buildString {
            payload.forEach {
                append(
                    when {
                        it == ' ' -> divider
                        it.isUpperCase() -> map[it.toLowerCase()]?.capitalize() ?: it.toString()
                        else -> map[it] ?: it.toString()
                    }
                )
            }
        }

        return stroke
    }


    fun toInitials(firstName: String?, lastName: String?): String? {


        val name = firstName?.trim1(' ')?.getOrNull(0)?.toUpperCase()?.toString() ?: ""
        val family = lastName?.trim1(' ')?.getOrNull(0)?.toUpperCase()?.toString() ?: ""

        return "$name$family".ifEmpty { null }

    }


}


