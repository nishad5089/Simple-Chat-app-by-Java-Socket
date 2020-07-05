import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = new ServerSocket(9999);
        Socket socket = socketServer.accept();
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String msgIn="";
        String msgOut = "";
        while (!msgIn.equals("end")){
            msgIn= din.readUTF();
            System.out.println(msgIn);
            msgOut = bufferedReader.readLine();
            dout.writeUTF(msgOut);
            dout.flush();
        }
    }

}
