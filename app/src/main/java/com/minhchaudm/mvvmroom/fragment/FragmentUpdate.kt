package com.minhchaudm.mvvmroom.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minhchaudm.mvvmroom.R

class FragmentUpdate:Fragment() {
    private lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_update_note,container,false)
        return rootView
    }
    companion object{
        fun newInstance() = FragmentUpdate()
    }
}