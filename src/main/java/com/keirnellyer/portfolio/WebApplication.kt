package com.keirnellyer.portfolio

import com.keirnellyer.portfolio.model.Profile
import com.keirnellyer.portfolio.repository.DummyProfileRepository
import com.keirnellyer.portfolio.repository.ProfileRepository
import com.keirnellyer.portfolio.view.ProfileView
import com.keirnellyer.portfolio.template.SparkHelper
import com.keirnellyer.portfolio.view.AppConfig
import spark.ModelAndView
import spark.Request
import spark.TemplateEngine
import spark.kotlin.get
import spark.kotlin.staticFiles
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class WebApplication(val templateEngine: TemplateEngine) {
    var appConfig: AppConfig = AppConfig(1337)
    val profileRepository: ProfileRepository = DummyProfileRepository()

    init {
        staticFiles.location("/public")

        get("/") {
            val model: MutableMap<String, Any> = HashMap()
            model.put("profile", view(profileRepository.profile))
            render(request, model, "index.ftl")
        }
    }

    fun view(model: Profile): ProfileView {
        // we use UTC time so that server and client work in the same timezone
        // format for future client-side parsing
        val birthDateOffset = model.birthDate
                .withZoneSameInstant(ZoneId.of("UTC"))
                .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)

        // obfuscate email so it isn't shown in plaintext (client-side JS will handle de-obfuscating)
        val obfuscatedEmail = xorString(model.email)

        return ProfileView(model.firstName, model.lastName, model.age, model.jobTitle, model.location,
                obfuscatedEmail)
    }

    fun xorString(s: String): String {
        // encode the string by XOR'ing each char
        // this can be decoded by repeating the operation
        return s.toCharArray()
                .map { c: Char -> c.toInt() xor appConfig.obfuscationKey }
                .map { i: Int -> i.toChar() }
                .joinToString(separator = "")
    }

    fun render(request: Request, model: Map<String, Any>, templatePath: String): String {
        val mutableModel: MutableMap<String, Any> = HashMap(model)
        mutableModel.put("appConfig", appConfig)
        mutableModel.put("fw", SparkHelper(request))
        return templateEngine.render(ModelAndView(mutableModel, templatePath))
    }
}
