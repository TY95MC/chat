import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier prepareForTunnel = new CyclicBarrier(CARS_COUNT + 1 );
//        Semaphore tunnelLimit = new Semaphore(CARS_COUNT / 2 );
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
                    cars[i] = new Car(race, 20 + (int) (Math.random() * 10), prepareForTunnel);
                }
        for (int i = 0; i < cars.length; i++) {

            new Thread(cars[i]).start();}
            try{
                prepareForTunnel.await();
                System.err.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                prepareForTunnel.await();
                prepareForTunnel.await();
            }catch(InterruptedException /**/| BrokenBarrierException e){
                e.printStackTrace();
            }

        System.err.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}





