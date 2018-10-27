package com.developmentmc.pokemonapp.model

class Pokemon(
    val avg_spawns: Int,
    val candy: String,
    val candy_count: Int,
    val egg: String,
    val height: String,
    val id: Int,
    val img: String,
    val multipliers: Any,
    val name: String,
    val next_evolution: List<Evolution>,
    val num: String,
    val prev_evolution: List<Evolution>,
    val spawn_chance: Int,
    val spawn_time: String,
    val type: List<String>,
    val weaknesses: List<String>,
    val weight: String
) {}