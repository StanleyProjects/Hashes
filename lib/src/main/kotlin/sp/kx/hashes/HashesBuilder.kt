package sp.kx.hashes

import java.security.MessageDigest

class HashesBuilder internal constructor(algorithm: String) {
    private val md = MessageDigest.getInstance(algorithm)

    fun update(byte: Byte): HashesBuilder {
        md.update(byte)
        return this
    }

    fun update(encoded: ByteArray): HashesBuilder {
        md.update(encoded)
        return this
    }

    fun digest(byte: Byte): ByteArray {
        md.update(byte)
        return md.digest()
    }

    fun digest(encoded: ByteArray): ByteArray {
        return md.digest(encoded)
    }

    fun digest(): ByteArray {
        return md.digest()
    }
}
