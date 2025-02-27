package validator

class CredentialValidator {

    fun isEmptyEmailAddress(emailAddress: String): Boolean {
        return emailAddress.trim { it <= ' ' }.isEmpty()
    }

    fun isValidEmailAddress(emailAddress: String): Boolean {
        val atSymbol = emailAddress.indexOf('@')
        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"

        if (atSymbol > 0 && atSymbol < emailAddress.length - 1 && emailAddress.matches(emailRegex.toRegex())) {
            return true
        }

        return false
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

    fun isValidRole(role: String): Boolean {
        return role != "Select your role"
    }
}