package uikitui.models

import uikitui.models.core.Component

class Action(type: String, val id: Int = 12345): Component(type, ""){
    override fun render(builder: StringBuilder, indent: String){
        builder.append("$indent{\n")
        builder.append("$indent    'type': 'action'\n")
        builder.append("$indent},\n")
    }

    override fun renderMustache(builder: StringBuilder, indent: String){
        builder.append("$indent{\n")
        builder.append("$indent    '\$type': $type\n")
        builder.append("$indent    'data': {\n")
        builder.append("$indent        'id': $id,\n")
        builder.append("$indent        'type': $type\n")
        builder.append("$indent    }\n")
    }
}