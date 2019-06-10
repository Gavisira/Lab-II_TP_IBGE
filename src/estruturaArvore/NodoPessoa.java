package estruturaArvore;

import classes.Pessoa;

public class NodoPessoa {

	Pessoa item;           // cont�m os dados da pessoa armazenada no nodo da �rvore.
	NodoPessoa direita;    // refer�ncia ao nodo armazenado, na �rvore, � direita da pessoa em quest�o.
    NodoPessoa esquerda;   // refer�ncia ao nodo armazenado, na �rvore, � esquerda da pessoa em quest�o.

    public NodoPessoa(Pessoa registro) {
    	item = registro;
    	direita = null;
    	esquerda = null;
    }
}
