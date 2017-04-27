package wzj.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import wzj.dao.IMemberDAO;
import wzj.factory.Factory;
import wzj.service.IMemberService;
import wzj.vo.Member;

public class MemberServiceImpl implements IMemberService {
	IMemberDAO memberDao=Factory.getDAOInstance("member.dao") ;
	@Override
	public boolean add(Member vo) throws Exception {
		if(memberDao.fingById(vo.getMid())==null){
			vo.setDel(0);
			return memberDao.doCreate(vo) ;
		}
		return false;	 
	}
	@Override
	public List<Member> listByDelete(int del) throws Exception {
		IMemberDAO memberDao=Factory.getDAOInstance("member.dao") ;
		return memberDao.findAllByDelete(del);
	}
	@Override
	public Member editPre(String id) throws Exception {
		IMemberDAO memberDao=Factory.getDAOInstance("member.dao") ;
		return memberDao.findByIdAndDelete(id, 0 );
	}
	@Override
	public boolean edit(Member vo) throws Exception {
		IMemberDAO memberDao=Factory.getDAOInstance("member.dao") ;
		return memberDao.doUpdateByDelete(vo, 0);
	}
	@Override
	public boolean delete(Set<String> ids) throws Exception {
		if(ids==null || ids.size()==0){
			return false ;
		}
		IMemberDAO memberDao=Factory.getDAOInstance("member.dao") ;
		return memberDao.doUpdateDelete(ids) ;
	}
	@Override
	public boolean addBatch(Set<Member> allMembers) throws Exception {
		if(allMembers==null || allMembers.size()==0){
			return false ;
		}
		Iterator<Member> iter=allMembers.iterator() ;
		IMemberDAO memberDao=Factory.getDAOInstance("member.dao") ;
		while(iter.hasNext()){
			Member vo=iter.next() ;
			if(memberDao.fingById(vo.getMid())!=null){
				iter.remove();
			}
		}
		return memberDao.doCreateBatch(allMembers) ;
	}
	@Override
	public Map<String, Object> list(Integer currentPage, Integer lineSize, String column, String keyword)
			throws Exception {
		Map<String ,Object> map=new HashMap<String ,Object>() ;
		IMemberDAO memberDao=Factory.getDAOInstance("member.dao") ;
		if(column==null || keyword==null){
			map.put("allMembers", memberDao.findAllSplitByDelete(currentPage, lineSize, 0)) ;
			map.put("memberCount", memberDao.getAllByDelete(0)) ;
		}else{
			map.put("allMembers", memberDao.findAllSplitByDelete(currentPage, lineSize, column,keyword ,0)) ;
			map.put("memberCount", memberDao.getAllByDelete(column,keyword,0)) ;
		}
		return map ;
	}
}
