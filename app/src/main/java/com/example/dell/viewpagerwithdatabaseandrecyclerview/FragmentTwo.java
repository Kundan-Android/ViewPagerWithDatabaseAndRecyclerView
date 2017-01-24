package com.example.dell.viewpagerwithdatabaseandrecyclerview;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {
    ListView listView;
    SimpleCursorAdapter simpleCursorAdapter;
    Cursor cursor;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment_two, container, false);
        listView = (ListView) v.findViewById(R.id.listview1);
        MainActivity mainActivity = (MainActivity) getActivity();

        cursor = mainActivity.myDatabase.queryStudent();
        if (cursor!=null) {
            while (cursor.moveToNext()) {
                simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                        R.layout.row,
                        cursor,
                        new String[]{"_id", "name", "sub", "email"},
                        new int[]{R.id.textView10, R.id.textView20, R.id.textView30, R.id.textView40});

                listView.setAdapter(simpleCursorAdapter);
            }
        }
        return v;
    }

}
