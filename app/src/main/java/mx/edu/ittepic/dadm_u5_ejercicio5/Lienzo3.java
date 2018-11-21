package mx.edu.ittepic.dadm_u5_ejercicio5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Imagen3 imagen1, imagen2, imagen3, imagen4, imagen5, imagen6;
    Context con;
    String mensaje;
    Uri uri;
    String ruta;
    MediaPlayer sonido;
    public Lienzo3(Context context) {
        super(context);
        con= context;
        imagen1=new Imagen3 (R.drawable.blue, 200, 350, this);
        imagen2=new Imagen3 (R.drawable.red, 1040, 350, this);
        imagen3=new Imagen3 (R.drawable.gray, 1860, 350, this);
        imagen4=new Imagen3 (R.drawable.orange, 200, 800, this);
        imagen5=new Imagen3 (R.drawable.black, 1040, 800, this);
        imagen6=new Imagen3 (R.drawable.green, 1860, 800, this);
        mensaje="";

    }
    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();
        imagen1.pintar(c,p);
        imagen2.pintar(c,p);
        imagen3.pintar(c,p);
        imagen4.pintar(c,p);
        imagen5.pintar(c,p);
        imagen6.pintar(c,p);
        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(mensaje,1230,100,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (imagen1.estaEnArea(xp,yp)){
                    mensaje="Blue";
                    ruta="android.resource://"+ con.getPackageName() +"/"+R.raw.blue;
                }
                else if (imagen2.estaEnArea(xp,yp)){
                    mensaje="Red";
                    ruta="android.resource://"+ con.getPackageName() +"/"+R.raw.red;

                }
                else if (imagen3.estaEnArea(xp,yp)){
                    mensaje="Gray";
                    ruta="android.resource://"+ con.getPackageName() +"/"+R.raw.gray;
                }
                else if (imagen4.estaEnArea(xp,yp)){
                    mensaje="Orange";
                    ruta="android.resource://"+ con.getPackageName() +"/"+R.raw.orange;
                }
                else if (imagen5.estaEnArea(xp,yp)){
                    mensaje="Black";
                    ruta="android.resource://"+ con.getPackageName() +"/"+R.raw.black;
                }
                else if (imagen6.estaEnArea(xp,yp)){
                    mensaje="Green";
                    ruta="android.resource://"+ con.getPackageName() +"/"+R.raw.green;
                }
                else mensaje="";
                uri= Uri.parse(ruta);
                sonido = MediaPlayer.create(con,uri);
                sonido.start();
                break;
            case MotionEvent.ACTION_MOVE:
                //Entra si event.getAction() esta moviendose
                break;
            case MotionEvent.ACTION_UP:
                //Entra cuando quitas el dedo de la pantalla
                break;
        }
        invalidate(); // Manda a llamar a onDraw
        return true;
    }
}
