import kotlin.math.sqrt
/*
//1. Функция для нахождения максимума
fun checkNum(num1: Int, num2: Int){
    if(num1>num2)
        println("Число " + num1 + " больше");
    else if(num1<num2)
        println("Число " + num2 + " больше");
    else
        throw Exception("Ошибка: Числа равны")
}

fun main(){
    try{
        val num1 = readLine()!!.toInt();
        val num2 = readLine()!!.toInt();

        println(checkNum(num1,num2));
    }
    catch(e: Exception){
        println(e.message)

    }
}


//2. Калькулятор деления

fun safeDivide(num1: Int, num2: Int): Int {
    if (num2 == 0) {
        throw ArithmeticException("Делить на ноль нельзя.")
    }
    return num1 / num2
}

fun main() {
    try {
        val result1 = safeDivide(10, 2)
        println("Результат: $result1")

        val result2 = safeDivide(10, 0)
        println("Результат: $result2")
    }
    catch (e: ArithmeticException) {
        println(e.message)
    }
}


//3. Конвертер строк в числа

fun stringToInt(str: String): Int {
    return try {
        str.toInt()
    }
    catch (e: NumberFormatException) {
        throw NumberFormatException("Невозможно преобразовать строку '$str' в целое число.")
    }
}

fun main() {
    try {
        val number1 = stringToInt("123")
        println("Число: $number1")

        val number2 = stringToInt("abc")
        println("Число: $number2")
    }
    catch (e: NumberFormatException) {
        println(e.message)
    }
}



//4. Проверка возраста

fun checkAge(age: Int): Int{
    if(age < 0 || age > 150){ throw  IllegalArgumentException("Недопустимый возраст")
    }
    else
    {println("возраст подтвержден")
        return age
    }
}

fun main() {
    try {
        val checkedAge1 = checkAge(5)
        val checkedAge2 = checkAge(-115)
    }
    catch (e: Exception){
        println(e.message)
    }
}


//5. Нахождение корня

import kotlin.math.sqrt

fun sqrtNum(num: Double){
    if(num < 0){ throw  IllegalArgumentException("Введено отрицательное число")
    }
    else
    { val sq=sqrt(num)
        println("Корень: '$sq'")
    }
}

fun main() {
    try {
        val checkedAge1 = sqrtNum(25.0)
        val checkedAge2 = sqrtNum(-115.0)
    }
    catch (e: Exception){
        println(e.message)
    }
}

//6. Факториал

import kotlin.math.sqrt

fun factorial(num: Int): Int{
    if(num < 0){ throw  IllegalArgumentException("Введено отрицательное число")
    }
    else if (num == 1 || num==0 ){
        return 1
    }
    else
    {
        return num * factorial(num - 1)
    }
}

fun main() {
    try {
        println("Факториал числа = " + factorial(5))
        println("Факториал числа = " + factorial(-5))
    }
    catch (e: Exception){
        println(e.message)
    }
}





//7. Проверка массива на нули

fun checkForZeros(array: IntArray) {
    if (array.contains(0))
        throw IllegalArgumentException("Массив содержит ноль.")
    else
        println("Массив не содержит нулей.")
}

fun main() {
    val array1 = intArrayOf(1, 2, 3, 4, 5)
    val array2 = intArrayOf(1, 2, 0, 4, 5)

    try
    {
        checkForZeros(array1)
        checkForZeros(array2)
    }
    catch (e: IllegalArgumentException) {
        println(e.message)
    }
}


//8. Калькулятор возведения в степень

import kotlin.math.pow

fun exp(base: Double, exponent: Double){
    if(exponent < 0){ throw  IllegalArgumentException("Введено отрицательное значение степени")
    }
    else
    {   val result = base.pow(exponent)
        println("Корень: '$result'")
    }
}

fun main() {
    val base1 = 10.0
    val exponent1 = 2.0

    val base2 = 2.0
    val exponent2 = -4.0

    try {
        exp(base1, exponent1)
        exp(base2, exponent2)
    }
    catch (e: Exception){
        println(e.message)
    }
}



//9. Обрезка строки

fun truncateString(inputStr: String, length: Int): String {
    if (length > inputStr.length) {
        val max =inputStr.length
        throw IllegalArgumentException("Число символов больше длины строки. Максимальная длина - '$max'")
    }
    return inputStr.take(length)
}

fun main() {
    val str = "Hello, World!"

    try {
        val truncatedStr1 = truncateString(str, 5)
        println("Обрезанная строка: $truncatedStr1")
        val truncatedStr2 = truncateString(str, 20)
        println("Обрезанная строка: $truncatedStr2")
    }
    catch (e: IllegalArgumentException) {
        println(e.message)
    }
}


//10. Поиск элемента в массиве

fun checkForItem(array: IntArray, element: Int) {
    if (array.contains(element))
        println("Массив содержит введеное элемент")
    else
        throw AbsenceElementException("Массив не содержит запрошенный элемент.")

}

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    val element = 4
    try
    {
        checkForItem(array, element)
    }
    catch (e: AbsenceElementException) {
        println(e.message)
    }
}

class AbsenceElementException(message: String) : Exception(message)

//11. Конвертация в двоичную систему

fun intToBinaryString(number: Int): String {
    if (number < 0) {
        throw IllegalArgumentException("Число не может быть отрицательным.")
    }
    return number.toString(2)
}

fun main() {
    try {
        val binaryString = intToBinaryString(10)
        println("Двоичное представление числа 10: $binaryString")
    }
    catch (e: IllegalArgumentException) {
        println(e.message)
    }
}




//12. Проверка делимости


fun safeDivide(num1: Int, num2: Int): Int {
    if (num2 == 0) {
        throw ArithmeticException("Делить на ноль нельзя.")
    }
    return num1 / num2
}

fun main() {
    try {
        val result1 = safeDivide(10, 2)
        println("Результат: $result1")

        val result2 = safeDivide(10, 0)
        println("Результат: $result2")
    }
    catch (e: ArithmeticException) {
        println(e.message)
    }
}





//13. Чтение элемента списка

fun getElementByIndex(list: List<Any>, index: Int): Any {
    if (index < 0 || index >= list.size) {
        throw IndexOutOfBoundsException("Индекс $index выходит за пределы списка.")
    }
    return list[index]
}

fun main() {
    val myList = listOf(1, 2, 3, 4, 5)

    try {
        val index = 22;
        val element = getElementByIndex(myList, index)

        println("Элемент по индексу $index : $element")
    } catch (e: IndexOutOfBoundsException) {
        println(e.message)
    }
}


//14. Парольная проверка

fun checkPasswordStrength(password: String) {
    if (password.length < 8) {
        throw WeakPasswordException("Пароль должен содержать не менее 8 символов.")
    }

    println("Пароль принят")
}

fun main() {

    val password = "str23"

    try {
        checkPasswordStrength(password)
    }
    catch (e: WeakPasswordException) {
        println(e.message)
    }
}

class WeakPasswordException(message: String) : Exception(message)

//16. Конкатенация строк

fun concatenateStrings(str1: String?, str2: String?): String {
    if (str1 == null || str2 == null) {
        throw NullPointerException("Одна из строк равна null.")
    }
    return str1 + str2
}

fun main() {
    val str1 = "Hello"
    val str2: String? = null

    try {
        val result = concatenateStrings(str1, str2)
        println("Результат: $result")
    }
    catch (e: NullPointerException) {
        println(e.message)
    }
}

//17. Остаток от деления

fun safeDivide(num1: Int, num2: Int): Int {
    if (num2 == 0) {
        throw ArithmeticException("Делить на ноль нельзя.")
    }
    return num1 % num2
}

fun main() {
    try {
        val result1 = safeDivide(10, 2)
        println("Результат: $result1")

    }
    catch (e: ArithmeticException) {
        println(e.message)
    }
}



//18. Квадратный корень

fun sqrtNum(num: Double){
    if(num < 0){ throw  IllegalArgumentException("Введено отрицательное число")
    }
    else
    { val sq=sqrt(num)
        println("Корень: '$sq'")
    }
}

fun main() {
    try {
        val checkedAge1 = sqrtNum(25.0)
    }
    catch (e: Exception){
        println(e.message)
    }
}

//19. Конвертер температуры

fun Fahrenheit(celsius: Double): Double {
    val absoluteZeroCelsius = -273.15
    if (celsius < absoluteZeroCelsius) {
        throw AbsoluteZeroException("Температура не может быть ниже абсолютного нуля.")
    }
    return (celsius * 9/5) + 32
}

fun main() {
    val temp = -925.0

    try {
        val fahrenheit = Fahrenheit(temp)
        println("'$temp' градусов Цельсия равно '$fahrenheit' градусов Фаренгейт.")
    }
    catch (e: AbsoluteZeroException){
        println(e.message)
    }
}
class AbsoluteZeroException(message: String) : Exception(message)


//20. Проверка строки на пустоту


fun checkString(str: String?) {
    if (str.isNullOrEmpty()) {
        throw EmptyOrNullStringException("Строка не может быть пустой или null.")
    }
    println("Строка корректна")
}

fun main() {
    val str: String? = null

    try {
        checkString(str)
    } catch (e: EmptyOrNullStringException) {
        println(e.message)
    }
}

class EmptyOrNullStringException(message: String) : Exception(message)*/