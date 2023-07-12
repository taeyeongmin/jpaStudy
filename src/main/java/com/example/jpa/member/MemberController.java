package com.example.jpa.member;

import com.example.jpa.member.vo.MemberEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;


@RestController
public class MemberController {

    @RequestMapping("/member")
    public void findMember(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        /******************/
//        MemberEntity memberEntity = em.find(MemberEntity.class, 1L);
        MemberEntity memberA = MemberEntity.builder().memberNo(4L).memberNm("멤버A").build();
        MemberEntity memberB = MemberEntity.builder().memberNo(5L).memberNm("멤버B").build();

        em.persist(memberA);
        em.persist(memberB);

        // 중간에 JPQL 실행
        TypedQuery<MemberEntity> query = em.createQuery("select m from MemberEntity m", MemberEntity.class);
        query.getResultList();

        System.err.println("====================================");
        /******************/
        et.commit();


        em.close();
        emf.close();

    }

}
