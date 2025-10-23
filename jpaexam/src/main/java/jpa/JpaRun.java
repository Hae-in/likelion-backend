package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaRun {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lionPU");// 대소문자구분함
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        // 입력
        User user = new User("goldbb", "goldbb@gmail.com");
        System.out.println("persis 전" + user);
        // user.setId(1L);

        // 현재 Use 라고 하는 엔티티는 아직 영속성 컨텍스트와는 관련 없다. (비영속)
        // entityManager.getTransaction();

        entityManager.persist(user); // 이 때 user 엔티티는 영속 상태가 됨
        System.out.println("persis 후" + user);

        // 조회



        System.out.println("commit 실행 전");
        entityManager.getTransaction().commit();
        System.out.println("commit 실행 후");


    }
}
