package aplicacao;

import java.util.Scanner;

import classes.Pessoa;
import estruturaLista.EstruturaLista;
import manipulacaoArquivo.ArquivoTextoLeitura;
import manipulacaoDados.ManipulaDados;

public class SistemaIBGE {

	public static void main(String[] args) {
		ArquivoTextoLeitura leitorArquivo = new ArquivoTextoLeitura();
		ManipulaDados manipulador = new ManipulaDados();
		Scanner leitor = new Scanner(System.in);
		int op, ID=0;
		System.out.println("Bem vindo ao Sistema CENSO 2020 do IBGE!\n");
		System.out.println("Para come�ar, informe o nome do arquivo da base de dados: ");
		String arquivo = leitor.next();
		leitorArquivo.abrirArquivo(arquivo);
		manipulador.carregaDadosArquivo(leitorArquivo);
		do {
			System.out.print("\t\t\tMENU DE OP��ES\n\n");
			System.out.print("\t\t1- Pesquisar dado de uma pessoa\n\t\t2- Excluir dado de uma pessoa\n\t\t3- Alterar dados de uma pesoa\n");
			System.out.print("\t\t4- Inserir dados de uma pessoa\n\t\t5- Gerar relat�rio populacional\n\t\t6- Gerar relat�rio estat�stico\n");
			System.out.print("\t\t7- Sair do programa\n\n\n\tEscolha: ");
			op = leitor.nextInt();
			switch(op){
				case 1:
					//Limpa a tela no windows, no linux e no MacOS, � claro que fica a discuss�o de n�s decidirmos
			        /*if (System.getProperty("os.name").contains("Windows"))
			            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			        else
			            Runtime.getRuntime().exec("clear");*/
					System.out.print("Insira o ID da pessoa a ser procurada: ");
					ID = leitor.nextInt();
					System.out.print("DADOS:\n" + PesquisarPessoa(ID));
				break;
				case 2:
					System.out.print("Para a exlus�o, digite o ID da pessoa a ser procurada: ");
					ID = leitor.nextInt();
					RemoverPessoa(ID);
				break;
				case 3:
					System.out.print("Altera��o de dados, digite o ID da pessoa: ");
					ID = leitor.nextInt();
					AlterarPessoa(ID);
				break;
				case 4:
					System.out.print("Adicionar dados, digite o ID: ");
					ID = leitor.nextInt();
					AdicionarPessoa(ID);
				break;
				case 5:
					System.out.print("\t\tRELAT�RIO POPULACIONAL\n");
					RelatorioGeral(ID);
				break;
				case 6:
					System.out.print("\t\tRELAT�RIO ESTAT�STICO\n");
					RelatorioEstatistico();
				break;
				case 7:
					System.out.print("\t\t\n\nObrigado pela aten��o !\n\n");
				break;
				default:
					System.out.print("\t\t*** Op��o digitada est� incorreta! ***\n\n: ");
				break;
			}
		}while(op != 7);
	}

	private static void RelatorioEstatistico() {
		// TODO Auto-generated method stub
		
	}

	private static void RelatorioGeral(int iD) {
		// TODO Auto-generated method stub
		
	}

	private static void AdicionarPessoa(int iD) {
		// TODO Auto-generated method stub
		
	}

	private static void AlterarPessoa(int iD) {
		// TODO Auto-generated method stub
		
	}

	private static void RemoverPessoa(int iD) {
		// TODO Auto-generated method stub
		
	}

	private static String PesquisarPessoa(int iD) {
		// TODO Auto-generated method stub
		return null;
	}
}
