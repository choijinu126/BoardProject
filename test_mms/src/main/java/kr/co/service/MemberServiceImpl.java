package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.BoardDTO;
import kr.co.domain.MemberVO;
import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO mdao;

	@Override
	public List<MemberVO> hlist() {
		return mdao.hlist();
	}

	@Override
	public void hinsert(MemberVO vo) {
		mdao.hinsert(vo);
	}

	@Override
	public MemberVO hread(String id) {
		return mdao.hread(id);
	}

	@Override
	public MemberVO hhomeSelect(String id) {
		return mdao.hhomeSelect(id);
	}

	@Override
	public List<BoardDTO> hhomeNewBoard(String category) {
		return mdao.hhomeNewBoard(category);
	}

}
