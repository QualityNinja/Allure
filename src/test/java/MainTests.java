import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Owner("Babok.PS")
public class MainTests {

    // Этот тест я сделал специально провальным, для наглядности Allue отчета
    @Test
    @Epic("Эпик 1: Основной функционал")
    @Feature("Фича 1: Арифметические операции")
    @Story("История 1.1: Сложение чисел")
    @Description("Этот тест складывает два числа и проверяет результат.")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "GitHub", url = "https://github.com")
    public void testAddition() {
        assertEquals(5, 2 + 2, "Результат сложения некорректен");
    }

    @Test
    @Feature("Фича 1: Арифметические операции")
    @Epic("Эпик 1: Основной функционал")
    @Story("История 1.2: Вычитание чисел")
    @Description("Этот тест вычитает одно число из другого и проверяет результат.")
    @Severity(SeverityLevel.MINOR)
    public void testSubtraction() {
        assertEquals(1, 3 - 2, "Результат вычитания некорректен");
    }

    @Test
    @Feature("Фича 1: Арифметические операции")
    @Epic("Эпик 1: Основной функционал")
    @Story("История 1.3: Умножение чисел")
    @Description("Этот тест умножает два числа и проверяет результат.")
    @Severity(SeverityLevel.NORMAL)
    @Issue("ISSUE-123")
    public void testMultiplication() {
        assertEquals(6, 2 * 3, "Результат умножения некорректен");
    }

    @Test
    @Epic("Эпик 1: Основной функционал")
    @Feature("Фича 1: Арифметические операции")
    @Story("История 1.4: Деление чисел")
    @Description("Этот тест делит одно число на другое и проверяет результат.")
    @Severity(SeverityLevel.CRITICAL)
    public void testDivision() {
        assertEquals(2, 6 / 3, "Результат деления некорректен");
    }

    @Test
    @Epic("Эпик 1: Основной функционал")
    @Feature("Фича 1: Арифметические операции")
    @Story("История 1.5: Деление на ноль")
    @Description("Этот тест проверяет деление на ноль.")
    @Severity(SeverityLevel.BLOCKER)
    public void testZeroDivision() {
        try {
            int result = 1 / 0;
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 3: Основные проверки")
    @Story("История 3.1: Соединение строк")
    @Description("Этот тест объединяет две строки.")
    @Severity(SeverityLevel.NORMAL)
    public void testStringConcatenation() {
        assertEquals("HelloWorld", "Hello" + "World");
    }


    // Этот тест я сделал специально провальным, для наглядности Allue отчета
    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 3: Основные проверки")
    @Story("История 3.2: Длина строки")
    @Description("Этот тест проверяет длину строки.")
    @Severity(SeverityLevel.MINOR)
    public void testStringLength() {
        assertEquals(4, "Hello".length());
    }

    // Этот тест я сделал специально провальным, для наглядности Allue отчета
    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 3: Основные проверки")
    @Story("История 3.3: Проверка подстроки")
    @Description("Этот тест проверяет, содержит ли строка заданную подстроку.")
    @Severity(SeverityLevel.CRITICAL)
    public void testStringContains() {
        assertEquals(true, "HelloWorld".contains("Petrushka"));
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 3: Основные проверки")
    @Story("История 3.4: Равенство строк")
    @Description("Этот тест проверяет, равны ли две строки.")
    @Severity(SeverityLevel.NORMAL)
    public void testStringEquality() {
        assertEquals("Hello", "Hello");
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 3: Основные проверки")
    @Story("История 3.5: Пустая строка")
    @Description("Этот тест проверяет, является ли строка пустой.")
    @Severity(SeverityLevel.TRIVIAL)
    public void testStringIsEmpty() {
        assertEquals(true, "".isEmpty());
    }


    @Test
    @Epic("Эпик 1: Основной функционал")
    @Feature("Фича 2: Дополнительные проверки с числами")
    @Story("История 2.1: Проверка четности числа")
    @Description("Этот тест проверяет, является ли число четным.")
    @Severity(SeverityLevel.NORMAL)
    public void testEvenNumber() {
        assertEquals(true, 4 % 2 == 0);
    }

    @Test
    @Epic("Эпик 1: Основной функционал")
    @Feature("Фича 2: Дополнительные проверки с числами")
    @Story("История 2.2: Проверка нечетности числа")
    @Description("Этот тест проверяет, является ли число нечетным.")
    @Severity(SeverityLevel.NORMAL)
    public void testOddNumber() {
        assertEquals(false, 5 % 2 == 0);
    }

    @Test
    @Epic("Эпик 1: Основной функционал")
    @Feature("Фича 2: Дополнительные проверки с числами")
    @Story("История 2.3: Минимальное значение")
    @Description("Этот тест проверяет минимальное значение из двух чисел.")
    @Severity(SeverityLevel.NORMAL)
    public void testMinValue() {
        assertEquals(3, Math.min(3, 5));
    }

    @Test
    @Epic("Эпик 1: Основной функционал")
    @Feature("Фича 2: Дополнительные проверки с числами")
    @Story("История 2.4: Максимальное значение")
    @Description("Этот тест проверяет максимальное значение из двух чисел.")
    @Severity(SeverityLevel.NORMAL)
    public void testMaxValue() {
        assertEquals(10, Math.max(10, 5));
    }

    @Test
    @Epic("Эпик 1: Основной функционал")
    @Feature("Фича 2: Дополнительные проверки с числами")
    @Story("История 2.5: Квадрат числа")
    @Description("Этот тест проверяет квадрат числа.")
    @Severity(SeverityLevel.NORMAL)
    public void testSquare() {
        assertEquals(16, Math.pow(4, 2), "Квадрат числа некорректен");
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.1: Соединение строки с пробелами")
    @Description("Этот тест проверяет соединение строк с пробелами.")
    @Severity(SeverityLevel.NORMAL)
    public void testStringConcatenationWithSpaces() {
        assertEquals("Hello World", "Hello " + "World");
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.2: Проверка отсутствия подстроки")
    @Description("Этот тест проверяет, что строка не содержит подстроку.")
    @Severity(SeverityLevel.CRITICAL)
    public void testStringNotContains() {
        assertEquals(false, "HelloWorld".contains("Moon"));
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.3: Подсчет символов")
    @Description("Этот тест проверяет количество символов в строке.")
    @Severity(SeverityLevel.NORMAL)
    public void testCharacterCount() {
        assertEquals(11, "Hello World".length());
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.4: Проверка перевода строки в верхний регистр")
    @Description("Этот тест проверяет преобразование строки в верхний регистр.")
    @Severity(SeverityLevel.NORMAL)
    public void testStringToUpperCase() {
        assertEquals("HELLO", "Hello".toUpperCase());
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.5: Проверка перевода строки в нижний регистр")
    @Description("Этот тест проверяет преобразование строки в нижний регистр.")
    @Severity(SeverityLevel.NORMAL)
    public void testStringToLowerCase() {
        assertEquals("hello", "Hello".toLowerCase());
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.6: Проверка символа в строке")
    @Description("Этот тест проверяет наличие символа в строке.")
    @Severity(SeverityLevel.NORMAL)
    public void testStringContainsCharacter() {
        assertEquals(true, "Hello".contains("e"));
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.7: Проверка индекса символа")
    @Description("Этот тест проверяет индекс первого появления символа в строке.")
    @Severity(SeverityLevel.NORMAL)
    public void testCharacterIndex() {
        assertEquals(1, "Hello".indexOf("e"));
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.8: Проверка замены символов")
    @Description("Этот тест проверяет замену символа в строке.")
    @Severity(SeverityLevel.NORMAL)
    public void testReplaceCharacter() {
        assertEquals("Jello", "Hello".replace("H", "J"));
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.9: Проверка начала строки")
    @Description("Этот тест проверяет, начинается ли строка с определенного символа.")
    @Severity(SeverityLevel.NORMAL)
    public void testStartsWith() {
        assertEquals(true, "Hello".startsWith("H"));
    }

    @Test
    @Epic("Эпик 2: Операции со строками")
    @Feature("Фича 4: Дополнительные проверки с числами")
    @Story("История 4.10: Проверка конца строки")
    @Description("Этот тест проверяет, заканчивается ли строка определенным символом.")
    @Severity(SeverityLevel.NORMAL)
    public void testEndsWith() {
        assertEquals(true, "Hello".endsWith("o"));
    }
}
