import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class Carton extends JPanel implements MouseListener, MouseMotionListener {
Carta[] cartas = new Carta[16];
String CartasJugadas ="", cartasCantadas = "";
GUI_Cliente pointer;

    
public Carton(GUI_Cliente v){
    this.pointer = v;
    cartas[0] = new Carta(getClass().getResource("/1.png"), "1", 50, 0, this);
    cartas[1] = new Carta(getClass().getResource("/2.png"), "2", 100, 0, this);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
}

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
       g.fillRect(0, 0, 300, 300);
       cartas[0].pintar(g);
       cartas[1].pintar(g);
       repaint();
    }
    
    public void LanzamientoCliente(){
   //     pointer.sc.enviarMensaje(CartasJugadas);
    }
    
    public void RecibirMensaje(String mensaje){
        cartasCantadas += mensaje;
        System.out.println(cartasCantadas);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    //Aqui se colocan los 16 if de cada caso
        if(cartas[0].estaEnArea(e.getPoint()))
        cartas[0].lanzamiento(e.getPoint());
        
        if(cartas[1].estaEnArea(e.getPoint()))
        cartas[1].lanzamiento(e.getPoint());
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }



}
