package com.java.logic.note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: DynamicArray .java
 * @Create : 2019-04-25-14:54
 * @Description :
 */

/**
 *  动态数组 类似于ArrayList
 * @param <E>
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    public DynamicArray(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity){
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity){
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity){
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }
    public void  add(E e){
        ensureCapacity(size +1);
        elementData[size++] = e;
    }
    public E get(int index){
        return (E)elementData[index];
    }
    public int size(){
        return size;
    }
    public E set(int index,E element){
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }


    public static void main(String[] args) {

        ArrayList<Integer> integerArrays = new ArrayList<>();
        Collection<Integer> integerCollection = new ArrayList<>();
        LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();


    }
}
