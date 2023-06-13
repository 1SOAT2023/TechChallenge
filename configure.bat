@echo off
echo Digite o nome do banco de dados:
set /p "Input1=Digite o nome do banco de dados: "
setx POSTGRES_DB %Input1%

echo Digite o nome do usuario:
set /p "Input2=Digite o nome do usuario: "
setx POSTGRES_DB %Input2%

echo Digite a senha:
set /p "Input3=Digite a senha: "
setx POSTGRES_DB %Input3%

docker compose up