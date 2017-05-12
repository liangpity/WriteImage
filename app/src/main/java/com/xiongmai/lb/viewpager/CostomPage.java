package com.xiongmai.lb.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2017-05-12.
 */

public class CostomPage implements ViewPager.PageTransformer {
    private final static float MAX_ROT = -20.f;
    private float rot;

    @Override
    public void transformPage(View page, float position) {

        if (position < -1 || position >= 1) {
            page.setAlpha(0);
        } else {
            rot = (MAX_ROT * position);
            page.setPivotX(page.getWidth() / 2);
            page.setPivotY(page.getHeight() / 2);
            page.setAlpha(1);
            page.setRotationY(rot);
        }
    }
}
