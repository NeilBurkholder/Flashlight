package com.ncautomation.flashlight

import android.app.Application
import com.ncautomation.commons.extensions.checkUseEnglish

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        checkUseEnglish()
    }
}
