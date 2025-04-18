package com.applications.calcfun.main.presentation

import androidx.lifecycle.ViewModel
import com.applications.calcfun.score.domain.api.ScoreInteractor

class MainViewModel(private val scoreInteractor: ScoreInteractor) : ViewModel() {
    fun clearScore() {
        scoreInteractor.clearScore()
    }
}