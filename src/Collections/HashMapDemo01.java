package Collections;

import org.w3c.dom.traversal.NodeFilter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xianz
 * @Date: 2020/8/2 22:02
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class HashMapDemo01 {
    public static Map<Student, Integer> map;
    public static int a = 10;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public synchronized void put(){
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {



        Hashtable hashtable;
        HashMap hashMap;

        ConcurrentHashMap concurrentHashMap;
        Collections.synchronizedMap(map);
        LinkedHashMap linkedHashMap;
        ArrayDeque arrayDeque;
        ArrayList arrayList;

        HashSet hashSet;
        Map<Integer, Integer> hashMap1 = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()){

        }


        if ("a".equals("b"));
        HashMapDemo01 hashMapDemo01 = new HashMapDemo01();

        hashMapDemo01.testHashMap();
        HashMapDemo01.testHashMap2();

        hashMapDemo01.testHashMap2();


    }

    static class Node2{}

    public void testHashMap(){
        HashMap<Student, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        Map<Student, Integer> map2 = Collections.synchronizedMap(map);
    }
    public static void testHashMap2(){
        Map<Student, Integer> map2 = Collections.synchronizedMap(map);
    }
    static void testHashMap3(){
        Map<Student, Integer> map2 = Collections.synchronizedMap(map);
    }
}
