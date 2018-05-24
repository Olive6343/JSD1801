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
 * �ļ��ϴ�����Servlet
 * @author Administrator
 *
 */
public class UploadServlet extends HttpServlet {

	private static String realPath;//����������洢��·��/
	private final static String descPath="upload";//�����ϴ��ļ��е�·��(upload)
	private static String savePath;
	//�����ļ��ϴ��Ľ��״̬����
	private List<String[]> upload_results=new ArrayList<String[]>();
	//�ļ���|����
	/**
	 * ����get����
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	/**
	 * ����Post����
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
			out.print("<a href=\""+obj[1]+"\" target=\"_blank\">����</a>");
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
	 * �ļ��ϴ��Ĵ������
	 * @throws Exception
	 */
	private  void upload(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		try{
		System.out.println("�����ϴ�....");
		realPath=req.getRealPath("/");
		savePath=realPath+File.separator+descPath;
	    String path=req.getContextPath();
		
		File uploadFile=new File(realPath);
		//�жϴ������ļ��Ƿ����
		if(!uploadFile.exists()){
			uploadFile.mkdirs();
		}
		String _temp=realPath+File.separator+"/temp";
		//������ʱ�ļ���
		File repository=new File(_temp);
		//ʵ����DiskFileItemFactory �ϴ��ļ�����
		DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(4096);
		diskFileItemFactory.setRepository(repository);//������ʱĿ¼
		
		ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);
	
		//���������е��ļ�����
		List<FileItem> fileItems=fileUpload.parseRequest(req);
		fileUpload.setFileSizeMax(4194304);
		
		Iterator<FileItem> iterator=fileItems.iterator();
		//��һ���������ļ�
		while(iterator.hasNext()){
			FileItem fileItem=iterator.next();
			//���浽��������ָ���ļ���
			String fileName=fileItem.getName();
			//�ж��Ƿ�ΪNULL
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
