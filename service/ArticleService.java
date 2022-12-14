package com.sbs.java.bm.service;

import java.sql.Connection;
import java.util.List;

import com.sbs.java.bm.dao.ArticleDao;
import com.sbs.java.bm.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService(Connection con) {
		this.articleDao = new ArticleDao(con);
	}

	public int getItemsInAPage() {
		return 3;
	}

	public int getForPrintListTotalPage() {
		int itemsInAPage = getItemsInAPage();

		int totalCount = articleDao.getTotalCount();
		int totalpage = (int) Math.ceil((double) totalCount / itemsInAPage);

		return totalpage;
	}

	public List<Article> getForPrintArticles(int page) {
		int itemsInAPage = getItemsInAPage();
		int limitFrom = (page - 1) * itemsInAPage;

		List<Article> articles = articleDao.getArticles(limitFrom, itemsInAPage);

		return articles;
	}

}