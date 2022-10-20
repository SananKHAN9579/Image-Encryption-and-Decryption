import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CODE {

    public static void opearte(int key){

      JFileChooser fileChooser=new JFileChooser();   //to Select  a file from Menu
      fileChooser.showOpenDialog(null);
      File file=fileChooser.getSelectedFile();
      //file input Stream Reader   to read Data
        try
        {
            FileInputStream fis=new FileInputStream(file);   //this class obtain input bytes from a file
            byte []data=new byte[fis.available()];          // to make Array of Byte
            fis.read(data);
            int i=0;
            for (byte b:data) {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);   //output stream used for writing data to a file
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Done");    //this class is used to Display some information

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        System.out.println("This is Testing");

        JFrame f=new JFrame();   //comes from
        f.setTitle("Image Operation");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);      //to centre the GUI on the Screen

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Exit the Application and Free the Memory

        Font font=new Font("Roboto",Font.BOLD,25);  //comes from java.awt package;
//        creating Button
        JButton button=new JButton();
        button.setText("Open Image");
        button.setFont(font);



        // Creating Text field
       JTextField textField=new JTextField(10);  //it helps the user to type some amount of TExt
       textField.setFont(font);





                                                          //this is an Action Event and usually occures
                                                         // when we perform some Action such as by CLicking on
                                                         // Button and Gives the Interface
                                                        //or use for Selecting a Menu Item
        button.addActionListener(e -> {
                    System.out.println("Button Clicked");
                    String text = textField.getText();
                    int temp=Integer.parseInt(text);      // convertion of String to Integer
                    opearte(temp);
                });



        f.setLayout(new FlowLayout());   //comes from awt layout
        //Arrangement of components or placing of componenets at a particuler place
        //within the container
        f.add(button);
        f.add(textField);
        f.setVisible(true);





    }

}
