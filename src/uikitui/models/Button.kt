package uikitui.models

import uikitui.models.core.Component

class Button(private val text: String, private val label: String, private val icon: String, private val action: Action) : Component("primary", ""){
    override fun render(builder: StringBuilder, indent: String){
        builder.append("$indent{\n")
        builder.append("$indent    'type': 'action'\n")
        builder.append("$indent},\n")
    }

    override fun renderMustache(builder: StringBuilder, indent: String){
        builder.append("$indent{\n")
        builder.append("$indent    '\$type': 'button'\n")
        builder.append("$indent    'attributes': {\n")
        builder.append("$indent        'text': $text,\n")
        builder.append("$indent        'label': $label,\n")
        builder.append("$indent        'type': $type\n")
        builder.append("$indent        'icon': $icon\n")
        builder.append("$indent        'action':"+ action.renderMustache(builder, "$indent        ") + "\n")
        builder.append("$indent ")
        builder.append("$indent    }\n")
    }
}