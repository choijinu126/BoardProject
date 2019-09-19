package kr.co.ca;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService bservice;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createUI() {
		
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(BoardVO vo) throws Exception {
		int reNum = bservice.create(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/listall")
	public String listall(Model model) throws Exception{
		List<BoardVO> list = bservice.listall();
		model.addAttribute("list", list);
		return "/board/listall";
	}
	
	@RequestMapping("/read")
	public void read(Model model, int bno, PageTO<BoardVO> to) throws Exception{
		BoardVO vo = bservice.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value="/del", method=RequestMethod.POST)
	public String del(int bno, PageTO<BoardVO> to) throws Exception {
		
		bservice.del(bno);
		
		return "redirect:/board/list?curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	
	@RequestMapping("/modify")
	public void modifyui(int bno, Model model, PageTO<BoardVO> to) throws Exception{
		
		BoardVO vo = bservice.modifyui(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardVO vo, PageTO<BoardVO> to) throws Exception{
		
		bservice.modify(vo);
		
		return "redirect:/board/read?bno="+vo.getBno()+"&curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	
	@RequestMapping("/list")
	public void list(PageTO<BoardVO> to, Model model) {
		PageTO<BoardVO> dbto = bservice.list(to);
		model.addAttribute("to", dbto);
	}
	
	@RequestMapping("/amount/{perPage}")
	@ResponseBody
	public int list(@PathVariable("perPage") int perPage) {
		int amount = bservice.amount();
		return (amount-1)/perPage+1;
	}
}
