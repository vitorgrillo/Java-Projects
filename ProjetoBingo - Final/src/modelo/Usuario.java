/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * <h1>CLASSE USUARIO </h1>
 * Classe Usuario é responsável pela construção e instancia dos objetos referentes as informações de cadastro dos usuarios no sistema. 
 * @author Vitor Grillo, Lucas Trinquinato, Caio Souza.
 * @version 1.00
 * @since Release do projeto labirinto (PUC - CAMPINAS 2017).
 */

public class Usuario implements Serializable{
    String email;
    String senha;
    String nome;
    int qtd_vitoria;
    Calendar calendar = Calendar.getInstance();
    Date primeira_data = new Date(calendar.getTime().getTime());
    
     /**
     * <h2> Email do usuario </h2>
     * @return email Retorna o email cadastrado no form.
     */
    public String getEmail() {
        return email;
    }
    
      /**
     * Email do usuario
     * @param email é referente ao email cadastrado no form.
     */
    public void setEmail(String email) {
        this.email = email;
    }
     
    /**
     * <h2> Nome do usuario </h2>
     * @return nome Retorna o nome cadastrado no form.
     */
    public String getNome() {
        return nome;
    }
      /**
     * Nome do usuario
     * @param nome é referente ao nome cadastrado no form.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
     /**
     * <h2> Senha do usuario </h2>
     * @return senha Retorna a senha cadastrado no form.
     */
    public String getSenha() {
        return senha;
    }
    
     /**
     * Senha do usuario
     * @param senha é referente a senha cadastrada no form.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     /**
     * <h2> Data do Cadastro </h2>
     * @return Retorna a Data do sistema utilizando a biblitoteca Date do Java - Date(calendar.getTime().getTime());.
     */
    public Date getPrimeiraData(){
        return primeira_data;
    }
    
     /**
     * Data do Cadastro
     * @param primeira_data é referente a data do cadastro no jogo.
     */
    public final void setPrimeiraData(Date primeira_data){
        this.primeira_data = primeira_data;
    }
    
     /**
     * <h2> Quantidade de Vitórias no Jogo </h2>
     * @return qtd_vitoria Retorna a Quantidade de Vitórias atual do usuário.
     */
    public int getQtdVitoria() { 
        return qtd_vitoria;
    } 
    
     /**
     *  Quantidade de Vitórias no Jogo
     * @param qtd_vitoria é referente a quantidade de vitórias do usuário atualmente no jogo.
     */    
    public void setQtdVitoria(int qtd_vitoria) { 
        this.qtd_vitoria = qtd_vitoria;
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.senha);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + this.qtd_vitoria;
        hash = 97 * hash + Objects.hashCode(this.calendar);
        hash = 97 * hash + Objects.hashCode(this.primeira_data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.qtd_vitoria != other.qtd_vitoria) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.calendar, other.calendar)) {
            return false;
        }
        if (!Objects.equals(this.primeira_data, other.primeira_data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", senha=" + senha + ", nome=" + nome + ", qtd_vitoria=" + qtd_vitoria + ", calendar=" + calendar + ", primeira_data=" + primeira_data + '}';
    }
    
    

}