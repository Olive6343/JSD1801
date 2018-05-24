package spring_demo;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ldq.springdemo.AOPConfig;
import com.ldq.springdemo.Performer;


@ContextConfiguration(classes = {AOPConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AOPTest {

	@Resource
	private Performer laowang;
	
	@Test
	public void testPerformer() {
		laowang.perform("aaaaaaaaaaaaaaaaaaaa");
	}

}
