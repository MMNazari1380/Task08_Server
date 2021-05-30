package com.company;

// ketabkhane ha
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author MMNazari1380
 * @version 1.0
 */
public class Server
{

    /**
     * baraye ejraye barname
     */
    public void run()
    {

        try
        {

            ServerSocket server =new ServerSocket(8888);
            Socket socket = server.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            StringBuilder sss = new StringBuilder();

            // halghe baraye chap har string ersali dar server va dadane pasokhe " Got emmmm "
            // va hamchenin baraye etmam barname ba  daryafte "over"
            while(true)
            {

                String str = dataInputStream.readUTF();
                dataOutputStream.writeUTF(" Got emmmm \n");
                if(str.equals("over"))
                    break;
                System.out.println(str);
                // baraye jam avary kole daryafti ha
                sss.append(str);
                sss.append("\n");

            }

            // baraye ersale tamame daryafti ha be client
            dataOutputStream.writeUTF(" tamam ersali ha : ");
            dataOutputStream.writeUTF(sss.toString());
            // bastan socket va stream ha
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

        }

        // residegi be exception
        catch ( IOException e)
        {

            e.printStackTrace();

        }

    }

}
