package main.result;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Bruce  {
    Bruce(){
        bruceForte();
        }

static void bruceForte(){
        byte[] userDefined=null;
        int inp=0;
        try{
        inp = Integer.parseInt(JOptionPane.showInputDialog(null,"enter your key!"));
        userDefined=hash(inp);
        }
        catch(Exception e){
        bruceForte();
        }
        if(inp<0){
        try {
        JOptionPane.showMessageDialog(null, "The key must be bigger than or equal to 0!");
        }
        catch(NullPointerException e){
        System.exit(-1);
        }
        bruceForte();
        }

        for(int i=0;i<100;i++){

        System.out.println(i);


        if(MessageDigest.isEqual(hash(i),userDefined)){
        try {
        JOptionPane.showMessageDialog(null, "We find your key " + i);
        }
        catch(Exception e){
            System.out.println("oops");
        }

        System.exit(0);
        break;
        }
        }


        System.out.println("We cannot find");
        }

static byte[] hash(int input){

        byte[] output=null;

        String inp=Integer.toString(input);
         try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        output = digest.digest(inp.getBytes(StandardCharsets.UTF_8));
        }
        catch(NoSuchAlgorithmException e){
        e.printStackTrace();
        }
        return output;
        }

public static void main(String[] args){
        new Bruce();
        }
}
