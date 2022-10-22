package net.elyow.forumia.auth.impl.firebase

import net.elyow.forumia.auth.api.EmailValidation
import net.elyow.forumia.auth.api.PasswordValidation
import java.util.regex.Pattern

private val emailPattern = Pattern.compile("^(.+)@(\\\\S+)\$")


val FirebaseEmailValidation = EmailValidation { emailPattern.matcher(it).matches() }


val FirebasePasswordValidation = PasswordValidation { it.length >= 6 }