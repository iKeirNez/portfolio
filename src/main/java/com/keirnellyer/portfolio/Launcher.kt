package com.keirnellyer.portfolio

import freemarker.template.Configuration
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
    val configuration: Configuration = Configuration(Configuration.VERSION_2_3_26)
    configuration.setClassForTemplateLoading({}::class.java, "/templates")
    return configuration
}

fun render(model: Map<String, Any>, templatePath: String): String {
    return FreeMarkerEngine(createFreemarkerConfig()).render(ModelAndView(model, templatePath))
}
