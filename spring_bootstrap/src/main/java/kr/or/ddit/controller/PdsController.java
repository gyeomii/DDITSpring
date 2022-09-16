package kr.or.ddit.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.command.Criteria;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

import kr.or.ddit.command.PdsModifyCommand;
import kr.or.ddit.command.PdsRegistCommand;

@Controller
@RequestMapping("/pds")
public class PdsController {
	
	@Autowired
	private PdsService pdsService;
	
	@Resource(name = "fileUploadPath")
	private String fileUploadPath;
	
	@GetMapping("/main")
	public String main(Model model) throws Exception {
		String url = "pds/main";
		model.addAttribute("category", "Pds");
		return url;
	}
	
	@GetMapping("/list")
	public ModelAndView list(Criteria cri, ModelAndView mnv) throws Exception{
		String url = "pds/list";
		
		Map<String, Object> dataMap = pdsService.getList(cri);
		
		mnv.addObject("dataMap", dataMap);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@GetMapping("registForm")
	public String registForm() throws Exception{
		String url = "pds/regist";
		return url;
	}
	
	@PostMapping(value="/regist", produces="text/plain;charset=utf-8")
	public String regist(PdsRegistCommand registReq, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/pds/list.do";
		
		String savePath = this.fileUploadPath;
		
		//file저장 -> List<AttachVO>
		List<AttachVO> attachList = MultipartFileUploadResolver.fileUpload(registReq.getUploadFile(), savePath);
		
		//DB
		PdsVO pds = registReq.toPdsVO();
		pds.setTitle(HTMLInputFilter.htmlSpecialChars(pds.getTitle()));
		pds.setAttachList(attachList);		
		pdsService.regist(pds);
		
		rttr.addFlashAttribute("from", "regist");
		return url;
	}
	
	@GetMapping("/detail")
	public String detail(int pno, String from, Model model, RedirectAttributes rttr) throws Exception{
		String url = "pds/detail";
		
		PdsVO pds = null;
		if (from != null && from.equals("list")) {
			pds = pdsService.read(pno);
			rttr.addAttribute("pno", pno);
			url = "redirect:/pds/detail.do?";
		} else {
			pds = pdsService.getPds(pno);
		}
		
		model.addAttribute("pds", pds);
		
		return url;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(ModelAndView mnv, int pno) throws Exception {
		String url = "pds/modify";

		PdsVO pds = pdsService.getPds(pno);

		mnv.addObject("pds", pds);
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping("/modify")
	public String modifyPOST(PdsModifyCommand modifyReq, 
							 HttpServletRequest request, 
							 RedirectAttributes rttr) throws Exception {
		String url = "redirect:/pds/detail.do";

		// 파일 삭제
		if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().size() > 0) {
			for (Integer ano : modifyReq.getDeleteFile()) {
				AttachVO attach = pdsService.getAttachByAno(ano);
				File deleteFile = new File(attach.getUploadPath(), attach.getFileName());
				if (deleteFile.exists()) {
					deleteFile.delete(); // File 삭제
				}
				pdsService.removeAttachByAno(ano); // DB 삭제
			}
		}
		// 파일 저장
		List<AttachVO> attachList = MultipartFileUploadResolver.fileUpload(modifyReq.getUploadFile(), fileUploadPath);

		// PdsVO settting
		PdsVO pds = modifyReq.toPdsVO();		
		pds.setAttachList(attachList);
		pds.setTitle(HTMLInputFilter.htmlSpecialChars(pds.getTitle()));

		// DB 저장
		pdsService.modify(pds);

		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("pno", pds.getPno());

		return url;

	}

	@RequestMapping("/remove")
	public String remove(int pno, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/pds/detail.do";

		// 첨부파일 삭제
		PdsVO pds = pdsService.getPds(pno);
		List<AttachVO> attachList = pds.getAttachList();
		if (attachList != null) {
			for (AttachVO attach : attachList) {
				int ano = attach.getAno();
				String uuidFileName = pdsService.getAttachByAno(ano).getFileName();
				File target = new File(attach.getUploadPath(), uuidFileName);
				if (target.exists()) {
					target.delete();
				}
			}
		}

		// DB삭제
		pdsService.remove(pno);

		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("pno", pno);

		return url;
	}
	
	//항상 view를 return하는 형태로 controller를 만들어야한다.
	@RequestMapping("/getFile")
	public String getFile(int ano,Model model) throws Exception {
		
		String url="downloadFile";
		
		AttachVO attach = pdsService.getAttachByAno(ano);
		
		model.addAttribute("savedPath", attach.getUploadPath());
		model.addAttribute("fileName", attach.getFileName());		
		
		return url;
	}
}








