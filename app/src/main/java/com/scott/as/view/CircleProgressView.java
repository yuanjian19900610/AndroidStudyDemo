package com.scott.as.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Function:
 * Created by yuanjian on 16/5/31.
 */
public class CircleProgressView extends View {

    //默认半径
    private float defaultRadius = 100;
    private Paint mPaint;
    private float mWidth = 4;

    private float pointX = 250, pointY = 250;


    private float fudu = 0;

    public CircleProgressView(Context context) {
        super(context);
        init();
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(40);
        String content = "2,000.00";
        float textwidth = mPaint.measureText(content);
        Rect rect = new Rect();
        //返回包围整个字符串的最小的一个Rect区域


        mPaint.getTextBounds(content, 0, content.length(), rect);
        Log.i("smarhit", "w=" + rect.width() + " h=" + rect.height() + "  length=" + textwidth);
        canvas.drawText(content, getWidth() / 2 - rect.width() / 2, getHeight() / 2 + rect.height() / 2, mPaint);


        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(mWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        defaultRadius = getWidth() / 4;
        pointX = getWidth() / 2;
        pointY = getHeight() / 2;


        canvas.drawCircle(pointX, pointY, defaultRadius, mPaint);


        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(15);
        mPaint.setStyle(Paint.Style.STROKE);
        RectF oval1 = new RectF(9, 9, getWidth() - 9, getHeight() - 9);
        canvas.drawArc(oval1, 300, -fudu, false, mPaint);

//        ValueAnimator animator = ValueAnimator.ofFloat(0, 245);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                fudu = (float) valueAnimator.getAnimatedValue();
//                Log.i("smarhit", "fudu=" + fudu);
//                invalidate();
//            }
//        });
//        animator.setDuration(3000);
//        animator.start();

        if(fudu<245){
            invalidate();
            fudu+=2;
        }


        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL);
        int radius = getWidth() / 2;
        float x = (Math.abs((float) (Math.sin(Math.PI * 30 / 180) * radius)));
        float y = Math.abs((float) (Math.cos(30) * radius));
        Log.i("smarhit", "x=" + x + "y=" + y + " ,radius=" + radius);
        canvas.drawCircle(radius + x, y + 5, 15, mPaint);


    }
}
