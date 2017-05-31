import org.junit.Test
import org.junit.Assert.*
import java.io.File
import java.nio.charset.Charset

    class FindTest {
        private fun assertFileContent(nameOut: String, nameIn: String) {
            val fileExpected = File(nameOut)
            val fileOut = File(nameIn)
            val contentExpected = fileExpected.readLines()
            val contentOut = fileOut.readLines()
            assertEquals(contentOut, contentExpected)
        }
        @Test
        fun main() {
            var inputString = arrayOf<String>("-d" , "D:/Test/new" , "Out.txt")
            FindLauncher.main(inputString)
            assertFileContent("files/output.txt" , "files/outputExpected.txt")

            inputString = arrayOf<String>("-r" , "-d" , "D:/Test" , "Out.txt")
            FindLauncher.main(inputString)
            assertFileContent("files/output.txt" , "files/outputExpected.txt")
        }

    }