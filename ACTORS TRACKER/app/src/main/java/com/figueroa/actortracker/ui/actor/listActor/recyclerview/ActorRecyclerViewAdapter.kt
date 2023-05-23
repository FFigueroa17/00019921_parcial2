package com.figueroa.actortracker.ui.actor.listActor.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.figueroa.actortracker.data.model.ActorModel
import com.figueroa.actortracker.databinding.ActorItemBinding

class ActorRecyclerViewAdapter(private val clickListener: (ActorModel)-> Unit):RecyclerView.Adapter<ActorRecyclerViewHolder>() {

    // LIST OF ACTORS

    private val actors = ArrayList<ActorModel>()

    // BINDING
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorRecyclerViewHolder {

        val binding = ActorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorRecyclerViewHolder(binding)

    }

    // ACTORS.SIZE
    override fun getItemCount(): Int = actors.size

    // EACH CARD
    override fun onBindViewHolder(holder: ActorRecyclerViewHolder, position: Int) {
        val actor = actors[position]
        holder.bind(actors[position], clickListener)
    }

    // FUN SET DATA

    fun setData(actorsList: List<ActorModel>){
        actors.clear()
        actors.addAll(actorsList)
    }
}