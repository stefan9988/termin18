package com.example.proba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainFragment.Click {
    private boolean hor=false;
    private SecundFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fldrugi)!=null){
            hor=true;
            fragment=new SecundFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fldrugi,fragment).commit();
        }

        MainFragment mainFragment=new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFrame,mainFragment).commit();





    }

    @Override
    public void clickkk(int id) {
        fk(id);
    }

    private void fk(int id) {
        if (hor){
        TextView textView=findViewById(R.id.textView);
        textView.setText(Names.getNamesById(id));}
        else {

            String ime=Names.getNamesById(id);
            SecundFragment secundFragment=new SecundFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFrame,secundFragment).commit();
            TextView textView=findViewById(R.id.textView);
            textView.setText(ime);
        }
    }


}