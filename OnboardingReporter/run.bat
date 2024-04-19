@if "%DEBUG%" == "" @echo off
setlocal enabledelayedexpansion

set DIRNAME=%~dp0

CALL %DIRNAME%\..\findJava.bat 1.8.0

SET JAVA_OPTS=%JAVA_OPTS% -DrallyJdwpPort=8004 -DrallySshPort=2004

gradlew -b %DIRNAME%\build.gradle bootRun

endlocal
