package mx.edu.ittepic.dadm_u5_ejercicio5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen2 {
    private Bitmap icono;
    private float x,y;
    private boolean visible;
    int i;
    public Imagen2 (int resource, float _x, float _y, Lienzo2 l){
        icono = BitmapFactory.decodeResource(l.getResources(),resource);
        x=_x;
        y=_y;
        visible=true;
    }

    public void pintar(Canvas c, Paint p) {
        if (visible) c.drawBitmap(icono,x,y,p);
    }

    public boolean estaEnArea(float xp, float yp) {
        if (!visible) return false;
        float x2,y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if (xp>=x && xp<=x2) if (yp>=y && yp<=y2) return true;

        return false;
    }
    public void mover(float xp, float yp){
        x=xp-icono.getHeight();
        y=yp-icono.getHeight()/2;
    }
    public  void hacerVisible (boolean v){
        visible=v;
    }
    public boolean colision (Imagen2 objetob){
        float x2=x+icono.getWidth();
        float y2=y+icono.getHeight();
        if (objetob.estaEnArea(x2,y)){
            return true;
        }
        if (objetob.estaEnArea(x,y)){
            return true;
        }
        if (objetob.estaEnArea(x2,y2)){
            return true;
        }
        if (objetob.estaEnArea(x,y2)){
            return true;
        }
        return false;
    }

}
