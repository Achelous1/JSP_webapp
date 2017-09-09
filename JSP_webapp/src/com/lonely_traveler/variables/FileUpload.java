package com.lonely_traveler.variables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

public class FileUpload {

	public static void uploadImage(HttpServletRequest request, MultipartRequest multi, String path, String type) {
		
		//파일 인풋 스트림
        FileInputStream fin = null;
        //파일 출력 스트림
        FileOutputStream fout = null;
	    int maxSize = 10*1024*1024;
	    String savePath = path;
	    String format = "UTF-8";
	    String uploadFile="";
	    int read = 0;
	    byte[] buf = new byte[1024];
	    
	    try{
	        String title = multi.getParameter("user_id");
	        uploadFile = multi.getFilesystemName(type);
	        File file = new File(savePath + title);
	        System.out.println("Uploading successful");
	        
	         //업로드된 파일 객체 생성
	         File oldFile = new File(savePath + uploadFile);
	         
	         //실제 저장될 파일 객체
	         File newFile = new File(savePath + title + ".jpg");
	         
	         //파일 객체 이름 변경
	         if(!oldFile.renameTo(newFile)){
	            
	            buf = new byte[1024];
	            fin = new FileInputStream(oldFile); 
	            fout = new FileOutputStream(newFile); 
	            
	            //1byte씩 계속해서 파일을 읽어가며 저장한다.
	            while((read=fin.read(buf,0,buf.length))!=-1){
	               fout.write(buf, 0, read);
	            }
	            
	            fin.close();
	            fout.close();
	            oldFile.delete();
	         }
	    }catch(Exception e){
	        e.printStackTrace();
	        System.out.println("Error occured in saving image");
	    }finally {
	    	System.out.println("uploading completed");
	    }
	}
	
}
