package controller;

import dao.VendedoraDAO;
import dao.UsuarioDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import usuario.*;

@Named("ctl")
@SessionScoped
public class Bean implements Serializable {

    public Bean() {
    }//construtor

    private String cpLogin;
    private String cpSenha;
    private String lbNome;
    private String lbFalhaLogin;
    private String cpNomeVendedora;
    
    public String btCadastroVendedora (ActionEvent ae){
        VendedoraDAO dao = new VendedoraDAO();
        
        Vendedora v = new Vendedora(cpNomeVendedora);
        
        dao.cadastrarVendedora(v);
        
        
        return null;
    }

    public String btLogin(ActionEvent ae) {
        System.out.println("tentando login com: " + cpLogin + " / " + cpSenha);

        UsuarioDAO dao = new UsuarioDAO();

        Usuario u = dao.buscarPorLoginSenha(cpLogin, cpSenha);
       
         if (u != null) {
            setLbNome(getCpLogin());
            setCpLogin("ok");
            System.out.println("Login Sucedido");

            return "principal";
        } else {
            setCpLogin("nop");
            setLbFalhaLogin("Login ou Senha Incorreto");
            return null; 
        }
    }

 
    
    public String getCpLogin() {
        return cpLogin;
    }

    public void setCpLogin(String cpLogin) {
        this.cpLogin = cpLogin;
    }

    public String getCpSenha() {
        return cpSenha;
    }

    public void setCpSenha(String cpSenha) {
        this.cpSenha = cpSenha;
    }

    public String getLbNome() {
        return lbNome;
    }

    public void setLbNome(String lbNome) {
        this.lbNome = lbNome;
    }

    public String getLbFalhaLogin() {
        return lbFalhaLogin;
    }

    public void setLbFalhaLogin(String lbFalhaLogin) {
        this.lbFalhaLogin = lbFalhaLogin;
    }

    public String getCpNomeVendedora() {
        return cpNomeVendedora;
    }

    public void setCpNomeVendedora(String cpNomeVendedora) {
        this.cpNomeVendedora = cpNomeVendedora;
    }

}
