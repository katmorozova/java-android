package multithreding;

public class Multithreading {
    static boolean isFive = false;

    public static void main(String[] args) {
        //multithreding.Timer timer = new multithreding.Timer();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10_000_000; i++){
                    if (i == 5){
                        isFive = true;
                    }
                    System.out.println(i);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }

                }
            }
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10_000_000; i++){
                    if(isFive){
                        break;
                    }
                    System.out.println(i);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }

                }
            }
        });
        thread2.start();

    }
}
