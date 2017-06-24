package com.keirnellyer.portfolio.model

import java.time.LocalDate

class Education(var school: Establishment, var degree: String, var studyField: String, var description: String?,
                var from: LocalDate, var to: LocalDate) {
}