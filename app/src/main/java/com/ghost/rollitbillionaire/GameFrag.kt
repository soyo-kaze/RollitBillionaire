package com.ghost.rollitbillionaire


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ghost.rollitbillionaire.databinding.FragmentGameBinding
import kotlin.random.Random


/**
 * A simple [Fragment] subclass.
 */
class GameFrag : Fragment() {
    private lateinit var binding : FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)
        binding.rollBut.setOnClickListener { gameFun(binding.betAmt.text.toString(),
            binding.betOne.text.toString(),
            binding.betTwo.text.toString(),
            binding.diceImg, binding.Amt)
        }

        return binding.root
    }

    private fun gameFun(bet:String?,one:String?,two:String?,img : ImageView, amount:TextView){

        val diceNo = (1..6).random()
        val amt1: Int
        val dice = when(diceNo){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        img.setImageResource(dice)



        if(bet==null || one==null || two==null){
            Toast.makeText(activity,"No fields should be empty",
                Toast.LENGTH_SHORT).show() // shows nullity error
        }else{

            if (bet.toInt() !in 1..amount.text.toString().toInt()){
                Toast.makeText(activity,"Yo|| check your bet. Should be in 1 & ${amount.text}",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                if(one.toInt() !in 1..6 || two.toInt() !in 1..6){
                    Toast.makeText(
                        activity,"Yo|| check your guesses $one & $two",
                        Toast.LENGTH_SHORT).show() // shows not in range error
                }else {
                    if (one.toInt() == diceNo || two.toInt() == diceNo) {
                        amount.text =
                            (amount.text.toString().toInt() + (bet.toInt() * 2)).toString()
                        Toast.makeText(
                            activity, "There you go Oracle",
                            Toast.LENGTH_SHORT
                        ).show()
                        //To-do if part
                    } else {
                        amt1 = (amount.text.toString().toInt() - bet.toInt())
                        if (amt1 <= 0) {
                            amount.text = 0.toString()
                            return requireView().findNavController()
                                .navigate(R.id.action_gameFrag_to_endGame)
                        }
                        amount.text = amt1.toString()
                        Toast.makeText(
                            activity, "Booo!! Better luck in next guess",
                            Toast.LENGTH_SHORT
                        ).show()
                        //To-do else part
                    }
                }
            }

        }


    }
}
