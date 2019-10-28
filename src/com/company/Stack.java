package com.company;

public class Stack extends CustomList {
    private CustomList customList = new CustomList();
    public synchronized Object push(Object e){
        customList.add(e);
        return e;
    }
    public synchronized Object pop(){
        if(customList.size()<=0) {
            throw new OutOfMemoryError();
        }
        Object o = customList.get(customList.size()-1);
            customList.remove(customList.size());
            return o;
    }
    public int size(){
        return customList.size();
    }
}
