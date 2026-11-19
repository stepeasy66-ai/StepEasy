package uk.ac.tees.mad.stepeasy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [StepsEntity ::class] ,
    exportSchema = false ,
    version = 1
)
abstract class StepDatabase : RoomDatabase() {
    abstract fun getStepDao() : StepsDao
}