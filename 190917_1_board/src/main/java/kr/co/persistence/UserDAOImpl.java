package kr.co.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.LoginDTO;
import kr.co.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SqlSession session;
	
	private final String NS="kr.co.mapper.user";
	@Override
	public UserVO login(LoginDTO dto) {
		return session.selectOne(NS+".login", dto);
	}
	
	@Override
	public UserVO autoselect(String jsid) {
		return session.selectOne(NS+".autoselect", jsid);
	}

	@Override
	public void updateJsidNvalidtime(String jsid, long validtime, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jsid", jsid);
		map.put("validtime", validtime);
		map.put("id", id);
		
		session.update(NS+".updateJsidNvalidtime", map);
	}
}
