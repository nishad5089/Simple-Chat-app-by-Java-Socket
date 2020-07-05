import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String msgIn="";
        String msgOut = "";
        while (!msgIn.equals("end")){
            msgOut = bufferedReader.readLine();
            dout.writeUTF(msgOut);
            msgIn= din.readUTF();
            System.out.println(msgIn);
            dout.flush();
        }
        socket.close();
    }
}
