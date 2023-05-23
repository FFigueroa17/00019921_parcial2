package com.figueroa.actortracker.ui.actor.listActor.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.figueroa.actortracker.data.model.ActorModel
import com.figueroa.actortracker.databinding.ActorItemBinding

class ActorRecyclerViewHolder(private val binding: ActorItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind (actor : ActorModel, clickListener: (ActorModel) -> Unit){

            binding.actorNameTextView.text = actor.name
            binding.actorAgeTextView.text = actor.age

            binding.actorCardView.setOnClickListener {
                clickListener(actor)
            }
        }


}