package com.developmentmc.pokemonapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developmentmc.pokemonapp.Adapter.PokemonListAdapter
import com.developmentmc.pokemonapp.Common.Common
import com.developmentmc.pokemonapp.Common.ItemOffsetDecoration
import com.developmentmc.pokemonapp.Retrofit.IPokemonList
import com.developmentmc.pokemonapp.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import retrofit2.Retrofit

class PokemonList : Fragment() {

    internal var compositeDisposable = CompositeDisposable()
    internal var iPokemonList: IPokemonList

    internal lateinit var recyclerView: RecyclerView

    init {
        val retrofit: Retrofit =  RetrofitClient.instance
        iPokemonList = retrofit.create(IPokemonList::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
        recyclerView = itemView.findViewById(R.id.pokemon_recyclerview) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        val itemDecoration = ItemOffsetDecoration(activity!!, R.dimen.spacing)
        recyclerView.addItemDecoration(itemDecoration)

        fetchData()
        return itemView
    }

    private fun fetchData() {
        compositeDisposable.add(iPokemonList.listPokemon
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ pokemonDex ->
                Common.pokemonList = pokemonDex.pokemon!!
                val adapter = PokemonListAdapter(activity!!, Common.pokemonList)

                recyclerView.adapter = adapter
            })
    }


}
