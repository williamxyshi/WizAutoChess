package com.source.wizautochess

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.source.wizautochess.utils.WebServerAccessObject
import com.source.wizautochess.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_connect.*

class ConnectServerActivity : AppCompatActivity() {

    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "launching connect to server activity")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)

        setUpVM()

        WebServerAccessObject.startServerCall(vm)

        connectButton.setOnClickListener {
            WebServerAccessObject.setUsernameCall(vm, vm.playerID.value?:return@setOnClickListener,  usernameText.text.toString())
        }
    }

    private fun setUpVM(){
        Log.d(TAG, "initializing vm")
        vm = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        vm.playerID.observe(this, Observer {
            connectButton.visibility = View.VISIBLE
        })

        vm.usernameResponse.observe(this, Observer {

            /**
             * initialize LOBBY fragment
             */
        })

    }

    companion object{
        const val TAG = "ConnectServerActivity"
    }
}