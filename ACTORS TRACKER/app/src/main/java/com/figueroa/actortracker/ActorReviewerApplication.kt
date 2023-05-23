package com.figueroa.actortracker

import android.app.Application
import com.figueroa.actortracker.data.actors
import com.figueroa.actortracker.repository.ActorRepository

class ActorReviewerApplication : Application() {

    // ADD GLOBAL REPOSITORY

    val actorRepository: ActorRepository by lazy {
        ActorRepository(actors)
    }
}