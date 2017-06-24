package com.keirnellyer.portfolio

import com.keirnellyer.portfolio.repository.DummyProfileRepository
import com.keirnellyer.portfolio.repository.ProfileRepository
import com.keirnellyer.portfolio.template.XorStringMethod
import spark.ModelAndView
import spark.TemplateEngine
import spark.kotlin.get
import spark.kotlin.staticFiles

class Application(val templateEngine: TemplateEngine) {
    val profileRepository: ProfileRepository = DummyProfileRepository()

    init {
        staticFiles.location("/public")

        get("/") {
            val model: MutableMap<String, Any> = HashMap()
            render(model, "index.ftl")
        }
    }

    fun render(model: MutableMap<String, Any>, templatePath: String): String {
        model.put("profile", profileRepository.profile)
        model.put("xorString", XorStringMethod())
        return templateEngine.render(ModelAndView(model, templatePath))
    }
}
