<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>

<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>

<%
/**
 * uploader.jsp
 *
 * Company: BizFlow Corp
 *
 * @author Taeho Lee
 * @version 1.0
 * @created: Feb 26, 2019
 * @modification history
 * @modified:
 *
 */
	ResourceBundle resource = ResourceBundle.getBundle("ewits2jobaid");
	String dir_root = "";
	String dir_temp = "";
	String file_max_size_str = "";
	String mem_size_str = "";
	Integer maxFileSize = 10240;
	Integer maxMemSize = 500;
	
	try {
		dir_root = resource.getString("jobaid.directory.materials");
		if (dir_root == null) {dir_root = "materials/";}
		
		dir_temp = resource.getString("jobaid.directory.temp");
		if (dir_temp == null) {dir_temp = "WEB-INF/temp/";}
		
		file_max_size_str = resource.getString("jobaid.file.size.max");
		if (file_max_size_str == null) {file_max_size_str = "10240";}
		maxFileSize = Integer.parseInt(file_max_size_str) * 1024;
		
		mem_size_str = resource.getString("jobaid.file.upload.mem.size");
		if (mem_size_str == null) {mem_size_str = "500";}
		maxMemSize = Integer.parseInt(mem_size_str) * 1024;
		
	} catch (Exception e) {
		dir_root = "";
	}
	System.out.println("----------------------------");
	System.out.println("dir_root=" + dir_root);
	System.out.println("dir_temp=" + dir_temp);
	System.out.println("file_max_size_str=" + file_max_size_str);
	System.out.println("mem_size_str=" + mem_size_str);

	System.out.println("[uploader.jsp] >>>>>");

	String errorMessage = null;
	File file ;
	int fileCount = 0;
	int fieldCount = 0;

	System.out.println("[uploader.jsp] loading configuration...");

	String rootPath = application.getRealPath("/").replace('\\', '/');
	dir_root = rootPath + dir_root;
	dir_temp = rootPath + dir_temp;

	System.out.println("[uploader.jsp] dir_root=" + dir_root + ", dir_temp=" + dir_temp);

	System.out.println("[uploader.jsp]  verifing the content type...");
	String contentType = request.getContentType();
	if ((contentType.indexOf("multipart/form-data") >= 0))
	{
		DiskFileItemFactory factory = new DiskFileItemFactory();
		System.out.println("[uploader.jsp] setting maximum size that will be stored in memory");
		factory.setSizeThreshold(maxMemSize);
		System.out.println("[uploader.jsp] setting temp path if file size is larger than maxMemSize.");
		factory.setRepository(new File(dir_temp));

		System.out.println("[uploader.jsp] creating a new file upload handler...");
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);
		try{
			System.out.println("[uploader.jsp] parsing the request to get file items.");
			List fileItems = upload.parseRequest(request);

			System.out.println("[uploader.jsp] process the uploaded field items.");
			Iterator i = fileItems.iterator();

			String paramName = null;
			String paramValue = null;
			while (i.hasNext())
			{
				FileItem fi = (FileItem)i.next();
				if (fi.isFormField())
				{
					paramName = fi.getFieldName();
					paramValue = fi.getString();
					System.out.println("[uploader.jsp] \t (field) " + paramName + "=" + paramValue);
					out.println("Field [" + Integer.toString(fieldCount++) + "] : " + paramName + "=" + paramValue + "<br>");
				}
				else
				{
					String fieldName = fi.getFieldName();
					System.out.println("[uploader.jsp] \t (file) fieldName=" + fieldName);
					String fileName = fi.getName();
					System.out.println("[uploader.jsp] \t (file) fileName=" + fileName);
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					System.out.println("[uploader.jsp] \t (file) writing the file...");
					if (sizeInBytes > 0) {
						// Write the file
						if( fileName.lastIndexOf("\\") >= 0 ){
							file = new File( dir_root +
							fileName.substring( fileName.lastIndexOf("\\"))) ;
						}else{
							file = new File( dir_root +
							fileName.substring(fileName.lastIndexOf("\\")+1)) ;
						}
							fi.write( file ) ;
							out.println("File [" + Integer.toString(fileCount++) + "] : <b>" + dir_root + fileName + "</b> has been uploaded sucessfully.<br>");
					}
				}
			 }
			 out.println("</body>");
			 out.println("</html>");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			errorMessage = ex.toString();
		}
	}
	else
	{
	  out.println("<p>No file uploaded</p>");
	}

	if (null != errorMessage && !"".equals(errorMessage)) {
		out.println("<h3>Fail to upload file.</h3>");
		out.println("<p>Error Details:</p>");
		out.println("<p>" + errorMessage + "</p>");
	}
	System.out.println("[uploader.jsp] <<<<<");
	
	System.out.println("Welcome Message : Redirect JSP");
	request.setAttribute("Request-Attribute", "Value of Attribute ");
	response.sendRedirect("uploader_main.jsp");
%>
