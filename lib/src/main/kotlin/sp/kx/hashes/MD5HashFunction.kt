package sp.kx.hashes

import java.security.MessageDigest

internal object MD5HashFunction : HashFunction {
    private val md = MessageDigest.getInstance("MD5")
    override val size = md.digestLength

    override fun map(bytes: ByteArray): ByteArray {
        return md.digest(bytes)
    }
}
