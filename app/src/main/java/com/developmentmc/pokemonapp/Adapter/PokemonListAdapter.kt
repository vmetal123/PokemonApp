package com.developmentmc.pokemonapp.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.developmentmc.pokemonapp.R
import com.developmentmc.pokemonapp.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class PokemonListAdapter(internal var context: Context,
                         internal var pokemonList: List<Pokemon>): RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        Glide.with(context).load(pokemonList[position].img).into(holder.img_pokemon)
        holder.txt_pokemon.text =pokemonList[position].name
    }

    inner class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        internal var img_pokemon: ImageView
        internal var txt_pokemon: TextView

        init {
            img_pokemon = itemView.findViewById(R.id.pokemon_image) as ImageView
            txt_pokemon = itemView.findViewById(R.id.pokemon_name) as TextView
        }
    }
}