package ork.liesa.keeptrackLog

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import ork.liesa.keeptrackLog.databinding.ActivityLogInBinding
import ork.liesa.keeptrackLog.databinding.ActivitySignUpBinding
import ork.liesa.keeptrackLog.models.LoginRequest
import ork.liesa.keeptrackLog.models.LoginResponse
import ork.liesa.keeptrackLog.uI.ApiClient
import ork.liesa.keeptrackLog.uI.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    lateinit var sharedPrefs:SharedPreferences
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
        }
    }
    fun makeLoginRequest(loginRequest: LoginRequest){
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.loginUser(loginRequest)
        request.enqueue(object :Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
              if (response.isSuccessful){
                  val loginResponse=response.body()
                  Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
                  startActivity(Intent(baseContext,HomeActivity::class.java))
                  //open home
              }
                else{
                    val error=response.errorBody()?.string()
                  Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
              }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
             Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun persistLoginDetails(loginResponse: LoginResponse){
        var editor=sharedPrefs.edit()
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()

    }
}



