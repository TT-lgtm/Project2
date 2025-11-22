import com.sun.jdi.connect.Connector.StringArgument
fun main(args: Array<String>) {
    var exitProgram = true
    do {
        print("Выберите номер задания для запуска (всего заданий 5 (1-5)): ")
        val inputTask = readln()
        val taskNum = inputTask.toInt()
        when (taskNum){
            1 -> taskNum1()
            2 -> taskNum2()
            3 -> taskNum3()
            4 -> taskNum4()
            5 -> taskNum5()
            else -> break
        }
        println("Хотите завершить работу программы?")
        val inputExit = readln()
        if(inputExit=="Да" || inputExit=="да" || inputExit=="Yes" || inputExit=="yes") {
            exitProgram = false
        }
        else {
            println("----------------------------------------")
        }
    } while (exitProgram)
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
    val used = BooleanArray(10) //используем Boolean, т.к. нам нужно true/false
    for(i in 0 until n.toInt())
    {
        for(j in 0 until m.toInt())
        {
            val s=mas[i][j].toString()
            for (ch in s) used[ch-'0']=true //(ch in s) перебирает строку s по одному символу ch, и переводит символьную цифру ch в числовое значение, из char в int
        }
    }
    var count=0
    //пройтись по всем элементам массива used, для каждого элемента b- если b==true, то увеличить count на 1
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
    if (simm)
        println("Матрица симметрична")
    else println("Матрица несимметрична")
}

fun taskNum3(){
    val alphabet = listOf('А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О',
        'П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я')

    val numbers = listOf(21,13,4,20,22,1,25,12,24,14,2,28,9,23,3,29,
        6,16,15,11,26,5,30,27,8,18,10,33,31,32,19,7,17)

    val map = alphabet.zip(numbers).toMap()
    //.zip берёт два списка одинаковой длины и "склеивает" их попарно, т.е. А=21, Б=13 и т.д.
    //.toMap() превращает список пар в словарь, т.е теперь вводя map['П'] можешь узнать ее число
    val reverseMap = numbers.zip(alphabet).toMap()

    print("Введите текст: ")
    val text = readLine()!!.uppercase()
    //!!- гарантирует, что здесь НЕ null и просит использовать значение
    //.uppercase() преобразует строку в верхний регистр, все буквы становятся заглавными
    print("Введите ключевое слово: ")
    val key = readLine()!!.uppercase()
    print("Зашифровать (1) или расшифровать (2): ")
    val mode = readLine()!!.toInt()

    var result = ""
    for (i in text.indices) {
        val letter = text[i]
        if (letter !in map.keys) {
            //Если буквы нет в алфавите
            result += letter
            continue
        }
        val letterNum = map[letter]!! //ищет число, которое соответствует букве, точно не null
        val keyLetter = key[i % key.length] //берёт остаток от деления, чтобы ключ повторялся по кругу
        val keyNum = map[keyLetter]!!

        val shift = if (mode == 1) letterNum + keyNum else letterNum - keyNum
        val newNum = ((shift - 1) % 33 + 33) % 33 + 1
        result += reverseMap[newNum]
    }

    if (mode == 1) println("Зашифровано: $result")
    else println("Расшифровано: $result")
}

fun taskNum4(){
    println("Введите элементы первого массива через пробел:")
    val arr1 = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }.toMutableList()
    //.trim() Убирает пробелы в начале и конце строки
    //.split(Regex("\\s+")) разбивает строку на части по любому количеству пробелов
    //\\s+ означает-- один или более пробельных символов
    //.map { it.toInt() } каждый элемент списка превращается из строки в число
    //.toMutableList() создаёт изменяемый список, чтобы можно было удалять элементы
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
        //word.toCharArray() преобразует слово в массив букв
        //.sorted() сортирует буквы по алфавиту
        //.joinToString("") склеивает отсортированные буквы обратно в строку
        if (key !in groups) groups[key] = mutableListOf()
        groups[key]!!.add(word)
    }

    for (group in groups.values) {
        println(group.joinToString(", "))
    }
}
