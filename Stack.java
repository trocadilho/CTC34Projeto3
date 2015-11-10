//CTC-34: Projeto 3
//Bruno Henrique Machado de Freitas

package ap;

//Aqui define-se a classe pilha que será usada conjuntamente com a classe automato.
/*São definidas funções básicas como checar se a pilha está vazia ou cheia, adicionar (push) ou remover (pop) um elemento e
olhar o topo da pilha (peek). Também são definidos os métodos get necessários.*/

public class Stack {
	private int top;
	private int maxsize;
	private int[] array;
	
	public Stack(int max){
		top = -1;
		maxsize = max;
		array = new int[maxsize];
	}
	
	public boolean isFull(){
		if(top == maxsize-1)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty(){
		if(top == -1)
			return true;
		else
			return false;
	}
	
	public void push(int i){
		if(!isFull()){
			top++;
			array[top] = i;
		}
		else
			System.out.println("Pilha cheia!");
	}
	
	public void pop(){
		if(!isEmpty()){
			top--;
		}
		else
			System.out.println("Pilha vazia!");
	}
	
	public int peek(){
		return array[top];
	}
	
	public int getstackSize(){
		return top+1;
	}
	
	public int[] getstack(){
		return array;
	}
}
