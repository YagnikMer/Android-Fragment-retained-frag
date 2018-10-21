package com.worldmer.fragmentretaineddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yagnik on 21-Oct-18.
 */

public class DetailFrag extends Fragment {
    TextView tvText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_detail, container, false);
        tvText = view.findViewById(R.id.tvtext);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        int value = bundle.getInt("value");
        if (null != tvText)
        {
            tvText.setText(String.valueOf(value+1));
        }
    }
}