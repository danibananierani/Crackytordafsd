import java.awt.AWTException;
import java.awt.FileDialog;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.text.BadLocationException;
public class Functionalities{
    
    Editor editor;
    String filename;
    String fileadress;
    public Functionalities(Editor editor){
        this.editor = editor;
    }
    public void printFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileadress+filename));
            String zeile;
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob job = service.createPrintJob();

            FileInputStream input = new FileInputStream(fileadress+filename);
            SimpleDoc doc = new SimpleDoc(input, flavor, null);
            job.print(doc, null);
            while((zeile = reader.readLine()) != null){
                System.out.println(zeile);
            }
        } catch (Exception e) {
            System.err.println("fehler");
        }
    }
    public void newFile(){
        editor.frame.setTitle("newfile");
        editor.area.setText("");

        fileadress = null;
        filename = null;
    }
    public void openFile(){
        FileDialog filed = new FileDialog(editor.frame, "Open", FileDialog.LOAD);
        filed.setVisible(true);
        if(filed.getFile() != null){
             filename = filed.getFile();
             fileadress = filed.getDirectory();
            editor.frame.setTitle(filename);
        }
        
       try {
        BufferedReader bf = new BufferedReader(new FileReader(fileadress +  filename));
        editor.area.setText("");

        String line = null;
        while((line = bf.readLine()) != null){
            editor.area.append(line+ "\n");
        }
        bf.close();
       } catch (Exception e) {
       }
    }
    public void saveFile() {
        FileDialog dl = new FileDialog(editor.frame, "Save", FileDialog.SAVE);

        if(filename == null){
           dl.setVisible(true);
            filename = dl.getFile();
            fileadress = dl.getDirectory();
            editor.frame.setTitle(filename);
        }
        try {
            FileWriter fw = new FileWriter(fileadress + filename);
            fw.write(editor.area.getText());
            fw.close();
        } catch (Exception e) {
        }



    }
    public void mathematischershit(String zeichen){
        editor.area.replaceSelection(zeichen);
    }
    public void linebreak(){
        Robot robot;
            
        editor.area.replaceSelection("    - ");
        
        
        
        
    

    }
    ArrayList<Integer> diecarets = new ArrayList<Integer>();
    String hurensohn;
    public void checklinebreak() {
        int x = editor.area.getCaretPosition();
        diecarets.add(x);
        System.out.println(diecarets);
        
        try {
            if(diecarets.size() <=1){
                 hurensohn = editor.area.getDocument().getText(0,editor.area.getCaretPosition());
            }else{
                System.err.println(diecarets.get(diecarets.size()-2));
                 hurensohn = editor.area.getDocument().getText(diecarets.get(diecarets.size() -2 ),editor.area.getCaretPosition() - diecarets.get(diecarets.size() -2 ));
            }
            if(hurensohn.charAt(0) == ' ' && hurensohn.charAt(4) == '-'){

                linebreak();
            }
            if(hurensohn.charAt(editor.area.getCaretPosition()-1) == ':'){
                linebreak();
            }
        } catch (BadLocationException e) {
            System.out.println("hurensohn");
        }
        
    }
    
}
