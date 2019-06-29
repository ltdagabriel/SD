# -*- coding: utf-8 -*-

# Faça uma implementação usando Sun RPC ou gRPC para um serviço remoto de gerenciamento de músicas/livros que
# possibilita adicionar, remover e consultar músicas/livros.


# python -m conda install -c anaconda grpcio-tools.protoc -I. --python_out=. --grpc_python_out=. helloworld.proto
from concurrent import futures
import time
import grpc
from src.atividade_5_RPC.livro_pb2_grpc import GreeterServicer, add_GreeterServicer_to_server
from src.atividade_5_RPC.livro_pb2 import Resposta, Livro


class Greeter(GreeterServicer):
    livros = []

    def AdicionarLivro(self, request, context):
        x = Livro(str(request.titulo), str(request.autor), str(request.publisher))
        self.livros.append(x)
        result = "Livro %s Adicionado" % request.titulo
        print(result)
        return Resposta(message=result)

    def RemoverLivro(self, request, context):
        result = "Livro %s não encontrado!" % request.titulo

        for livro in self.livros:
            if livro.titulo == request.titulo:
                self.livros.remove(livro)
                result = "Livro %s removido " % request.titulo
                return Resposta(message=result)

        print(result)
        return Resposta(message=result)

    def ListarLivros(self, request, context):
        result = []

        for livro in self.livros:
            result.append("Titulo: %s\n Author: %s\n publisher: %s\n" % (livro.titulo, livro.autor, livro.publisher))

        print(result)
        return Resposta(message="\n".join(result))


class Livro():
    def __init__(self, titulo, autor, publisher):
        self.titulo = titulo
        self.autor = autor
        self.publisher = publisher


_ONE_DAY_IN_SECONDS = 60 * 60 * 24


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    add_GreeterServicer_to_server(Greeter(), server)
    server.add_insecure_port('[::]:50051')
    server.start()

    try:
        while True:
            time.sleep(_ONE_DAY_IN_SECONDS)
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    serve()
