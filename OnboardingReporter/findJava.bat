echo off

SET RSR_JAVA_HOME=
SET TARGET_VERSION=%1

:: find java from home env
ECHO LOOKUP JAVA FROM ENVIRONMENT
set JAVA_HOME_CANDIDATES="%JAVA_HOME%,%JAVA8_HOME%,%JAVA8HOME%"
FOR /F "delims=," %%a in (%JAVA_HOME_CANDIDATES%) do (
  IF %%a NEQ "" (
    IF "!RSR_JAVA_HOME!" EQU "" (
      "%%a\bin\java.exe" -version 2>&1 | find "java version ""%TARGET_VERSION%" > NUL
      IF !ERRORLEVEL! EQU 0 (
        ECHO FOUND JAVA HOME UNDER %%a
        set RSR_JAVA_HOME=%%a
      )
    )
  )
)
IF "%RSR_JAVA_HOME%" NEQ "" GOTO JAVA_FOUND

:: find jdk paths under java dir
ECHO LOOKUP JAVA FROM JDK INSTALLATIONS
for /F %%a in ('dir "C:\Program Files\Java" /B /O:D^|find "jdk%TARGET_VERSION%"') do (
  IF "!RSR_JAVA_HOME!" EQU "" (
    ECHO FOUND JDK UNDER %%a
    set RSR_JAVA_HOME=C:\Program Files\Java\%%a
  )
)
IF "%RSR_JAVA_HOME%" NEQ "" GOTO JAVA_FOUND


:JAVA_FOUND
IF "%RSR_JAVA_HOME%" NEQ "" (
  ECHO SETTING JAVA HOME TO %RSR_JAVA_HOME%
  SET JAVA_HOME=%RSR_JAVA_HOME%
)
