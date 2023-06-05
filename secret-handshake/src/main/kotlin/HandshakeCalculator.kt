object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val binaryDigits = Integer.toBinaryString(number).reversed()

        val handshake = mutableListOf<Signal>()

        if (binaryDigits[0] == '1') handshake.add(Signal.WINK)
        if (binaryDigits.length > 1 && binaryDigits[1] == '1') handshake.add(Signal.DOUBLE_BLINK)
        if (binaryDigits.length > 2 && binaryDigits[2] == '1') handshake.add(Signal.CLOSE_YOUR_EYES)
        if (binaryDigits.length > 3 && binaryDigits[3] == '1') handshake.add(Signal.JUMP)
        if (binaryDigits.length > 4 && binaryDigits[4] == '1') handshake.reverse()

        return handshake
    }
}
