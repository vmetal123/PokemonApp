package com.developmentmc.pokemonapp.model

class Pokemon{
    var avg_spawns: Double = 0.toDouble()
    var candy: String? = null
    var candy_count: Int = 0
    var egg: String? = null
    var height: String? = null
    var id: Int = 0
    var img: String? = null
    var multipliers: List<Double>? = null
    var name: String? = null
    var next_evolution: List<Evolution>? = null
    var num: String? = null
    var prev_evolution: List<Evolution>? = null
    var spawn_chance: Double = 0.toDouble()
    var spawn_time: String? = null
    var type: List<String>? = null
    var weaknesses: List<String>? = null
    var weight: String? = null
}