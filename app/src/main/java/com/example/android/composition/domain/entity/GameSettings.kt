package com.example.android.composition.domain.entity

import java.io.Serializable

data class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSeconds: Int
) : Serializable