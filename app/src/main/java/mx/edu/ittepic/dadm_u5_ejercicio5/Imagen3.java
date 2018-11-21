package mx.edu.ittepic.dadm_u5_ejercicio5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen3 {
    private Bitmap icono;
    private float x,y;
    private boolean visible;
    int i;
    public Imagen3 (int resource, float _x, float _y, Lienzo3 l){
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

        if (xp>=x && xp<=x2){
            if (yp>=y && yp<=y2){
                return true;
            }
        }
        return false;
    }
}