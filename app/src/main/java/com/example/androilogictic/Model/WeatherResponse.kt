package com.example.androilogictic.Model

data class WeatherResponse (
    val location: Location,
    val current: Current
)

data class Location(
    val name: String,
    val region: String,
    val country: String
)

data class Current(
    val temp_c: Double,
    val condition: Condition
)

data class Condition(
    val text: String,
    val icon: String
)