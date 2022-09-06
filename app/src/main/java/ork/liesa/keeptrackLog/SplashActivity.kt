package ork.liesa.keeptrackLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharePrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        val accesstoken=sharedPrefs.getString("ACCESS_TOKEN","").toString()
        if (accessToken.isBlamk)

        val intent= Intent(this,LogInActivity::class.java)
        startActivity(intent)
        finish()

    }
}
