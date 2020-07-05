package ChatApp2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String msgIn="";
        String msgOut = "";
        while (!msgIn.equals("end")){
            msgOut = bufferedReader.readLine();
            printWriter.println(msgOut);
            printWriter.flush();
            msgIn = br.readLine();
            System.out.println(msgIn);

        }

        socket.close();
    }
}
