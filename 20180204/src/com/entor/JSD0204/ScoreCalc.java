package com.entor.JSD0204;


/**
 * 成绩计算类
 * 
 * @author Administrator
 *
 */
public class ScoreCalc {

	//三门课程成绩
	private double java;
	private double c;
	private double db;
	
	
//	//构造函数
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
		return "分数信息[java=" + java + ", c=" + c + ", db=" + db + "]";
	}

	/**
	 * 计算平均成绩
	 * @return
	 */
	public double avg(){
		//TODO 计算平均成绩  return (java+c+db)/3;
		return sum()/3;
	}
	
	/**
	 * 显示平均成绩
	 */
	public void showAvg(){
		System.out.println("平均成绩是：" + avg());
	}
	
	/**
	 * 计算总成绩
	 * @return
	 */
	public double sum(){
		return java + c + db;
	}
	
	/**
	 * 显示总成绩
	 */
	public void showSum(){
		System.out.println("总成绩是：" + sum());
	}
	
}
