package com.source.wizautochess.models

object LobbyDataModel {
    data class Result (val playercount: Int, val players: ArrayList<Player>)
    data class Player (val ready: Boolean, val username: String)
}