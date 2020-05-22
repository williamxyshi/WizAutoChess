package com.source.wizautochess.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.source.wizautochess.R
import com.source.wizautochess.adapters.LobbyPlayersAdapter
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

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_lobby, container, false)

        setUpVM()

        getLobbyDataThread.start()



        recyclerView = rootview.findViewById(R.id.playerList)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = LobbyPlayersAdapter(context, vm)

        return rootview
    }

    private fun setUpVM() {
        Log.d(TAG, "initializing vm")
        vm = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        vm.lobbyData.observe(this, Observer {
            val size = vm.playerCount.value?:0
            val lobbyData = vm.lobbyData.value
            recyclerView.adapter?.notifyDataSetChanged()
            Log.d(TAG, "player size: ${lobbyData?.size}, lobby data: $lobbyData")
        })
    }

    companion object{
        const val TAG = "LobbyFragment"
    }
}
