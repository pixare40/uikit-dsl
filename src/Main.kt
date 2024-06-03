
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.ResultValue
import kotlin.script.experimental.api.valueOrThrow
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

@KotlinScript
abstract class LayoutScript

fun main() {
    val builder = StringBuilder()
    val compilationConfiguration = createJvmCompilationConfigurationFromTemplate<LayoutScript> {
        jvm {
            dependenciesFromCurrentContext(
                wholeClasspath = true
            )
        }
    }

    val layoutString = """
         layout{
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
    """.trimIndent()
    val layoutScriptSource = layoutString.toScriptSource()

    val result = BasicJvmScriptingHost().eval(layoutScriptSource,
        compilationConfiguration,
        null).valueOrThrow().returnValue;

    println("Script evaluation result: ${result.scriptInstance}")

    println("Starting script evaluation")
    if (result !== null) {
        val layout = (result as? ResultValue.Value)?.value as? Layout
        if (layout != null) {
            layout.renderMustache(builder, "")
            println("Final result")
            println(builder.toString())
        } else {
            println("Script did not return a Layout object")
        }
    } else {
        println("Script evaluation failed: ")
    }
}

fun layout(init: Layout.() -> Unit): Layout {
    val layout = Layout()
    layout.init()
    return layout
}

