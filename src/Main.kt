data class Person(val name: String, val age: Int, val race: Color);

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255)
}

fun main() {
    val person = Person("Alice", 20, Color.GREEN)
    val (name) = person

    println("Hello, $name!")

    for (i in 1..5) {

        println("i = $i")
    }
}