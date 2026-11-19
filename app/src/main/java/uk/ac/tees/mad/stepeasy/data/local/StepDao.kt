package uk.ac.tees.mad.stepeasy.data.local

import androidx.compose.ui.layout.ContentScale
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StepsDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewSteps(stepsEntity: StepsEntity)

    @Query("SELECT * FROM step_table")
    fun fetchStepList(): Flow<List<StepsEntity>>
}