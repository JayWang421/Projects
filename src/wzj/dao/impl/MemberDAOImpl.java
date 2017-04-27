package wzj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import wzj.dao.IMemberDAO;
import wzj.dbc.DatabaseConnection;
import wzj.vo.Member;

public class MemberDAOImpl implements IMemberDAO{
	private PreparedStatement ps ;
	private Connection conn ;
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
		this.conn=DatabaseConnection.getConnection() ;
	}
	@Override
	public boolean doCreate(Member vo) throws SQLException {
		String sql="insert into member (mid,name,birthday,salary,note,del) values (?,?,?,?,?,?) " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setString(1, vo.getMid()); 
		this.ps.setString(2, vo.getName());
		this.ps.setDate(3, new java.sql.Date(vo.getBirthday().getTime()));
		this.ps.setDouble(4, vo.getSalary()); 
		this.ps.setString(5, vo.getNote());
		this.ps.setInt(6, vo.getDel());
		return this.ps.executeUpdate() > 0 ;
	}
	@Override
	public boolean doCreateBatch(Set<Member> allMembers) throws SQLException {
		String sql="insert into member (mid,name,birthday,salary,note,del) values(?,?,?,?,?,?) " ;
		this.ps=this.conn.prepareStatement(sql) ;
		Iterator<Member> iter=allMembers.iterator() ;
		while(iter.hasNext()){
			Member vo=iter.next() ;
			this.ps.setString(1, vo.getMid()); 
			this.ps.setString(2, vo.getName());
			this.ps.setDate(3, new java.sql.Date(vo.getBirthday().getTime()));
			this.ps.setDouble(4, vo.getSalary()); 
			this.ps.setString(5, vo.getNote());
			this.ps.setInt(6, vo.getDel());
			this.ps.addBatch();
		}
		int result [] =this.ps.executeBatch() ;
		for(int x=0 ; x<result.length ; x++){
			if(result[x]==0){
				return false ;
			}
		}
		return true ;
	}
	@Override
	public boolean doUpdateDelete(Set<String> ids) throws SQLException {
		StringBuffer buf=new StringBuffer() ;
		buf.append("update member set del=1 where mid in(") ;
		Iterator<String> iter=ids.iterator() ;
		while(iter.hasNext()){
			buf.append("'").append(iter.next()).append("'").append(",") ;
		}
		buf.delete(buf.length()-1, buf.length()).append(")") ;
		this.ps=this.conn.prepareStatement(buf.toString()) ;
		return this.ps.executeUpdate()> 0 ;
	}
	@Override
	public boolean doUpdate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(String mid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member fingById(String mid) throws SQLException {
		Member vo=null ;
		String sql="select mid,name,birthday,salary,note,del from member where mid= ? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setString(1, mid);
		ResultSet rs=this.ps.executeQuery() ;
		if(rs.next()){
			vo=new Member() ;
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setBirthday(rs.getDate(3));
			vo.setSalary(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setDel(rs.getInt(6));
		}
		return vo ;
	}

	@Override
	public List<Member> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Member> findAllByDelete(Integer del) throws SQLException {
		List<Member> all=new ArrayList<Member>() ;
		String sql="select mid,name,birthday,salary,note,del from member where del= ? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setInt(1, del);
		ResultSet rs=this.ps.executeQuery() ;
		while(rs.next()){
			Member vo=new Member() ;
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setBirthday(rs.getDate(3));
			vo.setSalary(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setDel(rs.getInt(6));
			all.add(vo) ;
		}
		return all ;
	}
	@Override
	public Member findByIdAndDelete(String mid, Integer del) throws SQLException {
		Member vo=null ;
		String sql="select mid,name,birthday,salary,note,del from member where mid= ? and del=? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setString(1, mid);
		this.ps.setInt(2, del);
		ResultSet rs=this.ps.executeQuery() ;
		if(rs.next()){
			vo=new Member() ;
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setBirthday(rs.getDate(3));
			vo.setSalary(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setDel(rs.getInt(6));
		}
		return vo ;
	}
	@Override
	public boolean doUpdateByDelete(Member vo, Integer del) throws SQLException {
		String sql="update member set name=?,birthday=?,salary=?,note=? where mid=? and del=? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setString(1,vo.getName()) ;
		this.ps.setDate(2, new java.sql.Date(vo.getBirthday().getTime()));
		this.ps.setDouble(3, vo.getSalary());
		this.ps.setString(4, vo.getNote());
		this.ps.setString(5,vo.getMid());
		this.ps.setInt(6,del);
		return this.ps.executeUpdate()> 0;
	}
	@Override
	public List<Member> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(String column, String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Member> findAllSplitByDelete(Integer currentPage, Integer lineSize, Integer del) throws SQLException {
		List<Member> all=new ArrayList<Member>() ;
		Member vo=null ;
		String sql="select * from "
				+ " ( select mid,name,birthday,salary,note,del,rownum rn from member where del=? and rownum<=?) temp "
				+ "where temp.rn>? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setInt(1, del);
		this.ps.setInt(2, currentPage*lineSize);
		this.ps.setInt(3, (currentPage-1)*lineSize);
		ResultSet rs=this.ps.executeQuery() ;
		while(rs.next()){
			vo=new Member() ;
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setBirthday(rs.getDate(3));
			vo.setSalary(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setDel(rs.getInt(6));
			all.add(vo) ;
		}
		return all ;
	}
	@Override
	public List<Member> findAllSplitByDelete(Integer currentPage, Integer lineSize, String column, String keyword,
			Integer del) throws SQLException {
		List<Member> all=new ArrayList<Member>() ;
		Member vo=null ;
		String sql="select * from "
				+ " ( select mid,name,birthday,salary,note,del,rownum rn from member where del=? and "+column+ " like ? and rownum<=?) temp "
				+ " where temp.rn>? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setInt(1, del);
		this.ps.setString(2, "%"+keyword+"%");
		this.ps.setInt(3, currentPage*lineSize);
		this.ps.setInt(4, (currentPage-1)*lineSize);
		ResultSet rs=this.ps.executeQuery() ;
		while(rs.next()){
			vo=new Member() ;
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setBirthday(rs.getDate(3));
			vo.setSalary(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setDel(rs.getInt(6));
			all.add(vo) ;
		}
		return all ;
	}
	@Override
	public Integer getAllByDelete(Integer del) throws SQLException {
		String sql="select count(*) from member where del=? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setInt(1, del);
		ResultSet rs=this.ps.executeQuery() ;
		if(rs.next()){
			return rs.getInt(1) ;
		}
		return 0 ;
	}
	@Override
	public Integer getAllByDelete(String column, String keyword, Integer del) throws SQLException {
		String sql="select count(*) from member where "+column+ " like ? and del= ? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setString(1, "%"+keyword+"%");
		this.ps.setInt(2, del);
		ResultSet rs=this.ps.executeQuery() ;
		if(rs.next()){
			return rs.getInt(1) ;
		}
		return 0 ;
	}
}
