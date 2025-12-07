import javax.swing.*;
import javax.swing.text.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;






 
public class ImageEditor extends JFrame {
    private final JTextPane editor;
    public static void main(String[] args) {
        new ImageEditor();
        
    }
    public ImageEditor() {
        super("Simple Image Editor (copy/paste images)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        editor = new JTextPane();
        editor.setContentType("text/plain");
        editor.setEditable(true);
        JScrollPane scroll = new JScrollPane(editor);

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton openBtn = new JButton("Open");
        JButton copyBtn = new JButton("Copy");
        JButton pasteBtn = new JButton("Paste");
        JButton clearBtn = new JButton("Clear");

        toolbar.add(openBtn);
        toolbar.add(copyBtn);
        toolbar.add(pasteBtn);
        toolbar.add(clearBtn);

        editor.setVisible(true);

    }

    
}