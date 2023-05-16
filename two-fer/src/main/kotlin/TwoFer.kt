fun twofer(name: String? = null): String {
    return if (name == "" || name == null) {
        "One for you, one for me."
    } else {
        "One for $name, one for me."
    }
}
