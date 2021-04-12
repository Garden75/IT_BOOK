package com.itbook.controller.action.meeting;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbook.controller.action.Action;
import com.itbook.dao.MeetingDAO;
import com.itbook.vo.Meeting.MeetingVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MeetingApplyAction implements Action{
	
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
		// 파일크기 지정
        int fileSize= 5*1024*1024;
        // 파일업로드 경로
        String uploadPath = request.getServletContext().getRealPath("/META-INF/UploadFolder");
        
        System.out.println("============ MeetingImg = " + uploadPath);
        
        try {
            
            // 파일요청
            MultipartRequest multi = new MultipartRequest
                    (request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
 
            // 파일명 가져오기
            String fileName = "";
            Enumeration<String> names = multi.getFileNames();
            
            
            if(names.hasMoreElements())
            {
                String name = names.nextElement();
                fileName = multi.getFilesystemName(name);
            }
            
            System.out.println("fileName : " + fileName);

            MeetingDAO mDao = MeetingDAO.getInstance();
            MeetingVO mVo = new MeetingVO();
            
            mVo.setMetName(multi.getParameter("metName"));
			mVo.setMetGreeting(multi.getParameter("metGreeting"));
			mVo.setMetIntro(multi.getParameter("metIntro"));
			mVo.setRepresent(multi.getParameter("represent"));
			mVo.setLocation(multi.getParameter("location"));
			mVo.setMetPlace(multi.getParameter("metPlace"));
			mVo.setKeyword(multi.getParameter("keyword"));
			mVo.setMetImg(multi.getFilesystemName("metImg"));
			mVo.setMemNum(multi.getParameter("memNum"));
			
			System.out.println(mVo +"MVO");
            boolean result = mDao.insertMeeting(mVo);
            
            if(result) {
            	
            	new MeetingListAction().execute(request, response);
            }
            	
            } catch (Exception e) {
                
            	e.printStackTrace();
                System.out.println("湲� ���� �ㅻ� : " + e.getMessage());
            }
        	
        
        }  
	}
