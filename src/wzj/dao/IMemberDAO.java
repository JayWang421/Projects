package wzj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import wzj.dao.util.IBaseDAO;
import wzj.vo.Member;

public interface IMemberDAO extends IBaseDAO<String , Member>{
	public List<Member> findAllByDelete(Integer del)throws SQLException ;
	public Member findByIdAndDelete(String mid ,Integer del)throws SQLException ;
	public boolean doUpdateByDelete(Member vo ,Integer del)throws SQLException ;
	public boolean doUpdateDelete(Set<String> ids) throws SQLException  ;
	public boolean doCreateBatch(Set<Member> allMembers)throws SQLException ;
	public List<Member> findAllSplitByDelete(Integer currentPage,Integer lineSize,Integer del)throws SQLException ;
	public List<Member> findAllSplitByDelete(Integer currentPage,Integer lineSize,String column,String keyword,Integer del)throws SQLException ;
	public Integer getAllByDelete(Integer del)throws SQLException ;
	public Integer getAllByDelete(String column,String keyword,Integer del)throws SQLException ;
}
