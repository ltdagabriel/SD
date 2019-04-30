1) Fazer um código para o Cliente e Servidor se comunicarem. O cliente envia e recebe mensagens. O servidor envia e recebe mensagens. Quando algum dos dois enviar 'SAIR', a comunicação entre eles deve ser finalizada. Use o TCP.


2) Faça uma interface gráfica para os clientes de chat e que possibilite vários clientes enviarem e visualizarem mensagens de os outros clientes conectados. Use o TCP.


3)  Faça um servidor para processar as seguintes mensagens dos clientes. O servidor deve suportar mensagens de múltiplos clientes. Use o TCP.

As mensagens estão no formato String UTF:

TIME

* Retorna a hora do sistema como uma String UTF no formato HH:MM:SS

DATE

* Retorna a data do sistema como uma String UTF no formato DD/MM/AAAA

FILES

* Retorna os arquivos da pasta definida por padrao (p. ex. /home/user/shared)

* retorna um inteiro indicando o número de arquivos

* envia o nome de um arquivo por vez como uma String UTF

DOWN nome-arquivo

* Faz o download do arquivo nome-arquivo

* retorna 0 se nome não existe ou retorna o tamanho do arquivo

* lê o número de bytes indicado por tamanho do arquivo e grava em um diretório padrão

EXIT

* Finaliza a conexão

4) Fazer uma aplicação com um servidor que gerencia a comunicação entre dois clientes usando TCP. Para cada cliente é criada uma thread no servidor. A comunicação entre as threads deve usar recursos como pipe ou memória compartilhada.

5) Faça uma aplicação com um servidor que gerencia um conjunto de arquivos remotos entre múltiplos usuários.  O servidor deve responder aos seguintes comandos:

-> ADDFILE (1): adiciona um arquivo novo.  (OPCIONAL)

-> DELETE (2):  remove um arquivo existente.

-> GETFILESLIST (3): retorna uma lista com o nome dos arquivos.

-> GETFILE (4): faz download de um arquivo.

O servidor deve registrar as ações em logs.

As solicitações possuem o seguinte formato:

1 byte: requisição(1)

1 byte: código do comando

1 byte: tamanho do nome do arquivo

variável: nome do arquivo (0-255 bytes)

As respostas possuem o seguinte formato:

1 byte: resposta(2)

1 byte: código do comando

1 byte: status code (1-SUCCESS, 2-ERROR)

----

para o GETFILESLIST adiciona-se os campos

2 bytes: número de arquivos (big endian order)

repete-se até terminar os nomes:

1 byte: tamanho do nome (1-255)

variável: nome do arquivo

----

para o GETFILE adiciona-se os campos

4 bytes: tamanho do arquivo (big endian order)

variável: bytes do arquivo.

----

para o ADDFILE adiciona-se os campos

4 bytes: tamanho do arquivo (big endian order)

variável: bytes do arquivo.

* ao fazer download do arquivo, grave em uma pasta padrão.

Última atualização: segunda, 8 Abr 2019, 16:47