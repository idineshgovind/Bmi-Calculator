package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.bmicalculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var viewModel: BmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentResultBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_result,
                container,
                false
            )
//        (activity as MainActivity?)?.setActionBarTitle("BMI Result")
        viewModel = ViewModelProvider(this)[BmiViewModel::class.java]
        val args = ResultFragmentArgs.fromBundle(requireArguments())

        binding.bmiViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.calculate(args.weight, args.height)
        binding.ShareButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out your BMI on 'BMI Calculator' app and Stay Fit!.\n Download now!\nwww.zohoschools.com"
            )
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
        binding.buttonAgain.setOnClickListener {
            view?.findNavController()
                ?.navigate(ResultFragmentDirections.actionResultFragmentToInputFragment())
        }
        return binding.root
    }
}
