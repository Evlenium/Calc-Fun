package com.applications.calcfun.score.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applications.calcfun.score.domain.api.ScoreInteractor

class ScoreViewModel(private val scoreInteractor: ScoreInteractor) : ViewModel() {
    private val scoreLiveData = MutableLiveData<ScoreState>()
    fun observerScoreState(): LiveData<ScoreState> = scoreLiveData
    fun getPoint() {
        renderState(ScoreState.Score(scoreInteractor.getPoint()))
    }

    fun clearScore() {
        scoreInteractor.clearScore()
    }

    private fun renderState(score: ScoreState) {
        scoreLiveData.postValue(score)
    }
}