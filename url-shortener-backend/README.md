# walking robot

### Test

clone this repo

run

```
#Movimento com rotações para direita:
curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
#Saída esperada: (2, 0, S)
#Movimento para esquerda:
Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
#Saída esperada: (0, 2, W)
#Repetição da requisição com movimento para esquerda:
Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
#Saída esperada: (0, 2, W)
#Comando inválido:
curl -s --request POST http://localhost:8080/rest/mars/AAA
#Saída esperada: 400 Bad Request
#Posição inválida:
curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
#Saída esperada: 400 Bad Request

```
