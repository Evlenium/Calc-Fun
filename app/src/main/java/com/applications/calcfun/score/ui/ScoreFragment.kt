package com.applications.calcfun.score.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.applications.calcfun.databinding.FragmentScoreBinding
import com.applications.calcfun.score.presentation.ScoreState
import com.applications.calcfun.score.presentation.ScoreViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScoreFragment : Fragment() {
    private var _binding: FragmentScoreBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<ScoreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPoint()
        viewModel.observerScoreState().observe(viewLifecycleOwner) { score ->
            render(score)
        }
    }

    private fun render(score: ScoreState) {
        when (score) {
            is ScoreState.Score -> binding.textViewScore.text = score.score.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearScore()
        _binding = null
    }
}