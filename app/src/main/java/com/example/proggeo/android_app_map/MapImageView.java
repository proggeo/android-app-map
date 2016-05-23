package com.example.proggeo.android_app_map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Proggeo on 5/5/2016.
 */
public class MapImageView extends ImageView {

    private int height;
    private int width;
    Paint p;
    ArrayList<Point> path = new ArrayList<Point>();

    public MapImageView(Context context) {
        super(context);
    }

    public MapImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p = new Paint();
        Paint p1 = new Paint();
        Paint p2 = new Paint();
        Paint roomPaint = new Paint();
        roomPaint.setColor(Color.RED);
        roomPaint.setStrokeWidth(8);
        p1.setColor(Color.BLUE);
        p1.setStrokeWidth(3);
        p2.setColor(Color.BLACK);
        p.setColor(Color.BLUE);
        p.setStrokeWidth(5);
        for (int i = 0; i < path.size() - 1; i++) {
            canvas.drawLine(path.get(i).x, path.get(i).y, path.get(i + 1).x, path.get(i + 1).y, p);
            canvas.drawPoint(path.get(i).x, path.get(i).y, roomPaint);
            canvas.drawPoint(path.get(i + 1).x, path.get(i + 1).y, roomPaint);
        }

//        for (int i = 0; i < 700; i += 10) {
//            for (int j = 0; j < 1000; j += 10) {
//                if (i % 100 == 0 || j % 100 == 0) canvas.drawPoint(i, j, p2);
//                else canvas.drawPoint(i, j, p1);
//            }
//        }

    }
}
