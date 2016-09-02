package com.scott.as;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Function:
 * Created by yuanjian on 16/5/24.
 */
public class OneFragment extends Fragment implements View.OnClickListener{

    private View rootView;
    private TextView tv_content;
    private Button btn_submit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_one,container,false);
        }
        initView();
        return rootView;
    }


    /**
     * 获取控件
     */
    private void initView() {
        tv_content = (TextView) rootView.findViewById(R.id.tv_content);
        btn_submit = (Button) rootView.findViewById(R.id.btn_submit);
        tv_content.setText("你好，我正在测试暂存");
        btn_submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:

                break;
        }
    }
}
