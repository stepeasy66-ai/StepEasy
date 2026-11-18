package uk.ac.tees.mad.stepeasy.utils

import android.content.Context
import androidx.core.content.edit

class PreferenceManager(private val context : Context) {
    private val sharedPreferences = context.getSharedPreferences("My_Prefs" , Context.MODE_PRIVATE)

    companion object{
        private const val KEY_IS_USER_LOGGED_IN = "isUserLoggedIn"
        private const val KEY_USER_EMAIL = "userEmail"
        private const val KEY_LAST_LOGIN = "lastLogin"

    }

    fun isUserLoggedIn() : Boolean{
        return sharedPreferences.getBoolean(KEY_IS_USER_LOGGED_IN , false)
    }

    fun setUserLoggedIn(isLoggedIn : Boolean){
       sharedPreferences.edit {
           putBoolean(KEY_IS_USER_LOGGED_IN , isLoggedIn)
       }
    }

    fun getUserEmail() : String?{
        return sharedPreferences.getString(KEY_USER_EMAIL , null)
    }

    fun setUserEmail(email : String) {
        sharedPreferences.edit {
            putString(KEY_USER_EMAIL, email)
        }
    }

    fun setLastLogin(lastLogin : Long){
        sharedPreferences.edit {
            putLong(
                KEY_LAST_LOGIN , lastLogin
            )
        }
    }

    fun getLasLogin(): Long{
        return sharedPreferences.getLong(KEY_LAST_LOGIN , 0)
    }

}