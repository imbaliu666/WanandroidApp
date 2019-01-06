package com.example.imbaliu.wanandroidapp.InitView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * 项目名： wanandroid
 * 包名：   com.example.imbaliu.wanandroidapp.InitView
 * 文件名： SignatureView
 * 创建者： LFY
 * 创建时间： 2018/12/29 11:12
 * 描述：   TODO
 */

public class SignatureView extends View {
    //画笔
    private Paint paint;
    //画布
    private Canvas cacheCanvas;
    //位图
    private Bitmap cachebBitmap;
    //图片保存路径
    private Path path;

    //位图缓存
    public Bitmap getCachebBitmap() {
        return cachebBitmap;
    }

    public SignatureView(Context context) {
        super(context);
        init();
    }



    private void init() {      //设置画笔
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        path = new Path();
        //创建位图
        cachebBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        //用自定义位图构建画布
        cacheCanvas = new Canvas(cachebBitmap);
        //设置画布为白色
        cacheCanvas.drawColor(Color.WHITE);

    }

    /**
     * 清除画板， 重置画笔
     */
    public void clear() {
        if (cacheCanvas != null) {
            paint.setColor(Color.WHITE);
            cacheCanvas.drawPaint(paint);
            paint.setColor(Color.BLACK);
            cacheCanvas.drawColor(Color.WHITE);
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(cachebBitmap, 0, 0, null);

        canvas.drawPath(path, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int curW = cachebBitmap != null ? cachebBitmap.getWidth() : 0;
        int curH = cachebBitmap != null ? cachebBitmap.getHeight() : 0;
        if (curW >= w && curH >= h) {
            return;
        }
        if (curW < w) curW = w;
        if (curH < h) curH = h;
        Bitmap newBitmap = Bitmap.createBitmap(curW, curH, Bitmap.Config.ARGB_8888);
        Canvas newCanvas = new Canvas();
        newCanvas.setBitmap(newBitmap);
        if (cachebBitmap != null) {
            newCanvas.drawBitmap(cachebBitmap, 0, 0, null);
        }
        cachebBitmap = newBitmap;
        cacheCanvas = newCanvas;
    }

    private float cur_x, cur_y;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                cur_x = x;
                cur_y = y;
                path.moveTo(cur_x, cur_y);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                path.quadTo(cur_x, cur_y, x, y);
                cur_x = x;
                cur_y = y;
                break;
            }
            case MotionEvent.ACTION_UP: {
                cacheCanvas.drawPath(path, paint);
                path.reset();
                break;
            }
            default:
                break;
        }
        invalidate();
        return true;
    }
}
