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
        p.setColor(Color.BLUE);
        p.setStrokeWidth(5);
//        canvas.drawLine(0, 0, 100, 100, p);
        for (int i = 0; i < path.size() - 1; i++) {
            canvas.drawLine(path.get(i).x, path.get(i).y, path.get(i + 1).x, path.get(i + 1).y, p);
        }
        for (int i = path.size() - 1; i > 1; i--) {
            canvas.drawLine(path.get(i).x, path.get(i).y, path.get(i - 1).x, path.get(i - 1).y, p);
        }
    }
}
