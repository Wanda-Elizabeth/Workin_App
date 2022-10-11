package ork.keeptrackingLog.keeptrackLog.database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ork.keeptrackingLog.models.Exercise
import ork.keeptrackingLog.models.ExerciseCategory

class DbExerciseCategories {


    @Database(entities = arrayOf(ExerciseCategory::class, Exercise::class), version = 3)
    abstract class keeptrackingDB: RoomDatabase() {
        abstract fun exerciseCategoryDao(): ExerciseCategoryDao
        abstract fun exerciseDao(): ExerciseDao

        companion object{
            private var database: keeptrackingDB? = null
            fun getDatabase(context: Context): keeptrackingDB{
                if (database==null){
                    database= Room.databaseBuilder(context, FkeeptrackingDB::class.java, "keeptrackingDB")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return database as keeptrackingDB
            }
        }
    }


}
