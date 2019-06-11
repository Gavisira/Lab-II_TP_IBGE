package aplicacao;

import java.util.Scanner;

import manipulacaoArquivo.ArquivoTextoLeitura;
import manipulacaoDados.ManipulaDados;

public class SistemaIBGE {

	public static void main(String[] args) {
		ArquivoTextoLeitura leitorArquivo = new ArquivoTextoLeitura();
		ManipulaDados manipulador = new ManipulaDados();
		Scanner leitor = new Scanner(System.in);
		int op = 0;
		float identidade = 0;
		String dados[] = new String[7];
		String lixo;
		System.out.println("Bem vindo ao Sistema CENSO 2020 do IBGE!\n");
		System.out.println("Para come�ar, informe o nome do arquivo da base de dados: ");
		String arquivo = leitor.next();
		leitorArquivo.abrirArquivo(arquivo);
		manipulador.carregaDadosArquivo(leitorArquivo);
		boolean mostraMenu = true;
		System.out.println("********** PAROU NO SWITCH CASE 4 FUNCIONANDO. AGORA � FAZER CASE 5 EM DIANTE **********");
		do {
			if (mostraMenu == true) {
				System.out.print("\n\t\t\tMENU DE OP��ES\n\n");
				System.out.print("\t\t1- Inserir dados de uma pessoa\n\t\t2- Inserir dados de diversas pessoas\n\t\t"
						+ "3- Pesquisar dados de uma pessoa\n\t\t4- Alterar dados de uma pesoa\n\t\t5- Excluir dados de uma pessoa\n\t\t"
						+ "6- Consultar relat�rios\n\nInforme a op��o desejada: ");
				do {
					op = leitor.nextInt();
					lixo = leitor.nextLine();
					if (op < 1 || op > 5)
						System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 5: ");
				} while (op < 1 || op > 5);
			}
			switch (op) {
			case 1:
				if (mostraMenu == true) {
					System.out.print("\nInforme os dados abaixo:\nIdentidade: ");
					do {
						dados[0] = String.valueOf(leitor.nextFloat());
						lixo = leitor.nextLine();
						if (Float.parseFloat(dados[0]) <= 0)
							System.out.print(
									"\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
					} while (Float.parseFloat(dados[0]) <= 0);
				} else {
					System.out.print("\nInforme os dados abaixo (para sair, escreva \"sair\"):\nIdentidade: ");
					do {
						dados[0] = leitor.nextLine();
						System.out.println(dados[0]);
						if (dados[0].equalsIgnoreCase("sair")) {
							mostraMenu = true;
							break;
						} else {
							if (Float.parseFloat(dados[0]) > 0)
								dados[0] = String.valueOf(dados[0]);
							else
								System.out.print(
										"\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
						}
					} while (!dados[0].equalsIgnoreCase("sair") && Float.parseFloat(dados[0]) <= 0);
				}

				if (!dados[0].equalsIgnoreCase("sair")) {
					if (manipulador.getArvore().pesquisar(Float.parseFloat(dados[0])) == null) {

						System.out.print("Nome completo: ");
						dados[1] = leitor.nextLine();

						System.out.print("Sexo ( m / f ): ");
						do {
							dados[2] = String.valueOf(leitor.next().charAt(0));
							if (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M")
									&& !dados[2].equalsIgnoreCase("f") && !dados[2].equalsIgnoreCase("F"))
								System.out.print("\tInforma��o inv�lida. Informe novamente o sexo ( m / f ): ");
						} while (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M")
								&& !dados[2].equalsIgnoreCase("f") && !dados[2].equalsIgnoreCase("F"));

						System.out.print("Idade: ");
						do {
							dados[3] = String.valueOf(leitor.nextInt());
							lixo = leitor.nextLine();
							if (Integer.parseInt(dados[3]) < 0)
								System.out.print("\tInforma��o inv�lida. Informe novamente a idade (valor n�o nulo): ");
						} while (Integer.parseInt(dados[3]) < 0);

						System.out.print("Tipo de moradia (rural / urbana): ");
						do {
							dados[4] = leitor.nextLine();
							if (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"))
								System.out.print(
										"\tInforma��o inv�lida. Informe novamente o tipo de moradia (rural / urbana): ");
						} while (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"));

						System.out.print("Estado civil (solteiro / casado / divorciado / vi�vo): ");
						do {
							dados[5] = leitor.nextLine();
							if (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
									&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
									&& !dados[5].equalsIgnoreCase("divorciado")
									&& !dados[5].equalsIgnoreCase("divorciada") && !dados[5].equalsIgnoreCase("viuvo")
									&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("vi�vo")
									&& !dados[5].equalsIgnoreCase("vi�vo"))
								System.out.print(
										"\tInforma��o inv�lida. Informe novamente o estado civil (solteiro / casado / divorciado /"
												+ " vi�vo): ");
						} while (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
								&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
								&& !dados[5].equalsIgnoreCase("divorciado") && !dados[5].equalsIgnoreCase("divorciada")
								&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("viuvo")
								&& !dados[5].equalsIgnoreCase("vi�vo") && !dados[5].equalsIgnoreCase("vi�vo"));

						System.out.print("Ra�a (parda / preta / branca / amarela / ind�gena): ");
						do {
							dados[6] = leitor.nextLine();
							if (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
									&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
									&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
									&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
									&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
									&& !dados[6].equalsIgnoreCase("ind�gena") && !dados[6].equalsIgnoreCase("ind�geno"))
								System.out.print(
										"\tInforma��o inv�lida. Informe novamente a ra�a (parda / preta / branca /"
												+ " amarela / ind�gena): ");
						} while (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
								&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
								&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
								&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
								&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
								&& !dados[6].equalsIgnoreCase("ind�gena") && !dados[6].equalsIgnoreCase("ind�geno"));
						manipulador.pessoaNova(dados);
					} else
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
				else
					op = 4;
				do {
					identidade = leitor.nextFloat();
					lixo = leitor.nextLine();
					if (identidade <= 0) {
						System.out.print(
								"\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
					}
				} while (identidade <= 0);
				if (manipulador.getArvore().pesquisar(identidade) != null)
					System.out.println(manipulador.getArvore().pesquisar(identidade).toString());
				else {
					System.out.println("A identidade " + identidade + " n�o consta nos registros.");
					mostraMenu = true;
				}
				break;
			case 4:
				int opAtualizar;
				if (mostraMenu == true) {
					System.out.print("Para atualiza��o de dados, informe a identidade para verificar os dados atuais: ");
					mostraMenu = false;
					op = 3;
				} else {
					do {
						System.out.print("\nOs dados atualiz�veis s�o:\n\t1- Nome\n\t2- Sexo\n\t3- Idade\n\t4- Moradia\n\t"
										+ "5- Estado civil\n\t6- Ra�a\n\t7- Cancelar\nInforme a op��o desejada: ");
						do {
							opAtualizar = leitor.nextInt();
							lixo = leitor.nextLine();
							if (opAtualizar < 1 || opAtualizar > 7)
								System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 8: ");
						} while (opAtualizar < 1 || opAtualizar > 7);
						switch (opAtualizar) {
						case 1:
							System.out.print("Informe o nome para atualiza��o: ");
							dados[1] = leitor.nextLine();
							if (manipulador.getArvore().pesquisar(identidade) != null)
								manipulador.getArvore().pesquisar(identidade).setNome(dados[1]);
							break;
						case 2:
							System.out.print("Informe o sexo para atualiza��o ( m / f ): ");
							do {
								dados[2] = String.valueOf(leitor.next().charAt(0));
								if (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M")
										&& !dados[2].equalsIgnoreCase("f") && !dados[2].equalsIgnoreCase("F"))
									System.out.print("\tInforma��o inv�lida. Informe novamente o sexo ( m / f ): ");
							} while (!dados[2].equalsIgnoreCase("m") && !dados[2].equalsIgnoreCase("M")
									&& !dados[2].equalsIgnoreCase("f") && !dados[2].equalsIgnoreCase("F"));
							if (manipulador.getArvore().pesquisar(identidade) != null)
								manipulador.getArvore().pesquisar(identidade).setSexo(dados[2].charAt(0));
							break;
						case 3:
							System.out.print("Informe a idade para atualiza��o: ");
							do {
								dados[3] = String.valueOf(leitor.nextInt());
								lixo = leitor.nextLine();
								if (Integer.parseInt(dados[3]) < 0)
									System.out.print("\tInforma��o inv�lida. Informe novamente a idade (valor n�o nulo): ");
							} while (Integer.parseInt(dados[3]) < 0);
							if (manipulador.getArvore().pesquisar(identidade) != null)
								manipulador.getArvore().pesquisar(identidade).setIdade(Integer.parseInt(dados[3]));
							break;
						case 4:
							System.out.print("Tipo de moradia (rural / urbana): ");
							do {
								dados[4] = leitor.nextLine();
								if (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"))
									System.out.print(
											"\tInforma��o inv�lida. Informe novamente o tipo de moradia (rural / urbana): ");
							} while (!dados[4].equalsIgnoreCase("rural") && !dados[4].equalsIgnoreCase("urbana"));
							if (manipulador.getArvore().pesquisar(identidade) != null)
								manipulador.getArvore().pesquisar(identidade).setMoradia(dados[4]);
							break;
						case 5:
							System.out.print("Estado civil (solteiro / casado / divorciado / vi�vo): ");
							do {
								dados[5] = leitor.nextLine();
								if (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
										&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
										&& !dados[5].equalsIgnoreCase("divorciado")
										&& !dados[5].equalsIgnoreCase("divorciada") && !dados[5].equalsIgnoreCase("viuvo")
										&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("vi�vo")
										&& !dados[5].equalsIgnoreCase("vi�vo"))
									System.out.print(
											"\tInforma��o inv�lida. Informe novamente o estado civil (solteiro / casado / divorciado /"
													+ " vi�vo): ");
							} while (!dados[5].equalsIgnoreCase("solteiro") && !dados[5].equalsIgnoreCase("solteira")
									&& !dados[5].equalsIgnoreCase("casado") && !dados[5].equalsIgnoreCase("casada")
									&& !dados[5].equalsIgnoreCase("divorciado") && !dados[5].equalsIgnoreCase("divorciada")
									&& !dados[5].equalsIgnoreCase("viuvo") && !dados[5].equalsIgnoreCase("viuvo")
									&& !dados[5].equalsIgnoreCase("vi�vo") && !dados[5].equalsIgnoreCase("vi�vo"));
							if (manipulador.getArvore().pesquisar(identidade) != null)
								manipulador.getArvore().pesquisar(identidade).setEstadoCivil(dados[5]);
							break;
						case 6:
							System.out.print("Ra�a (parda / preta / branca / amarela / ind�gena): ");
							do {
								dados[6] = leitor.nextLine();
								if (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
										&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
										&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
										&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
										&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
										&& !dados[6].equalsIgnoreCase("ind�gena") && !dados[6].equalsIgnoreCase("ind�geno"))
									System.out.print(
											"\tInforma��o inv�lida. Informe novamente a ra�a (parda / preta / branca /"
													+ " amarela / ind�gena): ");
							} while (!dados[6].equalsIgnoreCase("parda") && !dados[6].equalsIgnoreCase("pardo")
									&& !dados[6].equalsIgnoreCase("preta") && !dados[6].equalsIgnoreCase("preto")
									&& !dados[6].equalsIgnoreCase("branca") && !dados[6].equalsIgnoreCase("branco")
									&& !dados[6].equalsIgnoreCase("amarela") && !dados[6].equalsIgnoreCase("amarelo")
									&& !dados[6].equalsIgnoreCase("indigena") && !dados[6].equalsIgnoreCase("indigeno")
									&& !dados[6].equalsIgnoreCase("ind�gena") && !dados[6].equalsIgnoreCase("ind�geno"));
							if (manipulador.getArvore().pesquisar(identidade) != null)
								manipulador.getArvore().pesquisar(identidade).setRaca(dados[6]);
							break;
						case 7:
							System.out.println("case 8");
							mostraMenu = true;
							break;
						default:
							break;
						}
						System.out.println("opcao atualizar: " + opAtualizar);
					} while (opAtualizar != 7);
				}
				break;
			case 5:          //o conte�do dos CASES n�o necessariamente representam o que devem fazer
				System.out.print("Para a exlus�o, digite o ID da pessoa a ser procurada: ");
//					ID = leitor.nextInt();
//					RemoverPessoa(ID);
				break;
			case 6:
				System.out.print("Altera��o de dados, digite o ID da pessoa: ");
//					ID = leitor.nextInt();
//					AlterarPessoa(ID);
				break;
			case 7:
				System.out.print("\t\tRELAT�RIO POPULACIONAL\n");
//					RelatorioGeral(ID);
				break;
			case 8:
				System.out.print("\t\tRELAT�RIO ESTAT�STICO\n");
				RelatorioEstatistico();
				break;
			case 9:
				System.out.print("\t\t\n\nObrigado pela aten��o !\n\n");
				break;
			default:
				System.out.print("\t\t*** Op��o digitada est� incorreta! ***\n\n: ");
				break;
			}
		} while (op != 7);
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
