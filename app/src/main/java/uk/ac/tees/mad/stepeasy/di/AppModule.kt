package uk.ac.tees.mad.stepeasy.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import uk.ac.tees.mad.stepeasy.data.local.StepDatabase
import uk.ac.tees.mad.stepeasy.data.local.StepsDao
import uk.ac.tees.mad.stepeasy.domain.repository.AuthRepository
import uk.ac.tees.mad.stepeasy.utils.PreferenceManager

interface AppModule {
    val firebaseAuth : FirebaseAuth
    val firebaseFirestore : FirebaseFirestore
    val authRepository : AuthRepository
    val preferenceManager : PreferenceManager

    val db : StepDatabase

    val stepsDao : StepsDao
}