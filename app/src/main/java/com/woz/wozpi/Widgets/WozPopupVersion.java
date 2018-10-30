package com.woz.wozpi.Widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class WozPopupVersion extends FrameLayout {

    private static final String colorMain = "#e5140f26";
    private Paint mPaint;


    public WozPopupVersion(Context context) {
        super(context);
        init();
    }

    public WozPopupVersion(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WozPopupVersion(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){

        setWillNotDraw(false);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor(colorMain));
        mPaint.setStyle(Paint.Style.FILL);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        float mHeight = getHeight();
        float mWidth = getWidth();


        Path pathConnect = new Path();
        pathConnect.moveTo(0,0);
        pathConnect.lineTo(0,mHeight);
        pathConnect.lineTo(mWidth,0);
        pathConnect.lineTo(0,0);
        canvas.drawPath(pathConnect,mPaint);



    }
}
