package com.keirnellyer.portfolio

import spark.ModelAndView
import spark.TemplateEngine
import spark.kotlin.get
import spark.kotlin.staticFiles

class Application(val templateEngine: TemplateEngine) {
    init {
        staticFiles.location("/public")

        get("/") {
            val model: Map<String, Any> = HashMap()
            render(model, "index.ftl")
        }
    }

    fun render(model: Map<String, Any>, templatePath: String): String {
        return templateEngine.render(ModelAndView(model, templatePath))
    }
}
