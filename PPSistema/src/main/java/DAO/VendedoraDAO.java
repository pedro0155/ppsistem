
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import usuario.Vendedora;

public class VendedoraDAO {
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PPSistemaPU");
        
        public Vendedora cadastrarVendedora(Vendedora ven){
            EntityManager em= emf.createEntityManager();
            Vendedora vendedora = new Vendedora(ven.getNomeVendedora());
            
            
            try{
                em.getTransaction().begin();
                em.persist(vendedora);
                em.getTransaction().commit();
                return vendedora;
            }catch (Exception e) {
                System.out.println("falha ao cadastrar vendedoras");
                return null;
               
            } finally {
            em.close();}
         
        }
        
}
