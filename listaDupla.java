/* 
TP2 - AED
Aluno: Iago Rocha Gomes
Nº: 66453
*/

import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.text.*;

class REG {
    // Tipo abstrato que será utilizado para por os registos na fila
    String Nome;
    int dia;
    int mes;
    int ano;
    int telefone;
    REG prox;
    REG ant;

    REG(String nom, int d, int m, int an, int telef) {
        // construtor da classe REG
        Nome = nom;
        dia = d;
        mes = m;
        ano = an;
        telefone = telef;
        prox = null;
        ant = null;
    }
}

public class listaDupla {
    // Definição do tipo lista dupla
    REG Esq;
    REG Direita;

    listaDupla() {
        // Construtor da lista
        Esq = null;
        Direita = null;
    }

    int preencherLista(listaDupla List) {
        // metodo que realiza a leitura de um csv ou binario e preenche a lista com base nos dados 
        //nele contidos
        int tipo = 0;
        String ext = "";
        int index;
        String nom_fich;
        String fich="";
        BufferedReader br = null;
        String linha = "";
        String fichSplitBy = ".";
        String cvsSplitBy = ";";
        String binario = "bin";
        String csv = "csv";
        String texto = "txt";

        try {
            System.out.print("Nome do ficheiro que sera lido: ");
            Scanner in = new Scanner(System.in);
            nom_fich = in.nextLine();
            in.close();
            fich=nom_fich;
            index = fich.lastIndexOf(fichSplitBy);
            if(index > 0) {
                ext = fich.substring(index + 1);
                
              }

            if (ext.equals(binario)) {
                tipo = 1;
                
            }
            if (ext.equals(csv) || ext.equals(texto)) {
                tipo=2;
            }
            
            if(tipo == 1){
                try {
                    FileInputStream fpin = new FileInputStream (nom_fich);
                    DataInputStream Din = new DataInputStream (fpin);
                    byte n_char;
                    byte [] Nome;
                    int dia;
                    int mes;
                    int ano;
                    int telefone;
                    
                    while((Din.available()) > 0){
                        n_char= Din.readByte();
                        Nome = new byte[n_char];
                        int a=Din.read(Nome, 0, n_char);
                        String aux=new String(Nome);
        
                        dia=Din.readInt();
                        mes=Din.readInt();
                        ano=Din.readInt();
                        telefone=Din.readInt();

                        List.ColocaElementoDirLista(aux, dia, mes, ano, telefone);
                    }
                    
                    Din.close();
                }catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Problemas na abertura, leitura ou escrita. \n");
                }

            }

            if (tipo == 2) {
                String Nome;
                int dia;
                int mes;
                int ano;
                int telefone;

                br = new BufferedReader(new FileReader(nom_fich));
                while ((linha = br.readLine()) != null) {

                    String[] registo = linha.split(cvsSplitBy);
                    Nome = registo[0];
                    dia = Integer.parseInt(registo[1]);
                    mes = Integer.parseInt(registo[2]);
                    ano = Integer.parseInt(registo[3]);
                    telefone = Integer.parseInt(registo[4]);
                    List.ColocaElementoDirLista(Nome, dia, mes, ano, telefone);
                }
            }
            

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problemas na abertura, leitura ou escrita. \n");
        }
        return tipo;
    }

    void ColocaElementoEsqLista(String n, int d, int m, int a, int t) {
        // Metodo que põe os elementos na esquerda da lista
        REG aux = new REG(n, d, m, a, t);
        aux.prox = Esq;
        if (Esq != null) {
            Esq.ant = aux;
        }
        Esq = aux;
        if (Esq != null && Direita == null) {
            Direita = Esq;
        }

    }

    void ColocaElementoDirLista(String n, int d, int m, int a, int t) {
        // Metodo que põe os elementos na direita da lista
        REG aux = new REG(n, d, m, a, t);
        aux.ant = Direita;
        if (Direita != null) {
            Direita.prox = aux;
        }
        Direita = aux;
        if (Direita != null && Esq == null) {
            Esq = Direita;
        }
    }

    void Mostra() {
        // Metodo que exibe a lista
        REG w = Esq;
        System.out.println(" ");
        System.out.println("Nome: \t Data de Nascimento: \t Telefone:");
        while (w != null) {
            System.out.print(w.Nome);
            System.out.print("\t");
            System.out.print(w.dia);
            System.out.print("/");
            System.out.print(w.mes);
            System.out.print("/");
            System.out.print(w.ano);
            System.out.print("\t");
            System.out.println(w.telefone);
            w = w.prox;
        }

    }

    void GravaBin(listaDupla List, int s){
        // Metodo que grava a lista para bin
        String nom_fich;
        try{
            if (s == 0) {
                nom_fich = "Lista.bin";
            } else if (s == 1) {
                nom_fich = "Maiores_que_18.bin";
            } else {
                nom_fich = "Menores_que_18.bin";
            }

            FileOutputStream fpout = new FileOutputStream(nom_fich);
            DataOutputStream out = new DataOutputStream(fpout);
            REG w = Esq;
            byte n_char;
            String name;
            int d;
            int m;
            int a;
            int t;
            String str = "";
            while (w != null) {
                str=w.Nome;
                n_char = (byte) str.length();
                name = new String(str);
                d = w.dia;
                m = w.mes;
                a = w.ano;
                t = w.telefone;

                out.writeByte(n_char);
                out.writeBytes(name); 
                out.writeInt(d); 
                out.writeInt(m); 
                out.writeInt(a); 
                out.writeInt(t); 
                w = w.prox;
            }
            out.close();


        }catch (IOException e) {
            System.out.println("Problemas na abertura, leitura ou escrita. \n");
        }
        
    }

    void Grava(listaDupla List, int s) {
        // Metodo que grava a lista para csv
        String nom_fich;
        try {
            if (s == 0) {
                nom_fich = "Lista.csv";
            } else if (s == 1) {
                nom_fich = "Maiores_que_18.csv";
            } else {
                nom_fich = "Menores_que_18.csv";
            }
            FileWriter fpout = new FileWriter(nom_fich);
            REG w = Esq;
            String d;
            String m;
            String a;
            String t;

            while (w != null) {
                fpout.write(w.Nome);
                fpout.write(";");
                d = String.valueOf(w.dia);
                fpout.write(d);
                fpout.write(";");
                m = String.valueOf(w.mes);
                fpout.write(m);
                fpout.write(";");
                a = String.valueOf(w.ano);
                fpout.write(a);
                fpout.write(";");
                t = String.valueOf(w.telefone);
                fpout.write(t);
                fpout.write("\n");
                w = w.prox;
            }
            fpout.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problemas na abertura ou leitura \n");
        }

    }

    boolean deltaData(int ano, int mes, int dia){
        boolean maior=false;
        String nascimento= String.valueOf(mes) + "/" + String.valueOf(dia) + "/" + String.valueOf(ano);

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date date = new Date();
            Date firstDate = sdf.parse(nascimento);
            Date secondDate = date;
            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if(diff >= (18*365)){
                maior=true;
            }
        }catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Problemas na conversão de datas \n");
        }
        
        
        return maior;
    }

    listaDupla Maior18() {
        // metodo que seleciona aqueles que tem idade maior ou igual a 18 na lista e os
        // coloca em outra lista
        listaDupla Lista2 = new listaDupla();
        REG w = Esq;
        boolean m18;
        while (w != null) {
            m18 = deltaData(w.ano, w.mes, w.dia);
            if (m18) {
                Lista2.ColocaElementoDirLista(w.Nome, w.dia, w.mes, w.ano, w.telefone);
            }
            w = w.prox;
        }
        return Lista2;
    }

    listaDupla Menor18() {
        // metodo que seleciona aqueles que tem inferior a 18 na lista e os coloca em
        // uma outra lista
        listaDupla Lista3 = new listaDupla();
        REG w = Esq;
        boolean m18;
        while (w != null) {
            m18 = deltaData(w.ano, w.mes, w.dia);
            if (m18 == false) {
                Lista3.ColocaElementoDirLista(w.Nome, w.dia, w.mes, w.ano, w.telefone);
            }
            w = w.prox;
        }
        return Lista3;
    }

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
