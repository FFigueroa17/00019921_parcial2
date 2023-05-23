package com.figueroa.actortracker.data

import com.figueroa.actortracker.data.model.ActorModel


// DATA ACTOR 1
val name1 = "Tom Holland"
val age1 = "24"


// DATA ACTOR 2
val name2 = "Robert Downey Jr."
val age2 = "55"

// ADD DATA

val actors = mutableListOf(
    ActorModel(name1, age1),
    ActorModel(name2, age2),
)