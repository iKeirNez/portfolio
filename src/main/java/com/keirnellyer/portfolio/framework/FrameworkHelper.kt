package com.keirnellyer.portfolio.template

/**
 * Helper for template engine which is implemented by the supporting framework.
 *
 * This allows a template to get properties from the request and use framework related helper methods.
 */
interface FrameworkHelper {
    /**
     * The context path.
     */
    val contextPath: String

    /**
     * Prepends a path with the context path.
     */
    fun url(path: String): String
}
