package com.applications.calcfun.score.domain.api

interface ScoreInteractor {
    fun addPoint()
    fun getPoint(): Int
    fun clearScore()
}