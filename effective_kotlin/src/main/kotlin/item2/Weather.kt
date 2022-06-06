package item2

fun updateWeather(degree: Int) {
    val description: String
    val color: Color

    if (degree < 5) {
        description = "cold"
        color = Color.BLUE
    } else if (degree < 23) {
        description = "mild"
        color = Color.YELLOW
    } else {
        description = "hot"
        color = Color.RED
    }
}

fun updateWeatherByDestructuringDeclaration(degree: Int) {
    val (description, color) = when {
        degree < 5 -> "cold" to Color.BLUE
        degree < 23 -> "mild" to Color.YELLOW
        else -> "hot" to Color.RED
    }
}

enum class Color {
    BLUE, YELLOW, RED
}