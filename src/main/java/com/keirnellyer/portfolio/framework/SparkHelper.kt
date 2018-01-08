//package com.keirnellyer.portfolio.template
//
//import spark.Request
//
//class SparkHelper(request: Request) : FrameworkHelper {
//    // context path can be null, if so replace with '/'
//    override val contextPath: String = (request.contextPath() ?: "") + "/"
//
//    override fun url(path: String): String {
//        var path = path
//
//        // remove opening forward slash to prevent a double slash when appended to the context path
//        if (path.startsWith("/")) {
//            path = path.substring(Math.min(1, path.length), path.length)
//        }
//
//        return contextPath + path
//    }
//}
