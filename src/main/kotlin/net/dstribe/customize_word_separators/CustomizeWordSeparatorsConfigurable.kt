package net.dstribe.customize_word_separators

import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.project.Project
import com.intellij.ui.layout.panel
import javax.swing.JComponent
import javax.swing.JTextArea

class CustomizeWordSeparatorsConfigurable(private val project: Project) : SearchableConfigurable {

    private val state = CustomizeWordSeparatorsState.getInstance(project)
    private val myTextArea: JTextArea = JTextArea("", 25, 10)

    override fun isModified(): Boolean {
        return state.myState.customPattern1 != myTextArea.text
    }

    override fun getId(): String {
        return "preference.CustomizeWordSeparatorsConfigurable"
    }

    override fun getDisplayName(): String {
        return "Customize Word Separators"
    }

    override fun apply() {
        state.setCustomPattern(myTextArea.text)
    }

    override fun createComponent(): JComponent? {
        myTextArea.text = state.myState.customPattern1
        return panel {
            row("Patterns") {
                myTextArea()
            }
        }
    }
}