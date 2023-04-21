import java.awt.Graphics;
import java.util.Random;
import javax.swing.*;

public class GenerarCartonLoteria extends JPanel{
    private Carta car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12,car13,car14,car15,car16;
    private int x,y,Carton[][]=new int[4][4],valorGenerado;
    int Cartas[]=new int[54];
    private Programa p;
    private JTextArea a;
    public GenerarCartonLoteria(Programa p){
        this.p=p;
        valorGenerado=0;
        generarCarton();
        LlenarRevolverMostrarC(Cartas);
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
    public void Mostrar(int v[],JTextArea a){
        for(int i=0;i<v.length;i++){
            if(i==9||i==18||i==27||i==36||i==45||i==54){
                a.append(v[i]+"\n");
            }else{
                a.append(v[i]+"-");
            }
        }
    }
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
        car1=new Carta(getClass().getResource("/Imagenes/"+Carton[0][0]+".png"),0,0);
        car2=new Carta(getClass().getResource("/Imagenes/"+Carton[0][1]+".png"),100,0);
        car3=new Carta(getClass().getResource("/Imagenes/"+Carton[0][2]+".png"),200,0);
        car4=new Carta(getClass().getResource("/Imagenes/"+Carton[0][3]+".png"),300,0);
        car5=new Carta(getClass().getResource("/Imagenes/"+Carton[1][0]+".png"),0,150);
        car6=new Carta(getClass().getResource("/Imagenes/"+Carton[1][1]+".png"),100,150);
        car7=new Carta(getClass().getResource("/Imagenes/"+Carton[1][2]+".png"),200,150);
        car8=new Carta(getClass().getResource("/Imagenes/"+Carton[1][3]+".png"),300,150);
        car9=new Carta(getClass().getResource("/Imagenes/"+Carton[2][0]+".png"),0,300);
        car10=new Carta(getClass().getResource("/Imagenes/"+Carton[2][1]+".png"),100,300);
        car11=new Carta(getClass().getResource("/Imagenes/"+Carton[2][2]+".png"),200,300);
        car12=new Carta(getClass().getResource("/Imagenes/"+Carton[2][3]+".png"),300,300);
        car13=new Carta(getClass().getResource("/Imagenes/"+Carton[3][0]+".png"),0,450);
        car14=new Carta(getClass().getResource("/Imagenes/"+Carton[3][1]+".png"),100,450);
        car15=new Carta(getClass().getResource("/Imagenes/"+Carton[3][2]+".png"),200,450);
        car16=new Carta(getClass().getResource("/Imagenes/"+Carton[3][3]+".png"),300,450);
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
    }
}