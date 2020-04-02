package com.zpaas.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.zpaas.utils.StringUtil;
import com.zpaas.vo.LoginInfo;


@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	//用于存放验证码Session
	private static final String adminLoginValidImgSessionName = "adminLoginValidImgSessionName20140526";
	//用于存放已登陆信息Session
	public static final String adminIsLoginSessionName = "adminIsLoginSessionName20140526";
	//用于存放随机数
	private static final String adminLoginpassRandomSessionName = "adminLoginpassRandomSessionName20140526";
		
	
//	private TransactionSVC transactionSVC;
    

    
	/**
	 * 打开登陆界面
	 * @param loginInfo
	 * @return
	 */
	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest req){
		
		log.info("Enter method Login");
//		Transaction tx = new Transaction();
//		tx.setName("tx");
//		tx.setParticipantNum(1);
//		tx.setParticipants("participant01");
//		try {
//			transactionSVC.createTransaction(tx);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
//		ModelAndView mv = new ModelAndView("login/adminLogin/adminLogin");
//		String passRandom = System.currentTimeMillis()+"";
//		req.getSession().setAttribute(adminLoginpassRandomSessionName, passRandom);
//		req.getSession().removeAttribute(adminIsLoginSessionName);
//		mv.addObject("passRandom", passRandom);
//		return mv;
	}
	
	/**
	 * 登陆验证
	 * @param loginInfo
	 * @return
	 */
	@RequestMapping(value = "/doadminlogin.do")
	public ModelAndView doadminlogin(@ModelAttribute LoginInfo loginInfo,HttpServletRequest req) throws Exception{
		
		log.info("Enter method doadminlogin params is:"+loginInfo.toString());
		
		ModelAndView mv = new ModelAndView("login/adminLogin/adminLogin");
		
		Object loginSession = req.getSession().getAttribute(adminIsLoginSessionName);
		
		if(loginSession != null){
			//如果已经登陆则调到主界面
			mv.setView(new RedirectView("adminMain.do"));
			return mv;
		}
		
		if(StringUtil.isBlank(loginInfo.getVilicode())||
		   StringUtil.isBlank(loginInfo.getLoginName())||
		   StringUtil.isBlank(loginInfo.getLoginPass())){
			
			mv.setView(new RedirectView("adminlogin.do"));
			return mv;
		}
		
		//随机码
		String passRandom = req.getSession().getAttribute(adminLoginpassRandomSessionName).toString();
		if(StringUtil.isBlank(passRandom)){
			passRandom = System.currentTimeMillis()+"";
			req.getSession().setAttribute(adminLoginpassRandomSessionName, passRandom);
			mv.addObject("errorMsg", "过久未操作，请从新登录");
		    mv.addObject("inputId", "vilicode");
			mv.addObject("loginName", "");
			mv.addObject("passRandom", passRandom);
			return mv;
		}
		
		Object validCode = req.getSession().getAttribute(adminLoginValidImgSessionName);
		//校验验证码
		if(validCode.equals(loginInfo.getVilicode()) == false){
		    mv.addObject("errorMsg", "验证码错误");
		    mv.addObject("inputId", "vilicode");
			mv.addObject("loginName", loginInfo.getLoginName());
			mv.addObject("passRandom", passRandom);
			return mv;
		}
		
		
		//登录信息验证
		int i = 0;
		boolean loginFlag = i == 0?true:false;
		if(!loginFlag){
			mv.addObject("errorMsg", "用户名或密码错误");
			mv.addObject("inputId", "loginPass");
			mv.addObject("loginName", loginInfo.getLoginName());
			mv.addObject("passRandom", passRandom);
		}else{
			//登陆成功设置Session
			req.getSession().setAttribute(adminIsLoginSessionName, loginInfo);
		}
		
		return mv;
	}
	
	/**
	 * 显示验证码
	 * @param req
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdminImg.do")
    public void showValidataImg(HttpServletRequest req, HttpServletResponse response) throws Exception{
		log.info("Enter method showValidataImg");
//		String validCode = ValidateCodeUtil.generateValidateCode(req, response);
//		req.getSession().setAttribute(adminLoginValidImgSessionName, validCode);
	}
	
	/**
	 * 校验验证码
	 * @param req
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/validAdminLoginCode.do")
    @ResponseBody public String validAdminLoginCode(@ModelAttribute LoginInfo loginInfo,HttpServletRequest req) throws Exception{
		log.info("Enter method validAdminLoginCode,param is:"+loginInfo.toString());
		//校验验证码
		Object validCode = req.getSession().getAttribute(adminLoginValidImgSessionName);
		if(validCode.equals(loginInfo.getVilicode()) == false){
			return "false";
		}else{
			return "true";
		}
	}
	
	/**
	 * 从session获取登陆信息
	 * @param req
	 * @return
	 */
	public static LoginInfo getAdminLoginInfoFromSession(HttpServletRequest req){
		log.info("Enter method getAdminLoginInfoFromSession");
		Object loginInfoObj = req.getSession().getAttribute(adminIsLoginSessionName);
		
		if(loginInfoObj == null){
			return null;
		}
		
		return (LoginInfo)loginInfoObj;
	}
}
