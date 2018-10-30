package com.developmentmc.pokemonapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.LocalBroadcastManager
import android.view.MenuItem
import com.developmentmc.pokemonapp.Common.Common
import com.developmentmc.pokemonapp.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val showDetail = object: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent!!.action.toString() == Common.KEY_ENABLE_HOME){
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)

                val detailFragment: PokemonDetail = PokemonDetail.getInstance()
                val position: Int = intent.getIntExtra("position",-1)
                val bundle = Bundle()
                bundle.putInt("position", position)
                detailFragment.arguments = bundle

                val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.list_pokemon_fragment, detailFragment)
                fragmentTransaction.addToBackStack("detail")
                fragmentTransaction.commit()

                val pokemon: Pokemon = Common.pokemonList[position]
                toolbar.title = pokemon.name
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.setTitle("POKEMON LIST")
        setSupportActionBar(toolbar)
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showDetail, IntentFilter(Common.KEY_ENABLE_HOME))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home -> {
                toolbar.title = "POKEMON LIST"
                supportFragmentManager.popBackStack("detail",FragmentManager.POP_BACK_STACK_INCLUSIVE)
                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
                supportActionBar!!.setDisplayShowHomeEnabled(false)
            }
        }
        return true
    }
}
