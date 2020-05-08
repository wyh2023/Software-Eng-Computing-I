package edu.nju;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class CommandLineUtilTest {
    private static CommandLineUtil commandlineUtil;
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void init(){
        commandlineUtil = new CommandLineUtil();
    }


    @Test
    public void testHelp() {
        String input = "-h -s arg0 -p hello";
        runMain(input);
        assertFalse(commandlineUtil.getSideEffectFlag());
        String console = systemOutRule.getLogWithNormalizedLineSeparator();
        assertTrue(console.equals("help\n"));
    }

    @Test
    public void testSideEffect(){
        String input = "-s arg0";
        runMain(input);
        assertTrue(commandlineUtil.getSideEffectFlag());
    }

    @Test
    public void testPrint(){
        String input = "-p hello arg0";
        runMain(input);
        assertEquals("hello\n",systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void testMissingOptionArg(){
        String input = "arg0 -p ";
        exit.expectSystemExitWithStatus(-1);
        runMain(input);
        String errorMessage = "Missing argument for option: p\n";
        assertEquals(errorMessage,systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void testMissingUserArg(){
        String input = "-p hello";
        runMain(input);
        String console = systemOutRule.getLogWithNormalizedLineSeparator();
        assertEquals(CommandLineUtil.WRONG_MESSAGE+"\n",console);
    }

    private void runMain(String input){
        String[] args = input.split(" ");
        commandlineUtil.main(args);
    }
}
