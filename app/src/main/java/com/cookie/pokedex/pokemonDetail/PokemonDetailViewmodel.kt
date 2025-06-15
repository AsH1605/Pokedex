package com.cookie.pokedex.pokemonDetail

import androidx.lifecycle.ViewModel
import com.cookie.pokedex.data.remote.responses.Pokemon
import com.cookie.pokedex.repository.PokemonRepository
import com.cookie.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewmodel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }
}