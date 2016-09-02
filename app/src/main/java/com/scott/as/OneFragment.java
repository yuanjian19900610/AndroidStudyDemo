package com.scott.as;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Function:
 * Created by yuanjian on 16/5/24.
 */
public class OneFragment extends Fragment {

    private View rootView;
    private TextView tv_content;

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
         tv_content= (TextView) rootView.findViewById(R.id.tv_content);
        tv_content.setText("你好， 我github");
    }

    private void submit() {
        Log.i("smarhit", "web提交的内容");
    }


}
