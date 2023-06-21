package test;

import dao.UsersDAO;

public class UsersDAOTest {
    public static void main(String[] args) {
        UsersDAO usersDAO = new UsersDAO();
        int maxUserID = usersDAO.getMaxUserID();
        System.out.println("Max UserID: " + maxUserID);
    }
}
