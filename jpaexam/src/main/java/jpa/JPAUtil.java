package jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // 싱글톤 인스턴스
    private static final EntityManagerFactory emfInstance =
            // Persistence.createEntityManagerFactory("UserPU");
            Persistence.createEntityManagerFactory("lionPU");

    // JVM 종료 시 emfInstance 자동 close
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { // 리소스 정리에 유용 (DB 연결 종료, 파일 닫기 등)
            if (emfInstance != null) {
                System.out.println("---- EntityManagerFactory 종료 ---");
                emfInstance.close();
            }
        }));
    }

    // 외부 인스턴스 생성 방지
    private JPAUtil() {}

    // EntityManagerFactory 반환
    public static EntityManagerFactory getEntityManagerFactory() {
        return emfInstance;
    }
}
