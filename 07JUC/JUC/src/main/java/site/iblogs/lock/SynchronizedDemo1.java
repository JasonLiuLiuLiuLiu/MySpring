package site.iblogs.lock;

class SynchronizedDemo1 {
    public static void main(String[] args) {
        final SaleTicket sale = new SaleTicket();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 40; i++) {
                    sale.saleTicker();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 40; i++) {
                    sale.saleTicker();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 40; i++) {
                    sale.saleTicker();
                }
            }
        }, "C").start();

    }
}

class SaleTicket {
    private int number = 30;

    public synchronized void saleTicker() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + number-- + "张票,剩余" + number);
        }
    }
}