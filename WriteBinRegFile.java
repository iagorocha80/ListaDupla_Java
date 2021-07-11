import java.io.*;

public class WriteBinRegFile {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("dados.txt"));
            String str = "", str1, str2;
            byte n_char;
            String Nome;
            byte dia;
            byte mes;
            char ano;
            int telefone;

            String[] TMP;

            FileOutputStream fpout = new FileOutputStream("teste.bin");
            // BufferedWriter out = new BufferedWriter(fpout);
            DataOutputStream out = new DataOutputStream(fpout);

            while ((str = in.readLine()) != null) {
                str1 = in.readLine();
                str2 = in.readLine();

                n_char = (byte) str.length();
                Nome = new String(str);
                TMP = str1.split("/");
                System.out.println(TMP.length);

                dia = (byte) Integer.parseInt(TMP[0]);
                mes = (byte) Integer.parseInt(TMP[1]);
                ano = (char) Integer.parseInt(TMP[2]);
                telefone = Integer.parseInt(str2);

                out.writeByte(n_char); // 1
                out.writeBytes(Nome); // 11
                out.writeByte(dia); // 1
                out.writeByte(mes); // 1
                out.writeChar(ano); // 2
                out.writeInt(telefone); // 4

                System.out.println(str);
            }

            // Quantos bytes terá o ficheiro binario????
            // em modo texto 11 bytes se fosse continuo e 15 se tiver o CR LF
            // no fim de cada linha (ou 13 com espaço)
            out.close();
            in.close();
        } catch (IOException e) {
            // poder-se-à detectar qual o tipo de excepção lançada pelo
            // JRE mas para o objectivo da AED....
            System.out.println("Problemas na abertura, leitura ou escrita. \n");
        }
    }
}