package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.LoginDTO;
import kr.co.domain.UserVO;
import kr.co.persistence.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Inject
	private UserDAO udao;
	
	@Override
	public UserVO login(LoginDTO dto) {
		return udao.login(dto);
	}


	@Override
	public UserVO autoselect(String jsid) {
		return udao.autoselect(jsid);
	}


	@Override
	public void updateJsidNvalidtime(String jsid, long validtime, String id) {
		udao.updateJsidNvalidtime(jsid, validtime, id);
	}
	
}
