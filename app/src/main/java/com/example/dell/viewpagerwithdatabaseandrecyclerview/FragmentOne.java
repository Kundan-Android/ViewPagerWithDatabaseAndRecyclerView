package com.example.dell.viewpagerwithdatabaseandrecyclerview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
EditText et1,et2,et3;
    Button save;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment_one, container, false);
        et1 = (EditText) v.findViewById(R.id.edittext1);
        et2 = (EditText) v.findViewById(R.id.edittext2);
        et3 = (EditText) v.findViewById(R.id.edittext3);
        save = (Button) v.findViewById(R.id.button1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString();
                String subject = et2.getText().toString();
                String mail = et3.getText().toString();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.myDatabase.insertStudent(name,subject,mail);
                Toast.makeText(getActivity(), "Data inserted", Toast.LENGTH_SHORT).show();
                mainActivity.notifyData();
                et1.setText("");
                et2.setText("");
                et3.setText("");
            }
        });
        return v;

    }

}
