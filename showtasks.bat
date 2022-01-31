call .\runcrud
if "%ERRORLEVEL%" == "0" goto startbrowser
echo.
echo Initialization of runcrud.bat failed – breaking work
goto fail

:startbrowser
start chrome --new-window "http://localhost:8080/crud/v1/tasks"
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Page could not be opened – breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.