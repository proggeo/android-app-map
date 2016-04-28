package com.example.proggeo.android_app_map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by Proggeo on 4/26/2016.
 */
public class Drawing extends View{

    Bitmap plan;
    Picture picture;
    Drawable drawable;

    public Drawing(Context context) {
        super(context);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        plan = BitmapFactory.decodeResource(getResources(), R.drawable.plan4_400,options);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        Rect ourRect = new Rect();
//        ourRect.set(0, 0, canvas.getWidth(), canvas.getHeight() / 2);
//
//        Paint blue = new Paint();
//        blue.setColor(Color.BLUE);
//        blue.setStyle(Paint.Style.FILL);
//        canvas.drawRect(ourRect, blue);

//        canvas.drawPicture(picture);

        canvas.drawBitmap(plan, 0, 0, new Paint());
    }
}
