package com.mahakal001.sastanotepad.title

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.mahakal001.sastanotepad.R
import com.mahakal001.sastanotepad.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    private lateinit var viewModel: TitleViewModel
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
      val binding : FragmentTitleBinding = DataBindingUtil.inflate(
          inflater,
          R.layout.fragment_title, container, false)

        Log.i("TitleFragment","Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(TitleViewModel::class.java)
        binding.titleViewModel = viewModel
            binding.fab.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_titleFragment3_to_takeNoteFragment4)
        }

        return binding.root
    }

}
