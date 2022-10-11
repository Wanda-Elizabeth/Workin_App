package ork.keeptrackingLog.keeptrackLog

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModel
import ork.keeptrackingLog.keeptrackLog.databinding.ActivityHomeBinding
import ork.keeptrackingLog.keeptrackLog.viewmodel.ExerciseViewModel
import ork.liesa.keeptrackLog.R
import ork.liesa.keeptrackLog.databinding.ActivityHomeBinding
import ork.liesa.keeptrackLog.databinding.FragmentPlanBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var fcvHome:FragmentContainerView
    lateinit var sharedPrefs:SharedPreferences
    val exerciseViewModel:ExerciseViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onResume() {
        super.onResume()
        exerciseViewModel.exerciseCategoryLiveData.observe(this,) { exerciseCategories ->
            if (exerciseCategories.isEmpty()) {
                exerciseCategories()
            })
        }
        exerciseViewModel.exerciseCategoryLiveData.observe(this,{ exerciseViewModel->

        })
        exerciseViewModel.errorLiveData.observe(this { errorMsg ->
            if (exercise.isEmpty()){
                Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()

            }


    fun triggerFetchExerciseCategories(){
        sharedPrefs=getSharedPreferences("WORKOUT_PREFS", MODE_PRIVATE)
        var accessToken=sharedPrefs.getString("ACCESS_TOKEN"," ")
        exerciseViewModel.fetchAPiExerciseCatrgories()
    }


    fun setupBottomNav() {
        binding.BottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.plan -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment())
                        .commit()
                    true
                }

                R.id.track -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment())
                        .commit()
                    true

                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }

        binding.BottomNavigation.setOnItemSelectedListener { item ->  //
            when (item.itemId) {
                R.id.plan -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.track -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else -> false
            }
        }
        }
}


