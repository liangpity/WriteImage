package com.xiongmai.lb.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.xiongmai.lb.viewpager.R;

/**
 * Created by Administrator on 2017-05-12.
 */

public class ImageCanvans extends View {

    private Context mContext;
    private Bitmap oriBitmap;
    private Bitmap new1Bitmap;
    private Bitmap new2Bitmap;
    private Paint paint;
    private boolean isClear;
    private boolean isMove;
    private float startX , startY , clickX , clickY;


    public ImageCanvans(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        oriBitmap = BitmapFactory.decodeResource(getResources() , R.drawable.a ).copy(Bitmap.Config.RGB_565 , true);
        new1Bitmap = Bitmap.createBitmap(oriBitmap);
    }

    public void setBitmap ( Bitmap bitmap ){
        isClear = false;
        oriBitmap = bitmap;
        new1Bitmap = Bitmap.createBitmap(oriBitmap);
        invalidate();
    }

    public void clear() {
        isClear = true;
        new2Bitmap = Bitmap.createBitmap(oriBitmap);
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(handWriting(new1Bitmap) , 0 , 0 , paint);
    }

    private Bitmap handWriting ( Bitmap originalBitmap) {
        Canvas canvas = null;

        if(isClear){
            canvas = new Canvas(new2Bitmap);
        }
        else{
            canvas = new Canvas(originalBitmap);
        }

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        if(isMove){
            canvas.drawLine(startX , startY ,clickX ,clickY , paint);
        }
        startX = clickX;
        startY = clickY;
        if(isClear){
            return oriBitmap;
        } else {
            return originalBitmap;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        isClear = false;
        clickX = event.getX();
        clickY = event.getY();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            isMove = true;
            invalidate();
            return true;
        } else if(event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_DOWN){
            isMove = false;
            return true;
        }

        return super.onTouchEvent(event);
    }
}
