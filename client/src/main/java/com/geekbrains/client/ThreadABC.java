package com.geekbrains.client;

import javax.management.monitor.Monitor;

public class ThreadABC {
    private final Object monitor = new Object();
    private boolean nextLetter1 = true;

//    public static void main(String[] args) {
//        ThreadABC w = new ThreadABC();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 3; i++) {
//                    w.firstA();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for( int i = 0; i < 3; i++){
//                    w.thenB();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//    }
//
//    public void firstA(){
//        synchronized (monitor){
//            try{
//                System.out.println("a-turn");
//                if(!nextLetter1){
//                    System.out.println("a-wait");
//                    monitor.wait();
//                }
//                System.out.println("A");
//                nextLetter1 = false;
//                System.out.println("a-notify");
//                monitor.notify();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void thenB(){
//        synchronized (monitor){
//            try{
//                System.out.println("b-turn");
//                if(nextLetter1){
//                    System.out.println("b-wait");
//                    monitor.wait();
//                }
//                System.out.println("B");
//                nextLetter1 = true;
//                System.out.println("b-notify");
//                monitor.notify();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
    private boolean nextLetter2 = true;
    private boolean nextLetter3 = true;

    public static void main(String[] args){
    ThreadABC writeLetterNow = new ThreadABC();
    Thread tA = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                writeLetterNow.writeA();
            }
        }
    });
    Thread tB = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                writeLetterNow.writeB();
            }
        }
    });
    Thread tC = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 1; i < 6; i++){
                writeLetterNow.writeC();
            }
        }
    });

        tA.start();
        tB.start();
        tC.start();
    }


    public void writeA(){
        synchronized (monitor){
            try{
                while(!nextLetter1 /*&& !nextLetter2*/){
                    monitor.wait();
                }
                nextLetter1 = false;
                nextLetter2 = false;
                System.out.print("A");
                monitor.notifyAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void writeB(){
        synchronized (monitor){
            try{
                while(nextLetter2/* && nextLetter2*/){
                    monitor.wait();
                }
                nextLetter2 = true;
                nextLetter3 = false;
                System.out.print("B");
                monitor.notifyAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void writeC() {
        synchronized (monitor) {
            try {
                while(nextLetter3 /* && !nextLetter2*/){
                    monitor.wait();
                }
                nextLetter1 = true;
//                nextLetter2 = false;
                nextLetter3 = true;
                System.out.print("C ");
                monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
