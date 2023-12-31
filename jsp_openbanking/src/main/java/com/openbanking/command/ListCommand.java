package com.openbanking.command;

import java.util.ArrayList;

import com.openbanking.dao.BoardDao;
import com.openbanking.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDao boarddao = new BoardDao();
		ArrayList<BoardDto> boarddtos = boarddao.list();
		/*dao에서 리스트 메소드를 호출해서 사용*/
		request.setAttribute("list", boarddtos);		
	}

}
