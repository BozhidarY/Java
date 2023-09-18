package lab10;

public class Main {
    public static void main(String[] args) {

        int i;
        MyThread Ob = new MyThread();
        Thread thread = new Thread(Ob, "NameOfThread");
        thread.start();
        thread.getName();
        try {
            for (i = 0; i < 10; i++) {
                System.out.println("I am the Main thread " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
