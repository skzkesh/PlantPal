package unittest

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import validator.CredentialValidator

class CredentialValidatorJUnit {
    lateinit var validator: CredentialValidator

    @Before
    fun setup() {
        validator = CredentialValidator()
    }

    @Test
    fun checkIfUsernameIsEmpty() {
        Assert.assertTrue(validator.isEmptyUsername(""))
    }

    @Test
    fun checkIfEmailIsEmpty() {
        Assert.assertTrue(validator.isEmptyEmailAddress(""))
    }

    @Test
    fun checkIfEmailIsValid() {
        Assert.assertTrue(validator.isValidEmailAddress("abc123@dal.ca"))
    }

    @Test
    fun checkIfEmailIsNotValid() {
        Assert.assertFalse(validator.isValidEmailAddress("abc.123dal.ca"))
    }

    @Test
    fun checkIfPasswordIsValid() {
        Assert.assertTrue(validator.isValidPassword("pass122!@"))
    }

    @Test
    fun checkIfPasswordIsNotValid() {
        Assert.assertFalse(validator.isValidPassword("pa!1223"))
    }
}