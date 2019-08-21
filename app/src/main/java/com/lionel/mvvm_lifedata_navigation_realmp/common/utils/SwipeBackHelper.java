package com.lionel.mvvm_lifedata_navigation_realmp.common.utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.ISwipeBackCallback;

public class SwipeBackHelper {

    private static final int SWIPE_THRESHOLD = 150;
    private static final int SWIPE_VELOCITY_THRESHOLD = 5000;

    private ISwipeBackCallback swipeBackListener;

    public void initSwipeBack(Context context, View view, ISwipeBackCallback callback) {
        this.swipeBackListener = callback;
        SwipeGestureListener swipeGestureListener = new SwipeGestureListener();
        GestureDetector gestureDetector = new GestureDetector(context, swipeGestureListener);
        view.setOnTouchListener(((v, event) -> gestureDetector.onTouchEvent(event)));
    }


    private class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0 && swipeBackListener != null) {
                    swipeBackListener.onSwipeBack();
                    result = true;
                }
            }
            return result;
        }
    }
}
