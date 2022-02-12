package com.example.lesson17.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson17.R
import com.example.lesson17.utils.navigateTo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.navigateTo(fragment = MainFragment())
    }
}