package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.MemberVO;
import kr.co.domain.PageTO;
import kr.co.persistence.BoardDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDAO bdao;
	
	@Override
	public Integer create(BoardVO vo) throws Exception {
		return bdao.create(vo);
	}

	@Override
	public List<BoardVO> listall() {
		return bdao.listall();
	}
	
	@Override
	public BoardVO read(int bno) {
		bdao.increaseviewcnt(bno);
		return bdao.read(bno);
	}

	@Override
	public void del(int bno) {
		bdao.del(bno);
	}

	@Override
	public int modify(BoardVO vo) {
		return bdao.modify(vo);
	}

	@Override
	public PageTO list(PageTO to) {
		int amount = bdao.getAmount();
		to.setAmount(amount);
		
		List<BoardVO> list = bdao.list(to);
		to.setList(list);
		return to;
	}
}
