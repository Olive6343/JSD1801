package spring_demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ldq.springdemo.Juggler;


/**
 * Juggler测试类
 * 
 * @author Administrator
 *
 */
public class JugglerTest {

	@Test
	public void testInitializing() {
		// 1.读取applicationContext.xml，初始化Spring容器上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// 2.获得指定id的bean
		Juggler zhangsan = (Juggler)ac.getBean("zhangsan");
		// 3.请开始表演
		zhangsan.perform();
		
		Juggler lisi = (Juggler)ac.getBean("lisi");
		lisi.perform();
		
		
	}

}
