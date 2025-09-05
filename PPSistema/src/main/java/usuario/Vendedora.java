package usuario;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "vendedora")
public class Vendedora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nomeven")
    private String nomeVendedora;

    public Vendedora() {

    }
    
    

    public String getNomeVendedora() {
        return nomeVendedora;
    }

    public void setNomeVendedora(String nomeVendedora) {
        this.nomeVendedora = nomeVendedora;
    }

    public Vendedora(String nomeVendedora) {
        this.nomeVendedora = nomeVendedora;
    }

}
