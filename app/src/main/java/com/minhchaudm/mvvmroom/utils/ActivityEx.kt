package com.minhchaudm.kotlinmessenger.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


fun AppCompatActivity.addFragment(fragment: Fragment, id: Int,tag: String) {
    supportFragmentManager.inTransaction {
        add(id, fragment)
        addToBackStack(tag)
    }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, id: Int) {
    supportFragmentManager.inTransaction {
        replace(id, fragment)
        //addToBackStack(null)
    }
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { remove(fragment) }

}
