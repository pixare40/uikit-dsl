import uikitui.models.Action
import uikitui.models.Button
import uikitui.models.Hero
import uikitui.models.core.Component
import java.lang.StringBuilder

class Layout(type: String, zone: String): Component(type, zone) {
    fun hero(init: Hero.() -> Unit) = initComponent(Hero(), init)
    fun button(init: Button.() -> Unit,
               text: String,
               label: String,
               icon: String,
               action: Action
    ) = initComponent(Button(text, label, icon, action), init)
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent{\n")
        builder.append("$indent    'elements': [\n")
        children.forEach {
            it.render(builder, "$indent        ")
        }
        builder.append("$indent    ]\n")
        builder.append("$indent}\n")
    }
}