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
		int op=0;
		float identidade;
		String dados[] = new String[7];
		String lixo;
		System.out.println("Bem vindo ao Sistema CENSO 2020 do IBGE!\n");
		System.out.println("Para come�ar, informe o nome do arquivo da base de dados: ");
		String arquivo = leitor.next();
		leitorArquivo.abrirArquivo(arquivo);
		manipulador.carregaDadosArquivo(leitorArquivo);
		boolean mostraMenu = true;
System.out.println("********** PAROU NO CASE 4 DO SWITCH **********");
		do {
			if(mostraMenu == true) {
			System.out.print("\n\t\t\tMENU DE OP��ES\n\n");
			System.out.print("\t\t1- Inserir dados de uma pessoa\n\t\t2- Inserir dados de diversas pessoas\n\t\t"
					+ "3- Pesquisar dados de uma pessoa\n\t\t4- Alterar dados de uma pesoa\n\t\t5- Excluir dados de uma pessoa\n\n"
					+ "Informe a op��o desejada: ");
			do {
				op = leitor.nextInt();
				lixo = leitor.nextLine();
				if (op < 1 || op > 5)
					System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 5: ");
			} while (op < 1 || op > 5);
			}
			switch(op){
			case 1:
				if(mostraMenu == true) {
					System.out.print("\nInforme os dados abaixo:\nIdentidade: ");
					do {
						dados[0] = String.valueOf(leitor.nextInt());
						lixo = leitor.nextLine();
						if (Integer.parseInt(dados[0]) <= 0)
							System.out.print("\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
					} while (Integer.parseInt(dados[0]) <= 0);
				}
				else {
					System.out.print("\nInforme os dados abaixo (para sair, escreva \"sair\"):\nIdentidade: ");
					do {
						dados[0] = leitor.nextLine();
						System.out.println(dados[0]);
						if(dados[0].equalsIgnoreCase("sair")) {
							mostraMenu = true;
							break;
						}
						else {
							if (Integer.parseInt(dados[0]) > 0)
								dados[0] = String.valueOf(dados[0]);
							else
								System.out.print("\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
						}
					} while (!dados[0].equalsIgnoreCase("sair") && Integer.parseInt(dados[0]) <= 0);
				}
				
				if(!dados[0].equalsIgnoreCase("sair") ) {
				if(manipulador.getArvore().pesquisar(Float.parseFloat(dados[0])) == null) {
				
				System.out.print("Nome completo: ");
				dados[1] = leitor.nextLine();
				
				System.out.print("Sexo ( m / f ): ");
				do {
					dados[2] = String.valueOf(leitor.next().charAt(0));
					if(!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M") && !dados[2].equalsIgnoreCase("f")
							&& !dados[2].equalsIgnoreCase("F"))
						System.out.print("\tInforma��o inv�lida. Informe novamente o sexo ( m / f ): ");
				} while (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M") && !dados[2].equalsIgnoreCase("f")
						&& !dados[2].equalsIgnoreCase("F"));
				
				System.out.print("Idade: ");
				do {
					dados[3] = String.valueOf(leitor.nextInt());
					lixo = leitor.nextLine();
					if(Integer.parseInt(dados[3]) < 0)
						System.out.print("\tInforma��o inv�lida. Informe novamente a idade (valor n�o nulo): ");
				} while (Integer.parseInt(dados[3]) < 0);
				
				System.out.print("Tipo de moradia (rural / urbana): ");
				do {
					dados[4] = leitor.nextLine();
					if(!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"))
						System.out.print("\tInforma��o inv�lida. Informe novamente o tipo de moradia (rural / urbana): ");
				} while (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"));
				
				System.out.print("Estado civil (solteiro / casado / divorciado / vi�vo): ");
				do {
					dados[5] = leitor.nextLine();
					if(!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
							&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
							&& !dados[5].equalsIgnoreCase("divorciado") && !dados[5].equalsIgnoreCase("divorciada")
							&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("viuvo")
							&& !dados[5].equalsIgnoreCase("vi�vo") && !dados[5].equalsIgnoreCase("vi�vo"))
						System.out.print("\tInforma��o inv�lida. Informe novamente o estado civil (solteiro / casado / divorciado /"
								+ " vi�vo): ");
				} while (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
						&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
						&& !dados[5].equalsIgnoreCase("divorciado") && !dados[5].equalsIgnoreCase("divorciada")
						&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("viuvo")
						&& !dados[5].equalsIgnoreCase("vi�vo") && !dados[5].equalsIgnoreCase("vi�vo"));
				
				System.out.print("Ra�a (parda / preta / branca / amarela / ind�gena): ");
				do {
					dados[6] = leitor.nextLine();
					if(!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
							&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
							&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
							&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
							&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
							&& !dados[6].equalsIgnoreCase("ind�gena") && !dados[6].equalsIgnoreCase("ind�geno"))
						System.out.print("\tInforma��o inv�lida. Informe novamente a ra�a (parda / preta / branca /"
								+ " amarela / ind�gena): ");
				} while (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
						&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
						&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
						&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
						&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
						&& !dados[6].equalsIgnoreCase("ind�gena") && !dados[6].equalsIgnoreCase("ind�geno"));
					manipulador.pessoaNova(dados);
				}
				else
					mostraMenu = true;
				}
				break;
			case 2:
				mostraMenu = false;
				op = 1;
				break;
			case 3:
				if (mostraMenu == true)
					System.out.print("Para pesquisa, informe a identidade: ");
				do {
					identidade = leitor.nextFloat();
					lixo = leitor.nextLine();
					if (identidade <= 0) {
						System.out.print("\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
					}
				} while (identidade <= 0);
				System.out.println(manipulador.getArvore().pesquisar(identidade));
				if (mostraMenu == false)
					op = 4;
				break;
			case 4:
				int opAtualizar;
				if (mostraMenu == true)
					System.out.print("Para atualiza��o de dados, informe a identidade para verificar os dados atuais: ");
				else {
				do{
					System.out.println("Os dados atualiz�veis s�o:\n\t\t1- Identidade\n\t\t2- Nome\n\t\t3- Sexo\n\t\t4- Idade\n\t\t"
						+ "5- Moradia\n\t\t6- Estado civil\n\t\t7- Ra�a\n\t\t8- Cancelar\nInforme a op��o desejada");
					do {
						opAtualizar = leitor.nextInt();
						lixo = leitor.nextLine();
						if (opAtualizar < 1 || opAtualizar > 8)
							System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 8: ");
					} while (opAtualizar < 1 || opAtualizar > 8);
				} while (opAtualizar != 8);
				switch(opAtualizar) {
				case 1:
					break;
				}
				}
					//Limpa a tela no windows, no linux e no MacOS, � claro que fica a discuss�o de n�s decidirmos
			        /*if (System.getProperty("os.name").contains("Windows"))
			            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			        else
			            Runtime.getRuntime().exec("clear");*/
					System.out.print("Insira o ID da pessoa a ser procurada: ");
					identidade = leitor.nextInt();
//					System.out.print("DADOS:\n" + PesquisarPessoa(identidade));
				break;
				case 8:
					System.out.print("Para a exlus�o, digite o ID da pessoa a ser procurada: ");
//					ID = leitor.nextInt();
//					RemoverPessoa(ID);
				break;
				case 9:
					System.out.print("Altera��o de dados, digite o ID da pessoa: ");
//					ID = leitor.nextInt();
//					AlterarPessoa(ID);
				break;
				case 5:
					System.out.print("\t\tRELAT�RIO POPULACIONAL\n");
//					RelatorioGeral(ID);
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
		} while(op != 7);
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
