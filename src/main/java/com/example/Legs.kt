package com.example

import java.time.Duration
import java.util.Optional

object Legs {

    fun List<Leg>.longestOver(duration: Duration): Leg? {
        val longestLeg = maxByOrNull(Leg:: plannedDuration)
        return when {
            longestLeg == null -> null
            longestLeg.plannedDuration > duration -> longestLeg
            else -> null
        }
    }

    private fun Leg.isLongerThan(duration: Duration) =
        plannedDuration > duration
}