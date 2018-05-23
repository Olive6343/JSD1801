package com.ldq.car;
/**
 * 测试类
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
// 创建对象
		Car car = new Car("奔驰","红色","2吨","300迈");
		Driver d = new Driver("秋名山","男",30,10);
// 调用方法，实现司机的驾驶能力和修理能力
		car.repaire();
		car.run();
		d.repairCar(car);
		d.drive(car);
	}
}