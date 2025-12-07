       import java.awt.BorderLayout;
       import java.awt.Color;
       import java.awt.Dimension;
       import java.awt.Font;
       import java.awt.Graphics;
       import java.awt.Image;
       import java.awt.event.ActionEvent;
       import java.awt.event.ActionListener;
       import java.net.URL;
       import javax.swing.ImageIcon;
       import javax.swing.JButton;
       import javax.swing.JFrame;
       import javax.swing.JMenu;
       import javax.swing.JMenuBar;
       import javax.swing.JMenuItem;
       import javax.swing.JPanel;
       import javax.swing.JScrollPane;
       import javax.swing.JTextArea;
       import javax.swing.JToolBar;

       // Custom JPanel for background or image (stub implementation)
       class Imagetextarea extends JPanel {
           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               // Example: Load and draw an image (replace with your logic)
               try {
                   Image img = new ImageIcon(new URL("https://example.com/background.png")).getImage(); // Placeholder URL
                   g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
               } catch (Exception e) {
                   // Handle image loading errors
               }
           }
       }

       public class Editor implements ActionListener {
           static JTextArea area = new JTextArea();
           static JFrame frame = new JFrame("Moepad++");
           static Imagetextarea panel = new Imagetextarea();
           static JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
           Functionalities func;
           Keys key;

           public static void main(String[] args) {
               new Editor();
           }

           public Editor() {
               func = new Functionalities(this);
               key = new Keys(this);
               window();
               toolbar();
               frame.setVisible(true);
           }

           public void window() {
               frame.setSize(800, 1000);
               frame.setResizable(true);
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               area.setFont(new Font("Arial", Font.PLAIN, 24));
               area.setForeground(Color.WHITE);
               area.setCaretColor(Color.white);
               area.setBackground(Color.BLACK);
               area.addKeyListener(key);

               frame.setLayout(new BorderLayout());
               frame.add(scroll, BorderLayout.CENTER);
           }

           public void toolbar() {
               JToolBar barr = new JToolBar();
               barr.setOrientation(JToolBar.VERTICAL);
               barr.setBackground(Color.PINK);
               barr.setPreferredSize(new Dimension(100, 600));

               JButton buttonmusik = new JButton("Music");
               buttonmusik.addActionListener(this);
               barr.add(buttonmusik);

               JMenuBar bar = new JMenuBar();
               bar.setBackground(Color.PINK);
               JMenu[] menus = new JMenu[3];
               JMenuItem[] file = new JMenuItem[4];
               String[] filetitle = {"New", "Open", "Save", "Print"};
               String[] title = {"File", "Format", "Audioplayer"};

               for (int i = 0; i < menus.length; i++) {
                   menus[i] = new JMenu(title[i]);
                   bar.add(menus[i]);
               }

               for (int j = 0; j < file.length; j++) {
                   file[j] = new JMenuItem(filetitle[j]);
                   file[j].addActionListener(this);
                   file[j].setActionCommand(filetitle[j]);
                   menus[0].add(file[j]);
               }

               frame.setJMenuBar(bar);
               frame.add(barr, BorderLayout.WEST);
           }

           @Override
           public void actionPerformed(ActionEvent e) {
               String cmd = e.getActionCommand();
               switch (cmd) {
                   case "New": func.newFile(); break;
                   case "Open": func.openFile(); break;
                   case "Save": func.saveFile(); break;
                   case "Print": func.printFile(); break;
                   case "Music": System.out.println("Music button clicked!"); break;
               }
           }
       }
       