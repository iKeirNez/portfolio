package com.keirnellyer.portfolio

import freemarker.template.Configuration
import spark.TemplateEngine
import spark.template.freemarker.FreeMarkerEngine

fun main(args : Array<String>) {
    Application(createTemplateEngine())
}

fun createTemplateEngine(): TemplateEngine {
    val configuration: Configuration = Configuration(Configuration.VERSION_2_3_26)
    configuration.setClassForTemplateLoading({}::class.java, "/templates")

    return FreeMarkerEngine(configuration)
}
