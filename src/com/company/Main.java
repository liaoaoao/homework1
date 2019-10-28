package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CustomList customList = new CustomList();
        customList.add(11);
        customList.add(200);
        customList.add(100);
        customList.add(200);
        customList.add(100);
        customList.add(200);
        customList.add(100);
        customList.add(200);
        customList.add(100);
        customList.add(200);
        customList.add(100);
        customList.add(200);
        System.out.println(customList.get(2)+","+customList.size()+","+customList.remove(1));
        System.out.println("禹城渣渣辉");

    }
}
