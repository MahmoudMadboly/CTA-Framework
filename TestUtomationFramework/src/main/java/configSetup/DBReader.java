package configSetup;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBReader extends FileBase{

	private Connection connection;

	private Statement statement;



	public DBReader(String filePath, String userName, String password) {


		// here filePath = JDBC connection URL
		super(filePath);	



	}


	@Override
	public void loadFile() {}





	public void connectDB(String userName , String password) {

		try {

			//connect the data base
			connection = DriverManager.getConnection(filePath, userName, password);

			statement = connection.createStatement();


		}catch(Exception e) {

			e.printStackTrace();

		}
	}


	public ResultSet executeQuery(String query) {


		try {

			return statement.executeQuery(query);

		}catch(Exception e) {

			e.printStackTrace();

			return null;

		}
	}



	public int executeUpdate(String query) {


		try {

			return statement.executeUpdate(query);

		}catch(Exception e) {

			e.printStackTrace();

			return 0;

		}
	}


	public void closeConnection() {


		try {


			if(statement != null)
				statement.close();



			if(connection != null)
				connection.close();


		}catch(Exception e) {

			e.printStackTrace();

		}
	}
}