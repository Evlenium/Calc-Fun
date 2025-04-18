package com.applications.calcfun.score.domain.use_case

import com.applications.calcfun.score.domain.api.ScoreInteractor
import com.applications.calcfun.score.domain.api.ScoreRepository

class ScoreInteractorImpl(private val scoreRepository: ScoreRepository) : ScoreInteractor {
    override fun addPoint() {
        scoreRepository.addPoint()
    }

    override fun getPoint() =
        scoreRepository.getPoint()

    override fun clearScore() {
        scoreRepository.clearScore()
    }
}