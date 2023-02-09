//package old.famous_interview.stack
//
//class ParenthesisFunction {
//    fun main(){
//        val a  = mutableListOf<String>("a", "b", "c")
//
//        a.forEach {
//            it.printResult {
//                val data = it.plus(" Bishal")
//                data
//            }
//        }
//    }
//
//    public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
//        for (element in this) action(element)
//    }
//
//    public inline fun <String> String.printResult(action : (String) -> kotlin.String): Unit{
//       val d =  action(this)
//        println(d)
//    }
//}
