package scoreCalculator;

public class Main {
    public static void main(String args[]) {
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                validateNumArgs("init", args, 1);
                Repository.init();
                break;
            case "add":
                // sequence: courseName coursePoint score gradePoint
                // This will create a map between course and score
                validateNumArgs("add", args, 5);
                Repository.add(args[1], Integer.parseInt(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]));
                break;
            case "calculate":
                validateNumArgs("calculate", args, 2);
                Repository.calculate(args[1]);
                break;
            case "clear":
                /** clear all the scores in the file */
                validateNumArgs("clear", args, 1);
                Repository.clear();
                break; 
        }
    }

    public static void validateNumArgs(String cmd, String[] args, int num) {
        if (args.length != num) {
            System.out.println("Invalid number of arguments for command: " + cmd);
            System.exit(0);
        }
    } 
}
