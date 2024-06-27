package com.example.bankerror.utils

fun regex(input: String): String {
    if (input.matches("0+".toRegex())) return ""
    val regex = """^[0-9.]+${'$'}'""".toRegex()
    regex.matches(input)
    return input
}