@echo off

set MAVEN_OPTS=-Xms768m -Xmx1359m


call mvn -Dmaven.test.skip=true clean install

pause

:end
exit /b 0
