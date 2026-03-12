/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consulta;

import java.util.Set;

/**
 *
 * @author Gab
 */
public class Adotantes {
    
    private int id;
    private String nome;
    private String senha;
    private String telefone;
    private String email;

     //metodos gets e sets
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public int getId() {
       return id;    }

    public void setId(int id) {
        this.id = id;    }
    
    public String getNome() {
       return nome;    }

    public void setNome(String nome) {
        this.nome = nome;    }
    
    
    public String getEmail() {
       return email;    }

    public void setEmail(String email) {
        this.email = email;    }
    
    public String getTelefone() {
       return telefone;    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;    }
    }
    
    
    

