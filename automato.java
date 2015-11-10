//CTC-34: Projeto 3
//Bruno Henrique Machado de Freitas

package ap;

public class automato {
	/*Nesse programa, um autômato é definido pela sua quantidade de estados, pelo número de símbolos
	na fita de entrada e no alfabeto da pilha.*/
	private int states;
	private int tapeAlphabet;
	private int stackAlphabet;
	
	/*A função de transição delta é dividida em duas matrizes: delta1 que guarda o próximo estado e delta2 que guarda o 
	elemento a ser empilhado.*/
	private String[][][] delta1;
	private String[][][] delta2;
	/*Define-se um vetor de booleanas para indicar os estados finais. Se um estado é final, o elemento correspondente
	no vetor possui valor true.*/
	private boolean[] finalStates;
	
	//Construtor de autômato
	public automato(int s, int tapealpha, int stackalpha, String[][][] statesmatrix, String[][][] stackmatrix, boolean[] finalstates){
		states = s;
		tapeAlphabet = tapealpha;
		stackAlphabet = stackalpha;
		delta1 = statesmatrix;
		delta2 = stackmatrix;
		finalStates = finalstates;
	}
	
	//Métodos get necessários para se acessar os campos de autômato.
	
	public int getStates(){
		return states;
	}
	
	public int gettapeAlphabet(){
		return tapeAlphabet;
	}
	
	public int getstackAlphabet(){
		return stackAlphabet;
	}
	
	public String[][][] getDelta1(){
		return delta1;
	}
	
	public String[][][] getDelta2(){
		return delta2;
	}
	
	public boolean[] getfinalStates(){
		return finalStates;
	}
}
