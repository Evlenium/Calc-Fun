package com.applications.calcfun.score.data

import android.content.SharedPreferences
import android.util.Log
import com.applications.calcfun.score.domain.api.ScoreRepository

class ScoreRepositoryImpl(private val sharedPreferences: SharedPreferences) : ScoreRepository {
    private companion object {
        const val TOTAL_SCORE = "total_score"
    }

    override fun addPoint() {
        sharedPreferences.edit().putInt(TOTAL_SCORE, getPoint() + 1).apply()
    }

    override fun getPoint(): Int {
        Log.d("MyLog",sharedPreferences.getInt(TOTAL_SCORE, 0).toString())
        return sharedPreferences.getInt(TOTAL_SCORE, 0)
    }

    override fun clearScore() {
        sharedPreferences.edit().clear().apply()
    }
}