package com.xiongmai.lb.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2017-05-12.
 */

public class DepthPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View page, float position) {
        int pagerWidth = page.getWidth();

        if(position < -1){
            page.setAlpha(0);
        } else if(position <=0 ){
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setScaleX(1);
            page.setScaleY(1);
        } else if(position <= 1) {
            page.setAlpha(1 - position);
            page.setTranslationX(pagerWidth * -position);
            final float scale = MIN_SCALE + (1 - MIN_SCALE) * ( 1 - position);
            page.setScaleY(scale);
            page.setScaleX(scale);
        } else {
            page.setAlpha(0);
        }
    }
}
