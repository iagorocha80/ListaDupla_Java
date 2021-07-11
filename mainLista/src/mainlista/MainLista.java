/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlista;

/**
 *
 * @author Iago
 * 
 *  
    TP2 - AED
    Aluno: Iago Rocha Gomes
    Nº: 66453
*/
import listaDuplaPKG.*;
public class MainLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int seletor = 0,type;
        listaDupla L = new listaDupla();
        type= L.preencherLista(L);
        L.Mostra();
        listaDupla L2 = L.Maior18();
        listaDupla L3 = L.Menor18();
        switch (type){
            case 1:
                L.GravaBin(L, seletor);
                seletor++;
                L2.GravaBin(L2, seletor);
                seletor++;
                L3.GravaBin(L3, seletor);
                break;
            
            case 2:
                L.Grava(L, seletor);
                seletor++;
                L2.Grava(L2, seletor);
                seletor++;
                L3.Grava(L3, seletor);
                break;
        }
    }
    
}
