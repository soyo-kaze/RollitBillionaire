package com.ghost.rollitbillionaire


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ghost.rollitbillionaire.databinding.FragmentEndGameBinding
import com.ghost.rollitbillionaire.databinding.FragmentGameTitleBinding
import kotlin.system.exitProcess

/**
 * A simple [Fragment] subclass.
 */
class EndGame : Fragment() {

    lateinit var binding : FragmentEndGameBinding
    var is_yes = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_end_game,container,false)
        binding.playAgain.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_endGame_to_gameTitle)  }
        binding.exitAgain.setOnClickListener { exiFun(is_yes) }
        return binding.root
    }

    private fun exiFun(bool:Boolean){

        var is_bool = bool

        if(is_bool){
            Toast.makeText(activity,"Tap exit again!!",
                Toast.LENGTH_SHORT).show()
            is_bool = false
        }else{
            exitProcess(0)
        }
    }

}
