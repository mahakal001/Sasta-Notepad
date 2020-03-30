package com.mahakal001.sastanotepad.takeNote

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mahakal001.sastanotepad.R
import com.mahakal001.sastanotepad.database.NotesDatabase
import com.mahakal001.sastanotepad.databinding.FragmentTakeNoteBinding

/**
 * A simple [Fragment] subclass.
 */
class TakeNoteFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle? ): View? {

        // get binding
        val binding : FragmentTakeNoteBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_take_note,container, false)
        binding.setLifecycleOwner(this)

        val application = requireNotNull(this.activity).application
        val dataSource = NotesDatabase.getInstance(application).notesDatabaseDao
        val viewModelFactory = TakeNoteViewModelFactory(dataSource,application)
        val takeNoteViewModel = ViewModelProviders.of(this,viewModelFactory).get(TakeNoteViewModel::class.java)
        binding.takeNoteViewModel = takeNoteViewModel

        // Inflate the layout for this fragment
        binding.doneButton.setOnClickListener {
               // view : View ->  view.findNavController().navigate(R.id.action_takeNoteFragment4_to_titleFragment3)
                takeNoteViewModel.onTakeNoteCompleted(binding.editText.text.toString())
            Log.i("TakeNoteFragment",binding.editText.text.toString() )
        }

        // code regarding Recycler View
        val adapter = TakeNoteAdapter(
            NoteListener { noteId ->
                Toast.makeText(context, "${noteId}", Toast.LENGTH_LONG).show()
            }
        )

        binding.notesList.adapter = adapter
        takeNoteViewModel.allNotes.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.submitList(it)
            }
        })

        val manager = GridLayoutManager(activity, 2)
        binding.notesList.layoutManager = manager

            return binding.root
    }

}
