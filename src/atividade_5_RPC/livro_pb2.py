# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: livro.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='livro.proto',
  package='',
  syntax='proto3',
  serialized_options=None,
  serialized_pb=_b('\n\x0blivro.proto\"9\n\x05Livro\x12\x0e\n\x06titulo\x18\x01 \x01(\t\x12\r\n\x05\x61utor\x18\x02 \x01(\t\x12\x11\n\tpublisher\x18\x03 \x01(\t\"\x18\n\x06Titulo\x12\x0e\n\x06titulo\x18\x01 \x01(\t\"\x1b\n\x08Resposta\x12\x0f\n\x07message\x18\x01 \x01(\t\"\x1a\n\x07Request\x12\x0f\n\x07message\x18\x01 \x01(\t2}\n\x07Greeter\x12%\n\x0e\x41\x64icionarLivro\x12\x06.Livro\x1a\t.Resposta\"\x00\x12$\n\x0cRemoverLivro\x12\x07.Titulo\x1a\t.Resposta\"\x00\x12%\n\x0cListarLivros\x12\x08.Request\x1a\t.Resposta\"\x00\x62\x06proto3')
)




_LIVRO = _descriptor.Descriptor(
  name='Livro',
  full_name='Livro',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='titulo', full_name='Livro.titulo', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='autor', full_name='Livro.autor', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='publisher', full_name='Livro.publisher', index=2,
      number=3, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=15,
  serialized_end=72,
)


_TITULO = _descriptor.Descriptor(
  name='Titulo',
  full_name='Titulo',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='titulo', full_name='Titulo.titulo', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=74,
  serialized_end=98,
)


_RESPOSTA = _descriptor.Descriptor(
  name='Resposta',
  full_name='Resposta',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='message', full_name='Resposta.message', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=100,
  serialized_end=127,
)


_REQUEST = _descriptor.Descriptor(
  name='Request',
  full_name='Request',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='message', full_name='Request.message', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=129,
  serialized_end=155,
)

DESCRIPTOR.message_types_by_name['Livro'] = _LIVRO
DESCRIPTOR.message_types_by_name['Titulo'] = _TITULO
DESCRIPTOR.message_types_by_name['Resposta'] = _RESPOSTA
DESCRIPTOR.message_types_by_name['Request'] = _REQUEST
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

Livro = _reflection.GeneratedProtocolMessageType('Livro', (_message.Message,), dict(
  DESCRIPTOR = _LIVRO,
  __module__ = 'livro_pb2'
  # @@protoc_insertion_point(class_scope:Livro)
  ))
_sym_db.RegisterMessage(Livro)

Titulo = _reflection.GeneratedProtocolMessageType('Titulo', (_message.Message,), dict(
  DESCRIPTOR = _TITULO,
  __module__ = 'livro_pb2'
  # @@protoc_insertion_point(class_scope:Titulo)
  ))
_sym_db.RegisterMessage(Titulo)

Resposta = _reflection.GeneratedProtocolMessageType('Resposta', (_message.Message,), dict(
  DESCRIPTOR = _RESPOSTA,
  __module__ = 'livro_pb2'
  # @@protoc_insertion_point(class_scope:Resposta)
  ))
_sym_db.RegisterMessage(Resposta)

Request = _reflection.GeneratedProtocolMessageType('Request', (_message.Message,), dict(
  DESCRIPTOR = _REQUEST,
  __module__ = 'livro_pb2'
  # @@protoc_insertion_point(class_scope:Request)
  ))
_sym_db.RegisterMessage(Request)



_GREETER = _descriptor.ServiceDescriptor(
  name='Greeter',
  full_name='Greeter',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=157,
  serialized_end=282,
  methods=[
  _descriptor.MethodDescriptor(
    name='AdicionarLivro',
    full_name='Greeter.AdicionarLivro',
    index=0,
    containing_service=None,
    input_type=_LIVRO,
    output_type=_RESPOSTA,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='RemoverLivro',
    full_name='Greeter.RemoverLivro',
    index=1,
    containing_service=None,
    input_type=_TITULO,
    output_type=_RESPOSTA,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='ListarLivros',
    full_name='Greeter.ListarLivros',
    index=2,
    containing_service=None,
    input_type=_REQUEST,
    output_type=_RESPOSTA,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_GREETER)

DESCRIPTOR.services_by_name['Greeter'] = _GREETER

# @@protoc_insertion_point(module_scope)