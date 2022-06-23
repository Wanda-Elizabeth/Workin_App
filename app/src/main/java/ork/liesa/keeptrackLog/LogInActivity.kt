package ork.liesa.keeptrackLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import ork.liesa.keeptrackLog.databinding.ActivityLogInBinding
import ork.liesa.keeptrackLog.databinding.ActivitySignUpBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding:ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
      castVies()
         }
    fun castVies(){
        binding.tvSignup.setOnClickListener {
            val intent= Intent(this,SignUpActivity::class.java)
            startActivity(intent)

        }
     binding.btnLogin.setOnClickListener {
         val intent=Intent(this,HomeActivity::class.java)
         startActivity(intent)
         validateLogIn()
     }
    }
    fun validateLogIn(){
        var email=binding.etEmail.text.toString()
        var password=binding.etPassword.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error="Email required"
        }
        if (password.isBlank()){
            binding.tilPassword.error="Password required"
        }
    }

    }
