/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;

/**
 *
 * @author Fabio
 */
public class DAOMedico {
    ConexaoBD conex = new ConexaoBD();
    BeansMedico modelo = new BeansMedico();
    
    public void Salvar (BeansMedico modelo){
    
    conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos (nome_medico,crm_medico,profissao_medico,especialidade_medico) values (?,?,?,?)");
            
            pst.setString(1,modelo.getNome());
            pst.setInt(2,modelo.getCrm());
            pst.setString(3,modelo.getProfissao());
            pst.setString(4,modelo.getEspecialidade());
            pst.execute();
            JOptionPane.showMessageDialog(null,"DADOS INSERIDOS COM SUCESSO");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO AO INSERIR OS DADOS\n" + ex);
        }
        
    
    conex.desconectar();
            }
    
    
    public void Editar (BeansMedico mod){
    conex.conexao();
        try {
            PreparedStatement pst;
        pst = conex.con.prepareStatement("update medicos set nome_medico=?,crm_medico=?,profissao_medico=?,especialidade_medico=? where cod_medico=?");
            pst.setString(1,mod.getNome());
            pst.setInt(2,mod.getCrm());
            pst.setString(3,mod.getProfissao());
            pst.setString(4,mod.getEspecialidade());
            pst.setInt(5,mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"DADOS ALTERADOS COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO AO ALTERAR OS DADOS\n" + ex);
        }
    conex.desconectar();
    }
    
    public BeansMedico buscaMedico (BeansMedico mod){
        conex.conexao();
        conex.executaSql("select * from medicos where nome_medico like '%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_medico"));
            mod.setNome(conex.rs.getString("nome_medico"));
            mod.setCrm(conex.rs.getInt("crm_medico"));
            mod.setProfissao(conex.rs.getString("profissao_medico"));
            mod.setEspecialidade(conex.rs.getString("especialidade_medico"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não cadastrado\n");
        }
        
        conex.desconectar();
        return mod;
    }
    
}
