# TameOfThrones

This project is a solution to famous problem from GeekTrust.

# Prerequisites
1) Java8
2) Maven

# How to test ?

1) Change your working directory to this directory ( cd <PATH>/TameOfThrones )
  
2) Execute <b>mvn clean test</b>
  
# How to execute ?

<b>mvn clean test && mvn exec:java -Dexec.mainClass="com.everest.TOTController"</b>

# Sample Input & Output

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election
<b>Input:</b> 1
<b>Output:</b> None

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election
<b>Input:</b> 2
<b>Output:</b> None

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election
<b>Input:</b> 3
Air lOsadoowerph
lAnD adaklpdn
ICE daqwmeaopuieemxamvcofethMM


Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election
<b>Input:</b> 1
<b>Output:</b> space

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election
<b>Input:</b> 2
<b>Output:</b> [air, land, ice]

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election
<b>Input:</b> 4
Enter candidate names line by line ( Press <ENTER> at last to stop giving input ) >>
land
Space
Invalid Kingdom name..Ignoring
Invalid candidate:Space
space
air

<b>Output:</b> 
Results after round #1 ballot count
Allies for land : 1
Allies for air : 1
Allies for space : 0

Results after round #2 ballot count
Allies for land : 1
Allies for air : 0

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election
<b>Input:</b> 1
<b>Output:</b> land

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election
<b>Input:</b> 2
<b>Output:</b> [fire]

