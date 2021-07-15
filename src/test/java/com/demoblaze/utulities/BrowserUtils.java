package com.demoblaze.utulities;

public class BrowserUtils {

    public static void sleep(int second) {  //thread.sleep vardi sildik
        second *= 1000;


        //1 sec = 1000 milli seconds
        //1 * 1000 =1000
        try {                                 //butun yazdigimiz threadsleep lerde otomaik 1000 olarak algilayacak
            Thread.sleep(second);              //alti kirmizi iken cikan pencereden "more actions " sec altinda "
            // surround with try/catch sec" otomatik try cikiyor
        } catch (InterruptedException e) {
            e.printStackTrace();

            System.out.println("something happened in the sleep method");
        }

    }

}
