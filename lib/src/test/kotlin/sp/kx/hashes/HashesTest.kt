package sp.kx.hashes

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.security.MessageDigest

internal object HashesTest {
    @Test
    fun digestTest() {
        val encoded = "foo bar baz".toByteArray(Charsets.UTF_8)
        mapOf(
            "md5" to Hashes.MD5,
            "sha1" to Hashes.SHA1,
            "sha256" to Hashes.SHA256,
            "sha512" to Hashes.SHA512,
        ).forEach { (algorithm, hashes) ->
            val md = MessageDigest.getInstance(algorithm)
            val expected = md.digest(encoded)
            val actual = hashes.digest(encoded = encoded)
            assertTrue(expected.contentEquals(actual))
        }
    }
}
