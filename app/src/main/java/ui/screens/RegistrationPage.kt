package ui.screens

import FirebaseCRUD
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.plantpal.R
import com.google.firebase.database.FirebaseDatabase
import validator.CredentialValidator


class RegistrationPage : AppCompatActivity(), View.OnClickListener {

    private var username: EditText? = null
    private var emailAddress: Button? = null
    private var password: EditText? = null
    private var errorText: TextView? = null
    private lateinit var registerButton: Button


    private lateinit var crud: FirebaseCRUD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrationpage)

        initializeViews()
        crud = FirebaseCRUD(getDatabase())

        registerButton.setOnClickListener {
            moveToDashboardPage()
        }
    }

    override fun onClick(view: View?) {
        val name = getUsername()
        val emailAddress = getEmailAddress()
        val password = getPassword()
        val validator = CredentialValidator()

        val errorMessage = when {
            validator.isEmptyUsername(name) -> getString(R.string.EMPTY_NAME)
            validator.isEmptyEmailAddress(emailAddress) -> getString(R.string.EMPTY_EMAIL_ADDRESS)
            !validator.isValidEmailAddress(emailAddress) -> getString(R.string.INVALID_EMAIL_ADDRESS)
            !validator.isValidPassword(password) -> getString(R.string.INVALID_PASSWORD)
            else -> {
                saveCredentials(emailAddress, password, name)
                moveToDashboardPage()
                ""
            }
        }

        setStatusMessage(errorMessage)
    }

    fun initializeViews(){
        username = findViewById(R.id.registrationEditTextUsername)
        emailAddress = findViewById(R.id.registrationEditTextEmailAddress)
        password = findViewById(R.id.registrationEditTextPassword)
        errorText = findViewById(R.id.registrationErrorText)
        registerButton = findViewById(R.id.registrationRegisterButton)
    }

    protected fun getDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    protected fun saveCredentials(emailAddress: String, password: String, name: String) {
        //val hashedPassword: String = PasswordUtility.makeHash(password)
        crud.setUsername(name)
        crud.setEmailAddress(emailAddress)
        //crud.setPassword(hashedPassword)
    }

    fun getUsername(): String {
        return username?.text.toString().trim { it <= ' ' }
    }

    fun getEmailAddress(): String {
        return emailAddress?.text.toString().trim { it <= ' ' }
    }

    fun getPassword(): String {
        return password?.text.toString().trim { it <= ' ' }
    }

    fun moveToDashboardPage(){
        val dashboardIntent = Intent(this, DashboardPage::class.java)
        startActivity(dashboardIntent)
    }

    fun setStatusMessage(message : String){
        errorText?.setText(message.trim())
    }
}