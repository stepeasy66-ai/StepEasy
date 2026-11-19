package uk.ac.tees.mad.stepeasy.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import uk.ac.tees.mad.stepeasy.data.local.StepDatabase
import uk.ac.tees.mad.stepeasy.data.local.StepsDao
import uk.ac.tees.mad.stepeasy.data.repository.AuthRepositoryImpl
import uk.ac.tees.mad.stepeasy.domain.repository.AuthRepository
import uk.ac.tees.mad.stepeasy.utils.PreferenceManager

class AppModuleImpl(private val context : Context) : AppModule {
    override val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    override val firebaseFirestore: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
    override val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(
            firebaseAuth = firebaseAuth ,
            firebaseFirestore = firebaseFirestore ,
            preferenceManager = preferenceManager
        )
    }
    override val preferenceManager: PreferenceManager by lazy {
        PreferenceManager(context)
    }

    override val db by lazy {
        Room.databaseBuilder(
            context ,
            StepDatabase::class.java ,
            "step_database"
        ).build()
    }

    override val stepsDao: StepsDao by lazy {
        db.getStepDao()
    }
}