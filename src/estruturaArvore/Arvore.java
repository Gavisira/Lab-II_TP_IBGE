package estruturaArvore;

import classes.Pessoa;

public class Arvore {

	private NodoPessoa raiz; // refer�ncia � raiz da �rvore.

    /// Construtor da classe.
    /// Esse construtor cria uma nova �rvore bin�ria de alunos vazia. Para isso, esse m�todo atribui null � raiz da �rvore.
    public Arvore()
    {
        raiz = null;
    }

    /// M�todo booleano que indica se a �rvore est� vazia ou n�o.
    /// Retorna: 
    /// verdadeiro: se a raiz da �rvore for null, o que significa que a �rvore est� vazia.
    /// falso: se a raiz da �rvore n�o for null, o que significa que a �rvore n�o est� vazia.
    public Boolean arvoreVazia()
    {
        /// Se a raiz da �rvore for null, a �rvore est� vazia.
        if (this.raiz == null)
            return true;
        /// Caso contr�rio, a �rvore n�o est� vazia.
        else
            return false;
    }

    /// M�todo recursivo respons�vel por adicionar um aluno � �rvore.
    /// Par�metro "raizArvore": raiz da �rvore ou sub-�rvore em que o aluno ser� adicionado.
    /// Par�metro "alunoNovo": aluno que dever� ser adicionado � �rvore.
    /// Retorna a raiz atualizada da �rvore ou sub-�rvore em que o aluno foi adicionado.
    private NodoPessoa adicionar(NodoPessoa raizArvore, Pessoa pessoaNova)
    {
        /// Se a raiz da �rvore ou sub-�rvore for null, a �rvore est� vazia e ent�o um novo aluno � inserido.
        if (raizArvore == null)
            raizArvore = new NodoPessoa(pessoaNova);
        else
        {
            /// Se o n�mero de matr�cula do aluno armazenado na raiz da �rvore for maior do que o n�mero de matr�cula do aluno que dever� ser inserido na �rvore:
            /// adicione esse aluno � sub-�rvore esquerda; e atualize a refer�ncia para a sub-�rvore esquerda modificada. 
            if (raizArvore.item.getIdentidade() > pessoaNova.getIdentidade())
                raizArvore.esquerda = adicionar(raizArvore.esquerda, pessoaNova);
            else
            {
                /// Se o n�mero de matr�cula do aluno armazenado na raiz da �rvore for menor do que o n�mero de matr�cula do aluno que dever� ser inserido na �rvore:
                /// adicione esse aluno � sub-�rvore direita; e atualize a refer�ncia para a sub-�rvore direita modificada.
                if (raizArvore.item.getIdentidade() < pessoaNova.getIdentidade())
                    raizArvore.direita = adicionar(raizArvore.direita, pessoaNova);
                else
                    /// O n�mero de matr�cula do aluno armazenado na raiz da �rvore � igual ao n�mero de matr�cula do aluno que deveria ser inserido na �rvore.
                    System.out.println("A pessoa " + pessoaNova.getNome() + ", cuja identidade � " + pessoaNova.getIdentidade() + ", j� foi inserida anteriormente na �rvore.");
            }
        }
        /// Retorna a raiz atualizada da �rvore ou sub-�rvore em que o aluno foi adicionado.
        return raizArvore;
    }

    /// Metodo que encapsula a adi��o recursiva de alunos � �rvore.
    /// Par�metro "alunoNovo": aluno que dever� ser inserido na �rvore.
    public void inserir(Pessoa pessoaNova)
    {
        /// Chama o m�todo recursivo "adicionar", que ser� respons�vel por adicionar, o aluno passado como par�metro, � �rvore.
        /// O m�todo "adicionar" receber�, como primeiro par�metro, a raiz atual da �rvore; e, como segundo par�metro, o aluno que dever� ser adicionado � �rvore.
        /// Por fim, a raiz atual da �rvore � atualizada, com a raiz retornada pelo m�todo "adicionar".
        this.raiz = adicionar(this.raiz, pessoaNova);
    }

