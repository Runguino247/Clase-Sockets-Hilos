import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class client {
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    public client(String addr, int port){
        try {
            s = new Socket(addr,port);
            System.out.println("Conectado al servidor");
            // ENTRADA DE DATOS POR LA TERMINAL
            in = new DataInputStream(System.in);
            // SALIDA DE DATOS HACIA EL SERVIDOR
            out = new DataOutputStream(s.getOutputStream());
        } catch (UnknownHostException e) {
            System.out.println("Error de host:" + e);
            return;
        }
        catch (IOException e) {
            System.out.println("Error de entrada y Salida "+e);
            return;
        }

        String message = "";

        // bucle que seguira enviando datos hasta que el usuario escriba over
        while (!message.equals("over")) {
            try {
                message = in.readLine();
                out.writeUTF(message);
            } catch (IOException e) {
                System.out.println(e);
            }    
        }    
        // cierre de conexcion
        
        try {
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            
    }
    public static void main(String[] args){
                new client("127.0.0.1", 5000);
            }
}
