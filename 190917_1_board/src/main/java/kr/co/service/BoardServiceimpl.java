package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.SPageTO;
import kr.co.persistence.BoardDAO;
import kr.co.persistence.ReplyDAO;

@Service
@Transactional
public class BoardServiceimpl implements BoardService{
	
	@Inject
	private BoardDAO bdao;
	
	@Inject
	private ReplyDAO rdao;
	
	@Override
	public Integer create(BoardVO vo) throws Exception {
		bdao.create(vo);
		
		if(vo.getFiles() != null) {
			for(String filename : vo.getFiles()) {
				bdao.addAttch(filename, vo.getBno());
			}
		}
		
		return vo.getBno();
	}

	@Override
	public List<BoardVO> listall() {
		// TODO Auto-generated method stub
		return bdao.listall();
	}

	@Override
	public BoardVO read(int bno) {
		bdao.increaseviewcnt(bno);
		BoardVO vo = bdao.read(bno);
		return vo;
	}

	@Override
	public void del(int bno) {
		rdao.del(bno);
		bdao.clearAttach(bno);
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

	@Override
	public List<String> getAttach(int bno) {
		return bdao.getAttach(bno);
	}
}
