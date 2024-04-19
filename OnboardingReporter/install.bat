@if "%DEBUG%" == "" @echo off
setlocal enabledelayedexpansion

set DIRNAME=%~dp0
CALL %DIRNAME%\..\findJava.bat 1.8.0
gradlew -b %DIRNAME%\build.gradle clean install

endlocal
