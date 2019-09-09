package kr.co.ca;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.MemberVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Inject
	private BoardService bservice;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public void createUI() {
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(BoardVO vo) throws Exception {
		/*
		 * System.out.println(vo.getBno());
		 */		int reNum = bservice.create(vo);
		/*
		 * System.out.println(reNum); //1: 입력성공 0: 입력실패 System.out.println(vo.getBno());
		 */
		
		return "redirect:/board/listall";
	}
	
	@RequestMapping("/listall")
	public String listall(Model model) throws Exception{
		List<BoardVO> list = bservice.listall();
		model.addAttribute("list", list);
		return "/board/listall";
	}
	
	@RequestMapping("/list")
	public void list(PageTO to, Model model, int page) throws Exception{
		to.setCurPage(page);
		PageTO dbto = bservice.list(to);
		model.addAttribute("to", dbto);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Model model, int bno) {
		BoardVO vo = bservice.read(bno);
		model.addAttribute("vo", vo);
		return "/board/read";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String del(int bno) throws Exception{
		bservice.del(bno);
		return "redirect:/board/listall";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyUI(int bno, Model model) {
		BoardVO vo = bservice.read(bno);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVO vo, Model model) {
		int reNum = bservice.modify(vo);
		return "redirect:/board/read?bno="+vo.getBno();
	}
}
