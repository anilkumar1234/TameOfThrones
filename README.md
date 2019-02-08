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
4) Select ruler by election<br/>
<b>Input:</b> 1<br/>
<b>Output:</b> None

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 2<br/>
<b>Output:</b> None

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 3<br/>
Air lOsadoowerph<br/>
lAnD adaklpdn<br/>
ICE daqwmeaopuieemxamvcofethMM<br/>


Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 1<br/>
<b>Output:</b> space<br/>

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 2<br/>
<b>Output:</b> [air, land, ice]<br/>

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 4<br/>
land<br/>
space<br/>
air<br/>

<b>Output:</b> <br/>
Results after round #1 ballot count<br/>
Allies for land : 1<br/>
Allies for air : 1<br/>
Allies for space : 0<br/>

Results after round #2 ballot count<br/>
Allies for land : 1<br/>
Allies for air : 0<br/>

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 1<br/>
<b>Output:</b> land<br/>

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 2<br/>
<b>Output:</b> [fire]<br/>

