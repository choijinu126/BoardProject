package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberVO;

@Repository
public class MemberDAOimpl implements MemberDAO{
	
	@Inject
	private SqlSession session;
	
	private final String NS = "kr.co.mapper.member";
	
	@Override
	public void insert(MemberVO vo) {
		session.insert(NS+".insert", vo);
	}

	@Override
	public MemberVO idcheck(String id) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".idcheck", id);
	}


	@Override
	public List<MemberVO> list() {
		// TODO Auto-generated method stub
		return session.selectList(NS+".list");
	}

	@Override
	public MemberVO read(String id) {
		return session.selectOne(NS+".read", id);
	}

	@Override
	public MemberVO updateui(String id) {
		return session.selectOne(NS+".updateui", id);
	}

	@Override
	public void update(MemberVO vo) {
		session.update(NS+".update", vo);
		
	}

	@Override
	public void delete(MemberVO vo) {
		// TODO Auto-generated method stub
		session.delete(NS+".delete", vo);
	}

}
