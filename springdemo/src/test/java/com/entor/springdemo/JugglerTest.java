package com.entor.springdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Juggler测试类
 * 
 * @author Administrator
 *
 */
public class JugglerTest {

	@Test
	public void testConstructorDI() {
		// 1.读取appclicationContext.xml，初始化Spring容器上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// 2.获得指定id的bean
		Juggler zhangsan = (Juggler) ac.getBean("zhangsan");
		// 3.请开始表演
		zhangsan.perform();

		Juggler lisi = (Juggler) ac.getBean("lisi");
		lisi.perform();

		PoeticJuggler zhaosi = (PoeticJuggler) ac.getBean("zhaosi");
		zhaosi.perform();

		Stage stage = (Stage) ac.getBean("stage");
		System.out.println(stage);
	}

	@Test
	public void testFactoryMethodDI() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		Stage stage = (Stage) ac.getBean("stage");
		System.out.println(stage);
	}

	@Test
	public void testSetPropertyDI() {
		// 1.读取appclicationContext.xml，初始化Spring容器上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		Juggler wangwu = (Juggler) ac.getBean("wangwu");
		wangwu.perform();

		Juggler qianba = (Juggler) ac.getBean("qianba");
		qianba.perform();

		OneManBand oneManBand = (OneManBand) ac.getBean("oneManBand");
		oneManBand.perform();
	}

	@Test
	public void testSpELDI() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Instrumentalist laozhang = (Instrumentalist) ac.getBean("laozhang");
		laozhang.perform();

		Instrumentalist laowang = (Instrumentalist) ac.getBean("laowang");
		laowang.perform();
	}

	@Test
	public void testT() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Calculator calculator = (Calculator) ac.getBean("calculator");
		System.out.println(calculator.getPi());
		System.out.println(calculator.getSum());
		System.out.println(calculator.getRandom());
		System.out.println(calculator.getCircleArea());
		System.out.println(calculator.getJudge());
		System.out.println(calculator.getResult());
		System.out.println(calculator.getRegex());
	}
}
