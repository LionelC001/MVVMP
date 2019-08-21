package com.lionel.mvvm_lifedata_navigation_realmp.common.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;

import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.ISwipeBackCallback;

public class SwipeBackHelper extends GestureDetector.SimpleOnGestureListener {

    private static final int SWIPE_THRESHOLD = 150;
    private static final int SWIPE_VELOCITY_THRESHOLD = 5000;
    private final ISwipeBackCallback swipeBackListener;

    public SwipeBackHelper(ISwipeBackCallback callback) {
        this.swipeBackListener = callback;
    }



    public static class SwipeBackDetector extends  GestureDetector.SimpleOnGestureListener{}

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        boolean result = false;
        float diffX = e2.getX() - e1.getX();
        if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
            if (diffX > 0 && swipeBackListener!=null) {
                swipeBackListener.onSwipeBack();
                result = true;
            }
        }
        return result;
    }
}
