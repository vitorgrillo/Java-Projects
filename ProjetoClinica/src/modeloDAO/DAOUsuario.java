package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;
import modeloBeans.BeansUsuario;
import modeloConection.ConexaoBD;

public class DAOUsuario {

    ConexaoBD conex = new ConexaoBD();
    BeansUsuario modelo = new BeansUsuario();

    public void Salvar(BeansUsuario modelo) {

        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into usuarios (nome_usuario,login_usuario,senha_usuario,tipo_usuario) values (?,?,?,?)");

            pst.setString(1, modelo.getNomeUsuario());
            pst.setString(2, modelo.getLoginUsuario());
            pst.setString(3, modelo.getSenhaUsuario());
            pst.setString(4, modelo.getTipoUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "USUÁRIO INSERIDO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR USUÁRIO\n" + ex);
        }

        conex.desconectar();
    }

    public void Alterar(BeansUsuario mod) {
        conex.conexao();
        try {
            PreparedStatement pst;
            pst = conex.con.prepareStatement("update usuarios set nome_usuario=?,login_usuario=?,senha_usuario=?,tipo_usuario=? where cod_usuario=?");
            pst.setString(1, mod.getNomeUsuario());
            pst.setString(2, mod.getLoginUsuario());
            pst.setString(3, mod.getSenhaUsuario());
            pst.setString(4, mod.getTipoUsuario());
            pst.setInt(5, mod.getCodUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "USUARIO ALTERADO COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR OS DADOS DO USUÁRIO\n" + ex);
        }
        conex.desconectar();
    }

    public BeansUsuario buscaUsuario(BeansUsuario mod) {
        conex.conexao();
        conex.executaSql("select * from usuarios where nome_usuario like '%" + mod.getPesquisaUsuario() + "%'");
        try {
            conex.rs.first();
            mod.setCodUsuario(conex.rs.getInt("cod_usuario"));
            mod.setNomeUsuario(conex.rs.getString("nome_usuario"));
            mod.setLoginUsuario(conex.rs.getString("login_usuario"));
            mod.setSenhaUsuario(conex.rs.getString("senha_usuario"));
            mod.setTipoUsuario(conex.rs.getString("tipo_usuario"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado\n");
        }

        conex.desconectar();
        return mod;
    }

    public void Excluir(BeansUsuario mod) {
        conex.conexao();
        
        try{
            PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where cod_usuario=?");
            pst.setInt(1,mod.getCodUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso");       
        }catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao excluir o usuário\nErro:" + ex);
        }

    }

}
