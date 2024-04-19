@if "%DEBUG%" == "" @echo off
setlocal

set DIRNAME=%~dp0
gradlew -b %DIRNAME%\build.gradle publish

endlocal
