package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.cadastroProdutos;

/**
 * @author carol
 */
public class cadastroProdutoDao implements InterfaceProdutos<cadastroProdutos>{

    private ConexaoBanco conexao;

    public cadastroProdutoDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(cadastroProdutos cadastro) {
        // String com a consulta que será executada no banco
        String sql = "INSERT INTO listaProdutos (idProduto, nomeProduto, descricao, preco, quantidade) VALUES (?, ?, ?, ?, ?)";
        try {
            // Tenta realizar a conexão, se retornar verdadeiro entra no IF
            if (this.conexao.conectar()) {
                // Prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                // Substitui as interrogações da consulta pelo valor específico
                sentenca.setInt(1, cadastro.getIdProduto());
                sentenca.setString(2, cadastro.getNomeProduto());
                sentenca.setString(3, cadastro.getDescricao());
                sentenca.setFloat(4, cadastro.getPreco());
                sentenca.setInt(5, cadastro.getQuantidade());
                sentenca.execute(); // Executa o comando no banco
                sentenca.close(); // Fecha a sentença
                this.conexao.getConnection().close(); // Fecha a conexão com o banco
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(cadastroProdutos cadastro) {
    String sql = "UPDATE listaProdutos SET nomeProduto = ?, descricao = ?, preco = ?, quantidade = ? WHERE idProduto = ?";
    try {
        if (this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setString(1, cadastro.getNomeProduto());
            sentenca.setString(2, cadastro.getDescricao());
            sentenca.setFloat(3, cadastro.getPreco()); // Use setFloat aqui
            sentenca.setInt(4, cadastro.getQuantidade());
            sentenca.setInt(5, cadastro.getIdProduto()); // Não altere o ID
            sentenca.execute();
            sentenca.close();
            this.conexao.getConnection().close();
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    }

    @Override
    public void excluir() {
        String sql = "DELETE FROM listaProdutos";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

public void excluirID(int id) {
    String sql = "DELETE FROM listaProdutos WHERE idProduto = ?";
    try {
        if (this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setInt(1, id);
            sentenca.execute();
            sentenca.close();
            this.conexao.getConnection().close();
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}

     public ArrayList<cadastroProdutos> consultar() {
        
        ArrayList<cadastroProdutos> listaCadastros = new ArrayList<cadastroProdutos>();
        String sql = "SELECT c.idProduto, c.nomeProduto, c.descricao, c.preco, c.quantidade "+
                     "FROM listaProdutos as c "+ 
                     "ORDER BY c.idProduto ";
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    cadastroProdutos cadastro = new cadastroProdutos();
                    cadastro.setIdProduto(resultadoSentenca.getInt("idProduto"));
                    cadastro.setNomeProduto(resultadoSentenca.getString("nomeProduto"));
                    cadastro.setDescricao(resultadoSentenca.getString("descricao"));
                    cadastro.setPreco((float) resultadoSentenca.getDouble("preco"));
                    cadastro.setQuantidade(resultadoSentenca.getInt("quantidade"));
                    
                    listaCadastros.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaCadastros;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        } 
    }
}