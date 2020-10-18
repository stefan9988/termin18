package com.example.proba;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainFragment extends Fragment {
    private ListView listView;
    private List<String>data=Names.getNames();
    private Click click;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.lvMain);
        create();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (click !=null){
                    click.clickkk(position);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Click){
            click=(Click) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        click=null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    private void create(){
        ArrayAdapter<String>adapter=new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                data
        );
        listView.setAdapter(adapter);
    }
    interface Click{
        void clickkk(int id);
    }
}