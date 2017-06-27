package com.keirnellyer.portfolio.repository

import com.keirnellyer.portfolio.model.Profile

interface ProfileRepository {
    fun getProfile(): Profile
}
