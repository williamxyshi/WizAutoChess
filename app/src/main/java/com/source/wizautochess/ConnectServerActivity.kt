package com.source.wizautochess

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.source.wizautochess.utils.WebServerAccessObject

class ConnectServerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "launching connect to server activity")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)

        WebServerAccessObject.makeCall()

    }

    companion object{
        const val TAG = "ConnectServerActivity"
    }
}