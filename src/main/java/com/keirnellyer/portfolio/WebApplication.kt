//package com.keirnellyer.portfolio
//
//import com.keirnellyer.portfolio.controller.PortfolioController
//import com.keirnellyer.portfolio.util.Filters
//import com.keirnellyer.portfolio.view.AppConfig
//import freemarker.template.Configuration
//import no.api.freemarker.java8.Java8ObjectWrapper
//import spark.TemplateEngine
//import spark.debug.DebugScreen.*
//import spark.kotlin.after
//import spark.kotlin.staticFiles
//import spark.template.freemarker.FreeMarkerEngine
//
//class WebApplication {
//    companion object {
//        val appConfig: AppConfig = AppConfig(1337)
//        val templateEngine: TemplateEngine
//
//        init {
//            // configure and set template engine
//            val configuration: Configuration = Configuration(Configuration.VERSION_2_3_26)
//            configuration.setClassForTemplateLoading({}::class.java, "/templates")
//            configuration.objectWrapper = Java8ObjectWrapper(Configuration.VERSION_2_3_26)
//            templateEngine = FreeMarkerEngine(configuration)
//        }
//    }
//
//    init {
//        staticFiles.location("/public")
//        enableDebugScreen()
//
//        PortfolioController(appConfig).initializeRoutes()
//
//        after(function = Filters.addGzipHeader)
//    }
//
//}
