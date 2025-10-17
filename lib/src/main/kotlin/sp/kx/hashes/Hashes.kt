package sp.kx.hashes

interface Hashes {
    val size: Int
    fun map(bytes: ByteArray): ByteArray

    companion object {
        val MD5: Hashes = RealHashes(algorithm = "MD5")
        val SHA1: Hashes = RealHashes(algorithm = "SHA1")
    }
}
