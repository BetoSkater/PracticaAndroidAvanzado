package com.albertojr.practicaandroidavanzado.UI.MainActivity.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.albertojr.practicaandroidavanzado.R
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Model.Heroe
import com.albertojr.practicaandroidavanzado.UI.MainActivity.MainActivityViewModel
import com.albertojr.practicaandroidavanzado.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
//TODO probably I should add a @Entrypoint like in the list fragment
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

      //  binding.tvNameDetail.text = args.heroeId.toString()

        viewModel.heroe.observe(viewLifecycleOwner){
            updateDetail(it)
        }
        viewModel.getHeroe(args.heroeId)

        binding.ibLikeDetail.setOnClickListener{
            onFavButtonClicked()
        }

        viewModel.locations.observe(viewLifecycleOwner){
           val loc = it[0]
            Log.d("LOC", "HeroeLocations = $loc")
            Log.d("LOC", "HeroeLocations = ${loc.id}")
            Log.d("LOC", "HeroeLocations = ${loc.dateShow}")
            Log.d("LOC", "HeroeLocations = ${loc.latitud}")
            Log.d("LOC", "HeroeLocations = ${loc.longitud}")
        }
        viewModel.retrieveHeroeLocations(args.heroeId)
/*
        val hasPermission = ActivityCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION)


 */
 //TODO I don't need location in order to show markers on a map.
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    private fun updateDetail(heroe: Heroe){
        binding.ivHeroeDetail.load(heroe.picture){
            //TODO add modifiers in here
        }
        binding.tvNameDetail.text = heroe.name.toString()
        binding.tvDescriptionDetail.text = heroe.description.toString()

        if(heroe.isFavourite){
            binding.ibLikeDetail.load(R.mipmap.star_fill)
        }else{
            binding.ibLikeDetail.load(R.mipmap.star)
        }
    }
    private fun onFavButtonClicked(){

        if(viewModel.heroe.value != null){
            val updatedHeroe = viewModel.heroe.value as Heroe //TODO review, danger dangerous.
            updatedHeroe.let {
                it.isFavourite = !it.isFavourite
            }
            if (updatedHeroe.isFavourite){
                binding.ibLikeDetail.load(R.mipmap.star_fill)

            }else{
                binding.ibLikeDetail.load(R.mipmap.star)
            }
            viewModel.updateHeroeFavStateLocalAndRemote(updatedHeroe.id,updatedHeroe.isFavourite)
        }
    }
}