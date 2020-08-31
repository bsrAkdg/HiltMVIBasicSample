package com.bsrakdg.hiltmvibasicsample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //generate all components
class CustomApplication  : Application()