# scoreCalculator

## description and acknowledgement
To store course and score record persistently on the disk, calculate average score, average point,etc. Thanks to the CS61B proj2:gitlet, the file Utils.java and GitletException.java comes from this project, making it easier to interact with file operations with java.

## platform
git bash or other bash

## usage
change directory to the directory which folder scoreCalculator is in.
```bash
javac scoreCalculator/*.java
```
Then you can use the following command:
1. `java scoreCalculator.Main init`:

This command will create a `.score` directory in your current directoy, within which you will
find a file called `myscore`.`myscore` contains information which have been serialized.Note that
a `init` command is **NECESSAY** for every user.

2. `java scoreCalculator.Main add [coursename] [coursepoint] [score] [gradepoint]`

This command will create a new record about your score as well as its related course.

3. `java scoreCalculator.Main clear`

This command will clear all the information in the file `myscore`.Be careful with this!

4. `java scoreCalculator.Main calculate averagescore`

This command will calculate the average score of all the course recorded.

5. `java scoreCalculator.Main calculate averagepoint`

This command will calculate the average point of all the course recorded.

6. to be continued...



