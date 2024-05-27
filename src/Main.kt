fun main() {
    val layout = layout {
        button{
            text = "Click me"
            label = "Click me"
            icon = "play"
            type = "primary"
            action{
                type="play"
            }
        }
    }
    val builder = StringBuilder()
    layout.renderMustache(builder, "")
    println("Final result")
    println(builder.toString())
}

fun layout(init: Layout.() -> Unit): Layout {
    val layout = Layout()
    layout.init()
    return layout
}