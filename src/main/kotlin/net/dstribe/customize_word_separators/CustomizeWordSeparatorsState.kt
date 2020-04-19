package net.dstribe.customize_word_separators

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project

@State(
    name = "CustomizeWordSeparatorsState",
    storages = [Storage("CustomizeWordSeparatorsState.xml")]
)
class CustomizeWordSeparatorsState(val project: Project) :
    PersistentStateComponent<CustomizeWordSeparatorsState.State> {

    val myState = State()

    override fun getState(): State? {
        return myState
    }

    override fun loadState(state: State) {
        myState.customPattern1 = state.customPattern1
    }

    class State {
        var customPattern1: String = ""
    }

    fun setCustomPattern(value: String) {
        myState.customPattern1 = value
    }

    companion object {
        @JvmStatic
        fun getInstance(project: Project): CustomizeWordSeparatorsState {
            return ServiceManager.getService(project, CustomizeWordSeparatorsState::class.java)
        }
    }

}
