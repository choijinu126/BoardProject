package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.SPageTO;
import kr.co.persistence.BoardDAO;

@Service
@Transactional
public class BoardServiceimpl implements BoardService{
	
	@Inject
	private BoardDAO bdao;

	@Override
	public Integer create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return bdao.create(vo);
	}

	@Override
	public List<BoardVO> listall() {
		// TODO Auto-generated method stub
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
	public BoardVO modifyui(int bno) {
		return bdao.modifyui(bno);
		
	}

	@Override
	public void modify(BoardVO vo) {
		bdao.modify(vo);
		
	}

	@Override
	public PageTO<BoardVO> list(PageTO<BoardVO> to) {
		System.out.println(":::::::::::::::::::::::::::::::::::::board service list start::::::::::::::::::::::::::::::::::::::::::::::");
		int amount = bdao.getAmount();
		to.setAmount(amount);
		
		List<BoardVO> list = bdao.list(to);
		to.setList(list);
		
		return to;
	}

	@Override
	public int amount() {
		// TODO Auto-generated method stub
		return bdao.getAmount();
	}

	@Override
	public SPageTO searchList(SPageTO to) {
		int amount = bdao.searchAmount(to);
		to.setAmount(amount);
		
		List<BoardVO> list = bdao.searchList(to);
		to.setList(list);
		return to;
	}

	@Override
	public int searchAmount(SPageTO to) {
		return bdao.searchAmount(to);
	}
}
