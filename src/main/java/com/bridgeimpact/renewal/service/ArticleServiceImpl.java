package com.bridgeimpact.renewal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeimpact.renewal.dao.ArticleDAO;
import com.bridgeimpact.renewal.dao.BoardDAO;
import com.bridgeimpact.renewal.dto.ArticleVO;
import com.bridgeimpact.renewal.dto.BoardVO;

import javax.servlet.http.HttpServletRequest;


@Service
public class ArticleServiceImpl implements ArticleService {

	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private FileService fileService;

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private BoardDAO boardDAO;
    
	
	@Override
	public List<ArticleVO> selectAllArticle() throws Exception {
		// TODO Auto-generated method stub
		return articleDAO.selectAllArticle();
	}
	
	@Override
	public ArticleVO selectArticleByIndex(int index) throws Exception {
		// TODO Auto-generated method stub
		return  articleDAO.selectArticleByIndex(index);
	}

	@Override
	public List<ArticleVO> selectArticleByboardId(String id) throws Exception {
		// TODO Auto-generated method stub
		return articleDAO.selectArticleByboardId(id);
	}
	
	@Override
	public int writeArticle(HttpServletRequest request, ArticleVO article) throws Exception {
		/* 게시글 제목, 내용, 작성자 값 판별*/
		if ("".equals(article.getTitle()) ||
			"".equals(article.getContents()) ||
			"".equals(article.getWriteId())){
			return 0;
		}
		/* 게시글 db insert */
		int insertArticleResult = articleDAO.insertArticle(article);
		if (insertArticleResult < 1){	// 글 작성 실패시
			return 0;
		}

		fileService.insertFile(request, article);

		return insertArticleResult ;
	}

	@Override
	public int editArticle(HttpServletRequest request, ArticleVO article) throws Exception {
		//this.validateArticleVO(article);
		/* 게시글 제목, 내용, 작성자 값 판별*/
		if ("".equals(article.getTitle()) ||
				"".equals(article.getContents()) ||
				"".equals(article.getWriteId())){
			return 0;
		}
		int insertArticleResult = articleDAO.updateArticle(article);
		fileService.insertFile(request, article);
		return insertArticleResult;
	}

	private void validateArticleVO(ArticleVO article) {
		// TODO Article의 작성자, 글제목, 본문 유효성을 체크합니다.
	}

	@Override
	public void deleteArticle(ArticleVO board) throws Exception {
		articleDAO.deleteArticle(board);
	}

	@Override
	public void increaseHitCntByIndex(int index) throws Exception {
		articleDAO.updateHitCntByIndex(index);
	}

	@Override
	public int selectTotalCntByArticle(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return articleDAO.selectTotalCntByArticle(paramMap);
	}

	@Override
	public List<ArticleVO> selectArticleByPage(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return articleDAO.selectArticleByPage(paramMap);
	}

	@Override
	public Boolean checkValidateArticleByIdx(int num) throws Exception {
		ArticleVO article = articleDAO.selectArticleByIndex(num);
		if (article == null || "Y".equals(article.getDelGb())) {
			return false;
		}
		return true;
	}

	@Override
	public List<ArticleVO> selectMainArticleList(List<BoardVO> boardList) throws Exception {
		//TODO articleCnt should be static parameter
		int articleCnt = 5;
    	List<ArticleVO> resultList = new ArrayList<ArticleVO>();
    	resultList.addAll(articleDAO.selectArticleByRecent(articleCnt,boardList.get(0).getId()));
    	resultList.addAll(articleDAO.selectArticleByRecent(articleCnt,boardList.get(1).getId()));
    	resultList.addAll(articleDAO.selectArticleByRecent(articleCnt,boardList.get(2).getId()));
    	resultList.addAll(articleDAO.selectArticleByRecent(articleCnt,boardList.get(3).getId()));
		System.out.println("map 테스트 : " + resultList);
    	return resultList;
	}


}
