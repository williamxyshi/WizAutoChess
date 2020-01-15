package com.source.wizautochess.utils

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

//retrofit object that handles web calls
object WebServerAccessObject {

    val wikiApiServe by lazy {
        WizAutoChesApiService.create()
    }
    var disposable: Disposable? = null

    fun makeCall(){
        wikiApiServe.startCall().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> showResult(result.id) },
                { error -> showResult(error.message?:"ERROR") }
            )
    }

    fun showResult(s: String){
        Log.d(TAG, "result from server: $s")
    }


    const val TAG = "WebServerAccessObject"
}