/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelProduto;

public class ProdutoDAO {
   
    DAO conect = new DAO();//instancia a instrução de conexão com o BD
    ModelProduto modprod = new ModelProduto(); // instancia o modelo de criação de produto
    
    public void save(ModelProduto modprod){ //este método salva todas as informações inseridas no frames no BD
        conect.conexao();
        
        try {
            PreparedStatement pst = conect.connection.prepareStatement("INSERT INTO tb_produto(cod_produto, descr_produto, cat_produto, forn_produto, custo_produto, venda_produto, unid_produto, estoquemin_produto, estoquemax_produto ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
      
            pst.setString(1, modprod.getCodBarProduto());
            pst.setString(2, modprod.getDescrProduto());
            pst.setString(3, modprod.getCatProduto());
            pst.setString(4, modprod.getFornecProduto());
            pst.setDouble(5, modprod.getCustoProduto());
            pst.setDouble(6, modprod.getCustoVendaProduto());
            pst.setString(7, modprod.getUnidMedida());
            pst.setDouble(8, modprod.getMinProduto());
            pst.setDouble(9, modprod.getMaxProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados: \n" + ex);
            
        }
        
        
        conect.desconecta();
    }
    
    /*public DAO buscaProduto(DAO mod){
        conect.conexao();
        conect.executaSQL("select * from tb_produto where descr_produto like '%"+mod.getPesquisa()+"%'");
        try {
            conect.rs.first();
            mod.setCodProduct(conect.rs.getInt("cod_produto"));
            mod.setDescProduct(conect.rs.getInt("descr_produto"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
