package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
/*import com.itbook.controller.action.book.AdminTodayBookListAction;*/
/*import com.itbook.dao.BookDAO;*/
import com.itbook.dao.MeetingDAO;
/*import com.itbook.vo.Book.BookBoardVO;*/
import com.itbook.vo.Meeting.MeetingVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MetUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String metNum = request.getParameter("metNum");
//		String metName = request.getParameter("metName");
//		String metGreeting = request.getParameter("metGreeting");
//		String metIntro = request.getParameter("metIntro");
//		String metPlace = request.getParameter("metPlace");
//		String keyword = request.getParameter("keyword");
//		
//		
//		MeetingVO mVo = new MeetingVO();
//		
//		mVo.setMetNum(metNum);
//		mVo.setMetName(metName);
//		mVo.setMetGreeting(metGreeting);
//		mVo.setMetIntro(metIntro);
//		mVo.setMetPlace(metPlace);
//		mVo.setKeyword(keyword);
//		
//		MeetingDAO mDao = MeetingDAO.getInstance();
//		mDao.updateMeeting(mVo);
//		
//		new MeetingHomeAction().execute(request, response);
		
		String url = "/meeting/meetingList.jsp";
		
		int fileSize = 5 * 1024 * 1024;
		// 파일업로드 경로
		String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());

			// 파일정보
			String metNum = multi.getParameter("metNum");
			String metName = multi.getParameter("metName");
			String metGreeting = multi.getParameter("metGreeting");
			String metIntro = multi.getParameter("metIntro");
			String location[] = multi.getParameterValues("loaction");
			String metPlace = multi.getParameter("metPlace");
			String keyword[] = multi.getParameterValues("keyword");
			String existFile = multi.getParameter("metImg"); // 현재 파일
			
			MeetingVO mVo = new MeetingVO();
			mVo.setMetNum(metNum);
			mVo.setMetName(metName);
			mVo.setMetGreeting(metGreeting);
			mVo.setMetIntro(metIntro);
			
			//selectbox 값 가져오기
			if(location != null) {
				for(int i = 0; i<location.length; i++) {
					request.setAttribute("location", location[i]);
					mVo.setLocation(location[i]);
				}
			}
			
			mVo.setMetPlace(metPlace);
			
			//checkbox 값 가져오기
			/* mVo.setKeyword(keyword); */
			if(keyword != null) {
				for(int i = 0; i<keyword.length; i++) {
					request.setAttribute("keyword", keyword[i]);
					mVo.setKeyword(keyword[i]);
				}
			}
			
			// 파일업로드
			Enumeration<String> fileNames = multi.getFileNames();
			if (fileNames.hasMoreElements()) {
				String fileName = fileNames.nextElement();
				String updateFile = multi.getFilesystemName(fileName);
				if (updateFile == null)
					mVo.setMetImg(existFile);
				else
					mVo.setMetImg(updateFile);
			}
			
			MeetingDAO mDao = MeetingDAO.getInstance();
			boolean result = mDao.updateMeeting(mVo);

			if (result) {
				new MeetingHomeAction().execute(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION MESSAGE : " + e.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
