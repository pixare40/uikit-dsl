import uikitui.models.Button
import uikitui.models.Hero
import uikitui.models.core.Component
import java.lang.StringBuilder

class Layout(): Component("","") {
    fun hero(init: Hero.() -> Unit) = initComponent(Hero(), init)
    fun button(
        init: Button.() -> Unit,
    ) = initComponent(Button(), init)
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent{\n")
        builder.append("$indent    'elements': [\n")
        children.forEach {
            it.render(builder, "$indent        ")
        }
        builder.append("$indent    ]\n")
        builder.append("$indent}\n")
    }

    override fun renderMustache(builder: StringBuilder, indent: String) {
        builder.append("$indent{\n")
        builder.append("$indent    'elements': [\n")
        children.forEach {
            it.renderMustache(builder, "$indent        ")
        }
        builder.append("$indent    ]\n")
        builder.append("$indent}\n")
    }
}