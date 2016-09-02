package com.scott.as.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.scott.as.R;

/**
 * Function:
 * Created by yuanjian on 16/5/24.
 */
public class CascadeLayout extends ViewGroup {

    private int mHorizontalSpacing;
    private int mVerticalSpacing;

    public CascadeLayout(Context context) {
        super(context);
    }

    public CascadeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CascadeLayout);
        try {
            mHorizontalSpacing = ta.getDimensionPixelSize(R.styleable.CascadeLayout_horizontal_spacing, getResources().getDimensionPixelSize(R.dimen.casecade_horizontal_spacing));
            mVerticalSpacing = ta.getDimensionPixelSize(R.styleable.CascadeLayout_vertical_spacing, getResources().getDimensionPixelSize(R.dimen.casecade_vertical_spacing));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ta.recycle();
        }


    }

    public CascadeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


   @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 0;
        int height = getPaddingTop();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            width=getPaddingLeft()+mHorizontalSpacing*i;
            lp.x=width;
            lp.y=height;
            width+=child.getMeasuredWidth();
            height+=mVerticalSpacing;

        }
        width+=getPaddingRight();
        height+=getChildAt(getChildCount()-1).getMeasuredHeight()+getPaddingBottom();

        setMeasuredDimension(resolveSize(width,widthMeasureSpec),resolveSize(height,heightMeasureSpec));

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
       int count= getChildCount();
        for(int i=0;i<count;i++){
            View child=getChildAt(i);
            LayoutParams lp= (LayoutParams) child.getLayoutParams();
            child.layout(lp.x,lp.y,lp.x+child.getMeasuredWidth(),lp.y+child.getMeasuredHeight());
        }

    }

    public class LayoutParams extends ViewGroup.LayoutParams {
        int x;
        int y;


        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }


    }
}
