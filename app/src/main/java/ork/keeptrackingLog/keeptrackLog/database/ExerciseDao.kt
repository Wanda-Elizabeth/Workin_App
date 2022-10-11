package ork.keeptrackingLog.keeptrackLog.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ork.keeptrackingLog.keeptrackLog.models.ExcersiseCategory

@Dao
interface ExerciseDao {
    @Insert(onConflict = .REPLACE)
    fun insertExercises(exercise: ExerciseDao)

    @Query("SELECT * FROM Exercises")
    fun fetchExercises() : LiveData<List<ExerciseDao>>

    @Query("SELECT * FROM Exercises WHERE categoryId = :categoryId")
    fun fetchExercisesByCategory(categoryId: String): LiveData<List<ExerciseDao>>

}