package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomList  {

      //初始容量
      private static final int DEFAULT_CAPACITY = 10;

      //无参构造的初始值
      private static final Object[] DEFAULT_ELEMENT = {};

      //本体
      private Object[] elementData ;

      //数组大小
      private int size;

      //无参构造
      public CustomList(){
          this.elementData = DEFAULT_ELEMENT;
      }

      //有参构造
      public CustomList(int i){
          if(i!=0) {
              this.elementData = new Object[i];
          }else {
              this.elementData = DEFAULT_ELEMENT;
          }
      }
      public void add(Object e){
          ensureCapacity(size+1);
          elementData[size] = e;
              size++;

      }
      private void ensureCapacity(int minCapacity){
          if(elementData==DEFAULT_ELEMENT){
              System.out.println("容量不足，扩容为默认大小");
              grow(DEFAULT_CAPACITY);
          }else if(minCapacity - elementData.length>0){
              System.out.println("容量不足，扩容为原数组的1.5倍");
              grow(minCapacity);
          }else {
              System.out.println("容量充足");
          }

      }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


      private void grow(int minCapacity){
          int oldCapacity = elementData.length;
          int newCapacity = oldCapacity + (oldCapacity>>1);
          if(newCapacity - minCapacity<0){
              System.out.println("扩容1.5倍后小于所需容量");
              newCapacity = minCapacity;
          }
          if (newCapacity - MAX_ARRAY_SIZE>0){
              System.out.println("扩容1.5倍后超出界限");
              newCapacity = hugeCapacity(minCapacity);
          }
          elementData = Arrays.copyOf(elementData, newCapacity);
          System.out.println("扩容成功");
      }

      private int hugeCapacity(int minCapacity){
          if (minCapacity < 0) // overflow
              throw new OutOfMemoryError();
          return (minCapacity > MAX_ARRAY_SIZE) ?
                  Integer.MAX_VALUE :
                  MAX_ARRAY_SIZE;
      }

      public Object get(int number){
          rangeCheck(number);
          return elementData[number-1];

      }
      public Object set(int number,Object o){
          rangeCheck(number-1);
          Object oldValue = elementData[number];
          elementData[number-1] = o;
          return oldValue;
      }

      private void rangeCheck(int number){
           if(elementData.length-number<0)
          throw new OutOfMemoryError();
      }

      public int size(){
          return size;
      }

      public Object remove(int number){
          rangeCheck(number);
          int removeNumber = size - number+1;
          Object object = elementData[number-1];
          System.arraycopy(elementData, number, elementData,number-1,removeNumber);
          elementData[size-1]=null;
          size--;
          return object;
      }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }



}
