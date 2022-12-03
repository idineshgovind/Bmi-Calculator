package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.bmicalculator.databinding.FragmentInputBinding


class InputFragment : Fragment() {

    lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentInputBinding.inflate(
            inflater, container, false
        ).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonCheck.setOnClickListener {
                if (heightInput.text.isEmpty() || weightInput.text.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Please input Weight and Height Values greater than 0",
                        Toast.LENGTH_LONG
                    ).show()

                    return@setOnClickListener
                }

                view.findNavController().navigate(
                    InputFragmentDirections.actionInputFragmentToResultFragment(
                        weight = weightInput.text.toString().toInt(),
                        height = heightInput.text.toString().toInt()
                    )
                )
            }
        }
    }
}