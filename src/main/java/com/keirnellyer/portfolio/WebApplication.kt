package com.keirnellyer.portfolio

import com.keirnellyer.portfolio.model.Profile
import com.keirnellyer.portfolio.repository.DummyProfileRepository
import com.keirnellyer.portfolio.repository.ProfileRepository
import com.keirnellyer.portfolio.view.ProfileView
import spark.ModelAndView
import spark.TemplateEngine
import spark.kotlin.get
import spark.kotlin.staticFiles
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class WebApplication(val templateEngine: TemplateEngine) {
    val profileRepository: ProfileRepository = DummyProfileRepository()

    init {
        staticFiles.location("/public")

        get("/") {
            val model: MutableMap<String, Any> = HashMap()
            model.put("profile", view(profileRepository.profile))
            render(model, "index.ftl")
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

        return ProfileView(model.firstName, model.lastName, birthDateOffset, model.jobTitle, model.location,
                obfuscatedEmail)
    }

    private val MAGIC_NUMBER = 1337

    fun xorString(s: String): String {
        // encode the string by XOR'ing each char
        // this can be decoded by repeating the operation
        return s.toCharArray()
                .map { c: Char -> c.toInt() xor MAGIC_NUMBER }
                .map { i: Int -> i.toChar() }
                .joinToString(separator = "")
    }

    fun render(model: MutableMap<String, Any>, templatePath: String): String {
        return templateEngine.render(ModelAndView(model, templatePath))
    }
}
