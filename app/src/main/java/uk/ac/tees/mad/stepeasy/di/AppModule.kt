package uk.ac.tees.mad.stepeasy.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import uk.ac.tees.mad.stepeasy.domain.repository.AuthRepository

interface AppModule {
    val firebaseAuth : FirebaseAuth
    val firebaseFirestore : FirebaseFirestore
    val authRepository : AuthRepository
}