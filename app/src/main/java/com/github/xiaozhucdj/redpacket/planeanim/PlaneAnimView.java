package com.github.xiaozhucdj.redpacket.planeanim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.xiaozhucdj.redpacket.R;


/**
 * Created by dong.wang on 2017/1/6.
 */

public class PlaneAnimView extends RelativeLayout{

    private ImageView ground_view;
    private ImageView sky_view;
    private ImageView light_view;
    private ImageView road_line;
    private ImageView plane_view;
    private ImageView plane_shadow;

    private AnimatorSet mPlaneAnimSet;

    public PlaneAnimView(Context context) {
        this(context,null);
    }

    public PlaneAnimView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PlaneAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(View.LAYER_TYPE_HARDWARE, null);
        initUI();
    }


    private void initUI(){
        LayoutInflater.from(getContext()).inflate(R.layout.plane_anim_view,this);
        ground_view = (ImageView)findViewById(R.id.ground_view);
        sky_view = (ImageView)findViewById(R.id.sky_view);
        light_view = (ImageView)findViewById(R.id.light_view);
        road_line = (ImageView)findViewById(R.id.road_line);
        plane_view = (ImageView)findViewById(R.id.plane_view);
        plane_shadow = (ImageView)findViewById(R.id.plane_shadow);
    }

    public void startAnim(){
        setVisibility(VISIBLE);

        ObjectAnimator lightAlphaAnim = ObjectAnimator.ofFloat(light_view, "alpha", 0, 1);
        lightAlphaAnim.setDuration(2000);
        light_view.setVisibility(VISIBLE);
        light_view.setLayerType(View.LAYER_TYPE_HARDWARE, null);


        ObjectAnimator groundAlphaAnim = ObjectAnimator.ofFloat(ground_view, "alpha", 0, 1);
        groundAlphaAnim.setDuration(2000);
        groundAlphaAnim.setStartDelay(500);
        ground_view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        groundAlphaAnim.addListener(new CustomAnimatiorListener(){
            @Override
            public void onAnimStart(Animator animation) {
                ground_view.setVisibility(VISIBLE);
            }
        });

        ObjectAnimator roadLineAlphaAnim = ObjectAnimator.ofFloat(road_line, "alpha", 0, 0.6f);
        roadLineAlphaAnim.setDuration(2000);
        roadLineAlphaAnim.setStartDelay(500);
        road_line.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        roadLineAlphaAnim.addListener(new CustomAnimatiorListener(){
            @Override
            public void onAnimStart(Animator animation) {
                road_line.setVisibility(VISIBLE);
                AnimationDrawable roadAnim = (AnimationDrawable)road_line.getDrawable();
                if (roadAnim != null) {
                    roadAnim.start();
                }
            }
        });

        ObjectAnimator skyAlphaAnim = ObjectAnimator.ofFloat(sky_view, "alpha", 0, 1);
        skyAlphaAnim.setDuration(2500);
        skyAlphaAnim.setStartDelay(1000);
        sky_view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        skyAlphaAnim.addListener(new CustomAnimatiorListener(){
            @Override
            public void onAnimStart(Animator animation) {
                sky_view.setVisibility(VISIBLE);
            }
        });

        //飞机落下动画....start
        ObjectAnimator planeAlphaAnim = ObjectAnimator.ofFloat(plane_view, "alpha", 0, 1);
        planeAlphaAnim.setDuration(2000);
        planeAlphaAnim.setStartDelay(2000);
        plane_view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        planeAlphaAnim.setInterpolator(new DecelerateInterpolator());
        planeAlphaAnim.addListener(new CustomAnimatiorListener(){
            @Override
            public void onAnimStart(Animator animation) {
                plane_view.setVisibility(VISIBLE);
            }
        });

        ObjectAnimator planeScaleXAnim = ObjectAnimator.ofFloat(plane_view, "scaleX", 0.3f, 1);
        planeScaleXAnim.setDuration(2300);
        planeScaleXAnim.setStartDelay(2000);
        planeScaleXAnim.setInterpolator(new DecelerateInterpolator());

        ObjectAnimator planeScaleYAnim = ObjectAnimator.ofFloat(plane_view, "scaleY", 0.3f, 1);
        planeScaleYAnim.setDuration(2300);
        planeScaleYAnim.setStartDelay(2000);
        planeScaleYAnim.setInterpolator(new DecelerateInterpolator());

        ObjectAnimator planeTranslateYAnim = ObjectAnimator.ofFloat(plane_view, "y", -dip2px(getContext(),100), (getScreenHeight(getContext()) - dip2px(getContext(),210)));
        planeTranslateYAnim.setDuration(2300);
        planeTranslateYAnim.setStartDelay(2000);
        planeTranslateYAnim.setInterpolator(new DecelerateInterpolator());
        //飞机落下动画....end

        //飞机阴影落下....start
        ObjectAnimator planeShadowAlphaAnim = ObjectAnimator.ofFloat(plane_shadow, "alpha", 0, 0.5f);
        planeShadowAlphaAnim.setDuration(700);
        planeShadowAlphaAnim.setStartDelay(3600);
        plane_shadow.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        planeShadowAlphaAnim.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                plane_shadow.setVisibility(VISIBLE);
            }
        });

        ObjectAnimator planeShadowTranslateYAnim = ObjectAnimator.ofFloat(plane_shadow, "y", (getScreenHeight(getContext()) - dip2px(getContext(),160)),(getScreenHeight(getContext()) - dip2px(getContext(),140)) );
        planeShadowTranslateYAnim.setDuration(700);
        planeShadowTranslateYAnim.setStartDelay(3600);
        //飞机阴影落下....end

        //飞机拉起动画。。。start
        ObjectAnimator planeHideAlphaAnim = ObjectAnimator.ofFloat(plane_view, "alpha", 1, 0);
        planeHideAlphaAnim.setDuration(1000);
        planeHideAlphaAnim.setStartDelay(7500);

        ObjectAnimator planeHideScaleXAnim = ObjectAnimator.ofFloat(plane_view, "scaleX", 1f, 2f);
        planeHideScaleXAnim.setDuration(1000);
        planeHideScaleXAnim.setStartDelay(7500);

        ObjectAnimator planeHideScaleYAnim = ObjectAnimator.ofFloat(plane_view, "scaleY", 1f, 2f);
        planeHideScaleYAnim.setDuration(1000);
        planeHideScaleYAnim.setStartDelay(7500);

        int planeLocY = getScreenHeight(getContext()) - dip2px(getContext(),210);
        ObjectAnimator planeHideTranslateYAnim = ObjectAnimator.ofFloat(plane_view, "y", planeLocY, (planeLocY - dip2px(getContext(),85)));
        planeHideTranslateYAnim.setDuration(1000);
        planeHideTranslateYAnim.setStartDelay(7500);
        planeHideTranslateYAnim.setInterpolator(new LinearInterpolator());
        //飞机拉起动画。。。end

        //飞机阴影抬起....start
        ObjectAnimator planeShadowHideAlphaAnim = ObjectAnimator.ofFloat(plane_shadow, "alpha", 0.5f, 0.0f);
        planeShadowHideAlphaAnim.setDuration(700);
        planeShadowHideAlphaAnim.setStartDelay(7500);

        ObjectAnimator planeShadowHideTranslateYAnim = ObjectAnimator.ofFloat(plane_shadow, "y", (getScreenHeight(getContext()) - dip2px(getContext(),140)),getScreenHeight(getContext()));
        planeShadowHideTranslateYAnim.setDuration(700);
        planeShadowHideTranslateYAnim.setStartDelay(7500);
        //飞机阴影抬起....end

        ObjectAnimator planeAnimOver = ObjectAnimator.ofFloat(this, "alpha", 1, 0);
        planeAnimOver.setDuration(1000);
        planeAnimOver.setStartDelay(9000);


        mPlaneAnimSet = new AnimatorSet();
        mPlaneAnimSet.playTogether(lightAlphaAnim,groundAlphaAnim,roadLineAlphaAnim,skyAlphaAnim,planeAlphaAnim,
                planeScaleXAnim,planeScaleYAnim,planeTranslateYAnim,planeShadowAlphaAnim,planeShadowTranslateYAnim,planeHideAlphaAnim,planeHideScaleXAnim,
                planeHideScaleYAnim,planeHideTranslateYAnim,planeShadowHideAlphaAnim,planeShadowHideTranslateYAnim,planeAnimOver);

        mPlaneAnimSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (mPlaneAminListener != null) {
                    mPlaneAminListener.onAnimStart(animation);
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ground_view.setVisibility(INVISIBLE);
                ground_view.clearAnimation();
                sky_view.setVisibility(GONE);
                sky_view.clearAnimation();
                light_view.setVisibility(GONE);
                light_view.clearAnimation();
                road_line.setVisibility(INVISIBLE);
                road_line.clearAnimation();
                plane_view.setVisibility(GONE);
                plane_view.clearAnimation();

                if (mPlaneAminListener != null) {
                    mPlaneAminListener.onAnimEnd(animation);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mPlaneAnimSet.start();
    }

    public void cancle(){
        if (mPlaneAnimSet != null) {
            mPlaneAnimSet.cancel();
            mPlaneAnimSet.removeAllListeners();
        }
    }

    private PlaneAdminEndListener mPlaneAminListener;

    public void setPlaneAdminEndLisener(PlaneAdminEndListener lisener){
        this.mPlaneAminListener = lisener;
    }

    public interface PlaneAdminEndListener{
        void onAnimStart(Animator animation);
        void onAnimEnd(Animator animation);
        void onAnimCancel(Animator animation);
    }


    public static int getScreenHeight(Context ctx) {
        if (ctx == null)
            return 0;
        return ctx.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dip2px(Context context, int dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