    public Pessoa pesquisar(float identidade) {
    	return localizarNaArvore(raiz, identidade);
    }
    
    private Pessoa localizarNaArvore(NodoPessoa raizArvore, float identidade) {
    	if(!arvoreVazia()) {
			if (raizArvore != null) {
				if (raizArvore.item.getIdentidade() == identidade)
					return raizArvore.item;
				else if (raizArvore.item.getIdentidade() > identidade)
					return localizarNaArvore(raizArvore.esquerda, identidade);
				else if (raizArvore.item.getIdentidade() < identidade)
					return localizarNaArvore(raizArvore.direita, identidade);
			}
		}
    	return null;
    }

    /// M�todo recursivo respons�vel por localizar na �rvore ou sub-�rvore o antecessor do n� que dever� ser retirado. 
    /// O antecessor do n� que dever� ser retirado da �rvore corresponde
    /// ao n� que armazena os dados do aluno cujo n�mero de matr�cula � o maior, 
    /// dentre os n�meros de matr�cula menores do que o n�mero de matr�cula do n� que dever� ser retirado.
    /// Depois de ser localizado na �rvore ou sub-�rvore, 
    /// o antecessor do n� que dever� ser retirado da �rvore o substitui.
    /// Adicionalmente, a �rvore ou sub-�rvore � atualizada com a remo��o do antecessor.
    /// Par�metro "alunoRetirar": refer�ncia ao n� que armazena o aluno que dever� ser retirado da �rvore.
    /// Par�metro "raizArvore": raiz da �rvore ou sub-�rvore em que o antecessor do n� que dever� ser retirado dever� ser localizado.
    /// Retorna: raiz atualizada da �rvore ou sub-�rvore ap�s a remo��o do antecessor do n� que foi retirado da �rvore.
    private NodoPessoa antecessor(NodoPessoa pessoaRetirar, NodoPessoa raizArvore)
    {
        /// Se o antecessor do n� que dever� ser retirado da �rvore ainda n�o foi encontrado...
        if (raizArvore.direita != null)
        {
            /// Pesquise o antecessor na sub-�rvore direita.
            raizArvore.direita = antecessor(pessoaRetirar, raizArvore.direita);
            return raizArvore;
        }
        /// O antecessor do n� que dever� ser retirado da �rvore foi encontrado.
        else
        {
            /// O antecessor do n� que dever� ser retirado da �rvore foi localizado e dever� substitui-lo.
            pessoaRetirar.item.setIdentidade(raizArvore.item.getIdentidade());
            pessoaRetirar.item.setNome(raizArvore.item.getNome());
            pessoaRetirar.item.setSexo(raizArvore.item.getSexo());
            pessoaRetirar.item.setIdade(raizArvore.item.getIdade());
            pessoaRetirar.item.setMoradia(raizArvore.item.getMoradia());
            pessoaRetirar.item.setEstadoCivil(raizArvore.item.getEstadoCivil());
            pessoaRetirar.item.setRaca(raizArvore.item.getRaca());
            /// A raiz da �rvore ou sub-�rvore � atualizada com os descendentes � esquerda do antecessor.
            /// Ou seja, retira-se o antecessor da �rvore.
            return raizArvore.esquerda;
        }
    }

