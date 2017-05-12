package com.xiongmai.lb.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2017-05-12.
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View view, float position) {

        int pageW = view.getWidth();
        int pageH = view.getHeight();

        if (position < -1) {
            view.setAlpha(0);
        } else if (position <= 1) {
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float verMager = pageH * (1 - scaleFactor) / 2;
            float herMager = pageW * (1 - scaleFactor) / 2;

            if (position < 0) {
                view.setTranslationX(herMager - verMager / 2);
            } else {
                view.setTranslationX(-herMager + verMager / 2);
            }

            view.setScaleY(scaleFactor);
            view.setScaleY(scaleFactor);

            view.setAlpha(MIN_ALPHA + ( scaleFactor - MIN_SCALE ) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        } else {
            view.setAlpha(0);
        }


    }
}
