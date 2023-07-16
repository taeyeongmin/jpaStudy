package com.example.jpa;

import com.example.jpa.shop.Item;
import com.example.jpa.shop.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

//            Member member = new Member(null,"member","1","1","1");
//            em.persist(member);
//
//            Item item = new Item(null,"item",member,100,1);
//            em.persist(item);

//            Member findMember =  em.find(Member.class,1L);
//            System.err.println(findMember);
            Item item = em.find(Item.class, 2L);
            System.err.println(item);



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
