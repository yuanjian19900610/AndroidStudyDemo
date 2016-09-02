package com.scott.as;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.scott.as.view.AnimateButton;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;
    private TextView tv_content,tv_info,tv_info2;
    private Button btn,btn2;
    private AnimateButton ab_btn;
    private TextView tv_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_content= (TextView) findViewById(R.id.tv_content);
        SpannableString ss=new SpannableString(tv_content.getText());
        ss.setSpan(new BackgroundColorSpan(Color.RED), 2, 5, 0);
        ss.setSpan(new BackgroundColorSpan(Color.GREEN), 9, 15, 0);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 16, 22, 0);
        tv_content.setText(ss);
        tv_info= (TextView) findViewById(R.id.tv_info);
        btn= (Button) findViewById(R.id.btn);

        tv_info2= (TextView) findViewById(R.id.tv_info2);
        btn2= (Button) findViewById(R.id.btn2);
        tv_animation= (TextView) findViewById(R.id.tv_animation);


        btn.post(new Runnable() {
            @Override
            public void run() {
//                tv_info.setText("width:"+btn.getWidth()+",height:"+btn.getHeight()+"  size="+ btn.getTextSize());


            }
        });

        btn2.post(new Runnable() {
            @Override
            public void run() {
                tv_info2.setText("width:"+btn2.getWidth()+",height:"+btn2.getHeight()+"  size="+ btn2.getTextSize());
            }
        });
        ab_btn= (AnimateButton) findViewById(R.id.ab_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ObjectAnimator.ofFloat(btn2, "translationX", 0, 100).setDuration(1000).start();


                Intent mIntent = new Intent();
                mIntent.setAction(android.content.Intent.ACTION_VIEW);
                mIntent.setDataAndType(Uri.EMPTY, "audio/mp3");
                startActivity(mIntent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ab_btn.smoothScrollerTo(-50, -50, 2000);

//                Intent intent = new Intent(Intent.action_M);
//                startActivity(intent);

//                Intent mIntent = new Intent();
//                ComponentName comp = new ComponentName("com.android.music","com.android.music.MusicBrowserActivity");
//                mIntent.setComponent(comp);
//                mIntent.setAction(android.content.Intent.ACTION_VIEW);
//                startActivity(mIntent);

                Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(intent);
            }
        });


        ab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//
                tv_animation.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int flag = 0;
                        while (flag < 20) {
                            flag++;
                            tv_animation.scrollTo(-20 * flag, -20 * flag);

                        }

                    }

                }, 50);

            }

        });


    }


    @Override
    public void onClick(View view) {
        Log.i("smarhit","view onclick");
    }
}
