package cn.htjx.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.htjx.domain.ArticlePub;
import cn.htjx.domain.JoinUs;
import cn.htjx.domain.LeaveWord;
import cn.htjx.domain.MessageEntity;
import cn.htjx.service.IManageService;
import cn.htjx.vo.ArticlePubVo;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
    private IManageService manageService;
	
	//新闻发布
	@RequestMapping("/uploadInfo")
	@ResponseBody
	public MessageEntity uploadInfo(MessageEntity messageEntity,  
            @RequestParam(value = "file") MultipartFile file,
            HttpServletRequest request) throws IOException {  
		String titleName = request.getParameter("titleName");
		String content = request.getParameter("content");
		manageService.uploadInfo(messageEntity,file,titleName,content);
        return messageEntity;
    }
	
	@RequestMapping(path = "/saveLeave", method = RequestMethod.POST)
	public @ResponseBody String addLeaveWord(LeaveWord leaveWord,Model model) throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		try{
			manageService.saveLeave(leaveWord);
			jsonObject.put("status", true);
		}catch(Exception e){
			jsonObject.put("status", false);
		}
		jsonArray.add(jsonObject);
		return jsonArray.toString();
	}
	
	@RequestMapping(path = "/saveJoin", method = RequestMethod.POST)
	public @ResponseBody String saveJoin(JoinUs joinUs,Model model) throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		try{
			manageService.saveJoin(joinUs);
			jsonObject.put("status", true);
		}catch(Exception e){
			jsonObject.put("status", false);
		}
		jsonArray.add(jsonObject);
		return jsonArray.toString();
	}
	
	@RequestMapping(path = "/findRecomArticle", method = RequestMethod.POST)
	public @ResponseBody String findRecomArticle() throws Exception {
		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
		List<ArticlePubVo> list = new ArrayList<>();
		List<ArticlePub> recomArticles = manageService.findListArticle();
		for (ArticlePub articlePub : recomArticles) {
			ArticlePubVo articlePubVo = new ArticlePubVo();
			articlePubVo.setId(articlePub.getId());
			articlePubVo.setTitleName(articlePub.getTitleName());
			articlePubVo.setImgUrl(articlePub.getImgUrl());
			articlePubVo.setContent(articlePub.getContent());
			articlePubVo.setcTime(std.format(articlePub.getCreateTime()).toString());
			articlePubVo.setuTime(std.format(articlePub.getUpdateTime()).toString());
			list.add(articlePubVo);
		}
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("recomArticles", list);
		jsonArray.add(jsonObject);
		return jsonArray.toString();
	}
	
	@RequestMapping(path = "/findRecomArticleTen", method = RequestMethod.POST)
	public @ResponseBody String findRecomArticleTen() throws Exception {
		SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
		List<ArticlePubVo> list = new ArrayList<>();
		List<ArticlePub> recomArticles = manageService.findListArticleTen();
		for (ArticlePub articlePub : recomArticles) {
			ArticlePubVo articlePubVo = new ArticlePubVo();
			articlePubVo.setId(articlePub.getId());
			articlePubVo.setTitleName(articlePub.getTitleName());
			articlePubVo.setImgUrl(articlePub.getImgUrl());
			articlePubVo.setContent(articlePub.getContent());
			articlePubVo.setcTime(std.format(articlePub.getCreateTime()).toString());
			articlePubVo.setuTime(std.format(articlePub.getUpdateTime()).toString());
			list.add(articlePubVo);
		}
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("recomArticles", list);
		jsonArray.add(jsonObject);
		return jsonArray.toString();
	}
	
	//导出全部留言板
	@RequestMapping(path = "/outWord", method = RequestMethod.GET)
	public void outWord(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename=LeaveWord.xls");
		OutputStream out = response.getOutputStream();
		ExcelUtil<LeaveWord> puter = new ExcelUtil<LeaveWord>();
		String [] headers={"编号","名称","电话","留言内容","创建时间","更新时间"};
		//数据集合
		List<LeaveWord> leaveWords = manageService.findAllLeave();
		puter.exportExcel("全部留言板", headers, leaveWords, out, "yyyy-MM-dd HH:mm:ss");
		out.close();
	}
	//导出最新60条留言板
	@RequestMapping(path = "/outWordSix", method = RequestMethod.GET)
	public void outWordSix(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename=LeaveWordSix.xls");
		OutputStream out = response.getOutputStream();
		ExcelUtil<LeaveWord> puter = new ExcelUtil<LeaveWord>();
		String [] headers={"编号","名称","电话","留言内容","创建时间","更新时间"};
		//数据集合
		List<LeaveWord> leaveWords = manageService.findListLeave();
		puter.exportExcel("最新留言板", headers, leaveWords, out, "yyyy-MM-dd HH:mm:ss");
		out.close();
	}
	//导出全部加盟申请
	@RequestMapping(path = "/outJoin", method = RequestMethod.GET)
	public void outJoin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename=JoinUs.xls");
		OutputStream out = response.getOutputStream();
		ExcelUtil<JoinUs> puter = new ExcelUtil<JoinUs>();
		String [] headers={"编号","名称","电话","QQ","邮箱","省份","商场","具体地址","开店经验","有无店铺","留言内容","创建时间","更新时间"};
		//数据集合
		List<JoinUs> joinUss = manageService.findAllJoin();
		puter.exportExcel("全部加盟申请", headers, joinUss, out, "yyyy-MM-dd HH:mm:ss");
		out.close();
	}
	//导出最新60条加盟申请
	@RequestMapping(path = "/outJoinSix", method = RequestMethod.GET)
	public void outJoinSix(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename=JoinUsSix.xls");
		OutputStream out = response.getOutputStream();
		ExcelUtil<JoinUs> puter = new ExcelUtil<JoinUs>();
		String [] headers={"编号","名称","电话","QQ","邮箱","省份","商场","具体地址","开店经验","有无店铺","留言内容","创建时间","更新时间"};
		//数据集合
		List<JoinUs> joinUss = manageService.findListJoin();
		puter.exportExcel("最新加盟申请", headers, joinUss, out, "yyyy-MM-dd HH:mm:ss");
		out.close();
	}
	
}
