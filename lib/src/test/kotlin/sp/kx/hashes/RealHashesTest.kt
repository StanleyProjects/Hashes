package sp.kx.hashes

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.HexFormat

internal class RealHashesTest {
    @Test
    fun digestTest() {
        val hashes = RealHashes(algorithm = "MD5")
        val bytes = "foo bar baz".toByteArray()
        val actual = hashes.map(bytes = bytes)
        val expected = HexFormat.of().parseHex("ab07acbb1e496801937adfa772424bf7")
        assertTrue(expected.contentEquals(actual))
    }
}
