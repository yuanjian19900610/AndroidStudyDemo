package com.scott.as.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Scroller;

/**
 * Function:
 * Created by yuanjian on 16/5/25.
 */
public class AnimateButton extends Button {

    private Scroller mScroller;

    public AnimateButton(Context context) {
        super(context);
        mScroller=new Scroller(context);
    }

    public AnimateButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller=new Scroller(context);
    }

    public AnimateButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller=new Scroller(context);
    }


    public void smoothScrollerTo(int destX,int destY,int times){
        int scrollX=getScrollX();
        int scrollY=getScrollY();
        int deltaX=destX-scrollX;
        int deltaY=destY-scrollY;
        mScroller.startScroll(scrollX,scrollY,deltaX,deltaY,times);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
        }
    }
}

