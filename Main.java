package main.result;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        SimpleGui simpleGui = new SimpleGui();
 simpleGui.setVisible(true);

    }

    public static class Operation {

        public static void encrypt(String pathMessage, String pathEncryptMessage, int key) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(pathMessage);
                FileOutputStream fileOutputStream = new FileOutputStream(pathEncryptMessage);
                boolean done = false;
                while (!done) {
                  int next = fileInputStream.read();
           if (next == -1) {
           done = true;
                        fileInputStream.close();
                        fileOutputStream.close();
                    } else {
                        byte b = (byte) next;
                        byte c = (byte) (b + key);

                        fileOutputStream.write(c);
                    }
                }
            } catch (IOException e) {
                System.out.println("You haven't this folder, create it ");
            }
        }

        public static void decrypt(String pathEncryptMessage, String pathMessage, int key){
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(pathEncryptMessage);
            FileOutputStream fileOutputStream = new FileOutputStream(pathMessage);
            boolean done = false;
            while (!done) {
                int next = fileInputStream.read();
                if (next == -1) {
                    done = true;
                    fileInputStream.close();
                    fileOutputStream.close();
                } else {
                    byte b = (byte) next;
                    byte c = (byte) (b - key);

                    fileOutputStream.write((char)c);
                }
            }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}








