package com.xiongmai.lb.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xiongmai.lb.viewpager.R;

/**
 * Created by Administrator on 2017-05-12.
 */

public class ImageCanvasActivity extends AppCompatActivity {

    private ImageCanvans imageCanvans;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_canvas);
        imageCanvans = (ImageCanvans) findViewById(R.id.image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.c).copy(Bitmap.Config.RGB_565 , true);
//        imageCanvans.setBitmap(bitmap);
        button = (Button) findViewById(R.id.clear);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageCanvans.clear();
            }
        });
    }
}
