package wzj.test.junit;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

import junit.framework.TestCase;
import wzj.factory.Factory;
import wzj.service.IMemberService;
import wzj.vo.Member;

public class IMemberServiceTest {
	private static int rand=0 ;
	static {
		rand=new Random().nextInt(9999) ;
	}
	@Test
	public void testAdd() throws Exception{
		IMemberService memberService=Factory.getServiceInstance("member.service") ;
		Member vo=new Member() ;
		vo.setMid("mldn"+rand);
		vo.setName("»À"+rand);
		vo.setBirthday(new Date());
		vo.setSalary(77.7);
		vo.setNote("∫√»À");
		vo.setDel(0);
		TestCase.assertTrue(memberService.add(vo));
	}

}
