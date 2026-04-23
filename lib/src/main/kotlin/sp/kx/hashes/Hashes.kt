package sp.kx.hashes

import java.security.MessageDigest

class Hashes private constructor(algorithm: String) {
    private val md = MessageDigest.getInstance(algorithm)
    val size = md.digestLength

    fun digest(encoded: ByteArray): ByteArray {
        return md.digest(encoded)
    }

    companion object {
        val SHA256 = Hashes(algorithm = "sha256")
    }
}
