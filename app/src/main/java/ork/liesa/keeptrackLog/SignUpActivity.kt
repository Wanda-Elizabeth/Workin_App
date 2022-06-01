package ork.liesa.keeptrackLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var tvLogin: TextView
    lateinit var etName:TextInputEditText
    lateinit var tilName:TextInputLayout
    lateinit var etLast:TextInputEditText
    lateinit var tilLast:TextInputLayout
    lateinit var etEmail1:TextInputEditText
    lateinit var tilEmail1:TextInputLayout
    lateinit var etPassword1:TextInputEditText
    lateinit var tilPassword1:TextInputLayout
    lateinit var etPassword2:TextInputEditText
    lateinit var tilPassword2:TextInputLayout
    lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        tvLogin=findViewById(R.id.tvSign)
        etName=findViewById(R.id.etName)
        tilName=findViewById(R.id.tilName)
        etLast=findViewById(R.id.etLast)
        tilLast=findViewById(R.id.tilLast)
        etEmail1=findViewById(R.id.etEmail1)
        tilEmail1=findViewById(R.id.tilEmail1)
        etPassword1=findViewById(R.id.etPassword1)
        tilPassword1=findViewById(R.id.tilPassword1)
        etPassword2=findViewById(R.id.etPassword2)
        tilPassword2=findViewById(R.id.tilPassword2)
        btnSignUp=findViewById(R.id.btnSignup)

        tvLogin.setOnClickListener {
            val intent= Intent(this,LogInActivity::class.java)
            startActivity(intent)

        }
        btnSignUp.setOnClickListener {
            validateSignUp()
        }
    }
    fun validateSignUp(){
        var name=etName.text.toString()
        var last=etLast.text.toString()
        var password1=etPassword1.text.toString()
        var password2=etPassword2.text.toString()
        var email1=etEmail1.text.toString()
        if (name.isBlank()){
            tilName.error="Name is required"
        }
        if (last.isBlank()){
            tilLast.error="Name is required"
        }
        if (email1.isBlank()){
            tilEmail1.error="Email required"
        }
        if (password1.isBlank()){
            tilPassword1.error="Password required"
        }
        if (password2.isBlank()){
            tilPassword2.error="Does not match"
        }

    }

}

