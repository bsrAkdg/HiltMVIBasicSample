package com.bsrakdg.hiltmvibasicsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bsrakdg.hiltmvibasicsample.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Allows to inject
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
