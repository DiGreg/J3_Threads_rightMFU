public class User implements Runnable {
    //Поля пользователя:
    private MFU nameMFU;//ссылка на МФУ, с которым будет работать пользователь
    private int pageToPrint;
    private int pageToScan;

    //Коструктор пользователя (при создании объекта надо указать кол-во стр. на печать и сканирование):
    public User(MFU nameMFU, int pageToPrint, int pageToScan){
        this.pageToPrint = pageToPrint;
        this.pageToScan = pageToScan;
        this.nameMFU = nameMFU;
    }

    //здесь пропишу то, что должно выполняться в потоке
    @Override
    public void run(){
        if (pageToPrint > 0) nameMFU.print(pageToPrint); //печать страниц
        else System.out.println(Thread.currentThread().getName() + " не дал заданий на печать.");
        if (pageToScan > 0) nameMFU.scan(pageToScan); //сканирование страниц
        else System.out.println(Thread.currentThread().getName() + " не дал заданий на сканирование.");
    }

}
