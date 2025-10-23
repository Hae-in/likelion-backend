package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*; // static import

public class UserJpaTest {
    private static EntityManagerFactory emf; // 전체에 하나
    private EntityManager em; // 테스트마다 하나
    private EntityTransaction tx;

    // 테스트 실행될때마다 EntityManagerFactory가 매번 생성될 필요가 있을까?
    @BeforeAll
    public static void setUpClass() {
        // persistence-unit 이름
        emf = Persistence.createEntityManagerFactory("lionPU");
    }
    @AfterAll
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }
    }

    // EntityManager는 전체 테스트에서 하나만 생성되면 될까? 테스트마다 생성되어야할까?
    @BeforeEach
    public void aetUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @AfterEach
    public void tearDown() {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        if (em != null) {
            em.close();
        }
    }

    @Test
    @DisplayName("Insert Test :: 성공하면 id 값이 존재함.")
    void insertUser() {
        User user = new User("admin", "admin@admin.com");
        em.persist(user);
        tx.commit(); // 트랜잭션 종료

        // Assertions.assertNotNull(user.getId()); // static import로 변경
        assertNotNull(user.getId(), "입력이 성공적으로 일어나면 id는 null이 아니어야 합니다."); // null이면 실패, !null이면 성공, 뒤에 메세지 입력 가능
        // assertNotNull(null, "입력이 성공적으로 일어나면 id는 null이 아니어야 합니다."); // null이면 실패, !null이면 성공
    }

    @Test
    void findId() {
        User user = new User("goldbb", "goldbb@test.com");
        em.persist(user);
        tx.commit(); // 실제 DB에 저장

        tx = em.getTransaction();
        tx.begin();

        User found = em.find(User.class, user.getId());
        User found2 = em.find(User.class, user.getId());

        assertSame(found, found2);
    }
}
