/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleli
 */
public class SocketsClient {

    final static int PORT = 40080;
    final static String HOST = "localhost";

    public static void main(String[] args) {
        try {
            Socket sk = new Socket(HOST, PORT);

            sendMessageToServer(sk);
        } catch (IOException ex) {
            Logger.getLogger(SocketsClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void sendMessageToServer(Socket sk) {
        OutputStream os = null;
        InputStream is = null;
        try {
            os = sk.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            is = sk.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            Scanner sc = new Scanner(System.in);
            String linea;

            while (true) {
                System.out.println("Select a tv show:"
                        + "\n 1. Breaking Bad "
                        + "\n 2. Prison Break "
                        + "\n 3. Lost "
                        + "\n 4. Friday Night Lights "
                        + "\n 5. Dark");

                linea = sc.nextLine();
                bw.write(linea);
                bw.newLine();
                bw.flush();
                linea = br.readLine();

                String[] array = linea.split(" ");
                int i = 0;
                System.out.println("");

                for (String word : array) {
                    System.out.print(word + " ");
                    i++;
                    if (i == 20 || i == 40) {
                        System.out.println("");
                    }
                }
                System.out.println("");

            }

        } catch (IOException ex) {
            Logger.getLogger(SocketsClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SocketsClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
