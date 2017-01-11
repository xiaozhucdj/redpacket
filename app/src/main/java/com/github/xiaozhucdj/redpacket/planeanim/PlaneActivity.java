package com.github.xiaozhucdj.redpacket.planeanim;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.github.xiaozhucdj.redpacket.R;

/**
 * Created by chudaijiang on 2017/1/11 16:42
 */

public class PlaneActivity extends AppCompatActivity {

    private RelativeLayout planeRl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        planeRl = (RelativeLayout) findViewById(R.id.rl_plane);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_plane:
                startPlaneAnim();
                break;
            default:
                break;
        }

    }

    private PlaneAnimView mPlaneAnimView;

    private void startPlaneAnim(){
        if (mPlaneAnimView != null) {
            mPlaneAnimView.cancle();
            planeRl.removeView(mPlaneAnimView);
        }
        mPlaneAnimView = new PlaneAnimView(this);
        mPlaneAnimView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        planeRl.addView(mPlaneAnimView);

        mPlaneAnimView.setPlaneAdminEndLisener(new PlaneAnimView.PlaneAdminEndListener() {
            @Override
            public void onAnimStart(Animator animation) {

            }

            @Override
            public void onAnimEnd(Animator animation) {
                System.out.println("动画结束...");
                if (mPlaneAnimView != null) {
                    planeRl.removeView(mPlaneAnimView);
                }
                /*if (mAnimEndListener != null) {
                    mAnimEndListener.animEnd();
                }*/
            }

            @Override
            public void onAnimCancel(Animator animation) {
                if (mPlaneAnimView != null) {
                    planeRl.removeView(mPlaneAnimView);
                }
            }
        });
        mPlaneAnimView.startAnim();
    }

}
