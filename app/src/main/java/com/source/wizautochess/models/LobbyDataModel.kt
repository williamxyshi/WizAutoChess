package com.source.wizautochess.models

object LobbyDataModel {
    data class Result (val lobbyinfo: Players)
    data class Players (val players: ArrayList<Player>, val playercount: Int)
    data class Player (val ready: Boolean, val username: String)
}