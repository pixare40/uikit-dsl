import java.lang.StringBuilder

@DslMarker
annotation class UIKitMarker

interface IComponent{
    fun render(builder: StringBuilder)
}

@UIKitMarker
abstract class Component(val name: String, val type: String, val zone: String): IComponent{
    val children = arrayListOf<IComponent>()

    override fun render(builder: StringBuilder){
        builder.append("{\n")
        if(type.isNotEmpty()){
            builder.append("'\$type': '$type',\n")
        }
        if(zone.isNotEmpty()){
            builder.append("'\$zone': '$zone',\n")
        }
        children.forEach{
            it.render(builder)
        }
        builder.append("},\n")
    }

    override fun toString(): String{
        val builder = StringBuilder()
        render(builder)
        return builder.toString()
    }
}

class UIKitUI{
}