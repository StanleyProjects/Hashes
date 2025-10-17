package sp.kx.hashes

import java.security.MessageDigest

class RealHashes(algorithm: String) : Hashes {
    private val md = MessageDigest.getInstance(algorithm)
    override val size = md.digestLength

    override fun map(bytes: ByteArray): ByteArray {
        return md.digest(bytes)
    }
}
