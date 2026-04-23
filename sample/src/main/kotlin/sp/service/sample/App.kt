package sp.service.sample

import sp.kx.hashes.Hashes
import java.util.Locale

private fun Int.hex(locale: Locale = Locale.US): String {
    return String.format(locale, "%02x", and(0xff))
}

private fun ByteArray.hex(locale: Locale = Locale.US): String {
    if (isEmpty()) return ""
    val builder = StringBuilder()
    builder.append(get(0).toInt().hex(locale))
    for (i in 1 until size) {
        builder.append(get(i).toInt().hex(locale))
    }
    return builder.toString()
}

fun main() {
    val str = "foo bar baz"
    println("str(${str.length}): \"$str\"")
    val encoded = str.toByteArray(Charsets.UTF_8)
    println("encoded(${encoded.size}): ${encoded.hex()}")
    val sha256 = Hashes.SHA256.digest(encoded = encoded)
    println("sha256(${sha256.size}): ${sha256.hex()}")
}
