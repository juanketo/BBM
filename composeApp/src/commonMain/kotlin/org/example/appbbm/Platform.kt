package org.example.appbbm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform