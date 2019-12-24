import net.sourceforge.jFuzzyLogic.FIS;


/*

 * Тестовый парсер FCL-файла
 * компилируем командой "javac -cp ./jFuzzyLogic_v2.1a.jar Restaurant.java"
 * далее кладем файл Tea.class в каталог Tea
 * и запускаем командой "java -cp ./jFuzzyLogic_v2.1a.jar:Restaurant Restaurant" (Unix)

 */



// Входные переменные:
// Атмосфера заведения: restaurantAthmosphere
// Качество еды: foodQuality
// Качество обслуживания: serviceQuality
// Место расположения: location

// Выходные переменные:
// Оценка (критика): institutionAssessment
// Цена: foodPrice




// Ресторан
public class Restaurant {
	
	public static void main(String[] args) throws Exception {
		
		FIS fis = FIS.load("Restaurant.fcl", true);
		
		if (fis == null) {
			System.err.println("Error loading file with name 'Restaurant.fcl'");
			return;
		}

		// Показываем.
		fis.chart();

		// Задаем значения входных переменных.
		fis.setVariable("restaurantAthmosphere", 40);
		fis.setVariable("foodQuality", 2);
		fis.setVariable("serviceQuality", 70);
		fis.setVariable("location", 1800);

		// Вычисляем.
		fis.evaluate();

		// Печатаем информацию о выходной перменной.
		System.out.println(fis.getVariable("institutionAssessment").toString());
		System.out.println(fis.getVariable("foodPrice").toString());

		// Печатаем вещественное значение последней дефаззификации выходной переменной.
		System.out.println(fis.getVariable("institutionAssessment").getValue());
		System.out.println(fis.getVariable("foodPrice").getValue());

		// Показываем график выходной переменной. 
		fis.getVariable("institutionAssessment").chartDefuzzifier(true);
		fis.getVariable("foodPrice").chartDefuzzifier(true);
		
	}
	
}