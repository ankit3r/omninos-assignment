fun main(){

    val data = listOf(1,2,3,4,5)


    print("rangeTo() methode \n")
    for (i in 1.rangeTo(5)){
        print("$i\t")
    }
    print("\nStet() methode \n")
    for (i in (1..10).step(2)){
        print("$i\t")
    }
    print("\ndownTo() methode \n")
    for (i in 10.downTo(5)){
        print("$i\t")
    }
    print("\nreversed() methode \n")
    for (i in (1..10).reversed()){
        print("$i\t")
    }
    print("\nuntil() methode \n")
    for (i in 1 until 10){
        print("$i\t")

    }

    val result = calculate(4, 5, ::sum)
    println( "\nHigher order function $result" )
}

fun sum(a: Int, b: Int) = a + b

fun calculate(a: Int, b: Int, operation:(Int, Int) -> Int): Int {
    return operation(a, b)
}