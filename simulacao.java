//CTC-34: Projeto 3
//Bruno Henrique Machado de Freitas

package ap;

import java.util.Arrays;

public class simulacao{
	static boolean r = false;
	public static void main(String[] args) {
		//Aqui são criadas as entradas e realizadas as simulações através da função output.
		int states1 = 7;
		int tapeAlphabet1 = 4;
		int stackAlphabet1 = 3;
		String delta11[][][] = new String[7][4][3];
		delta11[0][3][2] = "1";
		delta11[1][0][2] = "1";
		delta11[1][3][2] = "2 4";
		delta11[2][1][0] = "2";
		delta11[2][3][1] = "3";
		delta11[3][2][2] = "3";
		delta11[4][1][2] = "4";
		delta11[4][3][2] = "5";
		delta11[5][2][0] = "5";
		delta11[5][3][1] = "6";
		String delta21[][][] = new String[7][4][3];
		delta21[0][3][2] = "1";
		delta21[1][0][2] = "0";
		delta21[1][3][2] = "2 2";
		delta21[2][1][0] = "2";
		delta21[2][3][1] = "2";
		delta21[3][2][2] = "2";
		delta21[4][1][2] = "2";
		delta21[4][3][2] = "2";
		delta21[5][2][0] = "2";
		delta21[5][3][1] = "2";
		boolean[] finalStates1 = new boolean[7];
		Arrays.fill(finalStates1, false);
		finalStates1[3] = true;
		finalStates1[6] = true;
		automato automato1 = new automato(states1, tapeAlphabet1, stackAlphabet1, delta11, delta21, finalStates1);
		Stack stack1 = new Stack(50);
		int[] cadeia1 = new int[5];
		cadeia1[0] = 0;
		cadeia1[1] = 0;
		cadeia1[2] = 1;
		cadeia1[3] = 2;
		cadeia1[4] = 2;
		System.out.println("Autômato 1");
		simulacao simulacao = new simulacao();
		System.out.print("[q1, ");
		for(int i = 0; i<cadeia1.length; i++){
			System.out.print(cadeia1[i]);
		}
		System.out.println(", " + (stackAlphabet1-1) + "]");
		simulacao.output(automato1, 0, stack1, cadeia1);
		if(!r)
			System.out.println("Cadeia rejeitada!");
		
		r = false;
		int states2 = 4;
		int tapeAlphabet2 = 3;
		int stackAlphabet2 = 4;
		String delta12[][][] = new String[4][3][4];
		delta12[0][2][3] = "1";
		delta12[1][0][3] = "1";
		delta12[1][1][3] = "1";
		delta12[1][2][3] = "2";
		delta12[2][0][0] = "2";
		delta12[2][1][1] = "2";
		delta12[2][2][2] = "3";
		String delta22[][][] = new String[4][3][4];
		delta22[0][2][3] = "2";
		delta22[1][0][3] = "0";
		delta22[1][1][3] = "1";
		delta22[1][2][3] = "3";
		delta22[2][0][0] = "3";
		delta22[2][1][1] = "3";
		delta22[2][2][2] = "3";
		boolean[] finalStates2 = new boolean[4];
		Arrays.fill(finalStates2, false);
		finalStates2[0] = true;
		finalStates2[3] = true;
		automato automato2 = new automato(states2, tapeAlphabet2, stackAlphabet2, delta12, delta22, finalStates2);
		Stack stack2 = new Stack(50);
		int[] cadeia2 = new int[6];
		cadeia2[0] = 0;
		cadeia2[1] = 0;
		cadeia2[2] = 0;
		cadeia2[3] = 1;
		cadeia2[4] = 1;
		cadeia2[5] = 1;
		System.out.println("Autômato 2");
		System.out.print("[q1, ");
		for(int i = 0; i<cadeia2.length; i++){
			System.out.print(cadeia2[i]);
		}
		System.out.println(", " + (stackAlphabet2-1) + "]");
		simulacao.output(automato2, 0, stack2, cadeia2);
		if(!r)
			System.out.println("Cadeia rejeitada!");
		
		r = false;
		int states3 = 4;
		int tapeAlphabet3 = 3;
		int stackAlphabet3 = 3;
		String delta13[][][] = new String[4][3][3];
		delta13[0][2][2] = "1";
		delta13[1][0][2] = "1";
		delta13[1][1][0] = "2";
		delta13[2][1][0] = "2";
		delta13[2][2][1] = "3";
		String delta23[][][] = new String[4][3][3];
		delta23[0][2][2] = "1";
		delta23[1][0][2] = "0";
		delta23[1][1][0] = "2";
		delta23[2][1][0] = "2";
		delta23[2][2][1] = "2";
		boolean[] finalStates3 = new boolean[4];
		Arrays.fill(finalStates3, false);
		finalStates3[0] = true;
		finalStates3[3] = true;
		automato automato3 = new automato(states3, tapeAlphabet3, stackAlphabet3, delta13, delta23, finalStates3);
		Stack stack3 = new Stack(50);
		int[] cadeia3 = new int[3];
		cadeia3[0] = 0;
		cadeia3[1] = 1;
		cadeia3[2] = 0;
		System.out.println("Autômato 3");
		System.out.print("[q1, ");
		for(int i = 0; i<cadeia3.length; i++){
			System.out.print(cadeia3[i]);
		}
		System.out.println(", " + (stackAlphabet3-1) + "]");
		simulacao.output(automato3, 0, stack3, cadeia3);
		if(!r)
			System.out.println("Cadeia rejeitada!");
	}
	
