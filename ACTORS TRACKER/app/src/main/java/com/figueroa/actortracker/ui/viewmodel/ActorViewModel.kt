package com.figueroa.actortracker.ui.viewmodel

import android.text.Editable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.figueroa.actortracker.ActorReviewerApplication
import com.figueroa.actortracker.data.model.ActorModel
import com.figueroa.actortracker.repository.ActorRepository

class ActorViewModel(private val repository: ActorRepository) : ViewModel() {

    // DATA

    var name = MutableLiveData("")
    var age = MutableLiveData("")

    // STATUS

    var status = MutableLiveData("")

    // FUNCTIONS

    // GET ACTORS

    fun getActors() = repository.getActors()

    // ADD ACTORS

    private fun addActor(actor: ActorModel) = repository.addActors(actor)

    // CREATE ACTORS

    fun createActor() {

        // VALIDATE DATA

        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        // IF VALIDATED

        // CREATE ACTOR

        val actor = ActorModel(
            name.value!!,
            age.value!!
        )

        // ADD ACTOR

        addActor(actor)

        // CLEAR DATA
        clearData()

        // UPDATE STATUS
        status.value = ACTOR_CREATED
    }

    // FUN CLEAR DATA

    fun clearData() {

        // SET ""
        name.value = ""
        age.value = ""
    }

    // FUN VALIDATE DATA - FIELDS ARE NOT EMPTY

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            age.value.isNullOrEmpty() -> return false
        }
        return true
    }

    // FUN CLEAR STATUS

    fun clearStatus() {
        status.value = INACTIVE
    }

    // FUN SET SELECTED ACTOR

    fun setSelectedActor(actor: ActorModel) {

        // SET VALUES FROM SELECTED ACTOR

        name.value = actor.name
        age.value = actor.age
    }

    // COMPANION OBJECT

    companion object {

        // FACTORY

        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ActorReviewerApplication
                ActorViewModel(app.actorRepository)
            }
        }

        // ADD STATUS

        const val WRONG_INFORMATION = "Wrong information"
        const val ACTOR_CREATED = "Actor created"
        const val INACTIVE = ""
    }

}