package edu.nju;

import org.apache.commons.cli.*;

public class CommandLineUtil {
    private static CommandLine commandLine;
    private static CommandLineParser parser = new DefaultParser();
    private static Options options = new Options();
    private boolean sideEffect;
    public static final String WRONG_MESSAGE = "Invalid input.";

    /**
     * you can define options here
     * or you can create a func such as [static void defineOptions()] and call it before parse input
     */
    static {
        options.addOption("h","help",false,"打印出所有预定义的选项与用法");
        options.addOption("p","print",true,"print the information");
        options.addOption( OptionBuilder.withLongOpt( "print" )
                .withDescription("print the information")
                .hasArg()
                .withArgName("information")
                .create());
        Option side_effect = new Option("s", "switch the sideEffect");
        options.addOption(side_effect);
    }

    public void main(String[] args){
        try {
            // parse the command line arguments
            CommandLine line = parser.parse( options, args );
            String[] s = line.getArgs();
            if( line.hasOption( "h" ) ) {
                // print the value of block-size
                System.out.println( "help" );
            } else if (s.length == 0){
                System.out.println(WRONG_MESSAGE);
            } else {
                if( line.hasOption( "p" ) ) {
                    // print the value of block-size
                    System.out.println( line.getOptionValue( "p" ) );
                }
                if( line.hasOption( "s" ) ) {
                    sideEffect = true;
                }
            }

        }
        catch( ParseException exp ) {
            System.out.println(  exp.getMessage() );
            System.exit(-1);
        }
    }

    /**
     * Print the usage of all options
     */
    private static void printHelpMessage() {
    }

    /**
     * Parse the input and handle exception
     * @param args origin args form input
     */
    public void parseInput(String[] args) {
    }

    /**
     * You can handle options here or create your own func
     */
    public void handleOptions() {

    }

    public boolean getSideEffectFlag(){
        return sideEffect;
    }

}
