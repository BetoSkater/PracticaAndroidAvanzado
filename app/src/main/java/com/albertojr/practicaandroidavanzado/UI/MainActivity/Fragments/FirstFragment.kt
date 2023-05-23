package com.albertojr.practicaandroidavanzado.UI.MainActivity.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.albertojr.practicaandroidavanzado.R
import com.albertojr.practicaandroidavanzado.UI.MainActivity.MainActivity
import com.albertojr.practicaandroidavanzado.databinding.FragmentFirstBinding
import com.albertojr.practicaandroidavanzado.UI.MainActivity.MainActivityViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private  val viewModel: MainActivityViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.heroes.observe(viewLifecycleOwner){
          Log.d("Fragment1 heroe list size", "${it.size}")
        }
     //   viewModel.getHeroes()



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}