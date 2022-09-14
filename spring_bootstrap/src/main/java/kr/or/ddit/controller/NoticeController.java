package kr.or.ddit.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.command.Criteria;
import com.jsp.command.NoticeModifyCommand;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

import kr.or.ddit.command.NoticeRegistCommand;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/main")
	public String main(Model model) {
		String url = "notice/main";
		model.addAttribute("category","Notice");
		return url;
	}
	
	@RequestMapping("/list")
	public String list(Criteria cri, Model model) throws Exception{
		String url="notice/list";
		
		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		
		model.addAttribute("dataMap", dataMap);
		
		return url;
	} 
	
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "notice/regist";
		return url;
	}
	
	@PostMapping("/regist")
	public String regist(NoticeRegistCommand noticeReq, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/notice/list.do";
		
		NoticeVO notice = noticeReq.toNoticeVO();
		notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		noticeService.regist(notice);
		
		rttr.addFlashAttribute("from", "regist");
		
		return url;
	}
	@RequestMapping("/detail")
	public ModelAndView detail(int nno, @RequestParam(defaultValue="") String from, ModelAndView mnv) throws SQLException{
		String url="notice/detail";
		NoticeVO notice = null;
		
		if(from != null && from.equals("list")) {
			notice = noticeService.getNotice(nno);
			url="redirect:/notice/detail.do?nno="+nno;
		}else {
			notice = noticeService.getNoticeForModify(nno);
		}
		mnv.addObject("notice",notice);
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(int nno, ModelAndView mnv) throws Exception{
		String url="notice/modify";
		
		NoticeVO notice = noticeService.getNoticeForModify(nno);
		
		mnv.addObject("notice",notice);
		mnv.setViewName(url);
		return mnv;
		
	}
	
	@PostMapping("/modify")
	public String modify(NoticeModifyCommand modifyReq, Model model, RedirectAttributes rttr)throws Exception{
		String url = "redirect:/notice/detail.do";
		
		NoticeVO notice = modifyReq.toNoticeVO();		
		notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		
		noticeService.modify(notice);
		
		rttr.addAttribute("nno",notice.getNno());
		rttr.addFlashAttribute("from","modify");
		
		return url;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String remove(int nno, RedirectAttributes rttr) throws Exception{
		String url="redirect:/notice/detail.do";
			
		noticeService.remove(nno);		
		
		rttr.addFlashAttribute("from","remove");
		rttr.addAttribute("nno",nno);
		
		return url;
	}
	
}
