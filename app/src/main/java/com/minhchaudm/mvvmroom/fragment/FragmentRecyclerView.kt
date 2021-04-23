package com.minhchaudm.mvvmroom.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.minhchaudm.kotlinmessenger.utils.addFragment
import com.minhchaudm.mvvmroom.R
import com.minhchaudm.mvvmroom.adapter.AdapterNote
import com.minhchaudm.mvvmroom.model.Note
import com.minhchaudm.mvvmroom.modelview.NoteViewModel
import com.minhchaudm.mvvmroom.remote.dao.Communicator
import kotlinx.android.synthetic.main.fragment_recyclerview.*

class FragmentRecyclerView : Fragment() {
    private lateinit var communicator: Communicator
    private lateinit var rootView: View
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this, NoteViewModel.NoteViewModelFactory(requireActivity().application))[NoteViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = activity as Communicator
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView =inflater.inflate(R.layout.fragment_recyclerview, container, false)
        return  rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initControl()
        initEvent()
    }

    private fun initEvent() {
        floatBtn_add.setOnClickListener {
            addFragment(FragmentAdd.newInstance(), R.id.recycler_Layout, "fragB")
        }
    }

    private fun initControl() {
        val adapter = AdapterNote(rootView.context, onItemClick, onItemDelete)
        //requireContext() check null truong hop null thi quang throw :v
        recycler_View.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(rootView.context)
        }
        recycler_View.adapter = adapter
        noteViewModel.getAllNote().observe(this, Observer {
            adapter.setNote(it)
        })
    }

    private val onItemClick: (Note) -> Unit = {
        communicator.sendData(it.title , it.description)

    }



    private val onItemDelete: (Note) -> Unit = {

    }

    companion object {
        fun newInstance() = FragmentRecyclerView()
    }
}
