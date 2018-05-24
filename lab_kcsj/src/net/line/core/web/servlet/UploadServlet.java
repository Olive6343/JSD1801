package net.line.core.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * 文件上传功能Servlet
 * @author Administrator
 *
 */
public class UploadServlet extends HttpServlet {

	private static String realPath;//定义服务器存储的路径/
	private final static String descPath="upload";//定义上传文件夹的路径(upload)
	private static String savePath;
	//定义文件上传的结果状态数组
	private List<String[]> upload_results=new ArrayList<String[]>();
	//文件名|下载
	/**
	 * 处理get请求
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	/**
	 * 处理Post请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			
			System.out.println("out:upload file....");
		    String path=req.getContextPath();
			this.upload(req, resp);
			
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
			PrintWriter out=resp.getWriter();
			out.print("<table border=\"1\" width=\"400\">");
			for(int i=0;i<upload_results.size();i++){
			String[]obj=upload_results.get(i);
			out.print("<tr>");
			out.print("<td>");
			out.print(obj[0]);
			out.print("</td>");
			out.print("<td>");
			out.print("<a href=\""+obj[1]+"\" target=\"_blank\">下载</a>");
			out.print("</td>");
			out.print("</tr>");
			}
			out.print("</table>");
			out.flush();
			out.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * 文件上传的处理过程
	 * @throws Exception
	 */
	private  void upload(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		try{
		System.out.println("处理上唇....");
		realPath=req.getRealPath("/");
		savePath=realPath+File.separator+descPath;
	    String path=req.getContextPath();
		
		File uploadFile=new File(realPath);
		//判断创建的文件是否存在
		if(!uploadFile.exists()){
			uploadFile.mkdirs();
		}
		String _temp=realPath+File.separator+"/temp";
		//创建临时文件家
		File repository=new File(_temp);
		//实例化DiskFileItemFactory 上传文件处理
		DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(4096);
		diskFileItemFactory.setRepository(repository);//设置临时目录
		
		ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);
	
		//解释请求中的文件内容
		List<FileItem> fileItems=fileUpload.parseRequest(req);
		fileUpload.setFileSizeMax(4194304);
		
		Iterator<FileItem> iterator=fileItems.iterator();
		//逐一遍历各个文件
		while(iterator.hasNext()){
			FileItem fileItem=iterator.next();
			//保存到服务器的指定文件夹
			String fileName=fileItem.getName();
			//判断是否为NULL
			if(fileName!=null){
			
				int len=fileName.lastIndexOf(".");
				String fType=fileName.substring(len+1, fileName.length());
				String reFileName=System.currentTimeMillis()+"."+ fType;
				System.out.println("fileName:"+fileName);
				System.out.println("reFileName:"+reFileName);
				File saveFile =new File(savePath, reFileName);
				
				String[]files={reFileName,path+"/upload/"+reFileName};
				upload_results.add(files);
				fileItem.write(saveFile);
			}
			
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
