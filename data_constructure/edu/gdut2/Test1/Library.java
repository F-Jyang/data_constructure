package edu.gdut2.Test1;

import java.util.ArrayList;
import java.util.List;

public class Library <T>{
   private List<T> resources=new ArrayList<>();
   public void addMedia(Media x){
       resources.add((T) x);
   }
   public Media retrieveLast(){
       int size=resources.size();
       if(size>0){
           return (Media) resources.get(size-1);
       }
       return null;
   }
}
