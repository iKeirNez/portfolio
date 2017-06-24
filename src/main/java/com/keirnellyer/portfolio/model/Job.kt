package com.keirnellyer.portfolio.model

import java.time.LocalDate

class Job(var company: Establishment, var title: String, var description: String?, var from: LocalDate,
          var to: LocalDate?) {
    val currentlyWorksHere
            get() = to == null
}