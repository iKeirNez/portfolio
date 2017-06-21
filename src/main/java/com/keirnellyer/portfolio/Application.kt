package com.keirnellyer.portfolio

import spark.ModelAndView
import spark.TemplateEngine
import spark.kotlin.get
import spark.kotlin.staticFiles
import java.time.LocalDate
import java.time.ZoneId

class Application(val templateEngine: TemplateEngine) {
    val profile: Profile = createProfile()

    init {
        staticFiles.location("/public")

        get("/") {
            val model: MutableMap<String, Any> = HashMap()
            render(model, "index.ftl")
        }
    }

    fun render(model: MutableMap<String, Any>, templatePath: String): String {
        model.put("profile", profile)
        return templateEngine.render(ModelAndView(model, templatePath))
    }

    fun createProfile(): Profile {
        val birthDate = LocalDate.of(1999, 1, 12)
        val zonedBirthDate = birthDate.atStartOfDay(ZoneId.of("Europe/London"))
        return Profile("Keir", "Nellyer", zonedBirthDate, "Dunfermline, Scotland", "keir@nellyer.co.uk")
    }
}
