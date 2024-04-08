package me.nathanfallet.groupeminaste.extensions

fun String.Companion.generateId(): String {
    val charPool: List<Char> = ('a'..'z') + ('0'..'9')
    return List(32) { charPool.random() }.joinToString("")
}
