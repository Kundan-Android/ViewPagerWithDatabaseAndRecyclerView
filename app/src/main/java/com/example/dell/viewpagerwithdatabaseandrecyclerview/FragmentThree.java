package com.example.dell.viewpagerwithdatabaseandrecyclerview;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThree extends Fragment {
RecyclerView recyclerView;
    ArrayList<Student>arrayList;
    MyDatabase myDatabase;
    Cursor cursor;
    MyAdapter myAdapter;

    public FragmentThree() {
        // Required empty public constructor
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
    {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = getActivity().getLayoutInflater().inflate(R.layout.row,parent,false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Student s = arrayList.get(position);
            holder.tv1.setText(s.getSno());
            holder.tv2.setText(s.getSname());
            holder.tv3.setText(s.getSubject());
            holder.tv4.setText(s.getEmail());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            public TextView tv1,tv2,tv3,tv4;
            public ViewHolder(View itemView) {

                super(itemView);
                tv1 = (TextView) itemView.findViewById(R.id.textView10);
                tv2 = (TextView) itemView.findViewById(R.id.textView20);
                tv3 = (TextView) itemView.findViewById(R.id.textView30);
                tv4 = (TextView) itemView.findViewById(R.id.textView40);
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment_three, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview11);
        arrayList = new ArrayList<Student>();
        MainActivity mainActivity = (MainActivity) getActivity();
        cursor = mainActivity.myDatabase.queryStudent();
        if (cursor!=null)
        {
            while (cursor.moveToNext())
            {
                int sno = cursor.getInt(0);
                String name = cursor.getString(1);
                String subject = cursor.getString(2);
                String email = cursor.getString(3);
                Student s = new Student();
                s.setSno(""+sno);
                s.setSname(name);
                s.setSubject(subject);
                s.setEmail(email);
                arrayList.add(s);
            }
        }
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        return v;
    }

}
