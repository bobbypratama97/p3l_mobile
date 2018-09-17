package com.example.grandatmahotelsv2.adapter;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.grandatmahotelsv2.R;
import com.example.grandatmahotelsv2.model.ImageModel;

import java.util.ArrayList;

public class SlidingImage_Adapter extends PagerAdapter {

    private ArrayList<ImageModel> imageModelArrayList;
    private LayoutInflater inflater;
    private Context context;
    private int[] myImageList = new int[]{R.drawable.doubledeluxe, R.drawable.executivedeluxe,
            R.drawable.juniorsuite,R.drawable.superior};


    public SlidingImage_Adapter(Context context) {
      /*  this.context = context;
        this.imageModelArrayList = imageModelArrayList;
        inflater = LayoutInflater.from(context);*/
        this.context = context;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

        ViewPager vp = (ViewPager) container;
        View view = (View) object;

        vp.removeView(view);

    }

    @Override
    public int getCount() {
        return myImageList.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slidingimages_layout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView4);
        imageView.setImageResource(myImageList[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);

        return view;


    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
