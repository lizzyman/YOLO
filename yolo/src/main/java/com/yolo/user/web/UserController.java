package com.yolo.user.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yolo.user.service.UserService;
import com.yolo.user.vo.UserVO;

@Controller()
public class UserController {

	// private Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/user/login")
	public ModelAndView loginByNaver() {
		ModelAndView view = new ModelAndView();
		view.setViewName("user/login");

		return view;

	}
	
	// NAVER CALL BACK
	@RequestMapping("/callBack")
	public String callBack(@RequestParam String state, @RequestParam String code, HttpServletRequest request) 
			throws UnsupportedEncodingException{
		String storedState = (String) request.getSession().getAttribute("state"); // 세션에 저장된 토큰을 받아온다.
		if(!state.equals(storedState)) {	// 세션에 저장되 토큰과 인증을 요청해서 받은 토큰이 일치하는지 검증한다.
			System.out.println("401 unauthorized");	// 인증이 실패했을 때의 처리 부분.
			return "redirect:/";
		}
		
			// AccessToken 요청 및 파싱할 부분.
		return "redirect:/";
	}
	

	// 카카오톡
	@RequestMapping(value = "/user/loginByKakao", method = RequestMethod.GET)
	public ModelAndView viewSignInPageByKakao() {
		ModelAndView view = new ModelAndView();

		view.setViewName("user/loginByKakao");

		return view;
	}

	/*
	 * @RequestMapping(value ="/user/signIn", method = RequestMethod.GET) public
	 * ModelAndView viewSignInPage() { ModelAndView view = new ModelAndView();
	 * 
	 * view.setViewName("user/signIn");
	 * 
	 * return view; }
	 */

	@RequestMapping(value = "/user/loginTotal", method = RequestMethod.POST)
	public void doSignInAction(@RequestParam("userId") String userId, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
		
		if (userId == "" || password == "") {
			try {
				PrintWriter write = response.getWriter();
				write.append("FAIL");
				write.flush();
				write.close();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setPassword(password);
		
		UserVO login = userService.selectOneUser(user);
		if (login != null) {
			try {
				PrintWriter write = response.getWriter();
				write.append("OK");
				write.flush();
				write.close();
				HttpSession session = request.getSession();
				session.setAttribute("_USER_", login);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		} else {
			try {
				PrintWriter write = response.getWriter();
				write.append("FAIL");
				write.flush();
				write.close();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
	}

	@RequestMapping(value = "/user/signUp", method = RequestMethod.GET)
	public ModelAndView viewSignUpPage() {
		ModelAndView view = new ModelAndView();

		view.setViewName("user/signUp");

		return view;
	}

	@RequestMapping(value = "/user/signUp", method = RequestMethod.POST)
	public void doSignUpPage(UserVO userVO, HttpServletResponse response) {

		try {
			boolean isValidPassword = verify(userVO.getPassword());
			if (isValidPassword) {
				try {
					userService.insertOneUser(userVO);
					PrintWriter writer = response.getWriter();
					writer.append("OK");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(), e);
				}

			} else {
				try {
					PrintWriter writer = response.getWriter();
					writer.append("FAIL");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("에러에러에러", e);
		}
	}

	@RequestMapping("/user/signout")
	public String doSignOutAction(HttpSession session) {

		session.invalidate();

		return "redirect:/yolo/home";
	}

	public boolean verify(String password) {
		String passwordPolicy = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9가-힣]).{8,})";
		Pattern pattern = Pattern.compile(passwordPolicy);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
