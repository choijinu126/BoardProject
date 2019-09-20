package kr.co.ca;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.SPageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/sboard")
public class SearchBoardController {
	@Inject
	private BoardService bservice;
	
	@RequestMapping("/list")
	public void list(SPageTO to, Model model) {
		SPageTO dbto = bservice.searchList(to);
		model.addAttribute("to", dbto);
	}
	
	@RequestMapping("/read")
	public void read(Model model, int bno, SPageTO to) throws Exception{
		BoardVO vo = bservice.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value="/del", method=RequestMethod.POST)
	public String del(int bno, SPageTO to) throws Exception {
		
		bservice.del(bno);
		
		return "redirect:/sboard/list?keyword=" + to.getKeyword() + "&searchType=" + to.getSearchType() + "&curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	
	@RequestMapping("/modify")
	public void modifyui(int bno, Model model, SPageTO to) throws Exception{
		
		BoardVO vo = bservice.modifyui(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardVO vo, SPageTO to) throws Exception{
		
		bservice.modify(vo);
		
		return "redirect:/sboard/read?keyword=" + to.getKeyword() + "&searchType=" + to.getSearchType() + "&bno="+vo.getBno()+"&curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	
	@RequestMapping("/amount/{perPage}/{keyword}/{searchType}")
	@ResponseBody
	public int list(@PathVariable("perPage") int perPage, @PathVariable("keyword") String keyword, @PathVariable("searchType") String searchType) {
		SPageTO to = new SPageTO();
		to.setKeyword(keyword);
		to.setSearchType(searchType);
		int amount = bservice.searchAmount(to);
		return (amount-1)/perPage+1;
	}
}
