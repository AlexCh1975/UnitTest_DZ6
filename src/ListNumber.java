import java.util.List;

public class ListNumber {
    public String compare(List<Integer> numbers1, List<Integer> numbers2){
        double averageNumber1 = averageNumbers(numbers1);
        double averageNumber2 = averageNumbers(numbers2);

        if (averageNumber1 > averageNumber2) {
            return "Первый список имеет большее среднее значение";
        }
        else if (averageNumber1 < averageNumber2){
            return "Второй список имеет большее среднее значение";
        }
        else return "Средние значения равны";
    }

    public double averageNumbers(List<Integer> numbers){
        double sum = 0;
        if (numbers.isEmpty()) {
            throw new ArithmeticException("Список не может быть пустым!");
        }
        for (int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }
        return sum / numbers.size() ;
    }
}
