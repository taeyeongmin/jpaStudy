package com.example.jpa;

import com.example.jpa.shop.Item;
import com.example.jpa.shop.Member;
import com.example.jpa.shop.Order;
import com.example.jpa.shop.OrderItem;

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

            Member findMember = em.find(Member.class, 3L);
            System.out.println("==================================");
            System.out.println(findMember.getOrders());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
