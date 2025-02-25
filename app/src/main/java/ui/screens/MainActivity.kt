package ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.plantpal.R

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initializeViews()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginButton.setOnClickListener {
            moveToLoginPage()
        }

        registerButton.setOnClickListener {
            moveToRegistrationPage()
        }
    }

    fun initializeViews(){
        loginButton = findViewById(R.id.openingLogInButton)
        registerButton = findViewById(R.id.openingRegisterButton)
    }

    private fun moveToLoginPage(){
        val loginIntent = Intent(this, LoginPage::class.java)
        startActivity(loginIntent)
    }

    private fun moveToRegistrationPage(){
        val registrationIntent = Intent(this, RegistrationPage::class.java)
        startActivity(registrationIntent)
    }
}