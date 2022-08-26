 package com.jsp.action.board;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.BoardService;

public class BoardListAction implements Action{

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/list";
		
		try {
			//처리
			CriteriaCommand command = HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
			Criteria cri = command.toCriteria();
			
			Map<String, Object> dataMap = boardService.getBoardList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/error/500";
		}
		return url;
	}

}
