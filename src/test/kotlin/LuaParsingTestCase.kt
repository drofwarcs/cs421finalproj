import com.cs.languageplugin.LuaParserDefinition
import com.intellij.testFramework.ParsingTestCase

class LuaParsingTestCase :  ParsingTestCase("", "lua", LuaParserDefinition()){


    fun testParsingTestData(){
        doTest(true)
    }
    override fun getTestDataPath(): String {
        return "src/test/testData"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}