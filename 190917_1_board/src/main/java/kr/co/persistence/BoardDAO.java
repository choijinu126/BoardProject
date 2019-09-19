package kr.co.persistence;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.SPageTO;

public interface BoardDAO {
	public Integer create(BoardVO vo) throws Exception;

	public List<BoardVO> listall();

	public BoardVO read(int bno);
	
	public void increaseviewcnt(int bno);

	public void del(int bno);

	public BoardVO modifyui(int bno);

	public void modify(BoardVO vo);

	public int getAmount();

	public List<BoardVO> list(PageTO<BoardVO> to);

	public List<BoardVO> searchList(SPageTO to);

	public int searchAmount(SPageTO to);


}
