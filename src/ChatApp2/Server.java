package ChatApp2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
    public static void main(String[] args) throws IOException {
        System.out.println("Server is Started");
        ServerSocket socketServer = new ServerSocket(8888);
        System.out.println("Server Waiting For Client Request");
        Socket socket = socketServer.accept();
        System.out.println("Client Accepted");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String msgIn="";
        String msgOut = "";
        while (!msgIn.equals("end")){
            msgIn= br.readLine();
            System.out.println(msgIn);
            msgOut = bufferedReader.readLine();
            printWriter.println(msgOut);
            printWriter.flush();
        }

        socket.close();
        System.out.println("Data sent form server to client");
    }

}
