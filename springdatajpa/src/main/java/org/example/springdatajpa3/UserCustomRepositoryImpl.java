package org.example.springdatajpa3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @Override
    public void lionCustome() {
        System.out.println("lionCustome");
    }

    private final EntityManager entityManager;

    // jpql을 통해서 쿼리를 생성
    // CriteriaBuilder를 이용해서 쿼리를 생성하고, 이 쿼리를 entityManager를 통해서 실행
    @Override
    public List<User> findByUserName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> user = query.from(User.class);

        // select u from User u where u.name = name;
        query.select(user).where(builder.like(user.get("name"), "%" + name + "%"));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<User> findUserDynamically(String name, String email) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> user = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();
        if (name != null) { // 검색 조건으로 name이 들어옴
            // predicates.add(builder.equal(user.get("name"), name));
            predicates.add(builder.like(user.get("name"), "%" + name + "%")); // like 검색
        }
        if (email != null) {
            predicates.add(builder.equal(user.get("email"), email));
        }

        // 사용자가 입력한 값에 따라서 쿼리가 동적으로 생성
        query.select(user).where(builder.and(predicates.toArray(new Predicate[0])));
        // name = null, email = null => select u from User u;
        // name != null, email = null => select u from User u where u.name = name;
        // name = null, email != null => select u from User u where u.email = email;
        // name != null, email != null => select u from User u where u.name = name and u.email = email;

        // query.select(user).where(builder.or(predicates.toArray(new Predicate[0])));
        // name != null, email != null => select u from User u where u.name = name or u.email = email;

        return entityManager.createQuery(query).getResultList();
    }
}
