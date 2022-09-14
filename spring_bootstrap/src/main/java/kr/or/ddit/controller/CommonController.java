package kr.or.ddit.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.dto.MenuVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;
import com.jsp.service.MemberService;
import com.jsp.service.MenuService;

@Controller
public class CommonController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private MemberService memberService;

	@RequestMapping("/main")
	public String main(Model model) {
		String url = "common/home";
		model.addAttribute("category","Home");
		return url;
	}

	@RequestMapping("/index")
	public String index(@RequestParam(defaultValue = "M000000") String mCode, Model model) throws Exception {
		String url = "common/indexPage";

		// GNB(Global Navigation Bar)
		List<MenuVO> menuList = menuService.getMainMenuList();

		// iFrame상태유지
		MenuVO menu = menuService.getMenuByMcode(mCode);

		model.addAttribute("menuList", menuList);
		model.addAttribute("menu", menu);

		return url;
	}

	@GetMapping("/common/loginForm")
	public String loginForm(@RequestParam(defaultValue = "") String error, 
							@ModelAttribute("retUrl") String retUrl, HttpServletResponse response) {
		String url = "/common/loginForm";
		
		if(error != null && error.equals("-1")) {
			response.setStatus(302);
		}
		
		//model.addAttribute("retUrl", retUrl);
		
		return url;
	}

	@PostMapping(value = "/common/login")
	public String login(String id, String pwd, HttpSession session, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/index.do";

		try {
			memberService.login(id, pwd);

			session.setAttribute("loginUser", memberService.getMember(id));
		} catch (NotFoundIdException | InvalidPasswordException e) {
			rttr.addFlashAttribute("message", e.getMessage());
			rttr.addFlashAttribute("pastID", id);
			url = "redirect:/common/loginForm.do";
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return url;
	}
	
	@GetMapping(value="/common/logout")
	public String logout(HttpSession session){
		String url="redirect:/";
		session.invalidate();
		
		return url;
	}
	
	@RequestMapping("/subMenu")
	@ResponseBody
	public ResponseEntity<List<MenuVO>> subMenu(String mCode) throws Exception {
		ResponseEntity<List<MenuVO>> entity=null;
	
		List<MenuVO> subMenu = null;

		try {
			subMenu = menuService.getSubMenuList(mCode);

			entity  = new ResponseEntity<List<MenuVO>>(subMenu,HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<MenuVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return entity;
	}

}
