package com.example

import java.time.Duration
import java.util.Optional

object Legs {
    @JvmStatic
    fun findLongestLegOver(
        legs: List<Leg>,
        duration: Duration
    ): Optional<Leg> {
        return Optional.ofNullable(longestLegOver(legs, duration))
    }

    fun longestLegOver(
        legs: List<Leg>,
        duration: Duration
        ): Leg? {
            val longestLeg: Leg? = legs.maxByOrNull(Leg:: plannedDuration)
            if (longestLeg != null && longestLeg.plannedDuration > duration)
                return longestLeg
            else
                return null
    }

    private fun Leg.isLongerThan(duration: Duration) =
        plannedDuration > duration
}