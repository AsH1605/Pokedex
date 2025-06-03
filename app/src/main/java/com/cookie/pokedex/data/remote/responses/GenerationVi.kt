package com.cookie.pokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire,

    @SerializedName("x-y")
    val xy: XY
)