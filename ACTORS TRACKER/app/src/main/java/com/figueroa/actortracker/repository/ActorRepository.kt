package com.figueroa.actortracker.repository

import com.figueroa.actortracker.data.model.ActorModel

class ActorRepository(private val actors: MutableList<ActorModel>) {

    // GET ALL ACTORS

    fun getActors() = actors

    // ADD NEW ACTOR

    fun addActors(actor: ActorModel) = actors.add(actor)
}