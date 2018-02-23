# Tic-Tac-Toe Game #

## General Info and Game configuration before starting the Game:
* All game specific configurations are kept in config file [config.properties](src/main/resources/config.properties)
* Before running application, Game admin can decide playfield size by providing value for 'playfieldsize' key in the config file.
* Allowed limit for 'playfieldsize' value is in between 3 to 10 only.
* 'playfieldsize' will decide the board size of the game.
e.g. If playfieldsize= 3 then board size will 3x3  
* Total no. of players are three.
* This game is designed in such a way that two (human)users will play against each other 
and against computer.
* Game admin can configure who will be first,second and third player and also who is the computer
 among three players.
*  Also Game admin can configure any single character as a sign to each player in the config file.

## How to start application/game:
### starting the application in Intellij
* Run the application class [TicTacToeApplication](src/main/java/com/game/TicTacToeApplication.java)

### Starting the application in terminal
* Make sure your JAVA_HOME environment variable is set to jre version 1.8
* Make sure your ~/.m2/settings.xml is inplace and correctly configured.
* In terminal ,navigate to current project directory. for ex. cd $PROJECT_DIR_PATH/Tic-Tac-Toe
* Run command `mvn package`
* Now, run command `java -jar target/Tic-Tac-Toe-1.0-SNAPSHOT.jar`

## How to play
* By any above means, once you have started the game then application will read the configurations
from config file and will initialize the game accordingly.
* After the game initialization, If Player-1 is human, then player will be prompted to enter valid move which is comma separated
numbers which denotes to the position of the board's cell.
e.g 1,1 is the top left corner position of the board.
* After valid move from player-1, game console will prompt player-2 (if player-2 is human) to enter valid move else it will automatically
ask computer to play its move.
* One after another all players will play their moves until its draw or win.

## Unit Testing
* No extra configuration needed to run below Junit test classes apart from Junit library.
* You can run Test classes directly from Intellij IDE
* Test classes:
1) [ConfigValidationTest](src/test/java/com/game/validation/ConfigValidationTest.java) :
    Test class for `ConfigValidation` class which checks validation scenarios for properties provided in config.properties file.
2) [BoardTest](src/test/java/com/game/component/BoardTest.java):
    Test class for `Board` which tests checkForWin and checkForDraw scenarios.
3) [RegexUtilTest](src/test/java/com/game/util/RegexUtilTest.java)
    Test class for `RegexUtil` class which test regex pattern of provided input String
