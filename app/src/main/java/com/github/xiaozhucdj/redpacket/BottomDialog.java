package com.github.xiaozhucdj.redpacket;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import static com.github.xiaozhucdj.redpacket.RedPacketDialog.convertDipOrPx;

/**
 * Created by chudaijiang on 2016/12/16 14:02
 */

public class BottomDialog extends Dialog {
    public BottomDialog(Context context) {
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

        window.setGravity(Gravity.CENTER | Gravity.CENTER);
        window.setWindowAnimations(R.style.AnimBottom);

    }
}
