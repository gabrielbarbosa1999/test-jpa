package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

    public static void main(String[] args) {
        /*
        Pessoa p1 = new Pessoa(null, "Carlos da Silve", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaguim da Silve", "joaquin@gmail.com");
        Pessoa p3 = new Pessoa(null, "Mario da Silve", "mario@gmail.com");

         */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-JPA");
        EntityManager em = emf.createEntityManager();

        /* Busca a pessoa com id 2 no banco de dados
        Pessoa p = em.find(Pessoa.class, 1);
        System.out.println(p);
         */

        //Apagando um peessoa do banco de dados
        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, 2);
        em.remove(p);
        em.getTransaction().commit();


        //Inserindo as pessoas no banco de dados
        /*
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        System.out.println("Pronto!");
         */

        em.close();
        emf.close();
    }

}
