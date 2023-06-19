package test;

import dao.UsersDAO;

public class UsersDAOTest {
    public static void main(String[] args) {
        testIsLoginOK();
    }

    private static void testIsLoginOK() {
		UsersDAO iDao = new UsersDAO();
		int users_id1 = iDao.getUserID("users_name", "users_password");
		int users_id2 = iDao.getUserID("yasuo2", "yasuo2");




        System.out.println("Login Result for user1: " + users_id1);
        System.out.println("Login Result for user2: " + users_id2);
    }
}
