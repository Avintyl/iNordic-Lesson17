package com.example.lesson17.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lesson17.R

fun FragmentManager.navigateTo(fragment: Fragment) {
    this.beginTransaction()
        .replace(R.id.fragmentContainer, fragment)
        .commit()
}