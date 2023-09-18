package lab10;

public class MyThread implements Runnable{

    void print(int i){
        System.out.println("Im a thread" + i);
    }

    @Override
    public void run() {
        int i;
        try{
            for(i = 0; i < 10; i++){
                Thread.sleep(150);
                this.print(i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
