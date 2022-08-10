package core

class CreateOrganismFeature : FunctionFeature<Any, Any> {
    override fun execute(input: Any): Result<Any> {
        TODO("Not yet implemented")
    }

}


interface Feature

interface FunctionFeature<in I, out O> : Feature {
    fun execute(input: I): Result<O>
}

interface RunnableFeature : Feature {
    fun execute(): Result<Unit>
}

interface ConsumerFeature<in I> : Feature {
    fun execute(input: I): Result<Unit>
}

interface SupplierFeature<out O>: Feature {
    fun execute(): Result<O>
}

/***
 * 	                0 in (arguments)	    1 in (argument)
0 out (returned)	Runnable	            Consumer
1 out (returned)	Supplier	            Function
 */
