package com.vologzhin.bigbrothersms

import android.app.Application
import com.kirillr.strictmodehelper.kotlin.dsl.initStrictMode
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initStrictMode(
            enable = BuildConfig.DEBUG,
            enableDefaults = false
        ) {
            threadPolicy {
                diskReads = true
                diskWrites = true
                network = true
                customSlowCalls = true
                unbufferedIo = true
                penalty { log = true }
            }

            vmPolicy {
                activityLeaks = true
                cleartextNetwork = true
                contentUriWithoutPermission = true
                fileUriExposure = true
                leakedClosableObjects = true
                leakedRegistrationObjects = true
                leakedSqlLiteObjects = true
                nonSdkApiUsage = true
                untaggedSockets = true
                credentialProtectedWhileLocked = true
                implicitDirectBoot = true
                penalty { log = true }
            }
        }
    }


}
