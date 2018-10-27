package com.developmentmc.pokemonapp.Retrofit

import com.developmentmc.pokemonapp.model.Pokedex
import io.reactivex.Observable
import retrofit2.http.GET

interface IPokemonList {
    @get:GET("pokedex.json")
    val listPokemon: Observable<Pokedex>
}