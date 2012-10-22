package com.whatever.tomcattest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	//DB INFO:
	//user: test
	//pass: 123qweASD
	//db name: tomcattestdb
	//table name: codetest
	//columns: id, user, text
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private String theResults = "";
	
	public void readDataBase() throws Exception {
		try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/tomcattestdb?" + "user=test&password=123qweASD");

	      // Statements allow to issue SQL queries to the database
	      statement = connect.createStatement();
	      // Result set get the result of the SQL query
	      resultSet = statement.executeQuery("SELECT * from tomcattestdb.codetest");
	      this.theResults = writeResultSet(resultSet);

	      // PreparedStatements can use variables and are more efficient
//	      preparedStatement = connect.prepareStatement("insert into  FEEDBACK.COMMENTS values (default, ?, ?)");
	      // "myuser, webpage, datum, summery, COMMENTS from FEEDBACK.COMMENTS");
	      // Parameters start with 1
//	      preparedStatement.setString(1, "Test Name");
//	      preparedStatement.setString(2, "Test Code");
//	      preparedStatement.executeUpdate();

//	      preparedStatement = connect.prepareStatement("SELECT * from tomcattestdb.codetest");
//	      resultSet = preparedStatement.executeQuery();
//	      writeResultSet(resultSet);

	      // Remove again the insert comment
//	      preparedStatement = connect
//	      .prepareStatement("delete from tomcattestdb.codetest where user= ? ; ");
//	      preparedStatement.setString(1, "rj");
//	      preparedStatement.executeUpdate();
	      
//	      resultSet = statement.executeQuery("SELECT * from tomcattestdb.codetest");
//	      writeMetaData(resultSet);
	      
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      close();
	    }

	  }
	
	private void writeMetaData(ResultSet resultSet) throws SQLException {
	    //   Now get some metadata from the database
	    // Result set get the result of the SQL query
	    
	    System.out.println("The columns in the table are: ");
	    
	    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
	    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
	      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
	    }
	  }
	
	private String writeResultSet(ResultSet resultSet) throws SQLException {
		String results = "";
		// ResultSet is initially before the first data set
	    while (resultSet.next()) {
	      // It is possible to get the columns via name
	      // also possible to get the columns via the column number
	      // which starts at 1
	      // e.g. resultSet.getSTring(2);
	      String user = resultSet.getString("user");
	      String text = resultSet.getString("text");
	      results += "<p>User: " + user + " | Text: " + text + "</p>\n";
	    }
	    return results;
	  }
	
	// You need to close the resultSet
	private void close() {
		try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }

	public String getTheResults() {
		return theResults;
	}

	public void setTheResults(String theResults) {
		this.theResults = theResults;
	}


}
