package MainModules;

import DataPackage.Variable;
import Modules.CheckFilesAndDirectory;
import Modules.GetIp;
import Modules.Logger;
import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.Date;

import static java.lang.System.out;

public class MainMenu extends Variable {
    Date date = new Date();



    public void Menu() {
        out.print("Welcome " + nameProperty + " to the program!\n" +
                "Input your command: ");
        setChooseAction(scanner.nextLine());

        new Logger().commandLoggerWriter(getChooseAction());
        if(chooseAction.contains("string") || chooseAction.contains("String")) {
            out.println("Available methods for string:\n " +
                    "Substring\n " +
                    "Append\n" +
                    " toLowerCase"+
                    "\n toUpperCase"+
                    "\n Replace");
            out.print("Enter method: ");
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("substring")) {
                new StringProcessing().substringString();
            }
            if (chooseAction.contains("contains")) {

            }

            if(chooseAction.contains("append")){
               new StringProcessing().appendString();
            }
            if(chooseAction.contains("tolowercase")){
               new StringProcessing().toLowerCaseString();
            }
            if(chooseAction.contains("touppercase")){
               new StringProcessing().toUpperCaseString();
            }
            if(chooseAction.contains("replace")){
               new StringProcessing().replaceString();
            }
        }
        if(chooseAction.contains("calc")) {
            new Calculator().calculator();
        }
        if(chooseAction.contains("info")) {
            out.println("Available methods for info:\n " +
                    "System");
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("system")) {
               new SystemInfo().getSystemInfo();
            }
        }
        if(chooseAction.contains("time")){
            Date date = new Date();
            out.println("Current time: " + date);
            out.println("--------------------------------");
            Menu();
        }
        if(chooseAction.contains("ip")){
                out.println("Your ip: "  + new GetIp().getIp());
        }
        if(chooseAction.contains("check")){
            new CheckFilesAndDirectory().allCheck();
            out.println("Check complete.");
            new MainMenu().Menu();

        }
        if(chooseAction.contains("log")){
            out.println("Available methods for log:\n " +
                    "Show\n" +
                    "");
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("show")) {
                out.println("1 - All logs   2 - Commands log  3 - Session logs");
                setEnterChooseNumber(scanner.nextInt());
                int chooseNumber = getEnterChooseNumber();
                if(chooseNumber == 1){
                    try {
                        new LogReader().allLogReader();
                        mm.Menu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (chooseNumber == 2) {
                    try {
                        new LogReader().logCommandReader();
                        mm.Menu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (chooseNumber == 3) {
                    try {
                        new LogReader().logSessionReader();
                        mm.Menu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
        if(chooseAction.contains("exit")){
            out.println("Bye bye!");
            System.exit(0);
        }
    }
}

