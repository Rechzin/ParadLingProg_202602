import java.util.Random;

class MeuThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            Random random = new Random();
            System.out.println(Thread.currentThread().getName() + " - Contagem: " + i);
            try {
                Thread.sleep(random.nextInt(1000, 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultithreadSimples {
    public static void main(String[] args) {
        MeuThread t1 = new MeuThread();
        MeuThread t2 = new MeuThread();

        t1.start(); // Inicia a thread t1
        t2.start(); // Inicia a thread t2

        System.out.println("Threads iniciadas!");
    }
}
