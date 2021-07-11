import java.io.*;
public class ReadBinRegFile {
public static void main(String[] args){
		try {
			//FileReader fpin=new FileReader("teste.bin");
			FileInputStream fpin = new FileInputStream ("Maiores_que_18.bin");
			//BufferedReader in = new BufferedReader(fpin);
			DataInputStream in = new DataInputStream (fpin);
			byte n_char;
			byte [] Nome;
			int dia;
			int mes;
			int ano;
			int telefone;
			while ((n_char= in.readByte()) != -1) {
				System.out.println(n_char);
				
				Nome = new byte[n_char];
				int a=in.read(Nome, 0, n_char);
				String aux=new String(Nome);
				System.out.println(aux);

				dia=in.readInt();
				System.out.println(dia);
				mes=in.readInt();
				System.out.println(mes);
				ano=in.readInt();
				System.out.println(ano);

				telefone=in.readInt();
				System.out.println(telefone);
			}

			in.close();
		}catch (IOException ignore) {
			// poder-se-à detectar qual o tipo de excepção lançada pelo JRE
            // mas para o objectivo da AED....
            //e.printStackTrace();
			System.out.println("\n");
		}
	}
}