package com.entor.cycle;

/**
 * break：跳出循环结构 计算1-100的和，当和大于1000的时候结束，输出最终的结果和最后一次加和的数
 * 
 * @author Administrator
 *
 */
public class CycleTest7 {

	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		for(;i <= 100; i++){
			if(sum > 1000){
				break;
			}
			
			sum += i;
		}
		System.out.println("最后一次加入的数：" + (i-1));
		System.out.println("最后结果：" + sum);
		
		
		
		int j = 1;
		int sum2 = 0;
		for(;j <= 100; j++){
			sum2 += j;
			if(sum2 > 1000){
				break;
			}
			
		}
		System.out.println("最后一次加入的数：" + j);
		System.out.println("最后结果：" + sum2);
	}
	
}
