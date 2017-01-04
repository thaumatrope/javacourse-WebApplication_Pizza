/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanne
 */
public class Server {

    private final ServerSocket server;
    public Server(int port) throws IOException{
        server=new ServerSocket(port);
    }
    private void verbinden(){
        while(true){
            Socket socke1=null;
            try{
                System.out.println("Ich warte mal auf den Klienten....");
                socke1=server.accept();//Warten auf den Client
                System.out.println("Da ist er");
                einausgabe(socke1);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    private void einausgabe(Socket s) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps=new PrintStream(s.getOutputStream());
        String str;
        while(br.ready()){
            str=br.readLine();
            ps.println("Vom Server gesendet: "+str);
        }
    }


    public static void main(String[] args) throws IOException {
        Server ich =new Server(4252);
        ich.verbinden();
    }
    
}
