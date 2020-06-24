package com.source.wizautochess.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.source.wizautochess.R
import com.source.wizautochess.viewmodels.MainActivityViewModel

class LobbyPlayersAdapter(private val context: Context?, private val vm: MainActivityViewModel)  : RecyclerView.Adapter<LobbyPlayersAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerViewHolder{
            return PlayerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_player_name, parent, false)).apply {
                userName = itemView.findViewById(R.id.cellPlayerName)
            }
    }

    override fun onBindViewHolder(
        holder: PlayerViewHolder,
        position: Int
    ) {
        val username = vm.lobbyData.value?.get(position)?.username
        val ready = vm.lobbyData.value?.get(position)?.ready
        holder.userName.text = username

        if(ready == true) {
            holder.userName.setTextColor(context?.resources?.getColor(R.color._light_green)?:return)
        } else {
            holder.userName.setTextColor(context?.resources?.getColor(R.color.red)?:return)
        }


    }

    override fun getItemCount(): Int {
        return vm.lobbyData.value?.size?:0
    }

    inner class PlayerViewHolder(item: View): RecyclerView.ViewHolder(item){
        lateinit var userName: TextView
    }
}