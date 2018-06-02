import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConn
{

	private static String jdbcDriver = null;
	private static String jdbcHost = null;
	private static String jdbcPort = null;
	private static String jdbcUrl = null;
	
	private static String dbUser;
	private static String dbPassword;

	public static void main(String args[])
	{
		String dbms = null;
		String dbid = null;   // SID or Service Name for oracle, Database Name for SQL Server 
		String dbinst = null; // Database Instance Name for SQL Server
		Connection conn = null;

		if (args == null || args.length < 5)
		{
			System.out.println("Usage:");
			System.out.println("\t JDBCConn <dbms> <db_host> <db_port> <db_id> <db_login> <db_pw>");
			System.out.println("\t <dbms> : Database Management System, e.g. oracle, sqlserver, mysql");
			System.out.println("\t <db_host> : Database Host (DNS name or IP address)");
			System.out.println("\t <db_port> : Database Port Number, e.g. 1521, 1433, 3306");
			System.out.println("\t <db_id> : Database Name.  For Oracle, SID or Service Name.");
			System.out.println("\t\t For Oracle, SID or Service Name.");
			System.out.println("\t\t\t To specify SID, start the string with \":\", e.g. :orcl");
			System.out.println("\t\t\t To specify Service Name, start the string with \"/\", e.g. /orcl.db.srv");
			System.out.println("\t\t For SQL Server or MySQL, Database Name.");
			System.out.println("\t <db_login> : Database User Login ID");
			System.out.println("\t <db_pw> : Database Password");
			return;
		}

		dbms        = args[0];
		jdbcHost    = args[1];
		jdbcPort    = args[2];
		dbid        = args[3];
		dbUser      = args[4];
		dbPassword  = args[5];

		//--------------------------------
		// JDBC Driver setting
		//--------------------------------
		if (dbms.equals("oracle"))
		{
			jdbcDriver = "oracle.jdbc.OracleDriver";
		}
		else if (dbms.equals("sqlserver"))
		{
			jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		}
		else if (dbms.equals("mysql"))
		{
			jdbcDriver = "com.mysql.jdbc.Driver";
		}

		//--------------------------------
		// JDBC URL setting
		//--------------------------------
		if (dbms.equals("oracle"))
		{
			// e.g. jdbc:oracle:thin:@dbhost:1521/dbsid
			jdbcUrl = "jdbc:oracle:thin:@" + jdbcHost;
			if (jdbcPort != null && jdbcPort.trim().length() > 0)
			{
				jdbcUrl += ":" + jdbcPort;
			}
			if (dbid.startsWith(":") || dbid.startsWith("/") )
			{
				jdbcUrl += dbid;  // SID starts with ":"  Service Name starts with "/"
			}
			else
			{
				jdbcUrl += ":" + dbid;  // SID assumed
			}
		}
		else if (dbms.equals("sqlserver"))
		{
			// e.g. jdbc:sqlserver://dbhost\dbinstance:1433;databaseName=dbname
			jdbcUrl = "jdbc:sqlserver://" + jdbcHost;
			if (dbinst != null && dbinst.trim().length() > 0)
			{
				jdbcUrl += "\\" + dbinst;
			}
			if (jdbcPort != null && jdbcPort.trim().length() > 0)
			{
				jdbcUrl += ":" + jdbcPort;
			}
			if (dbid != null && dbid.trim().length() > 0)
			{
				jdbcUrl += ";databaseName=" + dbid;
			}
		}
		else if (dbms.equals("mysql"))
		{
			// e.g. jdbc:mysql://dbhost:3306/dbname
			jdbcUrl = "jdbc:mysql://" + jdbcHost;
			if (jdbcPort != null && jdbcPort.trim().length() > 0)
			{
				jdbcUrl += ":" + jdbcPort;
			}
			if (dbid != null && dbid.trim().length() > 0)
			{
				jdbcUrl += "/" + dbid;
			}
		}


		//--------------------------------
		// JDBC Connection
		//--------------------------------
		try
		{
			Class.forName(jdbcDriver);
			System.out.println("JDBC driver registered: " + jdbcDriver);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
			System.out.println("CONNECTION SUCCESS!!!");
			conn.close();
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("JDBC Driver is not found.");
			cnfe.printStackTrace();
		}
		catch (SQLException se) {
			System.out.println("Connection Failed!!! JDBC URL = " + jdbcUrl);
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();;
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch (Exception e)
				{
					System.out.println("Exception while closing connection finally as cleanup effort.");
					e.printStackTrace();;
				}
			}
		}
	}

}