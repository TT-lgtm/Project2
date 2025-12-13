import com.sun.jdi.connect.Connector.StringArgument
import java.lang.Exception
fun main() {
    var exitProgram = true
    while (exitProgram)
    {
        var taskNum: Int? = null
        while (taskNum == null)
        {
            print("Выберите номер задания для запуска (1-5): ")
            val inputTask = readln().trim()

            if (inputTask.isEmpty())
            {
                println("Ошибка: ввод не может быть пустым")
                continue
            }
            try {
                val num = inputTask.toInt()
                if (num in 1..5) {
                    taskNum = num
                }
                else
                {
                    println("Ошибка: номер задания должен быть от 1 до 5")
                }
            } catch (e: Exception) {
                println("Ошибка: введено не число. Требуется целое число от 1 до 5")
            }
        }
        try {
            when (taskNum) {
                1 -> taskNum1()
                2 -> taskNum2()
                3 -> taskNum3()
                4 -> taskNum4()
                5 -> taskNum5()
            }
        } catch (e: Exception) {
            println("Ошибка при вводе в задание ${taskNum}!")
        }
        var exitConfirmed = false
        while (!exitConfirmed)
        {
            print("Хотите завершить работу программы? (Да/Нет): ")
            val inputExit = readln().trim().lowercase()
            when
            {
                inputExit in listOf("да", "yes", "д", "y") ->
                {
                    exitProgram = false
                    exitConfirmed = true
                }
                inputExit in listOf("нет", "no", "н", "n") ->
                {
                    println("----------------------------------------")
                    exitConfirmed = true
                }
                else -> println("Ошибка: введите 'Да' или 'Нет'")
            }
        }
    }
    println("Программа завершена")
}

fun taskNum1(){
    print("Введите количество строк в массиве: ")
    val n = readln()
    print("Введите количество столбцов в массиве: ")
    val m = readln()
    println("Заполните массив трехзначными числами")
    val mas = Array(n.toInt()) {IntArray(m.toInt())}
    for(i in 0 until n.toInt())
    {
        for(j in 0 until m.toInt())
        {
            do {
                print("mas["+i+"]["+j+"] = ")
                mas[i][j]= readln().toInt()
                if(mas[i][j]>999 || mas[i][j]<100){
                    print("Повторите ввод: ")
                }
            } while (mas[i][j]>999 || mas[i][j]<100)
        }
    }
    for(i in 0 until n.toInt())
    {
        for(j in 0 until m.toInt())
        {
            print(mas[i][j])
            print(" ")
        }
        println()
    }
    val used = BooleanArray(10)
    for(i in 0 until n.toInt())
    {
        for(j in 0 until m.toInt())
        {
            val s=mas[i][j].toString()
            for (ch in s) {
                used[ch - '0'] = true
            }
        }
    }
    var count=0
    for (b in used)
    {
        if (b)
            count++
    }
    println("В массивые использовано $count различных цифр")
}
fun taskNum2() {
    val n = 5
    val m = 5
    println("Заполните массив 5 на 5 элементами: ")
    val mas = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            print("mas[" + i + "][" + j + "] = ")
            mas[i][j] = readln().toInt()
        }
    }
    var simm = true
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (mas[i][j] != mas[j][i]) {
                simm = false
                break
            }
        }
    }
    for (i in 0 until n){
        for (j in 0 until m){
            print(mas[i][j])
            print(" ")
        }
        println()
    }
    if (simm)
        println("Матрица симметрична")
    else
        println("Матрица несимметрична")
}

fun taskNum3(){
    val alphabet = listOf('А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О',
        'П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я')

    val numbers = listOf(21,13,4,20,22,1,25,12,24,14,2,28,9,23,3,29,
        6,16,15,11,26,5,30,27,8,18,10,33,31,32,19,7,17)

    val map = alphabet.zip(numbers).toMap()
    val reverseMap = numbers.zip(alphabet).toMap()

    print("Введите текст: ")
    val text = readLine()!!.uppercase()
    print("Введите ключевое слово: ")
    val key = readLine()!!.uppercase()
    print("Зашифровать (1) или расшифровать (2): ")
    val mode = readLine()!!.toInt()

    var result = "";
    for (i in text.indices) {
        val letter = text[i]
        if (letter !in map.keys) {
            result += letter
            continue
        }
        val letterNum = map[letter]!!
        val keyLetter = key[i % key.length]
        val keyNum = map[keyLetter]!!

        val shift =
            if (mode == 1)
                letterNum + keyNum
            else
                letterNum - keyNum

        val newNum = ((shift - 1) % 33 + 33) % 33 + 1
        result += reverseMap[newNum]
    }

    if (mode == 1) println("Зашифровано: $result")
    else println("Расшифровано: $result")
}

fun taskNum4(){
    println("Введите элементы первого массива через пробел:")
    val arr1 = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }.toMutableList()
    println("Введите элементы второго массива через пробел:")
    val arr2 = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }

    val list1 = arr1.toMutableList()
    val result = mutableListOf<Int>()

    for (num in arr2) {
        if (num in list1) {
            result.add(num)
            list1.remove(num)
        }
    }
    println("Пересечение этих массивов: $result")
}

fun taskNum5(){
    println("Введите слова через пробел:")
    val words = readLine()!!.trim().split(Regex("\\s+")).toTypedArray()
    val groups = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val key = word.toCharArray().sorted().joinToString("")
        if (key !in groups)
            groups[key] = mutableListOf()
        groups[key]!!.add(word)
    }

    for (group in groups.values) {
        println(group.joinToString(", "))
    }
}
