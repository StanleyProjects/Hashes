package sp.kx.hashes

import java.security.MessageDigest

internal object SHA1HashFunction : HashFunction {
    private val md = MessageDigest.getInstance("SHA1")
    override val size = md.digestLength

    override fun map(bytes: ByteArray): ByteArray {
        return md.digest(bytes)
    }
}
