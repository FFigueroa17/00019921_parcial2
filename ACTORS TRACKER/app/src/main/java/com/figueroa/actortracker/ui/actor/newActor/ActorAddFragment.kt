package com.figueroa.actortracker.ui.actor.newActor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.figueroa.actortracker.R
import com.figueroa.actortracker.databinding.FragmentActorAddBinding
import com.figueroa.actortracker.ui.actor.viewmodel.ActorViewModel

class ActorAddFragment : Fragment() {

    // VIEW MODEL

    private val actorsViewModel: ActorViewModel by activityViewModels {
        ActorViewModel.Factory
    }

    // DATA BINDING

    private lateinit var binding: FragmentActorAddBinding

    // ON CREATE VIEW (BINDING)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentActorAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ON VIEW CREATED

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        setObserveStatus()
    }


    // FUN OBSERVE STATUS

    private fun setObserveStatus() {
        actorsViewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(ActorViewModel.WRONG_INFORMATION) -> {
                    actorsViewModel.clearStatus()
                }
                status.equals(ActorViewModel.ACTOR_CREATED) -> {
                    actorsViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }

    }

    // FUN SET VIEW MODEL
    private fun setViewModel() {
        binding.viewmodel = actorsViewModel
    }
}