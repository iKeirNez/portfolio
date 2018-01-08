//package com.keirnellyer.portfolio.view
//
//import com.keirnellyer.portfolio.WebApplication
//import com.keirnellyer.portfolio.template.SparkHelper
//import spark.ModelAndView
//import spark.Request
//import spark.TemplateEngine
//
//object ViewUtil {
//    fun render(request: Request, model: Map<String, Any>, view: String,
//               appConfig: AppConfig = WebApplication.appConfig,
//               templateEngine: TemplateEngine = WebApplication.templateEngine): String {
//        val mutableModel: MutableMap<String, Any> = HashMap(model)
//        mutableModel.put("appConfig", appConfig)
//        mutableModel.put("fw", SparkHelper(request))
//        return templateEngine.render(ModelAndView(mutableModel, view))
//    }
//}