package sp.kx.hashes

import java.security.MessageDigest

class HashesBuilder internal constructor(algorithm: String) {
    private val md = MessageDigest.getInstance(algorithm)

    fun update(encoded: ByteArray): HashesBuilder {
        md.update(encoded)
        return this
    }

    fun digest(encoded: ByteArray): ByteArray {
        return md.digest(encoded)
    }

    fun digest(): ByteArray {
        return md.digest()
    }
}
