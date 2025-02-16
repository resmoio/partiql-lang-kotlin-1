package org.partiql.lang.eval

import org.partiql.lang.errors.ErrorCode
import org.partiql.lang.errors.Property
import kotlin.reflect.KClass

/**
 * Defines a error test case for query evaluation.
 */
data class EvaluatorErrorTestCase(
    /** The "group" of the tests--this only appears in the IDE's test runner and can be used to identify where in the
     * source code the test is defined.
     */
    val groupName: String?,

    /**
     * The query to be evaluated.
     */
    val sqlUnderTest: String,

    /**
     * The [ErrorCode] the query is to throw.
     */
    val errorCode: ErrorCode? = null,

    /**
     * The error context the query throws is to match this mapping.
     */
    val expectErrorContextValues: Map<Property, Any>,

    /**
     * The Java exception that is equivalent to the thrown Kotlin exception
     */
    val cause: KClass<out Throwable>? = null,

    /**
     * Expected result in the permissive mode. Default value is null.
     */
    val expectedPermissiveModeResult: String? = null,

    /**
     * The [CompileOptions] to be used when compiling the query.
     *
     * Some errors are only thrown when certain compile options are enabled.
     */
    val compOptions: CompOptions = CompOptions.STANDARD
) {

    constructor(
        input: String,
        errorCode: ErrorCode? = null,
        expectErrorContextValues: Map<Property, Any>,
        cause: KClass<out Throwable>? = null,
        compOptions: CompOptions = CompOptions.STANDARD,
        expectedPermissiveModeResult: String? = null
    ) : this(null, input, errorCode, expectErrorContextValues, cause, expectedPermissiveModeResult, compOptions)

    /** This will show up in the IDE's test runner. */
    override fun toString(): String {
        val groupNameString = if (groupName == null) "" else "$groupName"
        val causeString = if (cause == null) "" else ": $cause"
        return "$groupNameString $sqlUnderTest : $errorCode : $expectErrorContextValues $causeString"
    }
}
