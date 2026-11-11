package uk.ac.tees.mad.stepeasy.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import uk.ac.tees.mad.stepeasy.domain.model.UserData
import uk.ac.tees.mad.stepeasy.domain.repository.AuthRepository

class AuthRepositoryImpl (private val firebaseAuth: FirebaseAuth ,
    private val firebaseFirestore: FirebaseFirestore
): AuthRepository {
    override suspend fun signIn(
        email : String ,
        password : String
    ): Result<Unit> {
        return try {
           val response = firebaseAuth
                .signInWithEmailAndPassword(email,password)
                .await()
            response?.user?.uid?:throw Exception("User ID is null")
            Result.success(Unit)
        }catch (e : Exception){
            Result.failure(e)
        }
    }

    override suspend fun signOut(): Result<Unit> {
        return try {
            firebaseAuth.signOut()
            Result.success(Unit)
        }catch (e : Exception){
            Result.failure(e)
        }
    }

    override suspend fun signUp(email: String, password: String): Result<Unit> {
        return try {
            val response = firebaseAuth
                .createUserWithEmailAndPassword(email,password)
                .await()
            response?.user?.uid?:throw Exception("User ID is null")
            val uid = response.user?.uid?:throw Exception("User ID is null")

            try {
                val profile = UserData(
                    email = email,
                    userId = uid,
                    createdAt = System.currentTimeMillis()
                )
                firebaseFirestore
                    .collection(USERS)
                    .document(uid)
                    .set(profile)
                    .await()

            }catch (e : Exception){
                response.user?.delete()?.await()
                throw e
            }
            Result.success(Unit)
        }catch (e :Exception){
            Result.failure(e)
        }
    }

    companion object{
        private const val USERS = "users"
    }
}