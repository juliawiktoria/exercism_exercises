class PhoneNumber(rawNumber: String) {
    val number: String?

    init {
        val cleanedNumber = rawNumber.replace(Regex("""[^0-9]"""), "")
        number = when {
            cleanedNumber.length == 11 && cleanedNumber[0] == '1' && cleanedNumber[1] != '0' && cleanedNumber[1] != '1' && cleanedNumber[4] != '0' && cleanedNumber[4] != '1' -> cleanedNumber.substring(1)
            cleanedNumber.length == 10 && cleanedNumber[0] != '0' && cleanedNumber[0] != '1' && cleanedNumber[3] != '0' && cleanedNumber[3] != '1' -> cleanedNumber
            else -> throw IllegalArgumentException()
        }
    }
}
