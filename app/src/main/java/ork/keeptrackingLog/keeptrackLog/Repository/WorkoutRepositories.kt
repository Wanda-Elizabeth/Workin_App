package ork.keeptrackingLog.keeptrackLog.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ork.keeptrackingLog.keeptrackLog.uI.ApiClient
import ork.keeptrackingLog.keeptrackLog.uI.ApiClient
import ork.keeptrackingLog.keeptrackLog.uI.ApiClient
import ork.keeptrackingLog.keeptrackLog.uI.ApiInterface


class ExerciseRepositories {
    val apiClient = ApiClient.buildApiClient((ApiInterface::class.java))
    val database =keeptrackingDB.getDatabase(keeptrackLog.appContext)
    val exerciseCategoryDao = database.exerciseCategoryDao()
    val exerciseDao = database.exerciseDao()


    suspend fun fetchExerciseCategories(accessToken: String)
            = withContext(Dispatchers.IO){
        val response =  apiClient.fetchExerciseCategories(accessToken)
        if(response.isSuccessful){
            val exerciseCategories = response.body()
            exerciseCategories?.forEach{category ->
                exerciseCategoryDao.insertExerciseCategory(category)
            }
        }
    }
    suspend fun fetchExercises(accessToken: String){
        withContext(Dispatchers.IO){
            val response = apiClient.fetchExercises(accessToken)
            if (response.isSuccessful){
                val exercises = response.body()
                exercises?.forEach{  exercise ->
                    exerciseDao.insertExercise(exercise)

                }
            }
        }
    }

}