package com.github.xiaozhucdj.redpacket;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;


public class RotateY3DAdmin extends Animation {

    private Camera mCamera;
    //中心点x坐标
    private float mCenterX;
    //中心点Y坐标
    private float mCenterY;

    public RotateY3DAdmin(float centerX, float centerY){
        this.mCamera = new Camera();
        this.mCenterX = centerX;
        this.mCenterY = centerY;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        //super.applyTransformation(interpolatedTime, t);
        Matrix matrix = t.getMatrix();
        mCamera.save();
        float degree = 360 - (360 * interpolatedTime);
        mCamera.rotateX(degree);
        mCamera.getMatrix(matrix);
        mCamera.restore();

        matrix.preTranslate(-mCenterX, -mCenterY);
        matrix.postTranslate(mCenterX, mCenterY);
        /*t.setAlpha(1.0f + ((0.0f - 1.0f) * (interpolatedTime - 0.5f) * 2));*/
    }
}
