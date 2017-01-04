
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instanz von Socket für den Verbindungsaufbau
        Socket socke=null;
        try{
            socke=new Socket("localhost",4252);
            
            OutputStream os=socke.getOutputStream();
            PrintStream ps=new PrintStream(os, true);
            ps.println("Hallo Ich bin der Client");
            ps.println("Hallo an den Server");
            System.out.println("Verbunden");
            InputStream is=socke.getInputStream();
            BufferedReader buff= new BufferedReader(new InputStreamReader(is));
            
            while(buff.ready()){
                System.out.println("Gelesen: "+buff.readLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(socke!=null){
                try{
                    socke.close();
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    }
}
