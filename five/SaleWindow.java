package five;

public class SaleWindow {
	public static void main(String[] args) throws InterruptedException {
		Runnable saleTask = new Runnable() {
			int i;

			@Override
			public void run() {
				for (; i < 1000; i++) {
					System.out.println(Thread.currentThread().getName() + "���۱��" + i + "��ӰƱ");
				}
			}
		};
		new Thread(saleTask, "����1").start();
		Thread.sleep(1);
		new Thread(saleTask, "����2").start();
		Thread.sleep(1);
		new Thread(saleTask, "����3").start();
		Thread.sleep(1);
	}
}
