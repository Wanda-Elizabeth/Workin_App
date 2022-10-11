package ork.keeptrackingLog.keeptrackLog

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ork.keeptrackingLog.keeptrackLog.models.LoginRequest
import ork.keeptrackingLog.keeptrackLog.models.LoginResponse
import ork.keeptrackingLog.keeptrackLog.viewmodel.UserViewModel
import ork.liesa.keeptrackLog.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    lateinit var sharedPrefs:SharedPreferences
    val UserViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }
        binding.btnLogin.setOnClickListener {
            validateLogIn()
        }

    }

    override fun onResume() {
        super.onResume()
        UserViewModel.loginLiveData.observe(this) { loginResponse ->
            Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG).show()
            persistLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext, HomeActivity::class.java))
        }
        UserViewModel.loginError.observe(this) { errorMsg ->
            Toast.makeText(baseContext, errorMsg, Toast.LENGTH_LONG).show()
        }
    }

    fun validateLogIn() {
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var error = false
        if (email.isBlank()) {
            error = true
            binding.tilEmail.error = "Email required"
        }
//        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            error=true
//            tilEmail
//        }
        if (password.isBlank()) {
            error = true
            binding.tilPassword.error = "Password required"
        }
        if(!error){
            var loginRequest=LoginRequest(email,password)
            UserViewModel.login(loginRequest)
        }
    }

    fun persistLoginDetails(loginResponse: LoginResponse){
        var editor=sharedPrefs.edit()
        val token="Bearer" ${loginResponse.accessToken}
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("ACCESS_TOKEN", token)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()

    }
}





