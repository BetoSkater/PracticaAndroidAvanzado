package com.albertojr.practicaandroidavanzado.UI.MainActivity.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.albertojr.practicaandroidavanzado.R
import com.albertojr.practicaandroidavanzado.UI.MainActivity.MainActivityViewModel
import com.albertojr.practicaandroidavanzado.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
//TODO probably I should add a @Entripoint like in the list fragment
@AndroidEntryPoint
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val args : SecondFragmentArgs by navArgs()
    private val viewModel:MainActivityViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNameDetail.text = args.heroeId.toString()

        viewModel.heroes.observe(viewLifecycleOwner){

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}