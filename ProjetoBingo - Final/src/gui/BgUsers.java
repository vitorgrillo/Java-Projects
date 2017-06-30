/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Vitor Grillo
 */
@Entity
@Table(name = "bg_users", catalog = "bingo", schema = "")
@NamedQueries({
    @NamedQuery(name = "BgUsers.findAll", query = "SELECT b FROM BgUsers b")
    , @NamedQuery(name = "BgUsers.findByEmail", query = "SELECT b FROM BgUsers b WHERE b.email = :email")
    , @NamedQuery(name = "BgUsers.findByPrimeiraDataMes", query = "SELECT b FROM BgUsers b WHERE b.primeiraDataMes = :primeiraDataMes")
    , @NamedQuery(name = "BgUsers.findByQtdVitoriaMes", query = "SELECT b FROM BgUsers b WHERE b.qtdVitoriaMes = :qtdVitoriaMes")})
public class BgUsers implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "senha")
    private byte[] senha;
    @Basic(optional = false)
    @Column(name = "primeira_data_mes")
    @Temporal(TemporalType.DATE)
    private Date primeiraDataMes;
    @Basic(optional = false)
    @Column(name = "qtd_vitoria_mes")
    private long qtdVitoriaMes;

    public BgUsers() {
    }

    public BgUsers(String email) {
        this.email = email;
    }

    public BgUsers(String email, byte[] senha, Date primeiraDataMes, long qtdVitoriaMes) {
        this.email = email;
        this.senha = senha;
        this.primeiraDataMes = primeiraDataMes;
        this.qtdVitoriaMes = qtdVitoriaMes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public byte[] getSenha() {
        return senha;
    }

    public void setSenha(byte[] senha) {
        byte[] oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public Date getPrimeiraDataMes() {
        return primeiraDataMes;
    }

    public void setPrimeiraDataMes(Date primeiraDataMes) {
        Date oldPrimeiraDataMes = this.primeiraDataMes;
        this.primeiraDataMes = primeiraDataMes;
        changeSupport.firePropertyChange("primeiraDataMes", oldPrimeiraDataMes, primeiraDataMes);
    }

    public long getQtdVitoriaMes() {
        return qtdVitoriaMes;
    }

    public void setQtdVitoriaMes(long qtdVitoriaMes) {
        long oldQtdVitoriaMes = this.qtdVitoriaMes;
        this.qtdVitoriaMes = qtdVitoriaMes;
        changeSupport.firePropertyChange("qtdVitoriaMes", oldQtdVitoriaMes, qtdVitoriaMes);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BgUsers)) {
            return false;
        }
        BgUsers other = (BgUsers) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gui.BgUsers[ email=" + email + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
