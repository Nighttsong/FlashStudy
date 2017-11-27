package com.flashCard.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.flashCard.model.FlashCard;
import com.flashCard.model.FlashCardSet;
import com.flashCard.model.User;

public class FlashcardDaoImpl {
	// Should have all database calls related to Flashcards

	public void addCreateFlashcard(FlashCardSet input, String useer) {
		String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
		String dbUserName = "newremoteuser";
		String dbPassword = "password";
		Connection conn = null;

		// This is where the sql call goes
		// we have flashcard we wish to add...
		List<FlashCard> toInput = input.getFlashcards();
		String categore = input.getCat();
		String name = input.getName();
		ResultSet rs = null;
		// we need to check if set exists or not
		// call database with the SQL of:
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(dbName, dbUserName, dbPassword);
			System.out.println("Database connection established");
			String SQLCheckExist = "SELECT * FROM Flashcards WHERE FLASHCARD_SET_NAME = '" + name + "' AND USER_NAME = '" + useer +"';";
			PreparedStatement preparedStatement = conn.prepareStatement(SQLCheckExist);
			rs = preparedStatement.executeQuery();

			// check to see if rs has things or not
			int setNumber = rs.getInt(0);

			if (setNumber == 0) { // if no we create a brand new one
				String SQLInsert0th = "INSERT INTO Flashcards (FLASHCARD_SET_NAME, FRONT_DATA, BACK_DATA, USER_NAME, IS_PRIVATE) VALUES ("
						+"'" + name + "', '" + toInput.get(0).getFront() + "', '"
						+ toInput.get(0).getBack() + "', '" + useer + "', '" + input.getPrivacy() + "');";
				preparedStatement = conn.prepareStatement(SQLInsert0th);
				preparedStatement.execute();
				
				//now we need to find the set number of the just created set
				SQLCheckExist = "SELECT * FROM Flashcards WHERE FLASHCARD_SET_NAME = '" + name + "' AND USER_NAME = '" + useer +"';";
				PreparedStatement preparedStatement2 = conn.prepareStatement(SQLCheckExist);
				rs = preparedStatement2.executeQuery();
				
				setNumber = rs.getInt(0);
				
				for( int i=1; i< toInput.size();i++) {
					String SQLInsert = "INSERT INTO Flashcards (FLASHCARD_SET_NBR, FLASHCARD_SET_NAME, FRONT_DATA, BACK_DATA, USER_NAME, IS_PRIVATE) VALUES ("
							+ setNumber + ", '" + name + "', '" + toInput.get(i).getFront() + "', '"
							+ toInput.get(i).getBack() + "', '" + useer + "', '" + input.getPrivacy() + "');";
					preparedStatement = conn.prepareStatement(SQLInsert);
					preparedStatement.execute();
				}
				
			} else { // if yes, we need to add to it
				for (int i = 0; i < toInput.size(); i++) {

					String SQLInsert = "INSERT INTO Flashcards (FLASHCARD_SET_NBR, FLASHCARD_SET_NAME, FRONT_DATA, BACK_DATA, USER_NAME, IS_PRIVATE) VALUES ("
							+ setNumber + ", '" + name + "', '" + toInput.get(i).getFront() + "', '"
							+ toInput.get(i).getBack() + "', '" + useer + "', '" + input.getPrivacy() + "');";
					preparedStatement = conn.prepareStatement(SQLInsert);
					preparedStatement.execute();

				}

				// we may need to change privacy if it exists
				String SQLUpdate = "UPDATE Flashcards SET IS_PRIVATE ='"+ input.getPrivacy()+"' WHERE FLASHCARD_SET_NBR = " +setNumber+";";
				preparedStatement = conn.prepareStatement(SQLUpdate);
				preparedStatement.execute();
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// shut it down
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
