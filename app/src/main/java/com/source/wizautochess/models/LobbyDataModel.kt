package com.source.wizautochess.models

object LobbyDataModel {
    data class Result (val lobbyinfo: LobbyInfo)
    data class LobbyInfo (val playercount: Int, val playersinfo: ArrayList<Player>)
    data class Player (val ready: Boolean, val username: String)
}