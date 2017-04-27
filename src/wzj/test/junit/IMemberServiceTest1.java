package wzj.test.junit;
import org.junit.Test;

import junit.framework.TestCase;
import wzj.factory.Factory;
import wzj.service.IMemberService;

public class IMemberServiceTest1 {

	@Test
	public void testListByDelete() {
		IMemberService memberService=Factory.getServiceInstance("member.service") ;
		try {
			TestCase.assertNotNull(memberService.listByDelete(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
