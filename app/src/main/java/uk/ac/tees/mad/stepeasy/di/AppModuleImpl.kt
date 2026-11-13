package uk.ac.tees.mad.stepeasy.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import uk.ac.tees.mad.stepeasy.data.repository.AuthRepositoryImpl
import uk.ac.tees.mad.stepeasy.domain.repository.AuthRepository

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
            firebaseFirestore = firebaseFirestore
        )
    }
}