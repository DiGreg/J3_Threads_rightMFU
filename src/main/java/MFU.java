/*
Класс МФУ - с методами печати и сканирования.
Вариант с синхронизированными кусками кода
(первоначальный вариант с синхр.статич. методами не подошёл, т.к. монитором для методов являлся класс
и при доступе к одному из методов, другой метод также оказывался заблокирован для исполнения,
пока не выполнится одно из заданий на печать или сканирование)

 */

public class MFU {
    //объекты-мониторы для синхронизированных блоков
    private Object printLock = new Object();
    private Object scanLock = new Object();

    //метод печати
    public void print(int pagesToPrint){

        //синхронизированный блок по печати - использую объект-монитор printLock:
        synchronized (printLock){
            for (int i = 1; i <= pagesToPrint; i++) {
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " -> напечатано: " + i + " стр.");
            }
        }
    }

    //метод сканирования
    public void scan(int pagesToScan){

        //синхронизированный блок по печати - использую объект-монитор scanLock:
        synchronized (scanLock){
            for (int i = 1; i <= pagesToScan; i++) {
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ " отсканировано : " + i + " стр.");
            }
        }
    }
}
