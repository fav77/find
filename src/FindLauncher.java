import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.*;

public class FindLauncher {

        @Option(name = "-d", metaVar = "directory", usage = "find in this directory")
        private String outputFile;

        @Option(name = "-r", metaVar = "true/false", usage = "use subdirectories")
        private Boolean useSubdirectories = false;

        @Argument(metaVar = "filename", usage = "Input file name")
        private String fileName;


        public static void main(String[] args) throws Exception {
            new FindLauncher().launch(args);
        }

        private void launch(String[] args) throws Exception {
            CmdLineParser parser = new CmdLineParser(this);

            try {
                parser.parseArgument(args);
            } catch (CmdLineException e) {
                System.err.println(e.getMessage());
                System.err.println("java -jar Find.jar -d directory -r true/false fileName");
                parser.printUsage(System.err);
                return;
            }
            Find find = new Find(outputFile, useSubdirectories);
            try (BufferedReader reader = new BufferedReader(new FileReader(find.find(fileName)))){
                BufferedWriter writer = new BufferedWriter(new FileWriter("files/output.txt"));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    writer.write(line);
                    writer.newLine();
                    line = reader.readLine();
                }
                writer.close();
            }
            System.out.println("Done") ;
        }
    }
