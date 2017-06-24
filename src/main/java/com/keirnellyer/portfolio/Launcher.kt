package com.keirnellyer.portfolio

import freemarker.template.Configuration
import no.api.freemarker.java8.Java8ObjectWrapper
import spark.TemplateEngine
import spark.template.freemarker.FreeMarkerEngine

fun main(args : Array<String>) {
    WebApplication(createTemplateEngine())
}

fun createTemplateEngine(): TemplateEngine {
    val configuration: Configuration = Configuration(Configuration.VERSION_2_3_26)
    configuration.setClassForTemplateLoading({}::class.java, "/templates")
    configuration.objectWrapper = Java8ObjectWrapper(Configuration.VERSION_2_3_26)

    return FreeMarkerEngine(configuration)
}
