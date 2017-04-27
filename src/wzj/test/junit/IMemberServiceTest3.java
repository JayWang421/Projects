package wzj.test.junit;

import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;
import wzj.factory.Factory;
import wzj.service.IMemberService;
import wzj.vo.Member;

public class IMemberServiceTest3 {

	@Test
	public void testEdit() throws Exception{
		IMemberService memberService=Factory.getServiceInstance("member.service") ;
		Member vo =new Member() ;
		vo.setMid("j001");
		vo.setName("haioren");
		vo.setBirthday(new Date());
		vo.setSalary(12.46);
		vo.setNote("haoren");
		vo.setDel(0);
		TestCase.assertTrue(memberService.edit(vo));
	}

}
