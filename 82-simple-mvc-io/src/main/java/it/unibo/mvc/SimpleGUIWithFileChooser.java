package it.unibo.mvc;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {
        Controller controller = new Controller();
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JButton save = new JButton("save");
        final JTextArea ta = new JTextArea();
        canvas.add(ta, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.writeInCurrentFile(ta.getText());
            }
            
        });

        final JPanel innerCanvas = new JPanel();
        innerCanvas.setLayout(new BorderLayout());
        JTextField tf = new JTextField(controller.getCurrentFilePath());
        JButton browse = new JButton("Browse...");
        innerCanvas.add(browse, BorderLayout.LINE_END);
        innerCanvas.add(tf, BorderLayout.CENTER);
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();
                if(chooser.showSaveDialog(browse) == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(chooser.getSelectedFile());
                }
            }
        });

        canvas.add(innerCanvas, BorderLayout.NORTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }

}

