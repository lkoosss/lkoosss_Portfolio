package com.ssoh.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssoh.model.BoardDao;
import com.ssoh.model.BoardDto;
import com.ssoh.model.MemberDto;
import com.ssoh.utility.WebUtility;

@WebServlet("/GoArticleModifyViewPage.do")
public class GoArticleModifyViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoArticleModifyViewPageController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtility.setEncoding(request, response);
		HttpSession session = request.getSession();
		
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		
		MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMemberDto");
		
		int articleNumberToModify = Integer.parseInt(request.getParameter("articleNumberToModify"));
		boardDto = boardDao.getOneBoard(articleNumberToModify);
		request.setAttribute("boardDto", boardDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/modifyArticle.jsp");
		dispatcher.forward(request, response);
	}
}
