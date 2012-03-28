package com.round.rect.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.ImageView;

public class RoundRectImageActivity extends Activity {
    /** Called when the activity is first created. */
	 private  int color;
	 private  Paint paint;
	 private  Rect rect;
	 private  RectF rectF;
	 private  Bitmap result;
	 private  Canvas canvas;
	 private  float roundPx;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView im=(ImageView )findViewById(R.id.imageView1);
        //## Drawable Resource as Bitmap
        Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.demo);
        im.setImageBitmap(getRoundedRectBitmap(bmp,12));
    }
    
    public  Bitmap getRoundedRectBitmap(Bitmap bitmap, int pixels)
    {
        result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(result);

        color = 0xff424242;
        paint = new Paint();
        rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        rectF = new RectF(rect);
        roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return result;
    }
}