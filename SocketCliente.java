
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketCliente extends Thread{
  Socket conexion;
  DataInputStream entrada;
  DataOutputStream salida;
  Carton c;

    public SocketCliente(Carton c) {
        this.c = c;
    }
       
    public boolean conectar(String IPServidor, int PuertoServidor){
        try{
            conexion = new Socket(IPServidor, PuertoServidor);
            salida = new DataOutputStream(conexion.getOutputStream());
            entrada = new DataInputStream(conexion.getInputStream());
            start();
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    public void enviarMensaje(String mensaje){
        try {
            salida.writeUTF(mensaje);
        
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {            
            try {
                c.RecibirMensaje(entrada.readUTF());
            } catch (IOException ex) {
                Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}


