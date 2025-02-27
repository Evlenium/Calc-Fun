package com.applications.calcfun.score.data

import android.content.SharedPreferences
import com.applications.calcfun.score.domain.api.ScoreRepository

class ScoreRepositoryImpl(private val sharedPreferences: SharedPreferences) : ScoreRepository {
    private companion object {
        const val TOTAL_SCORE = "total_score"
    }

    override fun addPoint() {
        sharedPreferences.edit().putInt(TOTAL_SCORE, getPoint() + 1).apply()
    }

    override fun getPoint() =
        sharedPreferences.getInt(TOTAL_SCORE, 0)
}