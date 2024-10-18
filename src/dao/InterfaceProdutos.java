/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author carol
 */
public interface InterfaceProdutos<cadProdutos> {
    
    public void inserir(cadProdutos objt);
    
    public void alterar(cadProdutos objt);
    
    public void excluir();
    
    public ArrayList<cadProdutos> consultar();
    
}

