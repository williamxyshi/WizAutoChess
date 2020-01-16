package com.source.wizautochess.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class
MainActivityViewModel(application: Application): AndroidViewModel(application) {

    var playerID: MutableLiveData<Int> = MutableLiveData()
    var usernameResponse: MutableLiveData<String> = MutableLiveData()


    companion object{
        private const val TAG = "MainActivityViewModel"

    }
}