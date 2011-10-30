import java.util.Scanner;

public class PesquisaHabitantes {

	public static void main(String[] args) throws PesquisaHabitantesException{
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite os salários dos habitantes: ");
		String salario = entrada.nextLine();
		
		System.out.print("Digite as idades dos habitantes: ");
		String idade = entrada.nextLine();
		
		System.out.print("Digite os sexos dos habitantes, sendo F para feminino e M para masculino: ");
		String sexo = entrada.nextLine();
		
		try{
			int[] dados = interpretarDados(salario, idade, sexo);
			
			System.out.println("Média dos salários: "+dados[0]);
			System.out.println("Menor idade: "+dados[1]);
			System.out.println("Maior idade: "+dados[2]);
			System.out.println("Quantidade de mulheres: "+dados[3]);
			System.out.println("Quantidade de homens: "+dados[4]);
			System.out.println("Quantidade de mulheres com salário até R$100,00: "+dados[5]);
			System.out.println("Quantidade de homens com salário até R$100,00: "+dados[6]);
		}catch(PesquisaHabitantesException e){
			System.out.println("A quantidade de dados deve ser igual para todas as questões!");
		}
	}
	
	public static int[] interpretarDados(String salario, String idade, String sexo) throws PesquisaHabitantesException {
		
		String retiraEspacosSalario = salario.trim();
		String retiraEspacosIdade = idade.trim();
		String retiraEspacosSexo = sexo.trim();
		
		String[] salarioSeparado = retiraEspacosSalario.split(" ");
		double[] salarios = new double[salarioSeparado.length];	
		
		String[] idadeSeparada = retiraEspacosIdade.split(" ");
		int[] idades = new int[idadeSeparada.length];
		
		String[] separaSexo = retiraEspacosSexo.split(" ");
		
		validarDados(separaSexo,salarioSeparado,idadeSeparada);
		
		for(int i = 0; i < salarioSeparado.length; i++){
			salarios[i] = Double.parseDouble(salarioSeparado[i]);
			idades[i] = Integer.parseInt(idadeSeparada[i]);
		}
		
		double mediaSalario = 0;
		int menorIdade = idades[0];
		int maiorIdade = idades[0];
		int mulheresSalario = 0;
		int homensSalario = 0;
		int quantidadeMulheres = 0;
		int quantidadeHomens = 0;
		
		for(int i = 0; i < salarios.length; i++){//TODOS OS ARRAYS TEM O MESMO TAMANHO. HÁ EXCEÇÃO PARA CASO CONTRÁRIO.
			//CALCULA MÉDIA DOS SALÁRIOS
			mediaSalario = (Math.round(mediaSalario + salarios[i] / salarios.length));
			
			//MENOR E MAIOR IDADE
			if(menorIdade > idades[i]){
				menorIdade = idades[i];
				
			}else if(maiorIdade < idades[i]){
				maiorIdade = idades[i];
			}
			
			//QUANTIDADE DE MULHERES E HOMENS QUE GANHAM ATÉ R$100,00
			if("F".equalsIgnoreCase(separaSexo[i]) && salarios[i] <= 100){
				mulheresSalario ++;	
				
			}else if("M".equalsIgnoreCase(separaSexo[i]) && salarios[i] <= 100){
				homensSalario++;
			}
			
			//QUANTIDADE DE MULHERES E HOMENS
			if("F".equalsIgnoreCase(separaSexo[i])){
				quantidadeMulheres++;
				
			}else if("M".equalsIgnoreCase(separaSexo[i])){
				quantidadeHomens++;
			}
		}
		
		int[] todosOsDados = new int [7];
		
		todosOsDados[0] = (int)mediaSalario;
		todosOsDados[1] = menorIdade;
		todosOsDados[2] = maiorIdade;
		todosOsDados[3] = quantidadeMulheres;
		todosOsDados[4] = quantidadeHomens;
		todosOsDados[5] = mulheresSalario;
		todosOsDados[6] = homensSalario;
		
		
		return todosOsDados;
	}

	private static void validarDados(String[] separaSexo, String[] salarioSeparado, String[] idadeSeparada) throws PesquisaHabitantesException {
		
		if(separaSexo.length != salarioSeparado.length || salarioSeparado.length != idadeSeparada.length
				|| separaSexo.length != idadeSeparada.length){
			throw new PesquisaHabitantesException("A quantidade de dados deve ser igual para todas as questões!");
		}
		
	}
	
}
