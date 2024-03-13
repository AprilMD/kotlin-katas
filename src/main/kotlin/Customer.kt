class Customer(private val firstName: String) {
    fun getFirstName(): String {
        return firstName.replaceFirstChar(Char::titlecase)
    }
}
