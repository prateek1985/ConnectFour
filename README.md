## Connect Four Game for 2 players

## Required
Java 8 or above

## To run from terminal

### 1. Go inside src folder 

    cd ./src

### 2. Compile main class
    javac GameCoordinator.java

### 3. Run main class
    java GameCoordinator

---------------------------------------

###  Things that I would have liked to add, change or improve in this solution

```
- Add Junit tests with high code coverage

- Currently only game is meant for 2 players based on requirements but in future if it becomes multiplayer then I would like 
  take number of players as input in begining and create players array and give turns in Game accordindly

- Preferrably use Spring boot framework & gradle  if we want to deploy this as an app on servers as Game grows bigger
   in future for easy dependency management and framework's other benefits  
  
- Since I am taking input from user better to add some HTML sanitizer using some standard library for security purpose
  so to avoid any malacious scripts from attacker
  
- For matching Patterns like "RRRR" or "GGGG" in grid to check if player won I am using "String.contains" method of Java which is not optimal
  hence better String matching algorithm can be implemented that give linear time complexity here in this case it does
  not matter as grid size in board in small 


```
