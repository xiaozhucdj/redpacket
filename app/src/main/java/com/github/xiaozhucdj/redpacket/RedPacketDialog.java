package com.github.xiaozhucdj.redpacket;

/**
 * Created by chudaijiang on 2016/12/14 18:54
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class RedPacketDialog extends Dialog implements View.OnClickListener {

    private FrameLayout redpacket_rootview;
    private TextView rob_money_num;
    private View open_redpacket_top;
    private View redpacket_bottom;
    private View redpacket_top;
    private ImageView close_bt;
    private ImageView sender_head_view;
    private TextView sender_name;
    private TextView sender_wish_text;
    private ImageView open_bt;


    public RedPacketDialog(Context context) {
        this(context,0);
    }

    public RedPacketDialog(Context context, int themeResId) {
        super(context, R.style.CenterCompatDialogTheme);

        init();
    }

    private void init(){
        Window window = getWindow();
        window.setContentView(R.layout.redpacket_open_dialog_view);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = convertDipOrPx(getContext(), 290);
        layoutParams.height = convertDipOrPx(getContext(), 380);
        window.setAttributes(layoutParams);


        initUI();
    }

    private void initUI(){
        redpacket_rootview = (FrameLayout)findViewById(R.id.redpacket_rootview);
        rob_money_num = (TextView)findViewById(R.id.rob_money_num);
        open_redpacket_top = findViewById(R.id.open_redpacket_top);
        redpacket_bottom = findViewById(R.id.redpacket_bottom);
        redpacket_top = findViewById(R.id.redpacket_top);
        close_bt = (ImageView)findViewById(R.id.close_bt);
        sender_head_view = (ImageView)findViewById(R.id.sender_head_view);
        sender_name = (TextView)findViewById(R.id.sender_name);
        sender_wish_text = (TextView)findViewById(R.id.sender_wish_text);
        open_bt = (ImageView)findViewById(R.id.open_bt);

        open_bt.setOnClickListener(this);
        close_bt.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.open_bt:
                float centerX = (float) open_bt.getWidth()/2;
                float centerY = (float) open_bt.getHeight()/2;
                RotateY3DAdmin rotateY3DAdmin = new RotateY3DAdmin(centerX,centerY);
                rotateY3DAdmin.setDuration(800);
                rotateY3DAdmin.setRepeatCount(Animation.INFINITE);
                open_bt.startAnimation(rotateY3DAdmin);
                open_bt.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onRedPacketOpen(true,2,"");
                    }
                },1500);
//                openRedPacket();

                break;
            case R.id.close_bt:
                dismiss();
                break;
        }
    }

    /**
     * 请求抢红包接口
     */
    /*private void openRedPacket(){
        RxBus.get().post(ComponentContract.PresenterMessages.V_2_P,
                new ComponentMessage(ComponentContract.PresenterMessages.OPEN_REDPACKET_MSG, mRedPacketMsg));
    }
*/
    public void onRedPacketOpen(final boolean isSuccess,final int coinNum,final String failReason){
        open_bt.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                showOpenRedPacketAnim(isSuccess,coinNum,failReason);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        open_bt.startAnimation(alphaAnimation);
        open_bt.setVisibility(GONE);
    }

    /**
     * 展示红包打开动画
     */
    private void showOpenRedPacketAnim(final boolean isSuccess,final int coinNum,final String failReason){
        redpacket_rootview.setBackgroundResource(R.drawable.redpocket_open_dialog_bg);

        TranslateAnimation topTranslateAnimation = new TranslateAnimation(0,0,0,-convertDipOrPx(getContext(), 225));
        topTranslateAnimation.setDuration(200);
        redpacket_top.startAnimation(topTranslateAnimation);

        TranslateAnimation bottomTranslateAnimation = new TranslateAnimation(0,0,0,convertDipOrPx(getContext(), 225));
        bottomTranslateAnimation.setDuration(200);
        redpacket_bottom.startAnimation(bottomTranslateAnimation);

        topTranslateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                sender_wish_text.setVisibility(GONE);
                sender_name.setTextColor(Color.parseColor("#333333"));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                redpacket_top.setVisibility(GONE);
                redpacket_bottom.setVisibility(GONE);
                open_redpacket_top.setVisibility(VISIBLE);
                rob_money_num.setVisibility(VISIBLE);
                if (isSuccess) {
                    rob_money_num.setText(coinNum+"金币");
                } else {
                    rob_money_num.setText(failReason);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 转换dip为px
     *
     * @param context
     * @param dip
     * @return
     */
    public static int convertDipOrPx(Context context, float dip) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }
}
