/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO {

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    private String driver = "org.postgressql.Driver"; //identifica o serviço de banco de dados
    private String caminho = "jdbc:postgresql://localhost:5434/db_storagecontrol"; //caminho do banco de dados
    private String usuario = "postgres"; //usuário do banco de dados
    private String senha = "1234"; //senha
    public Connection connection; //realiza conexão com banco de dados
    public ResultSet rs;
    private String pesquisa;
    
            
    public void conexao(){ //método responsável por realizar conexão com banco de dados
        try{
            System.setProperty("jdbc.Drivers", driver);
            connection = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados:\n"+ex.getMessage());
        }
    }
    
    public void executaSQL(String sql){
        try{
            java.sql.Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql);
        }catch (SQLException excecao){
            JOptionPane.showMessageDialog(null,"\nERRO NO COMANDO SQL!\nErro" + excecao + "" +
                 "\nCOMANDO SQL PASSADO" + sql);
        }
    
    }
    
    public void desconecta(){ //método responsável por realizar a desconexão com banco de dados
        try {
            connection.close();
            JOptionPane.showMessageDialog(null, "BD Desconectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao desconectar com BD \n!"+ex.getMessage());
        }
    }

    void setCodProduct(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDescProduct(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
