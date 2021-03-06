package com.github.xiaozhucdj.redpacket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.xiaozhucdj.redpacket.planeanim.PlaneActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button:
                RedPacketDialog redPacketDialog = new RedPacketDialog(this);
                redPacketDialog.show();
                break;
            case R.id.button2:
                BottomDialog bottomDialog = new BottomDialog(this);
                bottomDialog.show();
                break;
            case R.id.button3:
                startActivity(new Intent(this, PlaneActivity.class));
                break;
            default:
                break;
        }


    }


}
