package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.SPageTO;

@Repository
public class BoardDAOimpl implements BoardDAO{
	
	@Inject
	private SqlSession session;
	
	private final String NS = "kr.co.mapper.board";

	@Override
	public Integer create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.insert(NS+".create", vo);
	}

	@Override
	public List<BoardVO> listall() {
		// TODO Auto-generated method stub
		return session.selectList(NS+".listall");
	}

	@Override
	public BoardVO read(int bno) {
		return session.selectOne(NS+".read", bno);
	}

	@Override
	public void increaseviewcnt(int bno) {
		session.update(NS+".increaseviewcnt", bno);
	}

	@Override
	public void del(int bno) {
		session.delete(NS+".del", bno);
		
	}

	@Override
	public BoardVO modifyui(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".modifyui", bno);
	}

	@Override
	public void modify(BoardVO vo) {
		session.update(NS+".modify", vo);
		
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".amount");
	}

	@Override
	public List<BoardVO> list(PageTO<BoardVO> to) {
		// TODO Auto-generated method stub
		return session.selectList(NS+".list", to);
	}

	@Override
	public List<BoardVO> searchList(SPageTO to) {
		return session.selectList(NS+".searchList", to);
	}

	@Override
	public int searchAmount(SPageTO to) {
		return session.selectOne(NS+".searchAmount", to);
	}


}
