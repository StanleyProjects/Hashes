package sp.kx.hashes

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.HexFormat

internal object HashesTest {
    @Test
    fun sha256DigestTest() {
        val encoded = "foo bar baz".toByteArray(Charsets.UTF_8)
        val hex = "dbd318c1c462aee872f41109a4dfd3048871a03dedd0fe0e757ced57dad6f2d7"
        val expected = HexFormat.of().parseHex(hex)
        val actual = Hashes.SHA256.digest(encoded = encoded)
        assertTrue(expected.contentEquals(actual))
    }
}
