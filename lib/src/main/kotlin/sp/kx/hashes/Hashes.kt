package sp.kx.hashes

import java.security.MessageDigest

class Hashes private constructor(algorithm: String) {
    private val md = MessageDigest.getInstance(algorithm)
    val size = md.digestLength
    val empty = md.digest()

    fun digest(byte: Byte): ByteArray = synchronized(this) {
        md.update(byte)
        md.digest()
    }

    fun digest(encoded: ByteArray): ByteArray = synchronized(this) {
        md.digest(encoded)
    }

    fun builder(): HashesBuilder {
        return HashesBuilder(algorithm = md.algorithm)
    }

    fun update(byte: Byte): HashesBuilder {
        return HashesBuilder(algorithm = md.algorithm).update(byte)
    }

    fun update(encoded: ByteArray): HashesBuilder {
        return HashesBuilder(algorithm = md.algorithm).update(encoded)
    }

    companion object {
        val MD5 = Hashes(algorithm = "md5")
        val SHA1 = Hashes(algorithm = "sha1")
        val SHA256 = Hashes(algorithm = "sha256")
        val SHA512 = Hashes(algorithm = "sha512")
    }
}
