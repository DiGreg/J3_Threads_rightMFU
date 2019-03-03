/*
Написать класс МФУ, на котором возможно одновременно выполнять печать и сканирование
документов, но нельзя одновременно печатать или сканировать два документа. При печати в
консоль выводится сообщения «Отпечатано 1 стр.», при сканировании –
аналогично «Отсканировано...».
 */

public class MainClass {

    public static void main(String[] args) {
        //Создаю МФУ
        MFU mfu1 = new MFU();

        //Создаю и стартую пользователей, передаю в каждый экземпляр User'а ссылку на МФУ, а имя потока задаю в Threads:
        //(создаю объект User с параметрами; передаю его как параметр в объект Thread вместе с именем потока; запускаю поток)
        new Thread(new User(mfu1,8, 5), "Пользователь #1").start();
        new Thread(new User(mfu1,3, 7), "Пользователь #2").start();
        new Thread(new User(mfu1,6, 0), "Пользователь #3").start();
        new Thread(new User(mfu1,0, 5), "Пользователь #4").start();

    }
}
