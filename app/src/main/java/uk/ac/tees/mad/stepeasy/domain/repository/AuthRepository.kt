package uk.ac.tees.mad.stepeasy.domain.repository

interface AuthRepository {
    suspend fun signIn(email : String ,
                       password : String): Result<Unit>
    suspend fun signOut(): Result<Unit>
    suspend fun signUp(
        email: String ,
        password: String
    ): Result<Unit>
}


/**
 * signIn for login
 * signOut for logout
 * signUp for register new user
 */