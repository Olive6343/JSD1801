package com.entor.JSD0204;


/**
 * �ɼ�������
 * 
 * @author Administrator
 *
 */
public class ScoreCalc {

	//���ſγ̳ɼ�
	private double java;
	private double c;
	private double db;
	
	
//	//���캯��
//	public ScoreCalc(double java,double c,double db){
//		this.java = java;
//		this.c = c;
//		this.db = db;
//	}
	
	
	public double getJava() {
		return java;
	}

	public void setJava(double java) {
		this.java = java;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getDb() {
		return db;
	}

	public void setDb(double db) {
		this.db = db;
	}
	
	

	@Override
	public String toString() {
		return "������Ϣ[java=" + java + ", c=" + c + ", db=" + db + "]";
	}

	/**
	 * ����ƽ���ɼ�
	 * @return
	 */
	public double avg(){
		//TODO ����ƽ���ɼ�  return (java+c+db)/3;
		return sum()/3;
	}
	
	/**
	 * ��ʾƽ���ɼ�
	 */
	public void showAvg(){
		System.out.println("ƽ���ɼ��ǣ�" + avg());
	}
	
	/**
	 * �����ܳɼ�
	 * @return
	 */
	public double sum(){
		return java + c + db;
	}
	
	/**
	 * ��ʾ�ܳɼ�
	 */
	public void showSum(){
		System.out.println("�ܳɼ��ǣ�" + sum());
	}
	
}
