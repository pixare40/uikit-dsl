package uikitui.models

import uikitui.models.core.Component

class Button() : Component("", ""){
    var text: String = ""
    var label: String = ""
    var icon: String = ""
    override fun render(builder: StringBuilder, indent: String){
        builder.append("$indent{\n")
        builder.append("$indent    'type': 'action'\n")
        builder.append("$indent},\n")
    }

    fun action(init: Action.() -> Unit) = initComponent(Action(), init)

    override fun renderMustache(builder: StringBuilder, indent: String){
        val actionResult = children[0].renderMustache(StringBuilder(), "$indent            ");
        builder.append("$indent{\n")
        builder.append("$indent    '\$type': 'button',\n")
        builder.append("$indent    'attributes': {\n")
        builder.append("$indent        'text': '$text',\n")
        builder.append("$indent        'label': '$label',\n")
        builder.append("$indent        'type': '$type',\n")
        builder.append("$indent        'icon': '$icon',\n")
        children[0].renderMustache(builder, "$indent        ")
        builder.append("$indent}\n")
    }
}
