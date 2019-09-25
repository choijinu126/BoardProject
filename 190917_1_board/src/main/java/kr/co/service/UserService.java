package kr.co.service;

import kr.co.domain.LoginDTO;
import kr.co.domain.UserVO;

public interface UserService {
	public UserVO login(LoginDTO dto);


	public UserVO autoselect(String jsid);


	public void updateJsidNvalidtime(String jsid, long validtime, String id);
}
