class Foo(val name: String) {
    fun printName(pt: (String) -> Unit) {
        pt(name)
    }

    fun upperName(pt: (String) -> String): String {
        val newName = pt(name)
        return newName
    }
}

fun nameToUpper(name: String): String {
    return name.uppercase()
}

fun main() {
    val foo: Foo = Foo("Foo")
    foo.printName({ name ->
        println(name.uppercase())
    })

    val foo1: Foo = Foo("bar")
    // Or we supply a lambda expression, according below.
    // Also, we can supply a function literally.

    val newName = foo1.upperName({ name ->
        nameToUpper(name)
    })
    println(newName)

    val anotherNewName = foo1.upperName(::nameToUpper)
    println(anotherNewName)
}
