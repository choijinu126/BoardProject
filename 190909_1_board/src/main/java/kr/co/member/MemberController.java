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
	
	@RequestMapping("/delete")
	public String delete(MemberVO vo) {
		mservice.delete(vo);
		return "redirect:/member/list";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(MemberVO vo) {
		System.out.println(vo);
		mservice.update(vo);
		return "redirect:/member/read?id="+vo.getId();
	}
	
	
	@RequestMapping("/update")
	public void updateUI(Model model, String id) {
		MemberVO vo = mservice.updateui(id);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("/read")
	public void read(Model model, String id) {
		MemberVO vo = mservice.read(id);
		model.addAttribute("vo",vo);
	}
	
	@RequestMapping("/list")
	public void list(Model model) {
		List<MemberVO> list = mservice.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/insert")
	public void insertUI() {
		
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(MemberVO vo) {
		mservice.insert(vo);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/idcheck", method=RequestMethod.POST, produces = "application/text;charset=utf-8")
	@ResponseBody
	public String idcheck(String id) {
		MemberVO what = mservice.idcheck(id);
		
		if(what == null) {
			return "가능";
		}else {
			return "붕가능";
		}
		
	}
	
	

}
