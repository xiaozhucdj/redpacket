package com.github.xiaozhucdj.redpacket.kissanim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.github.xiaozhucdj.redpacket.R;
import com.github.xiaozhucdj.redpacket.planeanim.CustomAnimatiorListener;


/**
 * Created by dong.wang on 2017/1/10.
 */

public class MultiFlyKissView extends FrameLayout {

    private KissAnimView kissView1;
    private KissAnimView kissView2;
    private KissAnimView kissView3;
    private KissAnimView kissView4;
    private KissAnimView kissView5;
    private KissAnimView kissView6;
    private KissAnimView kissView7;
    private ImageView heartView1;
    private ImageView heartView2;


    private AnimatorSet mKissAnimSet;


    public MultiFlyKissView(Context context) {
        super(context);
    }

    public MultiFlyKissView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiFlyKissView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initUI(){
        int totalWidth = getScreenWidth(getContext());

        kissView1 = new KissAnimView(getContext(),0);
        kissView1.setImageResource(R.drawable.kiss_anim_list);
        LayoutParams kissLayoutParams1 = new LayoutParams(totalWidth,totalWidth);
        kissLayoutParams1.gravity = Gravity.CENTER_HORIZONTAL;
        kissLayoutParams1.topMargin = (int) (dip2px(getContext(),359) - totalWidth/2);
        kissView1.setLayoutParams(kissLayoutParams1);
        kissView1.setVisibility(GONE);
        addView(kissView1);

        kissView2 = new KissAnimView(getContext(),-45);
        kissView2.setImageResource(R.drawable.kiss_anim_list);
        float kissView2Width = totalWidth*0.35f;
        LayoutParams kissLayoutParams2 = new LayoutParams((int) kissView2Width,(int) kissView2Width);
        kissLayoutParams2.leftMargin = (int) (dip2px(getContext(),114) - kissView2Width/2);
        kissLayoutParams2.topMargin = (int) (dip2px(getContext(),164) - kissView2Width/2);
        kissView2.setLayoutParams(kissLayoutParams2);
        kissView2.setVisibility(GONE);
        addView(kissView2);

        kissView3 = new KissAnimView(getContext(),0.2f);
        kissView3.setImageResource(R.drawable.kiss_anim_list);
        float kissView3Width = totalWidth*0.21f;
        LayoutParams kissLayoutParams3 = new LayoutParams((int) kissView3Width,(int) kissView3Width);
        kissLayoutParams3.leftMargin = (int) (dip2px(getContext(),49) - kissView3Width/2);
        kissLayoutParams3.topMargin = (int) (dip2px(getContext(),261) - kissView3Width/2);
        kissView3.setLayoutParams(kissLayoutParams3);
        kissView3.setVisibility(GONE);
        addView(kissView3);

        kissView4 = new KissAnimView(getContext(),20);
        kissView4.setImageResource(R.drawable.kiss_anim_list);
        float kissView4Width = totalWidth*0.33f;
        LayoutParams kissLayoutParams4 = new LayoutParams((int) kissView4Width,(int) kissView4Width);
        kissLayoutParams4.leftMargin = (int) (dip2px(getContext(),256) - kissView4Width/2);
        kissLayoutParams4.topMargin = (int) (dip2px(getContext(),216) - kissView4Width/2);
        kissView4.setLayoutParams(kissLayoutParams4);
        kissView4.setVisibility(GONE);
        addView(kissView4);

        kissView5 = new KissAnimView(getContext(),-29);
        kissView5.setImageResource(R.drawable.kiss_anim_list);
        float kissView5Width = totalWidth*0.29f;
        LayoutParams kissLayoutParams5 = new LayoutParams((int) kissView5Width,(int) kissView5Width);
        kissLayoutParams5.leftMargin = (int) (dip2px(getContext(),89) - kissView5Width/2);
        kissLayoutParams5.topMargin = (int) (dip2px(getContext(),506) - kissView5Width/2);
        kissView5.setLayoutParams(kissLayoutParams5);
        kissView5.setVisibility(GONE);
        addView(kissView5);

        kissView6 = new KissAnimView(getContext(),47);
        kissView6.setImageResource(R.drawable.kiss_anim_list);
        float kissView6Width = totalWidth*0.32f;
        LayoutParams kissLayoutParams6 = new LayoutParams((int) kissView6Width,(int) kissView6Width);
        kissLayoutParams6.leftMargin = (int) (dip2px(getContext(),265) - kissView6Width/2);
        kissLayoutParams6.topMargin = (int) (dip2px(getContext(),495) - kissView6Width/2);
        kissView6.setLayoutParams(kissLayoutParams6);
        kissView6.setVisibility(GONE);
        addView(kissView6);

        kissView7 = new KissAnimView(getContext(),0);
        kissView7.setImageResource(R.drawable.kiss_anim_list);
        float kissView7Width = totalWidth*0.14f;
        LayoutParams kissLayoutParams7 = new LayoutParams((int) kissView7Width,(int) kissView7Width);
        kissLayoutParams7.leftMargin = (int) (dip2px(getContext(),323) - kissView7Width/2);
        kissLayoutParams7.topMargin = (int) (dip2px(getContext(),423) - kissView7Width/2);
        kissView7.setLayoutParams(kissLayoutParams7);
        kissView7.setVisibility(GONE);
        addView(kissView7);

        heartView1 = new ImageView(getContext());
        heartView1.setImageResource(R.drawable.heart_anim);
        float heartView1Width = totalWidth*0.1f;
        LayoutParams heartLayoutParams1 = new LayoutParams((int) heartView1Width,(int) heartView1Width);
        heartLayoutParams1.leftMargin = (int) (dip2px(getContext(),317) - heartView1Width/2);
        heartLayoutParams1.topMargin = (int) (dip2px(getContext(),327) - heartView1Width/2);
        heartView1.setLayoutParams(heartLayoutParams1);
        heartView1.setVisibility(GONE);
        addView(heartView1);

        heartView2 = new ImageView(getContext());
        heartView2.setImageResource(R.drawable.heart_anim);
        float heartView2Width = totalWidth*0.1f;
        LayoutParams heartLayoutParams2 = new LayoutParams((int) heartView2Width,(int) heartView2Width);
        heartLayoutParams2.leftMargin = (int) (dip2px(getContext(),71) - heartView2Width/2);
        heartLayoutParams2.topMargin = (int) (dip2px(getContext(),397) - heartView2Width/2);
        heartView2.setLayoutParams(heartLayoutParams2);
        heartView2.setVisibility(GONE);
        addView(heartView2);
        //初始化控件......end
    }


