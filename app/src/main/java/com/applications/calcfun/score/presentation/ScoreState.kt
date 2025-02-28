package com.applications.calcfun.score.presentation

sealed interface ScoreState {
    data class Score(val score: Int) : ScoreState
}