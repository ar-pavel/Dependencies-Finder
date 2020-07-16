import javax.swing.*;

public class Main {

    public static String readFile(){

        JFileChooser fileChooser = new JFileChooser();

        int r = fileChooser.showSaveDialog(null);

        while(r != JFileChooser.APPROVE_OPTION){
            r = fileChooser.showSaveDialog(null);
            System.err.println("Select the input file: ");
        }
        String path= fileChooser.getSelectedFile().getAbsolutePath();

        return path;
    }


    public static void main(String[] args) {
        String file = readFile();
        System.out.println(file);

    }
}
