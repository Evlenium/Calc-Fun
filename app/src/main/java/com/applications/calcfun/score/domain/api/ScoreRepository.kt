package com.applications.calcfun.score.domain.api

interface ScoreRepository {
    fun addPoint()
    fun getPoint(): Int
    fun clearScore()
}