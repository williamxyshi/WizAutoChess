package com.source.wizautochess.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.source.wizautochess.models.LobbyDataModel

class
MainActivityViewModel(application: Application): AndroidViewModel(application) {

    var playerID: MutableLiveData<Int> = MutableLiveData()
    var usernameResponse: MutableLiveData<String> = MutableLiveData()
    var lobbyData: MutableLiveData<ArrayList<LobbyDataModel.Player>> = MutableLiveData()
    var playerCount: MutableLiveData<Int> = MutableLiveData()


    companion object{
        private const val TAG = "MainActivityViewModel"

    }
}