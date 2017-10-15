/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coba.server;

/**
 *
 * @author 5213100176
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleFileClient {

    public final static int SOCKET_PORT = 13265;      // you may change this
    public final static String SERVER = "127.0.0.1";  // localhost
    public final static String FILE_TO_SEND = "C:/Users/5213100176/Downloads/666393.png";  // you may change this, I give a
    // different name because i don't want to
    // overwrite the one used by server...

    public final static int FILE_SIZE = 6022386; // file size temporary hard coded
    // should bigger than the file to be downloaded

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        Socket sock = null;
        try {
            sock = new Socket(SERVER, SOCKET_PORT);
            System.out.println("Connecting...");

            File myFile = new File(FILE_TO_SEND);
            byte[] mybytearray = new byte[(int) myFile.length()];
            System.out.println(myFile.length());
            fis = new FileInputStream(myFile);
            bis = new BufferedInputStream(fis);
            bis.read(mybytearray, 0, mybytearray.length);
            os = sock.getOutputStream();
            System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
            os.write(mybytearray, 0, mybytearray.length);
            os.flush();
            System.out.println("Done.");
            // receive file
            
        } finally {
            if (os != null) {
                os.close();
            }
            if (bis != null) {
                bis.close();
            }
            if (sock != null) {
                sock.close();
            }
        }
    }

}
