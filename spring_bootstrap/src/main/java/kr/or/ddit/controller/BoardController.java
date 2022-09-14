package kr.or.ddit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.command.BoardModifyCommand;
import com.jsp.command.Criteria;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

import kr.or.ddit.command.BoardRegistCommand;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/main")
	public String main(Model model) {
		String url = "board/main";
		model.addAttribute("category", "Board");
		return url;
	}

	@GetMapping("/list")
	public String list(Criteria cri, Model model) throws Exception {
		String url = "board/list";

		Map<String, Object> dataMap = boardService.getBoardList(cri);

		model.addAttribute("dataMap", dataMap);

		return url;
	}

	@GetMapping("/registForm")
	public String registForm() {
		String url = "board/regist";
		return url;
	}

	@PostMapping("/regist")
	public String regist(BoardRegistCommand boardReq, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/board/list.do";

		BoardVO board = boardReq.toBoardVO();
		board.setTitle(HTMLInputFilter.htmlSpecialChars(board.getTitle()));
		boardService.regist(board);
		
		rttr.addFlashAttribute("from", "regist");
		
		return url;
	}

	@GetMapping("/detail")
	public String detail(int bno, @RequestParam(defaultValue = "") String from, Model model, RedirectAttributes rttr)
			throws Exception {
		String url = "board/detail";
		BoardVO board = null;

		if (from != null && from.equals("list")) {
			board = boardService.getBoard(bno);
			rttr.addAttribute("bno", board.getBno());
			url = "redirect:/board/detail.do";
		} else {
			board = boardService.getBoardForModify(bno);
		}
		model.addAttribute("board", board);

		return url;
	}

	@PostMapping("/modifyForm")
	public String modifyForm(int bno, Model model) throws Exception {
		String url = "board/modify";

		BoardVO board = boardService.getBoardForModify(bno);

		model.addAttribute("board", board);

		return url;
	}

	@PostMapping("/modify")
	public String modify(BoardModifyCommand modifyReq, Model model, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/board/detail.do";

		BoardVO board = modifyReq.toBoardVO();
		board.setTitle(HTMLInputFilter.htmlSpecialChars(board.getTitle()));

		boardService.modify(board);

		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("bno", board.getBno());
		return url;
	}

	@PostMapping("/remove")
	public String remove(int bno, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/board/detail.do";
		
		boardService.remove(bno);
		
		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("bno", bno);

		return url;
	}

}
