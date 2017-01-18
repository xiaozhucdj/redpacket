package com.github.xiaozhucdj.redpacket.kissanim;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by dong.wang on 2017/1/10.
 */

public class KissAnimView extends ImageView{

    private float mRotateDegress = 0.0f;

    public KissAnimView(Context context,float rotateDegress) {
        this(context,null);
        this.mRotateDegress = rotateDegress;
    }

    public KissAnimView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KissAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setRotateDegress(float rotateDegress){
        this.mRotateDegress = rotateDegress;
    }

    public float getRotateDegress(){
        return mRotateDegress;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.rotate(mRotateDegress,getMeasuredWidth()/2f,getMeasuredHeight()/2f);
        super.onDraw(canvas);
    }
}
