package com.figueroa.actortracker.ui.actor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.figueroa.actortracker.R
import com.figueroa.actortracker.databinding.FragmentActorInfoBinding
import com.figueroa.actortracker.ui.actor.viewmodel.ActorViewModel

class ActorInfoFragment : Fragment() {

    // VIEW MODEL

    private val actorsViewModel: ActorViewModel by activityViewModels {
        ActorViewModel.Factory
    }

    // DATA BINDING

    private lateinit var binding: FragmentActorInfoBinding

    // ON CREATE VIEW (BINDING)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActorInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ON VIEW CREATED

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    // SET VIEW MODEL
    private fun setViewModel() {
        binding.viewmodel = actorsViewModel
    }
}