package ork.liesa.keeptrackLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import ork.liesa.keeptrackLog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
    }
    fun castViews() {
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            validateSignUp()
        }
    }


    fun validateSignUp() {
        val name = binding.etName.text.toString()
        var last = binding.etLast.text.toString()
        var password1 =binding.etPassword1.text.toString()
        var password2 =binding.etPassword2.text.toString()
        var email1 =binding.etEmail1.text.toString()
        if (name.isBlank()) {

            binding.tilName.error = "Name is required"
        }
        if (last.isBlank()) { binding.tilLast.error = "Name is required"
        }
        if (email1.isBlank()) {
            binding.tilEmail1.error = "Email required"
        }
        if (password1.isBlank()) {
            binding.tilPassword1.error = "Password required"
        }
        if (password2.isBlank()) {
            binding.tilPassword2.error = "Does not match"
        }
        if (email1.isBlank()) {
            binding.tilName.error = "Email required"
        }
        if (last.isBlank()) {
            binding.tilLast.error = "Password required"
        }
    }
}









