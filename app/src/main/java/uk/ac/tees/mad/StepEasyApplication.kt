package uk.ac.tees.mad

import android.app.Application
import uk.ac.tees.mad.stepeasy.di.AppModule
import uk.ac.tees.mad.stepeasy.di.AppModuleImpl

class StepEasyApplication : Application(){
    companion object{
        lateinit var appModule : AppModule
    }
    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(context = this)
    }
}