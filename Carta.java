
import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;

public class Carta {
    private Color ColorCatrin=new Color(30,27,27,175);
    private int x,y;
    private Image img;
    private boolean frijol=true;
    private String nombre;
    private GenerarCartonLoteria pointCarton;
    public Carta(URL direcciónImagen, int equis, int ye){
        x=equis;
        y=ye;
        img=new ImageIcon(direcciónImagen).getImage();
    }
    public void pintar(Graphics g){
        g.drawImage(img,x,y,null);
        if(!frijol){
            g.setColor(ColorCatrin);
            g.fillOval(x,y,50,50);
        }
    }
    public String getNombre(){
        return nombre;
    }
    public boolean estaEnArea(Point punteroRaton){
        int x2 = x + img.getWidth(null);
        int y2 = y + img.getHeight(null);
        if(punteroRaton.x >= x && punteroRaton.x <= x2){
            if (punteroRaton.y >= y && punteroRaton.y <= y2) {
                return true;
            }
     }
         return false;
    }
    public void lanzamiento(Point e){
       /*if(frijol)
       pointCarton.CartasJugadas  += nombre;
        
        if(!frijol)
         pointCarton.CartasJugadas =  pointCarton.CartasJugadas.replace(nombre,"");*/
        
        frijol = !frijol;
        System.out.println(pointCarton.CartasJugadas);
    }
}