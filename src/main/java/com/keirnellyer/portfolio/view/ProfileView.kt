package com.keirnellyer.portfolio.view

class ProfileView(var firstName: String, var lastName: String, var birthDateOffset: String, var jobTitle: String,
                  var location: String, var obfuscatedEmail: String) {

    val fullName = "$firstName $lastName"
}