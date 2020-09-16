package com.bsrakdg.hiltmvibasicsample

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

class MyTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        // the test runner when it runs a test which application to use
        // Don't use CustomApplication class for testing
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}