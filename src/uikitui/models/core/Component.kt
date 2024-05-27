package uikitui.models.core

import java.lang.StringBuilder

@DslMarker
annotation class UIKitMarker

interface IComponent{
    fun render(builder: StringBuilder, indent: String = "")
    fun renderMustache(builder: StringBuilder, indent: String = "")
}

@UIKitMarker
abstract class Component(var type: String = "", var zone: String): IComponent {
    val children = arrayListOf<IComponent>()

    protected fun <T: Component> initComponent(component: T, init: T.() -> Unit): T{
        component.init()
        children.add(component)
        return component
    }

    override fun render(builder: StringBuilder, indent: String){
        builder.append("$indent{\n")
        if(type.isNotEmpty()){
            builder.append("$indent    '\$type': '$type',\n")
        }
        if(zone.isNotEmpty()){
            builder.append("$indent    '\$zone': '$zone',\n")
        }
        children.forEach{
            it.render(builder, "$indent    ")
        }
        builder.append("$indent},\n")
    }

    override fun renderMustache(builder: StringBuilder, indent: String){
        builder.append("$indent{\n")
        if(type.isNotEmpty()){
            builder.append("$indent    '\$type': '$type',\n")
        }
        if(zone.isNotEmpty()){
            builder.append("$indent    '\$zone': '$zone',\n")
        }
        children.forEach{
            it.renderMustache(builder, "$indent    ")
        }
        builder.append("$indent}")
    }

    override fun toString(): String{
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}