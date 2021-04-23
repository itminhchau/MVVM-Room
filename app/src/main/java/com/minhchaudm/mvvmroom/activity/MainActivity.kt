package com.minhchaudm.mvvmroom.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.minhchaudm.kotlinmessenger.utils.addFragment
import com.minhchaudm.kotlinmessenger.utils.replaceFragment
import com.minhchaudm.mvvmroom.R
import com.minhchaudm.mvvmroom.fragment.FragmentRecyclerView
import com.minhchaudm.mvvmroom.fragment.FragmentUpdate
import com.minhchaudm.mvvmroom.model.Note
import com.minhchaudm.mvvmroom.modelview.NoteViewModel
import com.minhchaudm.mvvmroom.remote.dao.Communicator

class MainActivity : AppCompatActivity(),Communicator{

    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this, NoteViewModel.NoteViewModelFactory(this.application))[NoteViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(FragmentRecyclerView.newInstance(),R.id.frame_layout)

    }

    override fun sendData(title: String, description: String) {
        val bundle: Bundle? = null
        val fragmentUpdate = FragmentUpdate.newInstance()
        bundle?.putString("message",title)
        addFragment(FragmentUpdate.newInstance(),R.id.recycler_Layout,"fragB")


        fragmentUpdate.arguments = bundle


    }


}