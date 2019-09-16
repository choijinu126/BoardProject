package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardDTO;
import kr.co.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession session;
	
	private final String NS = "kr.co.mapper.member";

	@Override
	public List<MemberVO> hlist() {
		return session.selectList(NS + ".hlist");
	}

	@Override
	public void hinsert(MemberVO vo) {
		session.insert(NS+".hinsert", vo);
	}

	@Override
	public MemberVO hread(String id) {
		return session.selectOne(NS + ".hread", id);
	}

	@Override
	public MemberVO hhomeSelect(String id) {
		return session.selectOne(NS + ".hread", id);
	}

	@Override
	public List<BoardDTO> hhomeNewBoard(String category) {
		return session.selectList(NS + ".hhomeNewBoard", category);
	}

	
}
