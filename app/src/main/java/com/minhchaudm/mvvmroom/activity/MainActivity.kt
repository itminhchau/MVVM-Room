package com.minhchaudm.mvvmroom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minhchaudm.kotlinmessenger.utils.replaceFragment
import com.minhchaudm.mvvmroom.R
import com.minhchaudm.mvvmroom.fragment.FragmentAdd
import com.minhchaudm.mvvmroom.fragment.FragmentRecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(FragmentRecyclerView.newInstance(),R.id.frame_layout)
    }
}