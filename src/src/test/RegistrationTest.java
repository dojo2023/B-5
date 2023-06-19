package test;

import dao.UsersDAO;
import model.Users;

public class RegistrationTest {
public static void main(String[] args) {
// Create a new Users object with the registration data
Users user = new Users();
user.setUsers_name("yasuo2");
user.setUsers_password("yasuo2");
user.setUsers_birthday("19971118");
// Create a new instance of the UsersDAO
UsersDAO usersDAO = new UsersDAO();

// Call the InsertUser method to insert the new user into the database
boolean registrationSuccess = usersDAO.InsertUser(user);

if (registrationSuccess) {
    System.out.println("Registration successful. User added to the database.");
} else {
    System.out.println("Registration failed. User not added to the database.");
}
}
}
