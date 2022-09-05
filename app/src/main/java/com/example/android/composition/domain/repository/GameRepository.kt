package com.example.android.composition.domain.repository

import com.example.android.composition.domain.entity.GameSettings
import com.example.android.composition.domain.entity.Level
import com.example.android.composition.domain.entity.Question

interface GameRepository {
    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question

    fun getGameSettings(level: Level): GameSettings
}