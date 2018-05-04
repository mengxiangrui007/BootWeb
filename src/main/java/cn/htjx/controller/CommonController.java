package cn.htjx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.htjx.common.DateDealwith;
import cn.htjx.domain.ArticlePub;
import cn.htjx.service.IManageService;
import cn.htjx.vo.ArticlePageVo;
import cn.htjx.vo.ArticlePubPageVo;
import cn.htjx.vo.PageVo; 

@Controller
public class CommonController {
	
	@Autowired
	private IManageService manageService;
	
	//首页
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home";
		}else{
			return "home";
		}
	}
	//我们-公司简介
	@RequestMapping(path = "/gsjj", method = RequestMethod.GET)
	public String gsjj(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		model.addAttribute("status", 1);
		model.addAttribute("showUrl", "../images/wm/gsjj/show_gsjj.jpg");
		model.addAttribute("change1", "display:block");
		model.addAttribute("change2", "display:none");
		model.addAttribute("change3", "display:none");
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_wm";
		}else{
			return "home_wm";
		}
	}
	//我们-企业文化
	@RequestMapping(path = "/qywh", method = RequestMethod.GET)
	public String qywh(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		model.addAttribute("status", 2);
		model.addAttribute("showUrl", "../images/wm/qywh/show_qywh.jpg");
		model.addAttribute("change1", "display:none");
		model.addAttribute("change2", "display:block");
		model.addAttribute("change3", "display:none");
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_wm";
		}else{
			return "home_wm";
		}
	}
	//我们-发展历程
	@RequestMapping(path = "/fzlc", method = RequestMethod.GET)
	public String fzlc(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		model.addAttribute("status", 3);
		model.addAttribute("showUrl", "../images/wm/fzlc/show_fzlc.jpg");
		model.addAttribute("change1", "display:none");
		model.addAttribute("change2", "display:none");
		model.addAttribute("change3", "display:block");
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_wm";
		}else{
			return "home_wm";
		}
	}
	//品牌-品牌故事
	@RequestMapping(path = "/ppgs", method = RequestMethod.GET)
	public String ppgs(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		int pageNo = 1;
		int pageSize = 2;
		List<PageVo> list2 = new ArrayList<PageVo>();
		ArticlePubPageVo articlePubPageVo = manageService.findArticlePage(pageNo,pageSize);
		int totalNo = articlePubPageVo.getPage().getTotalNo();
		for(int a=0;a<totalNo;a++){
			int b = a+1;
			PageVo pageVo = new PageVo();
			pageVo.setNumPage(b);
			pageVo.setPageUrl("/pzxfy?pid="+b);
			list2.add(pageVo);
		}
		model.addAttribute("articlePubs", articlePubPageVo.getArticlePages());
		model.addAttribute("page", articlePubPageVo.getPage());
		model.addAttribute("pageNos", list2);
		String apFy = "";
		if(totalNo>1){
			apFy = "/appzxfy?pid=2";
		}else{
			apFy = "/appzxfy?pid=1";
		}
		model.addAttribute("apFy", apFy);
		model.addAttribute("status", 1);
		model.addAttribute("showUrl", "../images/pp/ppgs/show_ppgs.jpg");
		model.addAttribute("change1", "display:block");
		model.addAttribute("change2", "display:none");
		model.addAttribute("change3", "display:none");
		model.addAttribute("change4", "display:none");
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_pp";
		}else{
			return "home_pp";
		}
	}
	//品牌-品牌风格
	@RequestMapping(path = "/ppfg", method = RequestMethod.GET)
	public String ppfg(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		int pageNo = 1;
		int pageSize = 2;
		List<PageVo> list2 = new ArrayList<PageVo>();
		ArticlePubPageVo articlePubPageVo = manageService.findArticlePage(pageNo,pageSize);
		int totalNo = articlePubPageVo.getPage().getTotalNo();
		for(int a=0;a<totalNo;a++){
			int b = a+1;
			PageVo pageVo = new PageVo();
			pageVo.setNumPage(b);
			pageVo.setPageUrl("/pzxfy?pid="+b);
			list2.add(pageVo);
		}
		model.addAttribute("articlePubs", articlePubPageVo.getArticlePages());
		model.addAttribute("page", articlePubPageVo.getPage());
		model.addAttribute("pageNos", list2);
		String apFy = "";
		if(totalNo>1){
			apFy = "/appzxfy?pid=2";
		}else{
			apFy = "/appzxfy?pid=1";
		}
		model.addAttribute("apFy", apFy);
		model.addAttribute("status", 2);
		model.addAttribute("showUrl", "../images/pp/ppfg/show_ppfg.jpg");
		model.addAttribute("change1", "display:none");
		model.addAttribute("change2", "display:block");
		model.addAttribute("change3", "display:none");
		model.addAttribute("change4", "display:none");
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_pp";
		}else{
			return "home_pp";
		}
	}
	//品牌-品牌理念
	@RequestMapping(path = "/ppln", method = RequestMethod.GET)
	public String ppln(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		int pageNo = 1;
		int pageSize = 2;
		List<PageVo> list2 = new ArrayList<PageVo>();
		ArticlePubPageVo articlePubPageVo = manageService.findArticlePage(pageNo,pageSize);
		int totalNo = articlePubPageVo.getPage().getTotalNo();
		for(int a=0;a<totalNo;a++){
			int b = a+1;
			PageVo pageVo = new PageVo();
			pageVo.setNumPage(b);
			pageVo.setPageUrl("/pzxfy?pid="+b);
			list2.add(pageVo);
		}
		model.addAttribute("articlePubs", articlePubPageVo.getArticlePages());
		model.addAttribute("page", articlePubPageVo.getPage());
		model.addAttribute("pageNos", list2);
		String apFy = "";
		if(totalNo>1){
			apFy = "/appzxfy?pid=2";
		}else{
			apFy = "/appzxfy?pid=1";
		}
		model.addAttribute("apFy", apFy);
		model.addAttribute("status", 3);
		model.addAttribute("showUrl", "../images/pp/ppln/show_ppln.jpg");
		model.addAttribute("change1", "display:none");
		model.addAttribute("change2", "display:none");
		model.addAttribute("change3", "display:block");
		model.addAttribute("change4", "display:none");
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_pp";
		}else{
			return "home_pp";
		}
	}
	//品牌-品牌资讯
	@RequestMapping(path = "/ppzx", method = RequestMethod.GET)
	public String ppzx(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		int pageNo = 1;
		int pageSize = 2;
		List<PageVo> list2 = new ArrayList<PageVo>();
		ArticlePubPageVo articlePubPageVo = manageService.findArticlePage(pageNo,pageSize);
		int totalNo = articlePubPageVo.getPage().getTotalNo();
		for(int a=0;a<totalNo;a++){
			int b = a+1;
			PageVo pageVo = new PageVo();
			pageVo.setNumPage(b);
			pageVo.setPageUrl("/pzxfy?pid="+b);
			list2.add(pageVo);
		}
		model.addAttribute("articlePubs", articlePubPageVo.getArticlePages());
		model.addAttribute("page", articlePubPageVo.getPage());
		model.addAttribute("pageNos", list2);
		String apFy = "";
		if(totalNo>1){
			apFy = "/appzxfy?pid=2";
		}else{
			apFy = "/appzxfy?pid=1";
		}
		model.addAttribute("apFy", apFy);
		model.addAttribute("status", 4);
		model.addAttribute("showUrl", "../images/pp/ppzx/show_ppzx.jpg");
		model.addAttribute("change1", "display:none");
		model.addAttribute("change2", "display:none");
		model.addAttribute("change3", "display:none");
		model.addAttribute("change4", "display:block");
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_pp";
		}else{
			return "home_pp";
		}
	}
	//品牌-品牌资讯-PC分页
	@RequestMapping(path = "/pzxfy", method = RequestMethod.GET)
	public String pzxfy(HttpServletRequest request,Model model) throws Exception {
		String pid = request.getParameter("pid");
		model.addAttribute("status", 4);
		model.addAttribute("showUrl", "../images/pp/ppzx/show_ppzx.jpg");
		model.addAttribute("change1", "display:none");
		model.addAttribute("change2", "display:none");
		model.addAttribute("change3", "display:none");
		model.addAttribute("change4", "display:block");
		int pageNo = Integer.valueOf(pid);
		int pageSize = 2;
		List<PageVo> list2 = new ArrayList<PageVo>();
		ArticlePubPageVo articlePubPageVo = manageService.findArticlePage(pageNo,pageSize);
		int totalNo = articlePubPageVo.getPage().getTotalNo();
		for(int a=0;a<totalNo;a++){
			int b = a+1;
			PageVo pageVo = new PageVo();
			pageVo.setNumPage(b);
			pageVo.setPageUrl("/pzxfy?pid="+b);
			list2.add(pageVo);
		}
		model.addAttribute("articlePubs", articlePubPageVo.getArticlePages());
		model.addAttribute("page", articlePubPageVo.getPage());
		model.addAttribute("pageNos", list2);
		return "home_pp";
	}
	//品牌-品牌资讯-app分页
	@RequestMapping(path = "/appzxfy", method = RequestMethod.GET)
	public String appzxfy(HttpServletRequest request,Model model) throws Exception {
		String pid = request.getParameter("pid");
		model.addAttribute("status", 4);
		model.addAttribute("change1", "display:none");
		model.addAttribute("change2", "display:none");
		model.addAttribute("change3", "display:none");
		model.addAttribute("change4", "display:block");
		int pageNo = Integer.valueOf(pid);
		int pageSize = 2;
		List<PageVo> list2 = new ArrayList<PageVo>();
		ArticlePubPageVo articlePubPageVo = manageService.findArticlePage(pageNo,pageSize);
		int totalNo = articlePubPageVo.getPage().getTotalNo();
		for(int a=0;a<totalNo;a++){
			int b = a+1;
			PageVo pageVo = new PageVo();
			pageVo.setNumPage(b);
			pageVo.setPageUrl("/pzxfy?pid="+b);
			list2.add(pageVo);
		}
		model.addAttribute("articlePubs", articlePubPageVo.getArticlePages());
		model.addAttribute("page", articlePubPageVo.getPage());
		model.addAttribute("pageNos", list2);
		int num = 0;
		if(totalNo>pageNo){
			num = pageNo+1;
		}else{
			num = pageNo;
		}
		String apFy = "/appzxfy?pid="+num;
		model.addAttribute("apFy", apFy);
		return "app_home_pp";
	}
	//品牌-品牌资讯 -详情
	@RequestMapping(path = "/ppzxxq", method = RequestMethod.GET)
	public String ppzxxq(HttpServletRequest request,Model model) throws Exception {
		String wid = request.getParameter("wid");
		ArticlePub articlePub = manageService.findOneArticle(Long.valueOf(wid));
		model.addAttribute("articlePub", articlePub);
		model.addAttribute("showUrl", "../images/pp/ppzx/show_ppzx.jpg");
		String os = DateDealwith.getOsAndBrowserInfo(request);
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			List<ArticlePageVo> articlePageVos = manageService.findListArticleTwo();
			model.addAttribute("articlePageVos", articlePageVos);
			return "app_home_pp_xq";
		}else{
			return "home_pp_xq";
		}
	}
	//形象
	@RequestMapping(path = "/xxzx", method = RequestMethod.GET)
	public String xxzx(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_xx";
		}else{
			return "home_xx";
		}
	}
	//形象-春夏系列
	@RequestMapping(path = "/cxxl", method = RequestMethod.GET)
	public String cxxl(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_xx_cx";
		}else{
			return "home_xx_cx";
		}
	}
	//形象-秋冬系列
	@RequestMapping(path = "/qdxl", method = RequestMethod.GET)
	public String qdxl(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_xx_qd";
		}else{
			return "home_xx_qd";
		}
	}
	//门店
	@RequestMapping(path = "/mdzs", method = RequestMethod.GET)
	public String mdzs(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_md";
		}else{
			return "home_md";
		}
	}
	//加盟-加盟流程
	@RequestMapping(path = "/jmzx", method = RequestMethod.GET)
	public String jmlc(HttpServletRequest request,Model model) throws Exception {
		String os = DateDealwith.getOsAndBrowserInfo(request);
		if(os != null && (os.equals("Android")||os.equals("IPhone"))){
			return "app_home_jm";
		}else{
			return "home_jm";
		}
	}
	
	
	//系统管理
	@RequestMapping(path = "/yingran/admin", method = RequestMethod.GET)
	public String system(HttpServletRequest request) throws Exception {
	    return "adminManage";
	}
	@RequestMapping(path = "/newTrends", method = RequestMethod.GET)
	public String newTrends(HttpServletRequest request) throws Exception {
	    return "newsInput";
	}
	
	
	//加载磁盘图片
	@RequestMapping(value = "/getQRCode")
	public void getQRCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String imgUrl = request.getParameter("a");
		String[] urls = imgUrl.split(",");
		/*String newsUrl = "D:/YingRanInfo/"+urls[0]+"/"+urls[1]+".jpg";*/
		String newsUrl = "/home/YingRanInfo/"+urls[0]+"/"+urls[1]+".jpg";
		FileInputStream fis = null;
		response.setContentType("image/gif");
		try {
			OutputStream out = response.getOutputStream();
			File file = new File(newsUrl);
			fis = new FileInputStream(file);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			out.write(b);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
