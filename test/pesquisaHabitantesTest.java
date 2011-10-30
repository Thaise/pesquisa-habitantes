import static org.junit.Assert.*;

import org.junit.Test;


public class pesquisaHabitantesTest {

	@Test
	public void deveAnalisarDadosDeUmaPesquisaDeHabitantes() throws PesquisaHabitantesException {	
		
		String salario = "70 100 675 1500 540 62 70 85 690 100";
		String idade = "10 20 15 45 63 78 89 90 14 19";
		String sexo = "F F F F F M M F F M";
		int[] resultado = PesquisaHabitantes.interpretarDados(salario,idade,sexo);
		assertArrayEquals(new int[] {390, 10, 90, 7, 3, 3, 3}, resultado);
	}

	@Test
	public void deveAnalisarDadosDeUmaPesquisaDeHabitantes2() throws PesquisaHabitantesException {	
		
		String salario = "560 100 70";
		String idade = "20 65 14";
		String sexo = "F M F";
		int[] resultado = PesquisaHabitantes.interpretarDados(salario,idade,sexo);
		assertArrayEquals(new int[] {243, 14, 65, 2, 1, 1, 1}, resultado);
	}
	
	@Test
	public void deveAnalisarDadosDeUmaPesquisaDeHabitantes3() throws PesquisaHabitantesException {	
		
		String salario = "255 100 0";
		String idade = "14 14 12";
		String sexo = "M M M";
		int[] resultado = PesquisaHabitantes.interpretarDados(salario,idade,sexo);
		assertArrayEquals(new int[] {118, 12, 14, 0, 3, 0, 2}, resultado);
	}

	@Test(expected = PesquisaHabitantesException.class)
	public void deveLancarExcecaoAoAnalisarDadosIdadesAMenos() throws PesquisaHabitantesException {	
		
		String salario = "70 100 675 1500 540 62 100 100 70 80";
		String idade = "10 20 15 45 63 78 89 90 14";
		String sexo = "F F F F F M M F F M";
		int[] resultado = PesquisaHabitantes.interpretarDados(salario,idade,sexo);
		assertArrayEquals(new int[] {0}, resultado);
	}
	
	@Test(expected = PesquisaHabitantesException.class)
	public void deveLancarExcecaoAoAnalisarDadosSexosAMais() throws PesquisaHabitantesException {	
		
		String salario = "70 100 675 1500 540 62";
		String idade = "10 20 15 45 63 78";
		String sexo = "F F F F F M M F F M";
		int[] resultado = PesquisaHabitantes.interpretarDados(salario,idade,sexo);
		assertArrayEquals(new int[] {0}, resultado);
	}
	@Test(expected = PesquisaHabitantesException.class)
	public void deveLancarExcecaoAoAnalisarDadosSalariosAMenos() throws PesquisaHabitantesException {	
		
		String salario = "70 100 675 1500 540";
		String idade = "10 20 15 45 63 78";
		String sexo = "F F F F F M";
		int[] resultado = PesquisaHabitantes.interpretarDados(salario,idade,sexo);
		assertArrayEquals(new int[] {0}, resultado);
	}

}
