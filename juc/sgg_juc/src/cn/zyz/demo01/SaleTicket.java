package cn.zyz.demo01;

class Ticket{
    private int number = 30;
    public synchronized void saleTicket(){
        while (number>0){
            System.out.println(Thread.currentThread().getName()+"\t卖出第"+(30-(--number))+"张票"+"还剩下"+number+"张票");
        }
    }
}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"张三").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        },"李四").start();
    }
}
