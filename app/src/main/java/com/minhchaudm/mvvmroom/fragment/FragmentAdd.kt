package com.minhchaudm.mvvmroom.fragment

import android.app.PendingIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.minhchaudm.mvvmroom.R
import com.minhchaudm.mvvmroom.model.Note
import com.minhchaudm.mvvmroom.modelview.NoteViewModel
import kotlinx.android.synthetic.main.fragment_add_note.*

class FragmentAdd: Fragment() {
    private lateinit var rootView: View
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this, NoteViewModel.NoteViewModelFactory(requireActivity().application))[NoteViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_add_note,container,false)
        return rootView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_add.setOnClickListener {
            val note = Note(edit_title.text.toString(),edit_description.text.toString())
            noteViewModel.insertNote(note)
        }
    }
    companion object{
        fun newInstance() = FragmentAdd()
    }
}