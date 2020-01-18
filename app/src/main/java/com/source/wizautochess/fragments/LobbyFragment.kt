package com.source.wizautochess.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.source.wizautochess.R
import com.source.wizautochess.models.LobbyDataModel
import com.source.wizautochess.utils.WebServerAccessObject
import com.source.wizautochess.viewmodels.MainActivityViewModel

class LobbyFragment : Fragment() {
    private lateinit var vm: MainActivityViewModel
    private val getLobbyDataThread = Thread {
        while (true) {
            Thread.sleep(1000)
            WebServerAccessObject.getLobbyDataCall(vm)
        }
    }
    private var usernameTextViews: MutableList<TextView> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_lobby, container, false)

        usernameTextViews.add(rootview.findViewById(R.id.usernameText1))
        usernameTextViews.add(rootview.findViewById(R.id.usernameText2))
        usernameTextViews.add(rootview.findViewById(R.id.usernameText3))
        usernameTextViews.add(rootview.findViewById(R.id.usernameText4))
        usernameTextViews.add(rootview.findViewById(R.id.usernameText5))
        usernameTextViews.add(rootview.findViewById(R.id.usernameText6))
        usernameTextViews.add(rootview.findViewById(R.id.usernameText7))
        usernameTextViews.add(rootview.findViewById(R.id.usernameText8))

        setUpVM()

        getLobbyDataThread.start()
        return rootview
    }

    private fun setUpVM() {
        Log.d(TAG, "initializing vm")

        vm.lobbyData.observe(this, Observer {
            val size = vm.playerCount.value?:0
            val lobbyData = vm.lobbyData.value
            if (lobbyData != null)
            for (i in 0 until size) {
                usernameTextViews[i].apply {
                    text = lobbyData[i].username
                }
            }
        })
    }

    companion object{
        const val TAG = "LobbyFragment"
    }
}
