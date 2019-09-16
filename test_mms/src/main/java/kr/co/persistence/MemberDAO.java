package kr.co.persistence;

import java.util.List;

import kr.co.domain.BoardDTO;
import kr.co.domain.MemberVO;

public interface MemberDAO {

	List<MemberVO> hlist();

	void hinsert(MemberVO vo);

	MemberVO hread(String id);

	MemberVO hhomeSelect(String id);

	List<BoardDTO> hhomeNewBoard(String category);
}
