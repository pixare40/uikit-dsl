package uikitui.models

import uikitui.models.core.Component

class Hero : Component("hero", "A"){
    var title = ""
    var subtitle = ""
    var image = ""

    fun title(title: String){
        this.title = title
    }

    fun subtitle(subtitle: String){
        this.subtitle = subtitle
    }

    fun image(image: String){
        this.image = image
    }

    override fun render(builder: StringBuilder, indent: String){
        builder.append("$indent{\n")
        builder.append("$indent    'title': '$title',\n")
        builder.append("$indent    'subtitle': '$subtitle',\n")
        builder.append("$indent    'image': '$image'\n")
        builder.append("$indent},\n")
    }
}