    /// M�todo recursivo respons�vel por localizar um aluno na �rvore e retir�-lo da �rvore.
    /// Par�metro "raizArvore": raiz da �rvore ou sub-�rvore da qual o aluno ser� retirado.
    /// Par�metro "matricula": n�mero de matr�cula do aluno que dever� ser localizado e removido da �rvore.
    /// Retorna a raiz atualizada da �rvore ou sub-�rvore da qual o aluno foi retirado; ou null, caso n�o tenha sido localizado aluno com o n�mero de matr�cula informado.
    private NodoPessoa retirar(NodoPessoa raizArvore, float identidade)
    {
        /// Se a raiz da �rvore ou sub-�rvore for null, a �rvore est� vazia e o aluno, que deveria ser retirado dessa �rvore, n�o foi encontrado.
        /// Nesse caso, deve-se retornar null.
        if (raizArvore == null)
        {
        	 System.out.println("A pessoa, cuja identidade � " + identidade + ", n�o foi encontrada.");
            return raizArvore;
        }
        else
        {
            /// O n�mero de matr�cula do aluno armazenado na raiz da �rvore � igual ao n�mero de matr�cula do aluno que deve ser retirado dessa �rvore.
            /// Ou seja, o aluno que deve ser retirado da �rvore foi encontrado.
            if (raizArvore.item.getIdentidade() == identidade)
            {
                /// O n� da �rvore que ser� retirado n�o possui descendentes � direita.
                /// Nesse caso, os descendentes � esquerda do n� que est� sendo retirado da �rvore passar�o a ser descendentes do n�-pai do n� que est� sendo retirado.
                if (raizArvore.direita == null)
                    return (raizArvore.esquerda);
                else
                    /// O n� da �rvore que ser� retirado n�o possui descendentes � esquerda.
                    /// Nesse caso, os descendentes � direita do n� que est� sendo retirado da �rvore passar�o a ser descendentes do n�-pai do n� que est� sendo retirado.
                    if (raizArvore.esquerda == null)
                        return (raizArvore.direita);
                    else
                    {
                        /// O n� que est� sendo retirado da �rvore possui descendentes � esquerda e � direita.
                        /// Nesse caso, o antecessor do n� que est� sendo retirado � localizado na sub-�rvore esquerda desse n�. 
                        /// O antecessor do n� que est� sendo retirado da �rvore corresponde
                        /// ao n� que armazena o aluno cujo n�mero de matr�cula � o maior, 
                        /// dentre os n�meros de matr�cula menores do que o n�mero de matr�cula do n� que est� sendo retirado.
                        /// Depois de ser localizado na sub-�rvore esquerda do n� que est� sendo retirado, 
                        /// o antecessor desse n� o substitui.
                        /// A sub-�rvore esquerda do n� que foi retirado � atualizada com a remo��o do antecessor.
                        raizArvore.esquerda = antecessor(raizArvore, raizArvore.esquerda);
                        /// Retorna a raiz atualizada da �rvore ou sub-�rvore da qual o aluno foi retirado.
                        return (raizArvore);
                    }
            }
            else
            {
                /// Se o n�mero de matr�cula do aluno armazenado na raiz da �rvore for maior do que o n�mero de matr�cula do aluno que dever� ser localizado e retirado da �rvore:
                /// pesquise e retire esse aluno da sub-�rvore esquerda.
                if (raizArvore.item.getIdentidade() > identidade)
                    raizArvore.esquerda = retirar(raizArvore.esquerda, identidade);
                else
                    /// Se o n�mero de matr�cula do aluno armazenado na raiz da �rvore for menor do que o n�mero de matr�cula do aluno que dever� ser localizado e retirado da �rvore:
                    /// pesquise e retire esse aluno da sub-�rvore direita.
                    raizArvore.direita = retirar(raizArvore.direita, identidade);
                /// Retorna a raiz atualizada da �rvore ou sub-�rvore da qual o aluno foi retirado.
                return raizArvore;
            }
        }
    }

    /// M�todo que encapsula a retirada recursiva de um aluno da �rvore.
    /// Par�metro "matriculaRemover": n�mero de matr�cula do aluno que dever� ser localizado e removido da �rvore.
    public void remover(float identidadeRemover)
    {
        /// Chama o m�todo recursivo "retirar", que ser� respons�vel por pesquisar o aluno, cujo n�mero de matr�cula foi passado como par�metro, na �rvore e retir�-lo da �rvore.
        /// O m�todo "retirar" receber�, como primeiro par�metro, a raiz atual da �rvore; e, como segundo par�metro, o n�mero de matr�cula do aluno que dever� ser localizado e retirado dessa �rvore.
        this.raiz = retirar(this.raiz, identidadeRemover);
    }
}