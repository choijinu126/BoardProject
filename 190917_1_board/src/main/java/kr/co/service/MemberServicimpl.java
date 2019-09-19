package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.MemberVO;
import kr.co.persistence.MemberDAO;

@Service
@Transactional
public class MemberServicimpl implements MemberService{

	@Inject
	private MemberDAO mdao;
	
	@Override
	public void insert(MemberVO vo) {
		mdao.insert(vo);
	}

	@Override
	public MemberVO idcheck(String id) {
		// TODO Auto-generated method stub
		return mdao.idcheck(id);
		
	}

	@Override
	public List<MemberVO> list() {
		
		return mdao.list();
	}

	@Override
	public MemberVO read(String id) {
		return mdao.read(id);
	}

	@Override
	public MemberVO updateui(String id) {
		return mdao.updateui(id);
	}

	@Override
	public void update(MemberVO vo) {
		mdao.update(vo);
		
	}

	@Override
	public void delete(MemberVO vo) {
		// TODO Auto-generated method stub
		mdao.delete(vo);
		
	}

}
