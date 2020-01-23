/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleli
 */
public class SocketsServer {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        final int PORT = 40080;
    
        try {
            ServerSocket sk = new ServerSocket(PORT);
            while(true){
                Socket socket = sk.accept();
                System.out.println("Connected");
                ClientThread thread = new ClientThread(socket);
                thread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketsServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
