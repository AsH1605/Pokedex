package com.cookie.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.util.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cookie.pokedex.pokemonDetail.PokemonDetailScreen
import com.cookie.pokedex.pokemonlist.PokemonListScreen
import com.cookie.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "pokemon_list_screen") {
                    composable("pokemon_list_screen") {
                        PokemonListScreen(navController)
                    }
                    composable(
                        "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            }
                        )) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }
                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName?.toLowerCase(Locale.ROOT)?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

