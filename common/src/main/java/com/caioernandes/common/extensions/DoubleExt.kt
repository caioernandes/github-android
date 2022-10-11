package com.caioernandes.common.extensions

import kotlin.math.pow
import kotlin.math.roundToInt

fun Double?.orZero() = this ?: 0.0

fun Double.roundTo(numFractionDigits: Int): Double {
    val factor = 10.0.pow(numFractionDigits.toDouble())
    return (this * factor).roundToInt() / factor
}