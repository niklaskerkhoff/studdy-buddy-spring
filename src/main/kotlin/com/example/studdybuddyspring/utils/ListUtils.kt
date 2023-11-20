package com.example.studdybuddyspring.utils

fun <T> List<T>.findIndexOrNull(predicate: (T) -> Boolean): Int? {
    val index = indexOfFirst(predicate)
    if (index < 0) return null
    return index
}
