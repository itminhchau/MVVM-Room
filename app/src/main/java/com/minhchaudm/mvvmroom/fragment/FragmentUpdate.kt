package com.minhchaudm.mvvmroom.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minhchaudm.mvvmroom.R
import com.minhchaudm.mvvmroom.model.Note
import kotlinx.android.synthetic.main.fragment_update_note.*
import kotlinx.android.synthetic.main.fragment_update_note.view.*

class FragmentUpdate:Fragment() {
    private lateinit var rootView: View
    var displayMessenger: String? = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_update_note,container,false)
        displayMessenger = arguments?.getString("message")
       rootView.edit_title.setText(displayMessenger)

        return  rootView
    }
    companion object{
        fun newInstance() = FragmentUpdate()
    }

}