package com.scott.as.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Function:
 * Created by yuanjian on 16/5/24.
 */
public class MyCircle extends View {


    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
