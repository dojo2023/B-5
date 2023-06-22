package test;
import dao.PhysicalsDAO;
import model.Physicals;
public class PhysicalsDAOTest {
    public static void main(String[] args) {
        PhysicalsDAO physiDao = new PhysicalsDAO();

        // テスト用のPhysicalsオブジェクトを作成
        int users_id = 1;
        int physicals_resistance = 3;
        int physicals_condition = 9;
        Physicals physicals = new Physicals(users_id, 0, physicals_resistance, physicals_condition, null, null);

        // Physicalsの更新を実行
        boolean updateSuccess = physiDao.updatePhysicals(physicals);

        if (updateSuccess) {
            System.out.println("Physicalsの更新に成功しました");
        } else {
            System.out.println("Physicalsの更新に失敗しました");
        }
    }
}

