package ua.javarush.island;

public class Main2 {
    public static void main(String[] args) {
        Resource a = new Resource();
        Resource b = new Resource();
        MyThread myThread1 = new MyThread(a, b);
        myThread1.setName("My thread - 1");

        MyThread myThread2 = new MyThread(b, a);
        myThread2.setName("My thread - 2");
        myThread1.start();
        myThread2.start();
    }
}

class Resource{

}

class MyThread extends Thread{

    private final Resource resource1;
    private final Resource resource2;

    MyThread(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
            synchronized (resource1){
                synchronized (resource2){
                    while (true){

                    }
                }
            }
        }

}
