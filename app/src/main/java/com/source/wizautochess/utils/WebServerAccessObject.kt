package com.source.wizautochess.utils

import android.util.Log
import com.source.wizautochess.viewmodels.MainActivityViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

//retrofit object that handles web calls
object WebServerAccessObject {

    private val wizApiServe by lazy {
        WizAutoChesApiService.create()
    }
    var disposable: Disposable? = null

    fun startServerCall(vm: MainActivityViewModel){
        wizApiServe.startCall().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> showResult(result.id)
                                vm.playerID.value = result.id.toInt() },
                { error -> showResult(error.message?:"ERROR") }
            )
    }

    fun setUsernameCall(vm: MainActivityViewModel, id: Int, username: String){
        wizApiServe.addUser(id.toString(), username).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> showResult(result.result)
                                  vm.usernameResponse.value = result.result  },
                { error -> showResult(error.message?:"ERROR") }
            )
    }

    fun getLobbyDataCall(vm: MainActivityViewModel){
        wizApiServe.getPlayers().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> showResult("received lobby player info")
                    vm.lobbyData.value = result.players
                    vm.playerCount.value = result.playercount},
                { error -> showResult(error.message?:"ERROR") }
            )
    }

    fun showResult(s: String){
        Log.d(TAG, "result from server: $s")
    }


    const val TAG = "WebServerAccessObject"
}