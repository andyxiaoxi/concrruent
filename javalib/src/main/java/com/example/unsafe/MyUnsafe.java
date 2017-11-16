package com.example.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Created by Administrator on 2017/7/24.
 */
public class MyUnsafe {
    public static void main(String []args){


        try {
            Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeInstance.setAccessible(true);
            Unsafe unsafe = (Unsafe) theUnsafeInstance.get(Unsafe.class);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
