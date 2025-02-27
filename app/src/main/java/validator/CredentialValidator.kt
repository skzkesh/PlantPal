package validator

class CredentialValidator {

    fun isEmptyUsername(username: String?): Boolean {
        return username?.trim { it <= ' ' }?.isEmpty() ?: true
    }

    fun isEmptyEmailAddress(emailAddress: String?): Boolean {
        return emailAddress?.trim { it <= ' ' }?.isEmpty() ?: true
    }

    fun isValidEmailAddress(emailAddress: String): Boolean {
        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
        return emailAddress.matches(emailRegex.toRegex())
    }

    fun isValidPassword(password: String): Boolean {
        var specialCharCount = 0
        var alphanumericalCount = 0


        for (c in password.toCharArray()) {
            if (c == '!' || c == '@' || c == '#') {
                specialCharCount += 1
            } else if (Character.isLetterOrDigit(c)) {
                alphanumericalCount += 1
            }
        }

        if (specialCharCount == 2 && alphanumericalCount == 7) {
            return true
        }

        return false
    }
}