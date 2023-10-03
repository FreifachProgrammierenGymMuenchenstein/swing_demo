import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Sortierer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea unsortiertTextArea;
    private JTextArea sortiertTextArea;

    public Sortierer() {
        setContentPane(contentPane);
        setModal(true);
        JRootPane p = getRootPane();
        p.setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        /*addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });*/

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String[] woerter;
        String derText = unsortiertTextArea.getText();
        String derTextSortiert="";
        if (!derText.isEmpty())
        {
            woerter = derText.split("[^A-Za-z0-9_-]");
            Arrays.sort(woerter);
            for (String s: woerter){
                derTextSortiert += s;
                derTextSortiert += " ";
            }
        }
        sortiertTextArea.setText(derTextSortiert);
    }

    private void onCancel() {
        unsortiertTextArea.setText("");
        sortiertTextArea.setText("");
    }
}
