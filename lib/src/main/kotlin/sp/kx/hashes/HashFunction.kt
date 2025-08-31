package sp.kx.hashes

interface HashFunction {
    val size: Int
    fun map(bytes: ByteArray): ByteArray

    companion object {
        val MD5: HashFunction = MD5HashFunction
        val SHA1: HashFunction = SHA1HashFunction
    }
}
