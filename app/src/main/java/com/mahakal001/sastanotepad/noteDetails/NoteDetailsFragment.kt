package com.mahakal001.sastanotepad.noteDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBinderMapperImpl
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.mahakal001.sastanotepad.R
import com.mahakal001.sastanotepad.database.NotesDatabase
import com.mahakal001.sastanotepad.databinding.FragmentNoteDetailsBinding
import com.mahakal001.sastanotepad.title.TitleFragmentDirections

class NoteDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {

        // get Binding to fragment_note_details layout
        val binding : FragmentNoteDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_note_details, container, false )



        var fragArgs = NoteDetailsFragmentArgs.fromBundle(arguments!!)
        val application = requireNotNull(this.activity).application

        // get a reference to our Room Database
        val dataSource = NotesDatabase.getInstance(application).notesDatabaseDao
        // Create an instance of the ViewModel Factory.
        val viewModelFactory = NoteDetailsViewModelFactory(fragArgs.noteId, dataSource )

        // Get a reference to the ViewModel associated with this fragment
        val noteDetailViewModel = ViewModelProviders.of(this,viewModelFactory).get(NoteDetailsViewModel::class.java)
        binding.noteDetailsViewModel = noteDetailViewModel


        binding.setLifecycleOwner(this)

        binding.backButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(NoteDetailsFragmentDirections.actionNoteDetailsFragmentToTakeNoteFragment4())
        }

//        binding..setOnClickListener { view : View ->
//            //view.findNavController().navigate(R.id.action_titleFragment3_to_takeNoteFragment4)
//            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragment3ToTakeNoteFragment4())
//        }

        return binding.root

    }


}