import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {
    private Editor editor;

    public Keys(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Ctrl+O: Open file
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
            editor.func.openFile();
        }
        // Ctrl+N: New file
        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
            editor.func.newFile();
        }
        // Ctrl+S: Save file
        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            editor.func.saveFile();
        }
        // Ctrl+P: Print file
        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P) {
            editor.func.printFile();
        }
        // Ctrl+Q: Quit application
        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Q) {
            System.exit(0);
        }
        // Ctrl+Minus: Insert list item (e.g., "    - ")
        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_MINUS) {
            editor.func.linebreak();
        }
        // Enter: Check and auto-indent for lists
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            editor.func.checklinebreak();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used for shortcuts, but can be implemented for other features if needed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used for shortcuts, but can be implemented for other features if needed
    }
}
