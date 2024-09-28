package com.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import com.example.Legs.findLongestLegOver
import com.example.Legs.longestLegOver
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.*
import java.util.List
import java.util.concurrent.ThreadLocalRandom
class LongestLegOverTests {
    private val legs = List.of(
        leg("one hour", Duration.ofHours(1)),
        leg("one day", Duration.ofDays(1)),
        leg("two hours", Duration.ofHours(2))
    )
    private val oneDay = Duration.ofDays(1)

    @Test
    fun `is absent when no legs`() {
        assertNull(longestLegOver(emptyList(), Duration.ZERO))
    }

    @Test
    fun `is absent when no legs long enough` () {
        assertNull(longestLegOver(legs, oneDay))
    }

    @Test
    fun is_longest_leg_when_one_match() {
        assertEquals(
            "one day",
            longestLegOver(legs, oneDay.minusMillis(1))
                    !!.description
        )
    }

    @Test
    fun is_longest_leg_when_more_than_one_match() {
        assertEquals(
            "one day",
            longestLegOver(legs, Duration.ofMinutes(59))
                ?.description
        )
    }

    private fun leg(description: String, duration: Duration): Leg {
        val start = ZonedDateTime.ofInstant(
            Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt().toLong()),
            ZoneId.of("UTC")
        );
        return Leg(description, start, start.plus(duration));
    }
}