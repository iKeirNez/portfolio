package com.keirnellyer.portfolio.template

import freemarker.template.SimpleScalar
import freemarker.template.TemplateMethodModelEx
import freemarker.template.TemplateModelException

class XorStringMethod : TemplateMethodModelEx {
    @Throws(TemplateModelException::class)
    override fun exec(args: List<*>): Any {
        if (args.size != 1) {
            throw TemplateModelException("Invalid arguments")
        }

        val s = (args[0] as SimpleScalar).asString

        // encode the string by XOR'ing each char
        // this can be decoded by repeating the operation
        return s.toCharArray()
                .map { c: Char -> c.toInt() xor 1337 }
                .map { i: Int -> i.toChar() }
                .joinToString(separator = "")
    }
}
