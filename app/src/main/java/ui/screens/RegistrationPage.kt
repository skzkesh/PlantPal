package ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.plantpal.R

class RegistrationPage : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var emailAddress: Button
    private lateinit var password: EditText
    private lateinit var errorText: TextView
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrationpage)

        initializeViews()

        registerButton.setOnClickListener {
            moveToDashboardPage()
        }
    }

    fun initializeViews(){
        username = findViewById(R.id.registrationEditTextUsername)
        emailAddress = findViewById(R.id.registrationEditTextEmailAddress)
        password = findViewById(R.id.registrationEditTextPassword)
        errorText = findViewById(R.id.registrationErrorText)
        registerButton = findViewById(R.id.registrationRegisterButton)
    }

    fun getUsername(): String {
        return username.text.toString().trim { it <= ' ' }
    }

    fun getEmailAddress(): String {
        return emailAddress.text.toString().trim { it <= ' ' }
    }

    fun getPassword(): String {
        return password.text.toString().trim { it <= ' ' }
    }

    fun moveToDashboardPage(){
        val dashboardIntent = Intent(this, DashboardPage::class.java)
        startActivity(dashboardIntent)
    }

    fun setStatusMessage(message : String){
        errorText.setText(message.trim())
    }
}