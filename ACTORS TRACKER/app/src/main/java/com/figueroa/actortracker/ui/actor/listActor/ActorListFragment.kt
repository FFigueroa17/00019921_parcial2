package com.figueroa.actortracker.ui.actor.listActor

import android.os.Bundle
import android.text.Spannable.Factory
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.figueroa.actortracker.R
import com.figueroa.actortracker.data.model.ActorModel
import com.figueroa.actortracker.databinding.FragmentActorListBinding
import com.figueroa.actortracker.ui.actor.listActor.recyclerview.ActorRecyclerViewAdapter
import com.figueroa.actortracker.ui.actor.viewmodel.ActorViewModel

class ActorListFragment : Fragment() {

    // VIEW MODEL

    private val actorsViewModel: ActorViewModel by activityViewModels {
        ActorViewModel.Factory
    }

    // RECYCLER VIEW ADAPTER

    private lateinit var adapter: ActorRecyclerViewAdapter

    // BINDING

    private lateinit var binding: FragmentActorListBinding

    // ON CREATE VIEW (BINDING)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActorListBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ON VIEW CREATED

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        // NAVIGATE TO ADD ACTOR FRAGMENT (BUTTON)

        binding.addNewActorButton.setOnClickListener {
            actorsViewModel.clearData()
            it.findNavController().navigate(R.id.action_actorListFragment_to_actorAddFragment)
        }
    }

    // SET RECYCLER VIEW
    private fun setRecyclerView(view: View) {
        binding.actorListRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = ActorRecyclerViewAdapter {selectedActor ->
            showSelectedItem(selectedActor)
        }

        binding.actorListRecyclerView.adapter = adapter
        displayActors()
    }

    // DISPLAY ALL ACTORS

    private fun displayActors() {
        adapter.setData(actorsViewModel.getActors())
        adapter.notifyDataSetChanged()
    }

    // SHOW SELECTED ACTOR

    private fun showSelectedItem(selectedActor: ActorModel) {

        // SEND SELECTED ACTOR
        actorsViewModel.setSelectedActor(selectedActor)

        // NAVIGATE TO ACTOR DETAIL FRAGMENT
        findNavController().navigate(R.id.action_actorListFragment_to_actorInfoFragment)
    }
}