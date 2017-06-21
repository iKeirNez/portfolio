package com.keirnellyer.portfolio

import java.time.ZonedDateTime
import java.util.Objects

class Profile(var firstName: String, var lastName: String, var birthDate: ZonedDateTime, var location: String, var email: String) {

    val fullName: String
        get() = firstName + " " + lastName

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Profile) return false

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (birthDate != other.birthDate) return false
        if (location != other.location) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + birthDate.hashCode()
        result = 31 * result + location.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

    override fun toString(): String {
        return "Profile(firstName='$firstName', lastName='$lastName', birthDate=$birthDate, location='$location', email='$email')"
    }
}
