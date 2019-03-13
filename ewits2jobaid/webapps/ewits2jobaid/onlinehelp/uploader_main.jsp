<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<%@ page language="java" import="java.text.SimpleDateFormat, java.text.NumberFormat" %> 
<%!
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
	String getFileExtension(String fileName) {
		String extension = "";

		int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
		int j = fileName.lastIndexOf('.');

		if (j > p) {
			extension = fileName.substring(j+1);
			System.out.println("extension=" + extension);
		}
		return extension;
	}
%>
<% 
	ResourceBundle resource = ResourceBundle.getBundle("ewits2jobaid");
	String dir_root = "";
	String dir_temp = "";
	String file_max_size_str = "";
	String mem_size_str = "";
	Integer maxFileSize = 10240;
	Integer maxMemSize = 500;
	
	try {
		dir_root = resource.getString("jobaid.directory.jobaid");
		if (dir_root == null) {dir_root = "jobaid/";}
		
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
%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="Author" content="Taeho Lee">
	<meta name="Keywords" content="Job Aid File Upload">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>EWITS 2.0 Job Aid Online Help File Uploader</title>

	<script src="../components/jquery/jquery-3.3.1.js"></script>
	<script src="../components/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="../components/bootstrap/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="../components/fontawesome/css/all.min.css" />
	<script>
		$(function () {
		  $('[data-toggle="tooltip"]').tooltip();
		  
		  
		})
		
		function download(idx) {
			//$("#idx_" + idx).trigger("click");
			var obj = document.getElementById("idx_" + idx);
			obj.click();
		}
		
		
		function copyURL(idx) {
			$("#txtHiddenForClipboard").show();
			var url = $("#idx_" + idx).prop("href");
			$("#txtHiddenForClipboard").val(url);
			var obj = document.getElementById("txtHiddenForClipboard");
			obj.select();
			document.execCommand("copy");
			alert("URL copied: \r" + obj.value);
			$("#txtHiddenForClipboard").hide();
		}
	
	</script>
</head>
<body>

<div class="container">
	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
		<img src="../theme/hhs_logo.png" style="width:35px;height:35px" alt="HHS logo"> &nbsp;&nbsp;
		<li class="breadcrumb-item"> EWITS 2.0 Help & Resources</a></li>
		<li class="breadcrumb-item active" aria-current="page"><a href="#">EWITS 2.0 Job Aid Online Help File Uploader</a></li>
	  </ol>
	</nav>
</div>

<%
String fullDirPath = request.getRealPath(dir_root);
System.out.println("fullDirPath=" + fullDirPath);

File directory = new File(fullDirPath);
File[] list = directory.listFiles();
System.out.println("list=" + Integer.toString(list.length));

SimpleDateFormat formatDt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
NumberFormat numberFormat = NumberFormat.getInstance();
%>

<input type="text" id="txtHiddenForClipboard" name="txtHiddenForClipboard" value="" style="display:none;width:5px;"/>
<div class="container">
	<table class="table table-hover">
	  <thead>
		<tr>
		  <th scope="col">#</th>
		  <th scope="col">File Name</th>
		  <th scope="col">Date and Time</th>
		  <th scope="col">Size (KB)</th>
		  <th scope="col"> </th>
		</tr>
	  </thead>
	  <tbody>
<%
String fileName = null;
String extension = "";
int idx = 0;
for (int i=0; i<list.length; i++) {
	fileName = list[i].getName();
	if (!"uploader_main.jsp".equalsIgnoreCase(fileName)
		&& !"uploader_action.jsp".equalsIgnoreCase(fileName)) {
%>
			<tr>
			  <th scope="row"><%=++idx%></th>
			  <td><a id="idx_<%=i%>" href="./<%=list[i].getName()%>" target="new_<%=i%>"><%=list[i].getName()%></a></td>
			  <td><%=formatDt.format(list[i].lastModified())%></td>
			  <td><%=numberFormat.format(list[i].length() / 1024)%></td>
			  <td>
				<button type="button" class="btn btn-secondary far fa-copy" data-toggle="tooltip" data-placement="top" title="Copy URL" onclick="copyURL(<%=i%>);"></button>
			  </td>
			</tr>
<%
	}
}
%>
		</tbody>
	</table>
	
	<!--button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Move to top" onclick="$('html,body').scrollTop(0);">Move to top</button-->
	
</div>

<div class="container">
    <form action="uploader_action.jsp" method="post" enctype="multipart/form-data">
		<br/>
        <div>
			<input type="file" name="file1" size="50" accept=".html,.htm,.css,.jsp,.js" />
		</div>
        <div>
			<i class="fas fa-upload"></i> Click the Choose File button to upload your Job Aid Online Help file (html, htm, css, jsp, js):
		</div>
        <hr/>
        <div>
            <button type="submit" class="btn btn-primary">Upload</button>
            <button type="reset" class="btn btn-primary">Reset</button>
        </div>
    </form>	
</div>

</body>
</html>
