package com.bridgeimpact.renewal.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeimpact.renewal.dto.CommentVO;
import com.bridgeimpact.renewal.service.CommentService;

 
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/comment")
public class CommentController {
    
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    
    @Autowired
    private CommentService commentService;
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    
    
    /***
     * 게시판의 게시글의 댓글 리스트 요청
     * @param num : 게시글 번호
     * @return
     */
	@RequestMapping(value="/getCommentList.bim", method= RequestMethod.GET)
	public ModelAndView getCommentList(int num,HttpServletRequest request,HttpSession session){
		ModelAndView mav = new ModelAndView("board/commentForm");
		int parentIdx = Integer.parseInt(request.getParameter("num"));
		List<CommentVO> commentList = null;
		try {
			commentList = commentService.selectCommentByIndex(parentIdx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("commentList", commentList);
		mav.addObject("parentIdx", parentIdx);
		return mav;
	}
    
    /***
     * 이용자의 댓글 작성 ajax요청
     * @param model
     * @param commentVO
     * @param request
     * @param response
     * @return resultMap (json)
     */
	@RequestMapping(value="/writeCommentAjax.bim")
	@ResponseBody
	public Map<String, String> writeComment(Model model,CommentVO commentVO, HttpServletRequest request,HttpServletResponse response){
		
		Map<String, String> resultMap = new HashMap<String, String>();
		int resultCnt = 0;
		 
		try {
			 commentService.insertComment(commentVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = "";
		String resultMsg = "";

		if (resultCnt == 0){
			result = "success";
			resultMsg = "댓글 작성이 완료 되었습니다.";
		}else{
			result = "failure";
			resultMsg = "댓글 작성이 실패 하였습니다.";
		}
		resultMap.put("result", result);
	  	resultMap.put("resultMsg", resultMsg);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		return resultMap;
	}
	
	/**
	 * 이용자의 댓글 수정 ajax요청
	 * @param model
	 * @param commentVO
	 * @param request
	 * @param response
     * @return resultMap (json)
	 */
	@RequestMapping(value="/editCommentAjax.bim")
	@ResponseBody
	public Map<String, String> editComment(Model model,CommentVO commentVO, HttpServletRequest request,HttpServletResponse response){

		Map<String, String> resultMap = new HashMap<String, String>();
		 int resultCnt = 0;
		 
		try {
			resultCnt  = commentService.editComment(commentVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String result = "";
		  String resultMsg = "";

		  if ( resultCnt == 1 ){
			   result = "success";
			   resultMsg = "댓글 수정이 완료 되었습니다.";
			  } else {
			   result = "failure";
			   resultMsg = "댓글 수정이 실패 하였습니다.";
			  }

		  resultMap.put("result", result);
		  resultMap.put("resultMsg", resultMsg);
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		  return resultMap;
	}
	
	/**
	 * 이용자의 댓글 삭제 ajax요청
	 * @param model
	 * @param commentVO
	 * @param request
	 * @param response
     * @return resultMap (json)
	 */
	@RequestMapping(value="/deleteCommentAjax.bim")
	@ResponseBody
	public Map<String, String> deleteComment(Model model,CommentVO commentVO, HttpServletRequest request,HttpServletResponse response){
		Map<String, String> resultMap = new HashMap<String, String>();
		 int resultCnt = 0;
		try {
			resultCnt =  commentService.deleteComment(commentVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String result = "";
		  String resultMsg = "";

		  if ( resultCnt == 1 ){
			   result = "success";
			   resultMsg = "댓글 삭제가 완료 되었습니다.";
			  } else {
			   result = "failure";
			   resultMsg = "댓글 삭제가 실패 하였습니다.";
			  }

		  resultMap.put("result", result);
		  resultMap.put("resultMsg", resultMsg);
		  response.setContentType("text/plain");
		  response.setCharacterEncoding("UTF-8");
		  return resultMap;
	}
	
	/**
	 * 댓글 전체 리스트 (현재 작성만 되어있으며 사용중인 페이지 없음)
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/commentList.bim")
	public String boardList(Model model, HttpServletRequest request){
	       List<CommentVO> commentList = null;
		try {
			commentList = commentService.selectAllComment();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        model.addAttribute("commentList", commentList);
	 
		return "comment/commentList";
	}
	
	// TODO 사용중인곳 확인 필요
	@RequestMapping(value="/boardView.bim", method= RequestMethod.GET)
	public ModelAndView boardView(Model model, HttpServletRequest request,HttpSession session){
		ModelAndView mav = new ModelAndView("comment/viewForm");
		/*
		CommentVO selectCommentByIndex = null;
		try {
			commentService.increseHitCntByIndex(Integer.parseInt(request.getParameter("num")));
			selectCommentByIndex = commentService.selectCommentByIndex(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("comment" , selectCommentByIndex);
		session.setAttribute("commentInfo", selectCommentByIndex);
		*/
		return mav;
	}

	
    
}


