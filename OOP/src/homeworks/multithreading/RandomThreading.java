package homeworks.multithreading;

import java.util.Random;

public class RandomThreading {

    static boolean winner = false;

    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(0,1_000_000_000);

        Thread threadRandom = new Thread(new Runnable() {
            @Override
            public void run() {
                int numberThread;
                do {
                    numberThread = random.nextInt(0, 1_000_000_000);
                } while (numberThread != number);
                winner = true;
                System.out.println(numberThread);
            }
        });
        threadRandom.start();

                Thread threadTimer = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1_000_000_000; i++) {
                            if (winner) {
                                break;
                            }
                            System.out.println(i);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                });
                threadTimer.start();

            }
        }
