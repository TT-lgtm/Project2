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
            //   3 -> taskNum3()
            //   4 -> taskNum4()
            //  5 -> taskNum5()
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
    val used = BooleanArray(10) //используем Boolean, т.к. неам нужно true/false
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
    val mas = Array(n.toInt()) { IntArray(m.toInt()) }
    for (i in 0 until n.toInt()) {
        for (j in 0 until m.toInt()) {
            print("mas[" + i + "][" + j + "] = ")
            mas[i][j] = readln().toInt()
        }
    }
    var simm = true
    for (i in 0 until n.toInt()) {
        for (j in 0 until m.toInt()) {
            if (mas[i][j] != mas[j][i]) {
                simm = false
                break
            }
        }
        if (simm)
            println("Матрица симметрична")
        else println("Матрица несимметрична")
    }
}
fun taskNum3(){}
fun taskNum4(){}
fun taskNum5(){}fun main(args: Array<String>) {
    var exitProgram = true
    do {
        print("Выберите номер задания для запуска (всего заданий 5 (1-5)): ")
        val inputTask = readln()
        val taskNum = inputTask.toInt()
        when (taskNum){
            1 -> taskNum1()
            2 -> taskNum2()
            //   3 -> taskNum3()
            //   4 -> taskNum4()
            //  5 -> taskNum5()
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
    val used = BooleanArray(10) //используем Boolean, т.к. неам нужно true/false
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
    val mas = Array(n.toInt()) { IntArray(m.toInt()) }
    for (i in 0 until n.toInt()) {
        for (j in 0 until m.toInt()) {
            print("mas[" + i + "][" + j + "] = ")
            mas[i][j] = readln().toInt()
        }
    }
    var simm = true
    for (i in 0 until n.toInt()) {
        for (j in 0 until m.toInt()) {
            if (mas[i][j] != mas[j][i]) {
                simm = false
                break
            }
        }
        if (simm)
            println("Матрица симметрична")
        else println("Матрица несимметрична")
    }
}
fun taskNum3(){}
fun taskNum4(){}
fun taskNum5(){}