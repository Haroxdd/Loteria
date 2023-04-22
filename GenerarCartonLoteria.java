import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GenerarCartonLoteria extends JPanel implements MouseListener,MouseMotionListener{
    private Carta car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12,car13,car14,car15,car16;
    private int x,y,Cartas[]=new int[54],Carton[][]=new int[4][4],valorGenerado;
    String CartasJugadas="",cartasCantadas="";
    private Programa p;
    private JTextArea a;
    public GenerarCartonLoteria(Programa p){
        this.p=p;
        valorGenerado=0;
        generarCarton();
        LlenarRevolverMostrarC(Cartas);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    public int[] getVector(){
        return Cartas;
    }
    private void LlenarRevolverMostrarC(int v[]){
        int contador=1;
        Random ran=new Random();
        for(int i=0;i<v.length;i++) {
            v[i]=contador++;
        }
        for (int i=0;i<v.length;i++){
            int posAle=ran.nextInt(v.length);
            int temp=v[i];
            v[i]=v[posAle];
            v[posAle]=temp;
        }
    }
    /*public void Mostrar(int v[],JTextArea a){
        for(int i=0;i<v.length;i++){
            if(i==9||i==18||i==27||i==36||i==45||i==54){
                a.append(v[i]+"\n");
            }else{
                a.append(v[i]+"-");
            }
        }
    }*/
    private boolean replay(int tabla[][],int valor){
        for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){
               if(valor==tabla[i][j]){
                   return false;
               }
           } 
        }
        return true;
    }
    private String generarNombre(int v){
        String nombre=""+v;
        return nombre;
    }
    private void generarCarton(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                valorGenerado=(int)((Math.random()*(54-1))+1);
                while(replay(Carton,valorGenerado)==false){
                    valorGenerado=(int)((Math.random()*(54-1))+1);
                }
                Carton[i][j]=valorGenerado;
            }
        }
        car1=new Carta(getClass().getResource("/Imagenes/"+Carton[0][0]+".png"),0,0,this,generarNombre(Carton[0][0]));
        car2=new Carta(getClass().getResource("/Imagenes/"+Carton[0][1]+".png"),100,0,this,generarNombre(Carton[0][1]));
        car3=new Carta(getClass().getResource("/Imagenes/"+Carton[0][2]+".png"),200,0,this,generarNombre(Carton[0][2]));
        car4=new Carta(getClass().getResource("/Imagenes/"+Carton[0][3]+".png"),300,0,this,generarNombre(Carton[0][3]));
        car5=new Carta(getClass().getResource("/Imagenes/"+Carton[1][0]+".png"),0,150,this,generarNombre(Carton[1][0]));
        car6=new Carta(getClass().getResource("/Imagenes/"+Carton[1][1]+".png"),100,150,this,generarNombre(Carton[1][1]));
        car7=new Carta(getClass().getResource("/Imagenes/"+Carton[1][2]+".png"),200,150,this,generarNombre(Carton[1][2]));
        car8=new Carta(getClass().getResource("/Imagenes/"+Carton[1][3]+".png"),300,150,this,generarNombre(Carton[1][3]));
        car9=new Carta(getClass().getResource("/Imagenes/"+Carton[2][0]+".png"),0,300,this,generarNombre(Carton[2][0]));
        car10=new Carta(getClass().getResource("/Imagenes/"+Carton[2][1]+".png"),100,300,this,generarNombre(Carton[2][1]));
        car11=new Carta(getClass().getResource("/Imagenes/"+Carton[2][2]+".png"),200,300,this,generarNombre(Carton[2][2]));
        car12=new Carta(getClass().getResource("/Imagenes/"+Carton[2][3]+".png"),300,300,this,generarNombre(Carton[2][3]));
        car13=new Carta(getClass().getResource("/Imagenes/"+Carton[3][0]+".png"),0,450,this,generarNombre(Carton[3][0]));
        car14=new Carta(getClass().getResource("/Imagenes/"+Carton[3][1]+".png"),100,450,this,generarNombre(Carton[3][1]));
        car15=new Carta(getClass().getResource("/Imagenes/"+Carton[3][2]+".png"),200,450,this,generarNombre(Carton[3][2]));
        car16=new Carta(getClass().getResource("/Imagenes/"+Carton[3][3]+".png"),300,450,this,generarNombre(Carton[3][3]));
    }
    @Override
    public void paint(Graphics g){
        car1.pintar(g);
        car2.pintar(g);
        car3.pintar(g);
        car4.pintar(g);
        car5.pintar(g);
        car6.pintar(g);
        car7.pintar(g);
        car8.pintar(g);
        car9.pintar(g);
        car10.pintar(g);
        car11.pintar(g);
        car12.pintar(g);
        car13.pintar(g);
        car14.pintar(g);
        car15.pintar(g);
        car16.pintar(g);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(car1.estaEnArea(e.getPoint())){
            car1.lanzamiento(e.getPoint());
        }
        if(car2.estaEnArea(e.getPoint())){
            car2.lanzamiento(e.getPoint());
        }
        if(car3.estaEnArea(e.getPoint())){
            car3.lanzamiento(e.getPoint());
        }
        if(car4.estaEnArea(e.getPoint())){
            car4.lanzamiento(e.getPoint());
        }
        if(car5.estaEnArea(e.getPoint())){
            car5.lanzamiento(e.getPoint());
        }
        if(car6.estaEnArea(e.getPoint())){
            car6.lanzamiento(e.getPoint());
        }
        if(car7.estaEnArea(e.getPoint())){
            car7.lanzamiento(e.getPoint());
        }
        if(car8.estaEnArea(e.getPoint())){
            car8.lanzamiento(e.getPoint());
        }
        if(car9.estaEnArea(e.getPoint())){
            car9.lanzamiento(e.getPoint());
        }
        if(car10.estaEnArea(e.getPoint())){
            car10.lanzamiento(e.getPoint());
        }
        if(car11.estaEnArea(e.getPoint())){
            car11.lanzamiento(e.getPoint());
        }
        if(car12.estaEnArea(e.getPoint())){
            car12.lanzamiento(e.getPoint());
        }
        if(car13.estaEnArea(e.getPoint())){
            car13.lanzamiento(e.getPoint());
        }
        if(car14.estaEnArea(e.getPoint())){
            car14.lanzamiento(e.getPoint());
        }
        if(car15.estaEnArea(e.getPoint())){
            car15.lanzamiento(e.getPoint());
        }
        if(car16.estaEnArea(e.getPoint())){
            car16.lanzamiento(e.getPoint());
        }
        
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