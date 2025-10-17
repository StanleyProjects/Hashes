package sp.kx.hashes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.HexFormat

internal class RealHashesTest {
    @Test
    fun sizeTest() {
        assertEquals(16, RealHashes(algorithm = "MD5").size)
        assertEquals(20, RealHashes(algorithm = "SHA1").size)
        assertEquals(32, RealHashes(algorithm = "SHA256").size)
        assertEquals(64, RealHashes(algorithm = "SHA512").size)
    }

    @Test
    fun digestTest() {
        val hashes = RealHashes(algorithm = "MD5")
        val bytes = "foo bar baz".toByteArray()
        val actual = hashes.map(bytes = bytes)
        val expected = HexFormat.of().parseHex("ab07acbb1e496801937adfa772424bf7")
        assertTrue(expected.contentEquals(actual))
    }
}
