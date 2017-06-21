package com.keirnellyer.portfolio

import freemarker.template.Configuration
import freemarker.template.Version
import spark.ModelAndView
import spark.kotlin.get
import spark.kotlin.staticFiles
import spark.template.freemarker.FreeMarkerEngine

fun main(args : Array<String>) {
    staticFiles.location("/public")

    get("/") {
        val model: Map<String, Any> = HashMap()
        render(model, "index.ftl")
    }
}

fun createFreemarkerConfig(): Configuration {
    val configuration: Configuration = Configuration(Version(2, 3, 26))
    configuration.setClassForTemplateLoading({}::class.java, "/templates")
    return configuration
}

fun render(model: Map<String, Any>, templatePath: String): String {
    return FreeMarkerEngine(createFreemarkerConfig()).render(ModelAndView(model, templatePath))
}
