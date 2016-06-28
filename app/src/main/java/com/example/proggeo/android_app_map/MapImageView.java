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
    boolean adjusted = false;
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
        height = this.getHeight();
        width = this.getWidth();
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
        Point original = new Point();
        Point resized = new Point();
        double multiplierH = (double) height / 974.0;
        double multiplierW = (double) width / 656.0;
        for (int i = 0; i < path.size(); i++) {
            original = path.get(i);
            resized = new Point();
            resized.x = (int) ((double) (original.x - 328.0) * multiplierW) + width / 2;
            resized.y = (int) ((double) (original.y - 487.0) * multiplierH) + height / 2;
            path.set(i, resized);
        }
        for (int i = 0; i < path.size() - 1; i++) {
            canvas.drawLine(path.get(i).x, path.get(i).y, path.get(i + 1).x, path.get(i + 1).y, p);
            if (i == 0) canvas.drawPoint(path.get(i).x, path.get(i).y, roomPaint);
            canvas.drawPoint(path.get(i + 1).x, path.get(i + 1).y, roomPaint);
        }

    }
}
