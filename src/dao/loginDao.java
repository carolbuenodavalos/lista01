/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import model.loginModel;

public class loginDao implements loginInterface<loginModel> {
    private ConexaoBanco conexao;

    public loginDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void logar(loginModel login) {
       String sql = "INSERT INTO listaProdutos (idProduto, nomeProduto, descricao, preco,          quantidade) VALUES (?, ?, ?, ?, ?)";
    }
}

