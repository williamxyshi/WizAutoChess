package com.source.wizautochess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.source.wizautochess.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setUpVM()

    }

    private fun setUpVM(){
        Log.d(TAG, "initializing vm")
        vm = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)


    }


    companion object{
        private const val TAG = "MainActivity"
    }
}
