package sp.kx.hashes

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.HexFormat

internal class HashesTest {
    @Test
    fun md5Test() {
        val hashes: Hashes = Hashes.MD5
        val bytes = "foo bar baz".toByteArray()
        val actual = hashes.map(bytes = bytes)
        val expected = HexFormat.of().parseHex("ab07acbb1e496801937adfa772424bf7")
        assertTrue(expected.contentEquals(actual))
    }

    @Test
    fun sha1Test() {
        val hashes: Hashes = Hashes.SHA1
        val bytes = "foo bar baz".toByteArray()
        val actual = hashes.map(bytes = bytes)
        val expected = HexFormat.of().parseHex("c7567e8b39e2428e38bf9c9226ac68de4c67dc39")
        assertTrue(expected.contentEquals(actual))
    }
}
