package main.result;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class SimpleGui extends JFrame{
    public static String pathMessage;
    public static String  pathEncryptMessage = "C:\\Users\\Администратор\\encrypt.TXT";
     public static String  pathDecryptMessage = "C:\\Users\\Администратор\\decrypt.TXT";
    private JButton encrypt = new JButton("encrypt");
    private JButton decrypt = new JButton("decrypt");
    private JTextField inputFile = new JTextField("",2); // веденный файл
    private JTextField inputKey = new JTextField("",2); // введите ключ
    private JLabel inputf = new JLabel("Введите здесь путь к файлу который хотите encrypt/decrypt");
    private JLabel inputk = new JLabel("Введите здесь ключ");

 //   private Label label = new Label("encrypt and decrypt you message");
//    Main.Operation operation;i

    public SimpleGui() {
        super("encrypt and decrypt you message");
        this.setBounds(100,100,730,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,3,5,10)); // размеры отступа 2 последних
      //  container.add(label);
        container.add( inputKey);
       container.add( inputFile);
        container.add(inputk);
        container.add(inputf);
        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";

                String file =  String.valueOf(inputFile.getText());
                int key = Integer.parseInt(inputKey.getText());
                Main.Operation.encrypt(file,pathEncryptMessage,key);
                message += " Изменения сохранены в файл - " + pathEncryptMessage;
                message += "\n Не забудьте ваш ключ " + inputKey.getText() ;
                JOptionPane.showMessageDialog(null,message +" \n encrypting is done","Your Operation is Encrypt",JOptionPane.PLAIN_MESSAGE);
            }
        });
           decrypt.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   String message = "";
                   String file =  String.valueOf(inputFile.getText());
                   int key = 0;
                   try {
                       key = Integer.parseInt(inputKey.getText());
                   } catch (NumberFormatException numberFormatException) {

                   }
                   Main.Operation.decrypt(file,pathDecryptMessage,key);
                   message += " Изменения сохранены в файл - " + pathDecryptMessage + "\n";
                   message += "  Не забудьте ваш ключ " + inputKey.getText()  ;
                   JOptionPane.showMessageDialog(null,message +" \n decrypting is done","Your Operation is Decrypt",JOptionPane.PLAIN_MESSAGE);
               }
           });
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(encrypt);
        buttonGroup.add(decrypt);
        container.add(encrypt);
        container.add(decrypt);
    }
    }


