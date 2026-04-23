package sp.kx.hashes

import java.security.MessageDigest

class Hashes private constructor(algorithm: String) {
    private val md = MessageDigest.getInstance(algorithm)
    val size = md.digestLength

    fun digest(encoded: ByteArray): ByteArray {
        return md.digest(encoded)
    }

    fun builder(): HashesBuilder {
        return HashesBuilder(algorithm = md.algorithm)
    }

    fun update(encoded: ByteArray): HashesBuilder {
        return HashesBuilder(algorithm = md.algorithm).update(encoded)
    }

    companion object {
        val SHA256 = Hashes(algorithm = "sha256")
    }
}
