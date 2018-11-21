package mx.edu.ittepic.dadm_u5_ejercicio5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Imagen {
    private Bitmap icono;
    private float x,y;
    public Imagen (int resource, float _x, float _y, Lienzo l){
        icono = BitmapFactory.decodeResource(l.getResources(),resource);
        x=_x;
        y=_y;
    }

    public void pintar(Canvas c, Paint p) {
        c.drawBitmap(icono,x,y,p);
    }
}
