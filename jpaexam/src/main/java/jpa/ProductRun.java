package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductRun {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lionPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Product product = new Product("pencil", 100);
            Product product2 = new Product("bag", 200);
            Product product3 = new Product("keyboard", 300);

            em.persist(product);
            em.persist(product2);
            em.persist(product3);

            Product updatedProduct = em.find(Product.class, product.getId());
            updatedProduct.setPrice(400);

            Product deletedProduct = em.find(Product.class, product2.getId());
            em.remove(deletedProduct);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}