package com.ldq.car;
/**
 * ������
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
// ��������
		Car car = new Car("����","��ɫ","2��","300��");
		Driver d = new Driver("����ɽ","��",30,10);
// ���÷�����ʵ��˾���ļ�ʻ��������������
		car.repaire();
		car.run();
		d.repairCar(car);
		d.drive(car);
	}
}