    public void startAnim(){
        if (mKissAnimSet != null) {
            mKissAnimSet.cancel();
            mKissAnimSet = null;
            removeAllViews();
        }
        initUI();

        ObjectAnimator kissAlphaAnim_1 = ObjectAnimator.ofFloat(kissView1, "alpha", 0, 1);
        kissAlphaAnim_1.setDuration(300);
        kissView1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        kissAlphaAnim_1.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                kissView1.setVisibility(VISIBLE);
                AnimationDrawable kissAnim = (AnimationDrawable)kissView1.getDrawable();
                if (kissAnim != null) {
                    kissAnim.start();
                }
            }
        });

        ObjectAnimator hideKissAlphaAnim_1 = ObjectAnimator.ofFloat(kissView1, "alpha", 1, 0);
        hideKissAlphaAnim_1.setDuration(300);
        hideKissAlphaAnim_1.setStartDelay(2700);


        ObjectAnimator kissAlphaAnim_2 = ObjectAnimator.ofFloat(kissView2, "alpha", 0, 0.36f);
        kissAlphaAnim_2.setDuration(300);
        kissAlphaAnim_2.setStartDelay(500);
        kissView2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        kissAlphaAnim_2.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                kissView2.setVisibility(VISIBLE);
                AnimationDrawable kissAnim = (AnimationDrawable)kissView2.getDrawable();
                if (kissAnim != null) {
                    kissAnim.start();
                }
            }
        });
        ObjectAnimator hideKissAlphaAnim_2 = ObjectAnimator.ofFloat(kissView2, "alpha", 0.36f, 0f);
        hideKissAlphaAnim_2.setDuration(600);
        hideKissAlphaAnim_2.setStartDelay(1400);

        ObjectAnimator kissAlphaAnim_3 = ObjectAnimator.ofFloat(kissView3, "alpha", 0, 0.36f);
        kissAlphaAnim_3.setDuration(300);
        kissAlphaAnim_3.setStartDelay(1400);
        kissView3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        kissAlphaAnim_3.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                kissView3.setVisibility(VISIBLE);
                AnimationDrawable kissAnim = (AnimationDrawable)kissView3.getDrawable();
                if (kissAnim != null) {
                    kissAnim.start();
                }
            }
        });
        ObjectAnimator hideKissAlphaAnim_3 = ObjectAnimator.ofFloat(kissView3, "alpha", 0.36f, 0f);
        hideKissAlphaAnim_3.setDuration(400);
        hideKissAlphaAnim_3.setStartDelay(2300);

        ObjectAnimator kissAlphaAnim_4 = ObjectAnimator.ofFloat(kissView4, "alpha", 0, 0.36f);
        kissAlphaAnim_4.setDuration(200);
        kissAlphaAnim_4.setStartDelay(1300);
        kissView4.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        kissAlphaAnim_4.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                kissView4.setVisibility(VISIBLE);
                AnimationDrawable kissAnim = (AnimationDrawable)kissView4.getDrawable();
                if (kissAnim != null) {
                    kissAnim.start();
                }
            }
        });
        ObjectAnimator hideKissAlphaAnim_4 = ObjectAnimator.ofFloat(kissView4, "alpha", 0.36f, 0f);
        hideKissAlphaAnim_4.setDuration(200);
        hideKissAlphaAnim_4.setStartDelay(2000);

        ObjectAnimator kissAlphaAnim_5 = ObjectAnimator.ofFloat(kissView5, "alpha", 0, 0.36f);
        kissAlphaAnim_5.setDuration(100);
        kissAlphaAnim_5.setStartDelay(1800);
        kissView5.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        kissAlphaAnim_5.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                kissView5.setVisibility(VISIBLE);
                AnimationDrawable kissAnim = (AnimationDrawable)kissView5.getDrawable();
                if (kissAnim != null) {
                    kissAnim.start();
                }
            }
        });
        ObjectAnimator hideKissAlphaAnim_5 = ObjectAnimator.ofFloat(kissView5, "alpha", 0.36f, 0f);
        hideKissAlphaAnim_5.setDuration(100);
        hideKissAlphaAnim_5.setStartDelay(2500);

        ObjectAnimator kissAlphaAnim_6 = ObjectAnimator.ofFloat(kissView6, "alpha", 0, 0.36f);
        kissAlphaAnim_6.setDuration(300);
        kissAlphaAnim_6.setStartDelay(1000);
        kissView6.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        kissAlphaAnim_6.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                kissView6.setVisibility(VISIBLE);
                AnimationDrawable kissAnim = (AnimationDrawable)kissView6.getDrawable();
                if (kissAnim != null) {
                    kissAnim.start();
                }
            }
        });
        ObjectAnimator hideKissAlphaAnim_6 = ObjectAnimator.ofFloat(kissView6, "alpha", 0.36f, 0f);
        hideKissAlphaAnim_6.setDuration(300);
        hideKissAlphaAnim_6.setStartDelay(2200);

        ObjectAnimator kissAlphaAnim_7 = ObjectAnimator.ofFloat(kissView7, "alpha", 0, 0.36f);
        kissAlphaAnim_7.setDuration(300);
        kissAlphaAnim_7.setStartDelay(700);
        kissView7.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        kissAlphaAnim_7.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                kissView7.setVisibility(VISIBLE);
                AnimationDrawable kissAnim = (AnimationDrawable)kissView7.getDrawable();
                if (kissAnim != null) {
                    kissAnim.start();
                }
            }
        });
        ObjectAnimator hideKissAlphaAnim_7 = ObjectAnimator.ofFloat(kissView7, "alpha", 0.36f, 0f);
        hideKissAlphaAnim_7.setDuration(400);
        hideKissAlphaAnim_7.setStartDelay(1800);

        //心动画.......start
        ObjectAnimator heartAlphaAnim_1 = ObjectAnimator.ofFloat(heartView1, "alpha", 0, 1f);
        heartAlphaAnim_1.setDuration(800);
        heartAlphaAnim_1.setStartDelay(1000);
        heartView1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        heartAlphaAnim_1.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                heartView1.setVisibility(VISIBLE);
            }
        });
        ObjectAnimator hideHeartAlphaAnim_1 = ObjectAnimator.ofFloat(heartView1, "alpha", 1f, 0f);
        hideHeartAlphaAnim_1.setDuration(700);
        hideHeartAlphaAnim_1.setStartDelay(1800);

        int top1 = ((LayoutParams)heartView1.getLayoutParams()).topMargin;
        ObjectAnimator heartTranslateAnim_1 = ObjectAnimator.ofFloat(heartView1, "y", top1, (top1 - dip2px(getContext(),64)));
        heartTranslateAnim_1.setDuration(1500);
        heartTranslateAnim_1.setStartDelay(1000);

        ObjectAnimator heartScaleXAnim_1 = ObjectAnimator.ofFloat(heartView1, "scaleX", 1f, 2.38f);
        heartScaleXAnim_1.setDuration(1500);
        heartScaleXAnim_1.setStartDelay(1000);

        ObjectAnimator heartScaleYAnim_1 = ObjectAnimator.ofFloat(heartView1, "scaleY", 1f, 2.38f);
        heartScaleYAnim_1.setDuration(1500);
        heartScaleYAnim_1.setStartDelay(1000);

        //第二个心
        ObjectAnimator heartAlphaAnim_2 = ObjectAnimator.ofFloat(heartView2, "alpha", 0, 0.5f);
        heartAlphaAnim_2.setDuration(200);
        heartAlphaAnim_2.setStartDelay(1300);
        heartView2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        heartAlphaAnim_2.addListener(new CustomAnimatiorListener() {
            @Override
            public void onAnimStart(Animator animation) {
                heartView2.setVisibility(VISIBLE);
            }
        });
        ObjectAnimator hideHeartAlphaAnim_2 = ObjectAnimator.ofFloat(heartView2, "alpha", 0.5f, 0f);
        hideHeartAlphaAnim_2.setDuration(700);
        hideHeartAlphaAnim_2.setStartDelay(1500);

        int top2 = ((LayoutParams)heartView2.getLayoutParams()).topMargin;
        ObjectAnimator heartTranslateAnim_2 = ObjectAnimator.ofFloat(heartView2, "y", top2, (top2 - dip2px(getContext(),51)));
        heartTranslateAnim_2.setDuration(900);
        heartTranslateAnim_2.setStartDelay(1300);

        ObjectAnimator heartScaleXAnim_2 = ObjectAnimator.ofFloat(heartView2, "scaleX", 1f, 3f);
        heartScaleXAnim_2.setDuration(900);
        heartScaleXAnim_2.setStartDelay(1300);

        ObjectAnimator heartScaleYAnim_2 = ObjectAnimator.ofFloat(heartView2, "scaleY", 1f, 3f);
        heartScaleYAnim_2.setDuration(900);
        heartScaleYAnim_2.setStartDelay(1300);


        mKissAnimSet = new AnimatorSet();
        mKissAnimSet.playTogether(kissAlphaAnim_1,hideKissAlphaAnim_1,kissAlphaAnim_2,hideKissAlphaAnim_2,
                kissAlphaAnim_3,hideKissAlphaAnim_3,kissAlphaAnim_4,hideKissAlphaAnim_4,kissAlphaAnim_5,hideKissAlphaAnim_5,
                kissAlphaAnim_6,hideKissAlphaAnim_6,kissAlphaAnim_7,hideKissAlphaAnim_7,heartAlphaAnim_1,hideHeartAlphaAnim_1,
                heartTranslateAnim_1,heartScaleXAnim_1,heartScaleYAnim_1,heartAlphaAnim_2,hideHeartAlphaAnim_2,heartTranslateAnim_2,
                heartScaleXAnim_2,heartScaleYAnim_2);

        mKissAnimSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (mKissAminListener != null) {
                    mKissAminListener.onAnimStart(animation);
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (mKissAminListener != null) {
                    mKissAminListener.onAnimEnd(animation);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                if (mKissAminListener != null) {
                    mKissAminListener.onAnimCancel(animation);
                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        mKissAnimSet.start();
    }


    public void cancel(){
        if (mKissAnimSet != null) {
            mKissAnimSet.cancel();
            mKissAnimSet.removeAllListeners();
        }
    }

    private KissAdminEndListener mKissAminListener;

    public void setFlyKissAdminEndLisener(KissAdminEndListener lisener){
        this.mKissAminListener = lisener;
    }

    public interface KissAdminEndListener{
        void onAnimStart(Animator animation);
        void onAnimEnd(Animator animation);
        void onAnimCancel(Animator animation);
    }

    public static int getScreenHeight(Context ctx) {
        if (ctx == null)
            return 0;
        return ctx.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * @Description: 获取屏幕的宽度
     * @param: context
     * @return: int
     */
    public static int getScreenWidth(final Context context) {
        if (context == null)
            return 0;
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int dip2px(Context context, int dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
    
}
