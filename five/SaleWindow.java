package five;

public class SaleWindow {
	public static void main(String[] args) throws InterruptedException {
		Runnable saleTask = new Runnable() {
			int i;

			@Override
			public void run() {
				for (; i < 1000; i++) {
					System.out.println(Thread.currentThread().getName() + "出售编号" + i + "电影票");
				}
			}
		};
		new Thread(saleTask, "窗口1").start();
		Thread.sleep(1);
		new Thread(saleTask, "窗口2").start();
		Thread.sleep(1);
		new Thread(saleTask, "窗口3").start();
		Thread.sleep(1);
	}
}
