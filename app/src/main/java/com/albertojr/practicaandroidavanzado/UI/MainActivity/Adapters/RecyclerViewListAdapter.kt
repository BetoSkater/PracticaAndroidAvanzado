package com.albertojr.practicaandroidavanzado.UI.MainActivity.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.albertojr.practicaandroidavanzado.R
import com.albertojr.practicaandroidavanzado.UI.MainActivity.Heroe
import androidx.recyclerview.widget.ListAdapter
class RecyclerViewListAdapter(private val onClick: (String) -> (Unit))
    : ListAdapter<Heroe, RecyclerViewListAdapter.HeroeViewHolder>(HeroeDiffCallback())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.heroe_cell, parent, false)
        return HeroeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HeroeViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private lateinit var heroe : Heroe
        private val heroeImage = view.findViewById<ImageView>(R.id.ivHeroeImageCell)
        private val heroeFav = view.findViewById<ImageButton>(R.id.ibFavCell)
        private val heroeName = view.findViewById<TextView>(R.id.tvHeroeNameCell)
        //TODO On Click listener goes here
        fun bind(heroe: Heroe){
            this.heroe = heroe

           //TODO use image library used by teacher not glide or picasso// heroeImage =

           // heroe.isLiked //TODO add the show and hide fav in a function

            heroeName.text = heroe.name
            heroeImage.maxWidth = 300
            heroeImage.minimumWidth  = 300
            heroeImage.maxHeight = 300
            heroeImage.minimumHeight  = 300
        }
    }
    class HeroeDiffCallback: DiffUtil.ItemCallback<Heroe>() {
        override fun areItemsTheSame(oldItem: Heroe, newItem: Heroe): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Heroe, newItem: Heroe): Boolean {
            return oldItem == newItem
        }
    }
}

