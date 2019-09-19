package kr.co.service;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.SPageTO;

public interface BoardService {
	public Integer create(BoardVO vo) throws Exception;

	public List<BoardVO> listall();

	public BoardVO read(int bno);

	public void del(int bno);

	public BoardVO modifyui(int bno);

	public void modify(BoardVO vo);

	public PageTO<BoardVO> list(PageTO<BoardVO> to);

	public int amount();

	public SPageTO searchList(SPageTO to);

	public int searchAmount(SPageTO to);
}
