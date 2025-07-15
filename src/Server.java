import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket s = null;
    private ServerSocket ss = null;
    private DataInputStream in = null;
    // construct
    public Server(int port){
        try {
            ss = new ServerSocket(port);
            System.out.println("Servidor iniciado \n esperando al cliente");

            // Acepta conexion del cliente
            s = ss.accept();
            System.out.println("Cliente conectado");
            //  nos preparamos apara reconocer los datos del cliente
            in = new DataInputStream(s.getInputStream());
            String message = "";

            // Seguimos leyendo hasta que el cliente nos envie un Over
            while (!message.equals("over")) {
                try {
                    message = in.readUTF();
                    System.out.println(message);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            System.out.println("Cerrando la conexion");
            in.close();
            s.close();


        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Server(5000); //ejecutamos el servidor en el puerto 5000
    }
}
