package com.worldmer.fragmentretaineddemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState==null)
        addFragment(new ListFrag(),"LIST",false);
    }

    public void addFragment(Fragment fragment,String tag,boolean isback)
    {
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(isback==true)
        transaction.addToBackStack(tag);
        transaction.replace(R.id.llfragment,fragment,tag);
        transaction.commit();
    }

    @Override
    public void onFragDetailIndex(int value) {
        Bundle bundle = new Bundle();
        bundle.putInt("value",value);
        DetailFrag fragment = new DetailFrag();
        fragment.setArguments(bundle);
        addFragment(fragment,"DETEIL",true);
    }
}
