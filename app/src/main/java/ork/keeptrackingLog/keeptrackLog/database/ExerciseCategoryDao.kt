package ork.keeptrackingLog.keeptrackLog.database

import androidx.lifecycle.LiveData
import androidx..Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ork.keeptrackingLog.models.ExerciseDao



@Dao
interface ExerciseCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExerciseCategory(exerciseCategory: ExerciseCategory)

    @Query("SELECT * FROM exercisecategory")
    fun getExerciseCategory():LiveData<List<ExerciseCategory>> //changing the name in order to query the Api call
}