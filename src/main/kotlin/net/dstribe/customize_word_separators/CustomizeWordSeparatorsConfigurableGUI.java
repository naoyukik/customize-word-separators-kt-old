package net.dstribe.customize_word_separators;

import com.intellij.openapi.project.Project;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CustomizeWordSeparatorsConfigurableGUI {

  private JTextArea myPatternTextArea;
  private JPanel rootPanel;
  private JLabel myPatternLabel;
  private CustomizeWordSeparatorsState mState;

  public JPanel getRootPanel() {
    return rootPanel;
  }

  public void createUI(Project project) {
    mState = CustomizeWordSeparatorsState.getInstance(project);
    assert mState.getState() != null;
    myPatternTextArea.setText(mState.getState().getMyCustomPattern());
  }

  public void apply() {
    mState.setCustomPattern(myPatternTextArea.getText());
  }

  public boolean isModified() {
    boolean modified = false;
    assert mState.getState() != null;
    modified |= !myPatternTextArea.getText().equals(mState.getState().getMyCustomPattern());
    return modified;
  }
}
