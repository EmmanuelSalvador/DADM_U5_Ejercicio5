package mx.edu.ittepic.dadm_u5_ejercicio5;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Cuadro {
    float x, y, x2, y2;
    int color;
    public  Cuadro(float posx, float posy, float posx2, float posy2, Lienzo l, int c){
        x=posx;
        y=posy;
        x2=posx2;
        y2=posy2;
        color=c;
        l.invalidate();
    }
    public void pintar(Paint p, Canvas c){
        p.setColor(color);
        c.drawRect(x,y,x2,y2,p);
    }
    public boolean estaEnArea(float xp, float yp, float x1, float y1, int x2, int y2) {

        if (xp>=x1 && xp<=x2){
            if (yp>=y1 && yp<=y2){
                return true;
            }
        }
        return false;
    }
}
