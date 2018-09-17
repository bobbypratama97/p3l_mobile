package com.example.grandatmahotelsv2;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.grandatmahotelsv2.adapter.SlidingImage_Adapter;
import com.example.grandatmahotelsv2.model.ImageModel;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ViewGallery extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;

    private int[] myImageList = new int[]{R.drawable.doubledeluxe, R.drawable.executivedeluxe,
            R.drawable.juniorsuite,R.drawable.superior};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gallery);
        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();

        mPager = (ViewPager) findViewById(R.id.pager);
        SlidingImage_Adapter viewPagerAdapter = new SlidingImage_Adapter(this);

        mPager.setAdapter(viewPagerAdapter);

     //   init();
    }


    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }

   /* private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(ViewGallery.this,imageModelArrayList));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }*/

}
