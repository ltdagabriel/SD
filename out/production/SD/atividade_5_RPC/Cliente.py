import grpc

from atividade_5_RPC.livro_pb2 import Livro, Request, Titulo
from atividade_5_RPC.livro_pb2_grpc import GreeterStub

if __name__ == '__main__':
    channel = grpc.insecure_channel('localhost:50051')
    stub = GreeterStub(channel)

    # adicionar Livro
    for i in range(1, 4):
        response = stub.AdicionarLivro(
            Livro(titulo=f'Historias de SD {i:d}', autor='Gabriel', publisher='UTFPR'))
        print("Adicionado: " + response.message)

    # Listar Livros
    print("Lista de livros antes da remoção\n")
    response = stub.ListarLivros(Request(message='None'))
    print(response.message)

    # Remover Livro
    response = stub.RemoverLivro(Titulo(titulo='Historias de SD 2'))
    print("Remover: " + response.message)

    print("Lista de livros após da remoção\n")
    response = stub.ListarLivros(Request(message='None'))
    print(response.message)
