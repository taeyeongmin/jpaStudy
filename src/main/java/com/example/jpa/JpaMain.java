package com.example.jpa;
import com.example.jpa.team.Member;
import com.example.jpa.team.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaInf");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 1. 팀 객체 생성
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // 2. 멤버 객체 생성 및 팀 객체 매핑
            Member member = new Member();
            member.setUserName("memberA");
            member.setTeam(team);
            em.persist(member);

            // 3. commit 전 쿼리 실행 및 영속성 컨텍스트 초기화
//            em.flush();
//            em.clear();

            // 3. 팀 객체 조회 => 팀은 1번에서 영속성 컨텍스트에 올라감(1차 캐시에 존재)
            Team findTeam = em.find(Team.class, team.getId());
            // 4. 팀 객체에서 매핑 되어 있는 회원들 조회
            List<Member> memberList = findTeam.getMemberList();

            System.out.println("=============================================");
            for(Member m : memberList){
                System.out.println("m2 = "+ m.getUserName());
            }
            System.out.println("=============================================");

            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

