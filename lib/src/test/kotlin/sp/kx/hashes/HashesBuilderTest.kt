package sp.kx.hashes

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.security.MessageDigest

internal object HashesBuilderTest {
    private val issuers = mapOf(
        "md5" to Hashes.MD5,
        "sha1" to Hashes.SHA1,
        "sha256" to Hashes.SHA256,
        "sha512" to Hashes.SHA512,
    )

    @Test
    fun digestByteArrayTest() {
        val p0 = byteArrayOf(0x00, 0x01, 0x02, 0x03)
        val p1 = byteArrayOf(0x10, 0x11, 0x12, 0x13)
        issuers.forEach { (algorithm, hashes) ->
            val md = MessageDigest.getInstance(algorithm)
            md.update(p0)
            md.update(p1)
            val expected = md.digest()
            val actual = hashes.update(p0).digest(p1)
            assertTrue(expected.contentEquals(actual))
        }
    }

    @Test
    fun digestByteTest() {
        val b0: Byte = 0x00
        val b1: Byte = 0x10
        issuers.forEach { (algorithm, hashes) ->
            val md = MessageDigest.getInstance(algorithm)
            md.update(b0)
            md.update(b1)
            val expected = md.digest()
            val actual = hashes.update(b0).digest(b1)
            assertTrue(expected.contentEquals(actual))
        }
    }
}
