package test;

import dao.UsersDAO;
import model.Users;

public class UsersDAOTest {
    public static void main(String[] args) {
        testIsLoginOK();
    }

    private static void testIsLoginOK() {
        UsersDAO usersDAO = new UsersDAO();
        Users user1 = new Users(1, "yasuo", "yasuo", null, null, null);
        Users user2 = new Users(0, "nohope", "nohope", null, null, null);
        Users user3 = new Users(0, "impossible", "impsible", null, null, null);

        boolean result1 = usersDAO.isLoginOK(user1);
        boolean result2 = usersDAO.isLoginOK(user2);
        boolean result3 = usersDAO.isLoginOK(user3);

        System.out.println("Login Result for user1: " + result1);
        System.out.println("Login Result for user2: " + result2);
        System.out.println("Login Result for user3: " + result3);
    }
}
