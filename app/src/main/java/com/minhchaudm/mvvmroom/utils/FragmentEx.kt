package com.minhchaudm.kotlinmessenger.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun Fragment.addFragment(fragment: Fragment, id: Int,tag: String) {
    fragmentManager?.inTransaction {
        add(id, fragment)
        addToBackStack(tag)
    }
}

fun Fragment.replaceFragment(fragment: Fragment, id: Int) {
    fragmentManager?.inTransaction {
        replace(id, fragment)
       addToBackStack(null)
    }
}

fun Fragment.removeFragment(fragment: Fragment) {
    fragmentManager?.inTransaction { remove(fragment) }
}