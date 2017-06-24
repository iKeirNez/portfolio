package com.keirnellyer.portfolio.repository

import com.keirnellyer.portfolio.model.Profile

import java.time.LocalDate
import java.time.ZoneId

class DummyProfileRepository : ProfileRepository {
    override val profile: Profile
        get() {
            val birthDateTime = LocalDate.of(1999, 1, 12).atStartOfDay(ZoneId.of("Europe/London"))
            return Profile("Keir", "Nellyer", birthDateTime, "Software Engineer", "Dunfermline, Scotland",
                    "test@abc.com")
        }
}
