package com.ghost.rollitbillionaire


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ghost.rollitbillionaire.databinding.FragmentGameTitleBinding
import kotlin.system.exitProcess


/**
 * A simple [Fragment] subclass.
 */
class GameTitle : Fragment() {
    private lateinit var binding : FragmentGameTitleBinding
    var is_yes = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game_title,container,false)
        binding.titleStart.setOnClickListener { view : View -> view.findNavController().navigate(R.id.action_gameTitle_to_gameEntry) }
        binding.titleExit.setOnClickListener { exiFun() }
        return binding.root
    }

    private fun exiFun(){



        if(is_yes){
            Toast.makeText(activity,"Tap exit again!!",
                Toast.LENGTH_SHORT).show()
            is_yes = false
        }else{
            exitProcess(0)
        }
    }
}
