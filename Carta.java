
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import javax.swing.ImageIcon;

public class Carta {
private final Image img;
private final String nombre;
private final int x;
private final int y;
private boolean frijol = true;
private Carton pointCarton;
public Carta(URL urlImagen, String nom, int x, int y, Carton c){
    this.img = new ImageIcon(urlImagen).getImage();
    this.nombre = nom;
    this.x = x;
    this.y = y;
    this.pointCarton = c;
}

    public String getNombre() {
        return nombre;
    }

public void pintar(Graphics g){
    g.drawImage(img, x, y, null);
    if(!frijol){
        g.setColor(Color.GRAY);
        g.fillOval(img.getWidth(null)/2, img.getHeight(null)/2, 50, 50);
    }
    
}
    public boolean estaEnArea(Point punteroRanton){
     int x2 = x + img.getWidth(null);
     int y2 = y + img.getHeight(null);
     if(punteroRanton.x >= x && punteroRanton.x <= x2){
            if (punteroRanton.y >= y && punteroRanton.y <= y2) {
                return true;
            }
     }
         return false;
    }
   public void lanzamiento(Point e){
       if(frijol)
       pointCarton.CartasJugadas  += nombre;
        
        if(!frijol)
         pointCarton.CartasJugadas =  pointCarton.CartasJugadas.replace(nombre,"");
        
        frijol = !frijol;
        System.out.println(pointCarton.CartasJugadas);
   }
    
}
