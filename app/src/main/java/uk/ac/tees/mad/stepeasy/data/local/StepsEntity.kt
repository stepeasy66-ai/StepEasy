package uk.ac.tees.mad.stepeasy.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("step_table")
data class StepsEntity(
    @PrimaryKey (autoGenerate = true) val id : Int = 0,
    val numOfSteps : Int = 0 ,
    val date : String  = "",
)