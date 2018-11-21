package mx.edu.ittepic.dadm_u5_ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Cuadro cuadro1,cuadro2;
    Imagen imagen1;
    Context con;
    public Lienzo(Context context) {
        super(context);
        con= context;
        cuadro1=new Cuadro( 1800, 800, 2200,1000, this, Color.RED);
        cuadro2=new Cuadro(1800,1100,2200,1300,this, Color.BLUE);
        imagen1=new Imagen(R.drawable.smile, 300, 500, this);
    }
    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();
        cuadro1.pintar(p,c);
        cuadro2.pintar(p,c);
        imagen1.pintar(c,p);
        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText("Start / Iniciar", 1830,930,p);
        c.drawText("Play Game", 1850,1230,p);
        p.setTextSize(120);
        c.drawText("Bienvenido / Welcome", 650,230,p);
        c.drawText("Color play", 1000,350,p);
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (cuadro1.estaEnArea(xp,yp,1800, 800, 2200,1000)){
                    Intent pa2 = new Intent (con,Main2Activity.class);
                    con.startActivity(pa2);
                }
                if (cuadro2.estaEnArea(xp,yp,1800,1100,2200,1300)){
                    Intent pa3 = new Intent (con,Main3Activity.class);
                    con.startActivity(pa3);
                }
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
