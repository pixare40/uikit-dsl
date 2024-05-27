import uikitui.models.Action

fun main() {
    val layout = Layout("buttton", "A",)

    var builder = StringBuilder()
    println(layout.render(builder, ""))
}