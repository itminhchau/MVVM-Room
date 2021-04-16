package com.minhchaudm.mvvmroom.fragment

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.graphics.rotationMatrix
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.minhchaudm.kotlinmessenger.utils.replaceFragment
import com.minhchaudm.mvvmroom.R
import com.minhchaudm.mvvmroom.adapter.AdapterNote
import com.minhchaudm.mvvmroom.model.Note
import com.minhchaudm.mvvmroom.modelview.NoteViewModel
import kotlinx.android.synthetic.main.fragment_recyclerview.*

class FragmentRecyclerView: Fragment() {
    private lateinit var rootView: View
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this,NoteViewModel.NoteViewModelFactory(requireActivity().application))[NoteViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_recyclerview,container,false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initControl()
        initEvent()
    }

    private fun initEvent() {
        floatBtn_add.setOnClickListener {
            replaceFragment(FragmentAdd.newInstance(),R.id.recycler_Layout)
        }
    }

    private fun initControl() {
       val adapter = AdapterNote(rootView.context,onItemClick,onItemDelete)
        recycler_View.setHasFixedSize(true)
        recycler_View.layoutManager = LinearLayoutManager(rootView.context)
        recycler_View.adapter = adapter
        noteViewModel.getAllNote().observe(this, Observer {
            adapter.setNote(it)
        })
    }
    private val onItemClick:(Note)->Unit = {

    }
    private val onItemDelete:(Note)->Unit={

    }

    companion object{
        fun newInstance() = FragmentRecyclerView()
    }
}