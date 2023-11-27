import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestListNumbers {
    private List<Integer> numbers1;
    private List<Integer> numbers2;
    private ListNumber listNumber;

    @BeforeEach
    void setUp(){
        numbers1 = new ArrayList<>();
        numbers2 = new ArrayList<>();
        listNumber = new ListNumber();
    }

    /**
     *  Проверяем корректную работу метода averageNumbers,
     *  должен вернуть определенное значение.
     */
    @Test
    void testListNumbersAverageNumbers(){
        numbers1.add(2);
        numbers1.add(4);
        numbers1.add(3);

        assertEquals(3, listNumber.averageNumbers(numbers1));
    }

    /**
     *  Проверяем метод averageNumbers в случае передачи пустого списка,
     *  должен выбросить исключение ArithmeticException.
     */
    @Test
    void testListNumberAverageNumbersZero(){
        assertThatThrownBy(() -> listNumber.averageNumbers(numbers1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Список не может быть пустым!");
    }

    /**
     *  Поверяем корректное поведение метода compare. Три сценария:
     *  1. Когда среднее первого списка больше второго, возвращает ("Первый список имеет большее среднее значение").
     *  2. Когда среднее первого списка меньше второго, возвращает ("Второй список имеет большее среднее значение").
     *  3. Когда среднее обоих списков равны, возврает ("Средние значения равны").
     */

    @ParameterizedTest
    @CsvSource({
            "2, 4, 3, 2, 4, 2, Первый список имеет большее среднее значение",
            "2, 4, 2, 2, 4, 3, Второй список имеет большее среднее значение",
            "2, 4, 3, 2, 4, 3, Средние значения равны"
    })
    void testCompare(int a1, int b1, int c1, int a2, int b2, int c2, String res){
        numbers1.add(a1);
        numbers1.add(b1);
        numbers1.add(c1);
        numbers2.add(a2);
        numbers2.add(b2);
        numbers2.add(c2);
        assertEquals(res, listNumber.compare(numbers1, numbers2));
    }
}
