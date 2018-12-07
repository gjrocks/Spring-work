@echo off
set back=%cd%
for /d %%i in (C:\Users\gjadhav\Documents\workspace-sts-3.9.4.RELEASE\*) do (
cd "%%i"
mvn clean
)
cd %back%