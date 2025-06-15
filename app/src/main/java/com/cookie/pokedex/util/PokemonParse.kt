package com.cookie.pokedex.util

import androidx.compose.ui.graphics.Color
import com.cookie.pokedex.data.remote.responses.Stat
import com.cookie.pokedex.data.remote.responses.Type
import com.cookie.pokedex.ui.theme.AtkColor
import com.cookie.pokedex.ui.theme.DefColor
import com.cookie.pokedex.ui.theme.HPColor
import com.cookie.pokedex.ui.theme.SpAtkColor
import com.cookie.pokedex.ui.theme.SpDefColor
import com.cookie.pokedex.ui.theme.SpdColor
import com.cookie.pokedex.ui.theme.TypeBug
import com.cookie.pokedex.ui.theme.TypeDark
import com.cookie.pokedex.ui.theme.TypeDragon
import com.cookie.pokedex.ui.theme.TypeElectric
import com.cookie.pokedex.ui.theme.TypeFairy
import com.cookie.pokedex.ui.theme.TypeFighting
import com.cookie.pokedex.ui.theme.TypeFire
import com.cookie.pokedex.ui.theme.TypeFlying
import com.cookie.pokedex.ui.theme.TypeGhost
import com.cookie.pokedex.ui.theme.TypeGrass
import com.cookie.pokedex.ui.theme.TypeGround
import com.cookie.pokedex.ui.theme.TypeIce
import com.cookie.pokedex.ui.theme.TypeNormal
import com.cookie.pokedex.ui.theme.TypePoison
import com.cookie.pokedex.ui.theme.TypePsychic
import com.cookie.pokedex.ui.theme.TypeRock
import com.cookie.pokedex.ui.theme.TypeSteel
import com.cookie.pokedex.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}