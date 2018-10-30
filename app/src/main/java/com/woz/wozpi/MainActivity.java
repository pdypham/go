package com.woz.wozpi;

import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.animation.Interpolator;

import com.woz.core.WozActivity;

import java.lang.reflect.Field;

public class MainActivity extends WozActivity {

    private WozSlide slidePage;


    private SlidePageAdapter slidePageAdapter;

    @Override
    protected int setLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        slidePage = findViewById(R.id.slidePage);
        slidePageAdapter = new SlidePageAdapter(getSupportFragmentManager());

        slidePage.setAdapter(slidePageAdapter);
//        slidePage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                if(position >= slidePageAdapter.slidePageFragmentList.size() - 2){
//                    slidePageAdapter.slidePageFragmentList.add(SlidePageFragment.getInstance("https://i.imgur.com/hETOr6Y.jpg"));
//                    slidePageAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        try {
            Field mScroller;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            CustomScroller scroller = new CustomScroller(slidePage.getContext(), null);
            // scroller.setFixedDuration(5000);
            mScroller.set(slidePage, scroller);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            Log.e("ERROR","ERROR");
        }


//

//        Handler handler = new Handler(){
//
//            @Override
//            public void handleMessage(Message msg) {
//                // Do task here
//
//            }
//        };
//        handler.sendEmptyMessageAtTime(1,5000);


    }




    @Override
    protected void onStop() {

        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void loadData() {

    }




//    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
//    }
//
//    /**
//     * A native method that is implemented by the 'native-lib' native library,
//     * which is packaged with this application.
//     */
//    public native String stringFromJNI();
}