package com.github.xiaozhucdj.redpacket.planeanim;

import android.animation.Animator;

/**
 * Created by dong.wang on 2017/1/6.
 */

public abstract class CustomAnimatiorListener implements Animator.AnimatorListener {
    @Override
    public void onAnimationStart(Animator animation) {
        onAnimStart(animation);
    }

    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    public abstract void onAnimStart(Animator animation);

}
