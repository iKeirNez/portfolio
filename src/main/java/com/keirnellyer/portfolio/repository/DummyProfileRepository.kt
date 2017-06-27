package com.keirnellyer.portfolio.repository

import com.keirnellyer.portfolio.model.Profile

import java.time.LocalDate
import java.time.ZoneId

class DummyProfileRepository : ProfileRepository {
    private val profile: Profile

    init {
        val birthDateTime = LocalDate.of(1999, 1, 12).atStartOfDay(ZoneId.of("Europe/London"))
        profile = Profile("Keir", "Nellyer", birthDateTime, "Software Engineer", "Dunfermline, Scotland",
                "test@abc.com")
    }

    override fun getProfile(): Profile {
        return profile
    }
}
