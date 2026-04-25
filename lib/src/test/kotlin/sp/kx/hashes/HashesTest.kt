package sp.kx.hashes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.security.MessageDigest

internal object HashesTest {
    private val issuers = mapOf(
        "md5" to Hashes.MD5,
        "sha1" to Hashes.SHA1,
        "sha256" to Hashes.SHA256,
        "sha512" to Hashes.SHA512,
    )

    @Test
    fun digestByteArrayTest() {
        val encoded = "foo bar baz".toByteArray(Charsets.UTF_8)
        issuers.forEach { (algorithm, hashes) ->
            val md = MessageDigest.getInstance(algorithm)
            val expected = md.digest(encoded)
            val actual = hashes.digest(encoded = encoded)
            assertTrue(expected.contentEquals(actual))
        }
    }

    @Test
    fun digestByteTest() {
        val byte: Byte = 0x42
        issuers.forEach { (algorithm, hashes) ->
            val md = MessageDigest.getInstance(algorithm)
            md.update(byte)
            val expected = md.digest()
            val actual = hashes.digest(byte = byte)
            assertTrue(expected.contentEquals(actual))
        }
    }

    @Test
    fun sizeTest() {
        issuers.forEach { (algorithm, hashes) ->
            val md = MessageDigest.getInstance(algorithm)
            assertEquals(md.digestLength, hashes.size)
        }
    }

    @Test
    fun emptyTest() {
        val encoded = byteArrayOf()
        issuers.forEach { (algorithm, hashes) ->
            val md = MessageDigest.getInstance(algorithm)
            val expected = md.digest(encoded)
            val actual = hashes.empty
            assertTrue(expected.contentEquals(actual))
        }
    }
}
