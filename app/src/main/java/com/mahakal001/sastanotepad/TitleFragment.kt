package com.mahakal001.sastanotepad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mahakal001.sastanotepad.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
      val binding : FragmentTitleBinding = DataBindingUtil.inflate(
          inflater, R.layout.fragment_title, container, false)

        binding.fab.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_titleFragment3_to_takeNoteFragment4)
        }

        return binding.root
    }

}
