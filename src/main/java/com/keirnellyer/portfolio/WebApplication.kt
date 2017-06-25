package com.keirnellyer.portfolio

import com.keirnellyer.portfolio.controller.PortfolioController
import com.keirnellyer.portfolio.repository.DummyProfileRepository
import com.keirnellyer.portfolio.repository.ProfileRepository
import com.keirnellyer.portfolio.util.Filters
import com.keirnellyer.portfolio.view.AppConfig
import freemarker.template.Configuration
import no.api.freemarker.java8.Java8ObjectWrapper
import spark.TemplateEngine
import spark.kotlin.after
import spark.kotlin.staticFiles
import spark.template.freemarker.FreeMarkerEngine

class WebApplication {
    companion object {
        val appConfig: AppConfig = AppConfig(1337)
        val templateEngine: TemplateEngine

        init {
            // configure and set template engine
            val configuration: Configuration = Configuration(Configuration.VERSION_2_3_26)
            configuration.setClassForTemplateLoading({}::class.java, "/templates")
            configuration.objectWrapper = Java8ObjectWrapper(Configuration.VERSION_2_3_26)
            templateEngine = FreeMarkerEngine(configuration)
        }
    }

    val profileRepository: ProfileRepository = DummyProfileRepository()

    init {
        staticFiles.location("/public")

        PortfolioController(appConfig, profileRepository).initializeRoutes()

        after(function = Filters.addGzipHeader)
    }

}
