import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

internal class CalculatorTest {

    @TestFactory
    fun `Expressions are evaluated correctly`() =
        listOf(
            "0" to 0,
            // "1 + 2" to 3,
            // ... more tests here
            // "(1 + 2) * 5 / 2 + -3 * 7" to -14,
        ).map { (expression, expected) ->
            dynamicTest(
                "\"$expression\""
            ) {
                // when the expression is evaluated
                val result = evaluate()

                // then it should equal the expected result
                assertEquals(expected, result)

            }
        }
}