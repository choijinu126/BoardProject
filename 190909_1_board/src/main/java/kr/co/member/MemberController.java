package kr.co.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.MemberVO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) {
		List<MemberVO> list = mservice.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public void insertUI() {
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(MemberVO vo) {
		mservice.insert(vo);
		return "redirect:/member/list";
	}
	
	@RequestMapping("/read")
	public void read(String id, Model model) {
		MemberVO vo = mservice.read(id);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("/update")
	public void updateUI(String id, Model model) {
		MemberVO vo = mservice.updateUI(id);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberVO vo) {
		mservice.update(vo);
		return "redirect:/member/read?id=" + vo.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(String id) {
		mservice.delete(id);
		return "redirect:/member/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
	public String idcheck(String id) {
		MemberVO what = mservice.idcheck(id);
		if(what == null) {
			return "사용 가능";
		}else {
			return "사용 불가";
		}
	}
}
