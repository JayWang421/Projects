package wzj.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import wzj.vo.Member;

public interface IMemberService {
	public boolean add(Member vo)throws Exception ;
	public List<Member> listByDelete(int del)throws Exception ;
	public Member editPre(String id)throws Exception ;
	public boolean edit(Member vo)throws Exception ;
	public boolean delete(Set<String> ids)throws Exception ;
	public boolean addBatch(Set<Member> allMembers)throws Exception ;
	public Map<String ,Object> list(Integer currentPage,Integer lineSize,String column,String keyword)throws Exception ; 
}