	public void output(automato a, int currentState, Stack s, int[] cadeia){
		/*Aqui está a maior parte da lógica da simulação. O algoritmo usado é recursivo 
		usando o conceito de busca em profundidade.
		/*Primeiramente, analisam-se todas as transições possíveis para uma 
		determinada configuração de estado atual, posição na fita e pilha. Se encontrar 
		uma transição possível, ela é impressa no console.
		Depois disso, o algoritmo é chamado de maneira recursiva para cada um dos estados atingíveis 
		por essas transições.*/
		boolean p, q;
		p = q = false;
		int nextState;
		int aux2 = a.gettapeAlphabet() - 1;
		int aux3 = a.getstackAlphabet() - 1;
		
		//Aqui são impressas no console as transições possíveis que não são transições épsilon.
		if (cadeia[0] != a.gettapeAlphabet()-1){
			for(int i=0; i<a.getDelta1()[currentState][cadeia[0]].length; i++){
				if(a.getDelta1()[currentState][cadeia[0]][i] != null){
					String[] numbers1 = a.getDelta1()[currentState][cadeia[0]][i].split(" ");
					int[] numeros1 = new int[numbers1.length];
					for(int j = 0; j<numbers1.length; j++){
						numeros1[j] = Integer.parseInt(numbers1[j]);
					}
					String[] numbers2 = a.getDelta2()[currentState][cadeia[0]][i].split(" ");
					int[] numeros2 = new int[numbers2.length];
					for(int j = 0; j<numbers2.length; j++){
						numeros2[j] = Integer.parseInt(numbers2[j]);
					}
					for(int j=0; j<numeros1.length; j++){
						if(!s.isEmpty() && s.peek()==i || i==a.getstackAlphabet()-1){
							p = q = false;
							nextState = numeros1[j];
							if(i!=a.getstackAlphabet()-1){
								s.pop();
								p = true;
							}
							if(numeros2[j]!=a.getstackAlphabet()-1){
								s.push(numeros2[j]);
								q = true;
							}
							int[] cadeianova = new int[cadeia.length-1];
							for(int k=0; k<cadeianova.length; k++){
								cadeianova[k] = cadeia[k+1];
							}
							
							System.out.print("[q" + (nextState+1) + ", ");
							if(cadeianova.length == 0){
								cadeianova = new int[1];
								cadeianova[0] = a.gettapeAlphabet() - 1;
							}
							for(int k = 0; k<cadeianova.length; k++){
								System.out.print(cadeianova[k]);
							}
							if(s.isEmpty()){
								System.out.print(", " + aux3);
							}
							else{
								System.out.print(", ");
								for(int k = s.getstackSize()-1; k>=0; k--){
									System.out.print(s.getstack()[k]);
								}
							}
							System.out.print("]");
							if(over(a, nextState, cadeia)){
								System.out.println(" Cadeia aceita!");
								r = true;
							}
							if(q)
								s.pop();
							if(p)
								s.push(i);
						}
					}
				}
			}
		}
		
		//Aqui são impressas no console as transições épsilon possíveis.
		if(!r){
			for(int i=0; i<a.getDelta1()[currentState][a.gettapeAlphabet()-1].length; i++){
				if(a.getDelta1()[currentState][a.gettapeAlphabet()-1][i] != null){
					String[] numbers1 = a.getDelta1()[currentState][a.gettapeAlphabet()-1][i].split(" ");
					int[] numeros1 = new int[numbers1.length];
					for(int j = 0; j<numbers1.length; j++){
						numeros1[j] = Integer.parseInt(numbers1[j]);
					}
					String[] numbers2 = a.getDelta2()[currentState][a.gettapeAlphabet()-1][i].split(" ");
					int[] numeros2 = new int[numbers2.length];
					for(int j = 0; j<numbers2.length; j++){
						numeros2[j] = Integer.parseInt(numbers2[j]);
					}
					for(int j=0; j<numeros1.length; j++){
						if(!s.isEmpty() && s.peek()==i || i==a.getstackAlphabet()-1){
							p = q = false;
							nextState = numeros1[j];
							if(i!=a.getstackAlphabet()-1){
								s.pop();
								p = true;
							}
							if(numeros2[j]!=a.getstackAlphabet()-1){
								s.push(numeros2[j]);
								q = true;
							}
							
							System.out.print("[q" + (nextState+1) + ", ");
							if(cadeia.length == 0){
								System.out.print(aux2);
							}
							else{
								for(int k = 0; k<cadeia.length; k++){
									System.out.print(cadeia[k]);
								}
							}
							if(s.isEmpty()){
								System.out.print(", " + aux3);
							}
							else{
								System.out.print(", ");
								for(int k = s.getstackSize()-1; k>=0; k--){
									System.out.print(s.getstack()[k]);
								}
							}
							System.out.print("]");
							if(over(a, nextState, cadeia)){
								System.out.println(" Cadeia aceita!");
								r = true;
							}
							if(q)
								s.pop();
							if(p)
								s.push(i);
						}
					}
				}
			}
			System.out.println("");
		}
		
		//Aqui o algoritmo é chamado recursivamente para as transições possíveis que não são transições épsilon.
		if(!r){
			for(int i=0; i<a.getDelta1()[currentState][cadeia[0]].length; i++){
				if(a.getDelta1()[currentState][cadeia[0]][i] != null){
					String[] numbers1 = a.getDelta1()[currentState][cadeia[0]][i].split(" ");
					int[] numeros1 = new int[numbers1.length];
					for(int j = 0; j<numbers1.length; j++){
						numeros1[j] = Integer.parseInt(numbers1[j]);
					}
					String[] numbers2 = a.getDelta2()[currentState][cadeia[0]][i].split(" ");
					int[] numeros2 = new int[numbers2.length];
					for(int j = 0; j<numbers2.length; j++){
						numeros2[j] = Integer.parseInt(numbers2[j]);
					}
					for(int j=0; j<numeros1.length; j++){
						if(!s.isEmpty() && s.peek()==i || i==a.getstackAlphabet()-1){
							p = q = false;
							nextState = numeros1[j];
							if(i!=a.getstackAlphabet()-1){
								s.pop();
								p = true;
							}
							if(numeros2[j]!=a.getstackAlphabet()-1){
								s.push(numeros2[j]);
								q = true;
							}
							int[] cadeianova = new int[cadeia.length-1];
							for(int k=0; k<cadeianova.length; k++){
								cadeianova[k] = cadeia[k+1];
							}
							if(cadeianova.length == 0){
								cadeianova = new int[1];
								cadeianova[0] = a.gettapeAlphabet() - 1;
							}
							output(a, nextState, s, cadeianova);
							if(q)
								s.pop();
							if(p)
								s.push(i);
						}
					}
				}
			}
			
			//Aqui o algoritmo é chamado recursivamente para as transições possíveis que são transições épsilon.
			if (cadeia[0] != a.gettapeAlphabet()-1){
				for(int i=0; i<a.getDelta1()[currentState][a.gettapeAlphabet()-1].length; i++){
					if(a.getDelta1()[currentState][a.gettapeAlphabet()-1][i] != null){
						String[] numbers1 = a.getDelta1()[currentState][a.gettapeAlphabet()-1][i].split(" ");
						int[] numeros1 = new int[numbers1.length];
						for(int j = 0; j<numbers1.length; j++){
							numeros1[j] = Integer.parseInt(numbers1[j]);
						}
						String[] numbers2 = a.getDelta2()[currentState][a.gettapeAlphabet()-1][i].split(" ");
						int[] numeros2 = new int[numbers2.length];
						for(int j = 0; j<numbers2.length; j++){
							numeros2[j] = Integer.parseInt(numbers2[j]);
						}
						for(int j=0; j<numeros1.length; j++){
							if(!s.isEmpty() && s.peek()==i || i==a.getstackAlphabet()-1){
								p = q = false;
								nextState = numeros1[j];
								if(i!=a.getstackAlphabet()-1){
									s.pop();
									p = true;
								}
								if(numeros2[j]!=a.getstackAlphabet()-1){
									s.push(numeros2[j]);
									q = true;
								}
								output(a, nextState, s, cadeia);
								if(q)
									s.pop();
								if(p)
									s.push(i);
							}
						}
					}
				}
			}
		}
	}
	
	public boolean over(automato a, int estado, int[] cadeia){
		/*Por fim, aqui está a lógica de checar se a simulação (função output) validou a cadeia. 
		A cadeia é considerada válida se o estado atual é um estado final e a fita terminou de ser lida.*/
		boolean acabou = false;
		if(a.getfinalStates()[estado] && cadeia[0] == a.gettapeAlphabet()-1) 
			acabou = true;
		return acabou;
	}
}
