package ork.keeptrackingLog.keeptrackLog

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ork.keeptrackingLog.keeptrackLog.models.RegisterRequest
import ork.keeptrackingLog.keeptrackLog.models.UserViewModel
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
        override fun onResume() {
            super.onResume()
            UserViewModel.register
        }
    }


    fun validateSignUp() {
        val name = binding.etName.text.toString()
        var last = binding.etLast.text.toString()
        var password1 = binding.etPassword1.text.toString()
        var password2 = binding.etPassword2.text.toString()
        var email1 = binding.etEmail1.text.toString()
        var phoneNumber = binding.etPhonenumber.text.toString()
        var error = false
        if (name.isBlank()) {

            binding.tilName.error = "Name is required"
        }
        if (last.isBlank()) {
            binding.tilLast.error = "Name is required"
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
        if (!error) {
            binding.pvRegister.visibility = View.VISIBLE
            var registerRequest = RegisterRequest(name, last,phoneNumber, email1, password1)
            UserViewModel=

        }

    }

//    fun makeReqistrationRequest(requesterRequest: RegisterRequest) {
//        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
//        var request = apiClient.registerUser(requesterRequest)
//
//        request.enqueue(object : Callback<Registerresponse> {
//            override fun onResponse(call: Call<Registerresponse>, response: Response<Registerresponse>) {
//                binding.pvRegister.visibility=View.GONE
//                        var message =response.body()?.message
//                        Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()
//                        startActivity(Intent(baseContext,LogInActivity::class.java))
//
//            }
//
//            override fun onFailure(call: Call<Registerresponse>, t: Throwable) {
//                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//
//            }
//
//        })
//    }
}











