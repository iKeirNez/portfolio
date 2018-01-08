//package com.keirnellyer.portfolio.controller
//
//import com.keirnellyer.portfolio.view.AppConfig
//import com.keirnellyer.portfolio.view.ViewUtil
//import spark.kotlin.get
//import spark.kotlin.RouteHandler
//
//class PortfolioController(val appConfig: AppConfig) {
//    fun initializeRoutes() {
//        get("/", function = servePortfolioPage)
//    }
//
//    val servePortfolioPage: RouteHandler.() -> Any = {
//        val model: MutableMap<String, Any> = HashMap()
//
////        val profile = profileRepository.profile
////        // obfuscate email so it isn't shown in plaintext (client-side JS will handle de-obfuscating)
////        val obfuscatedEmail = xorString(profile.email)
////        val profileView = ProfileView(profile.firstName, profile.lastName, profile.age, profile.jobTitle,
////                profile.location, obfuscatedEmail)
////
////        model.put("profile", profileView)
//        ViewUtil.render(request, model, "index.ftl")
//    }
//
//    private fun xorString(s: String): String {
//        // encode the string by XOR'ing each char
//        // this can be decoded by repeating the operation
//        return s.toCharArray()
//                .map { c: Char -> c.toInt() xor appConfig.obfuscationKey }
//                .map { i: Int -> i.toChar() }
//                .joinToString(separator = "")
//    }
//}
