package mx.edu.ittepic.dadm_u5_ejercicio5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Imagen2 imagen1, imagen2, imagen3, imagen4, texto1, texto2, texto3, texto4, puntero;
    Context con;
    String mensaje;
    int i;
    public Lienzo2(Context context) {
        super(context);
        con= context;
        i=0;
        imagen1=new Imagen2 (R.drawable.black, 150, 200, this);
        imagen2=new Imagen2 (R.drawable.blue, 150, 500, this);
        imagen3=new Imagen2 (R.drawable.orange, 150, 800, this);
        imagen4=new Imagen2 (R.drawable.green, 150, 1100, this);
        texto1=new Imagen2 (R.drawable.orangetext, 1800, 180, this);
        texto2=new Imagen2 (R.drawable.blacktext, 1800, 480, this);
        texto3=new Imagen2 (R.drawable.greentext, 1800, 780, this);
        texto4=new Imagen2 (R.drawable.bluetext, 1800, 1080, this);
        mensaje="Une los colores con sus nombres";
        puntero=null;

    }
    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();
        imagen1.pintar(c,p);
        imagen2.pintar(c,p);
        imagen3.pintar(c,p);
        imagen4.pintar(c,p);
        texto1.pintar(c,p);
        texto2.pintar(c,p);
        texto3.pintar(c,p);
        texto4.pintar(c,p);
        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(mensaje,850,100,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (texto1.estaEnArea(xp,yp)){
                    puntero=texto1;
                }
                else if (texto2.estaEnArea(xp,yp)){
                    puntero=texto2;
                }
                else if (texto3.estaEnArea(xp,yp)){
                    puntero=texto3;
                }
                else if (texto4.estaEnArea(xp,yp)){
                    puntero=texto4;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (puntero!=null){
                    puntero.mover(xp,yp);
                    if (puntero.colision(imagen3)&&puntero==texto1){
                        imagen3.hacerVisible(false);
                        texto1.hacerVisible(false);
                        i++;
                        if (i==3) mensaje="Te queda 1 color para terminar";
                        else mensaje="Te faltan "+(4-i)+" colores por unir";
                    }
                    if (puntero.colision(imagen1)&&puntero==texto2){
                        imagen1.hacerVisible(false);
                        texto2.hacerVisible(false);
                        i++;
                        if (i==3) mensaje="Te queda 1 color para terminar";
                        else mensaje="Te faltan "+(4-i)+" colores por unir";
                    }
                    if (puntero.colision(imagen2)&&puntero==texto4){
                        imagen2.hacerVisible(false);
                        texto4.hacerVisible(false);
                        i++;
                        if (i==3) mensaje="Te queda 1 color para terminar";
                        else mensaje="Te faltan "+(4-i)+" colores por unir";
                    }
                    if (puntero.colision(imagen4)&&puntero==texto3){
                        imagen4.hacerVisible(false);
                        texto3.hacerVisible(false);
                        i++;
                        if (i==3) mensaje="Te queda 1 color para terminar";
                        else mensaje="Te faltan "+(4-i)+" colores por unir";
                    }
                    if (i==4){
                        mensaje="Haz terminado con todos los colores";
                    }
                }
                //Entra si event.getAction() esta moviendose
                break;
            case MotionEvent.ACTION_UP:
                puntero=null;
                //Entra cuando quitas el dedo de la pantalla
                break;
        }
        invalidate(); // Manda a llamar a onDraw
        return true;
    }
}
