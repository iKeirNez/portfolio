package com.keirnellyer.portfolio.util

import spark.kotlin.RouteHandler
import java.util.regex.Pattern

object Filters {
    private val PATTERN_COMMA_SEPARATOR = Pattern.compile(",\\s*")

    val addGzipHeader: RouteHandler.() -> Unit = {
        if (request.headers("Accept-Encoding")?.split(PATTERN_COMMA_SEPARATOR)?.contains("gzip") ?: false) {
            response.header("Content-Encoding", "gzip")
        }
    }
}