
public class PesquisaHabitantes {

	public static double[] calculos(double[] salario, int[] idade, String[] sexo) {
		
		double mediaSalario = 0;
		
		for(int i = 0; i < salario.length; i++){
			mediaSalario = mediaSalario + salario[i] / 10;	
		}
		
		int menorIdade = idade[0];
		int maiorIdade = idade[0];
		
		for(int i = 0; i < idade.length; i++){
			if(menorIdade > idade[i]){
				menorIdade = idade[i];	
			}else
			if(maiorIdade < idade[i]){
				maiorIdade = idade[i];
			}
		}
		
		int quantidadeMulheres = 0;
		
		for(int i = 0; i < sexo.length && i < salario.length; i++){
			if("F".equals(sexo[i]) && salario[i] <= 100){
				quantidadeMulheres ++;	
			}
		}	
			
		int quantidadeHomens = 0;
			
		for(int i = 0; i < sexo.length; i++){
			if("M".equals(sexo[i])){
				quantidadeHomens++;
			}
		}
		
		double[] todosOsDados = new double [5];
		
		todosOsDados[0] = mediaSalario;
		todosOsDados[1] = menorIdade;
		todosOsDados[2] = maiorIdade;
		todosOsDados[3] = quantidadeMulheres;
		todosOsDados[4] = quantidadeHomens;
		
		
		return todosOsDados;
	}
	
}
