package kr.co.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardDTO;
import kr.co.domain.MemberVO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService mservice;
	
	@RequestMapping(value = "/hhome", method = RequestMethod.GET)
	public void hhome(Model model) {
		hhomeNewBoard(model);
	}
	
	@RequestMapping(value = "/hhome", method = RequestMethod.POST)
	public void hhomeSelect(String id, Model model) {
		MemberVO vo = mservice.hhomeSelect(id);
		model.addAttribute("vo", vo);
		
		hhomeNewBoard(model);
	}
	
	public void hhomeNewBoard(Model model) {
		List<BoardDTO> notice = new ArrayList<BoardDTO>();
		List<BoardDTO> event = new ArrayList<BoardDTO>();
		notice = mservice.hhomeNewBoard("notice");
		event = mservice.hhomeNewBoard("event");
		
		model.addAttribute("notice", notice);
		model.addAttribute("event", event);
	}
	
	@RequestMapping(value = "/hlist", method = RequestMethod.GET)
	public void hlist(Model model) {
		model.addAttribute("list", mservice.hlist());
	}
	
	@RequestMapping(value = "/hinsert", method = RequestMethod.GET)
	public void hinsertUI() {
	}
	
	@RequestMapping(value = "/hinsert", method = RequestMethod.POST)
	public String hinsert(MemberVO vo) {
		if(vo.getShirts() != null) {vo.setShirts("o");
		}else {vo.setShirts("x");}
		
		if(vo.getLocker() != null) {vo.setLocker("o");
		}else {vo.setLocker("x");}
		
		mservice.hinsert(vo);
		return "redirect:/member/hlist";
	}
	
	@RequestMapping(value = "/hread", method = RequestMethod.GET)
	public void hread(String id, Model model) {
		MemberVO vo = mservice.hread(id);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value = "/hlogin", method = RequestMethod.GET)
	public void loginUI() {
		
	}
}
