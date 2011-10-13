import static org.junit.Assert.*;

import org.junit.Test;


public class pesquisaHabitantesTest {

	@Test
	public void test() {	
		int[] idade = {10, 20, 15,  45, 63, 78, 89, 90, 14, 19};
		double[] salario = {70, 100, 675, 1500, 540, 62, 70, 85, 690, 100};
		String[] sexo = {"F", "F", "F", "F", "F", "M", "M", "F", "F", "M"};
		double[] resultado = PesquisaHabitantes.calculos(salario, idade, sexo);
		assertArrayEquals(new double[] {389.2, 10, 90, 3, 3}, resultado, 0);
	}

}
