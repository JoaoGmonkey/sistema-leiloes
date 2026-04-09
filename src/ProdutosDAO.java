/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
public void cadastrarProduto(ProdutosDTO produto){
    String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());

        prep.execute();
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
    }
}
    
public ArrayList<ProdutosDTO> listarProdutos(){
    String sql = "SELECT * FROM produtos";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        resultset = prep.executeQuery();

        while(resultset.next()){
            ProdutosDTO obj = new ProdutosDTO();

            obj.setId(resultset.getInt("id"));
            obj.setNome(resultset.getString("nome"));
            obj.setValor(resultset.getInt("valor"));
            obj.setStatus(resultset.getString("status"));

            listagem.add(obj);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
    }

    return listagem;
}
    
    
    
        // teste git
}

