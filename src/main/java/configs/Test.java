package configs;

import entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Test {
    public static void main(String[] args) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        String cateid = "5";
        Category category = enma.find(Category.class, cateid);
        try {
            trans.begin();
            // Gọi phương thức để insert, update, delete
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }

        //System.out.println(category);
    }


}
