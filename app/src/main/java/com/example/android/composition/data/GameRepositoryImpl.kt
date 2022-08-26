package com.example.android.composition.data

import com.example.android.composition.domain.entity.GameSettings
import com.example.android.composition.domain.entity.Level
import com.example.android.composition.domain.entity.Question
import com.example.android.composition.domain.repository.GameRepository
import kotlin.random.Random
import kotlin.math.min
import kotlin.math.max

object GameRepositoryImpl : GameRepository {
    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = hashSetOf<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when(level) {
            Level.TEST -> {
                return GameSettings(
                    10,
                    3,
                    50,
                    8)
            }
            Level.EASY -> {
                return GameSettings(
                    10,
                    10,
                    70,
                    60)
            }
            Level.NORMAL -> {
                return GameSettings(
                    20,
                    20,
                    80,
                    40)
            }
            Level.HARD -> {
                return GameSettings(
                    30,
                    30,
                    90,
                    40)
            }
        }
    }
}