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
            var result: Leg? = null
            for (leg in legs) {
                if (leg.isLongerThan(duration))
                    if (result == null ||
                        leg.isLongerThan(result.plannedDuration)
                    )
                        result = leg
        }
        return result
    }

    private fun Leg.isLongerThan(duration: Duration) =
        plannedDuration.compareTo(duration) > 0
}