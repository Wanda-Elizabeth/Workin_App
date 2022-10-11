package ork.keeptrackingLog.keeptrackLog.Repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ork.keeptrackingLog.keeptrackLog.database.ExerciseCategoryDao
import ork.keeptrackingLog.keeptrackLog.uI.ApiClient
import ork.keeptrackingLog.keeptrackLog.uI.ApiInterface

class ExerciseRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    val database = DbExerciseCategories.getDatabase(.appContext)
    val exerciseCategoryDao = database.exerciseCategoryDao()
    val exerciseDao = database.exerciseDao()


    suspend fun fetchApiExerciseCategories(accessToken: String) =
        withContext(Dispatchers.IO) {
            val response = apiClient.fetchExerciseCategories(accessToken)
            if (response.isSuccessful) {
                val exerciseCategories = response.body()
                if (exerciseCategories != null) {
                    exerciseCategories.forEach { category ->
                        exerciseCategoryDao.insertExerciseCategory(category)
                    }
                }
            }
            return@withContext response
        }
    fun getDbExerciseCategories(): LiveData<List<ExerciseCategoryDao>>{
        return exerciseCategoryDao.getExerciseCategory()
    }

    suspend fun fetchExercises(accessToken: String){
        withContext(Dispatchers.IO){
            val response = apiClient.fetchExercises(accessToken)
            if (response.isSuccessful){
                val exercises = response.body()
                exercises?.forEach { exercise ->
                    exerciseDao.insertExercises(exercise)
                }
            }
            return@withContext response
        }
    }

}

