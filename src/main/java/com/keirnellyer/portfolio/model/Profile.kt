package com.keirnellyer.portfolio.model

import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

class Profile(var firstName: String, var lastName: String, var birthDate: ZonedDateTime, var jobTitle: String,
              var location: String, var email: String) {
    val age: Int
        get() {
            return birthDate.until(ZonedDateTime.now(), ChronoUnit.YEARS).toInt()
        }
}
