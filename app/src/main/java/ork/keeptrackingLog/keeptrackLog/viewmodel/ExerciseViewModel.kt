package ork.keeptrackingLog.keeptrackLog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ork.keeptrackingLog.keeptrackLog.Repository.ExerciseRepository
import ork.keeptrackingLog.keeptrackLog.database.ExerciseDao

class ExerciseViewModel : ViewModel() {
    val exerciseRepository = ExerciseRepository()

    lateinit var exerciseCategoryLiveData : LiveData<List<ExerciseDao>>
    val errorLiveData = MutableLiveData<String>()

    fun fetchAPiExerciseCatrgories(accessToken: String) {
        viewModelScope.launch {
            val response = exerciseRepository.fetchApiExerciseCategories(accessToken)
            if (!response.isSuccessful) {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }

    }

    fun getDbExerciseCategories(){
        exerciseCategoryLiveData = exerciseRepository.getDbExerciseCategories()
    }

    fun fetchExercises(accessToken: String) {
        viewModelScope.launch {
            exerciseRepository.fetchExercises(accessToken)
        }
    }
}