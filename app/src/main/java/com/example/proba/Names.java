package com.example.proba;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private static List<String>names;

    private static void init(){
        if (names==null){
        names=new ArrayList<>();
        names.add("Stefan");
        names.add("Marko");
        names.add("Ivan");
        names.add("Pavle");}
    }
    public static List<String>getNames(){
        init();
        return names;
    }
    public static String getNamesById(int id){
        init();
        if ((id>=0) && (id<names.size())){
            return names.get(id);
        }
        return null;
    }

}
