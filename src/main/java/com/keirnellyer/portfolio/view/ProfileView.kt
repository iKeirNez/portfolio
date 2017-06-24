package com.keirnellyer.portfolio.view

class ProfileView(val firstName: String, val lastName: String, val age: Int, val jobTitle: String,
                  val location: String, val obfuscatedEmail: String) {

    val fullName = "$firstName $lastName"
}