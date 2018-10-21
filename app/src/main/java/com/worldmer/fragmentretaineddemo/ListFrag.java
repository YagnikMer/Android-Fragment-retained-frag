package com.worldmer.fragmentretaineddemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Yagnik on 21-Oct-18.
 */

public class ListFrag extends Fragment{
    ListView lvlist;
    List<String> numberList;
    FragCallback callback;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.frag_list,container,false);

        callback = (FragCallback)getContext();
        lvlist = view.findViewById(R.id.lvlist);
        createList();
        ArrayAdapter<String> adapter = new ArrayAdapter
                (getContext(),android.R.layout.simple_list_item_1,numberList);
        lvlist.setAdapter(adapter);
        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                callback.onFragDetailIndex(i);
            }
        });
        return view;
    }

    public void createList()
    {
        numberList = new ArrayList<>();
        numberList.add("ONE");
        numberList.add("TWO");
        numberList.add("THREE");
        numberList.add("FOUR");
        numberList.add("FIVE");
        numberList.add("SIX");
        numberList.add("SEVEN");
        numberList.add("EIGHT");
        numberList.add("NINE");
        numberList.add("TEN");
    }
}
