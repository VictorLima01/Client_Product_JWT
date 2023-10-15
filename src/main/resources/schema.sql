/*CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);

CREATE TABLE produtos (
   id TEXT PRIMARY KEY UNIQUE NOT NULL,
    preco TEXT NOT NULL,
    image TEXT NOT NULL,
    marca TEXT NOT NULL,
    titulo TEXT NOT NULL,
    review TEXT NOT NULL
);

CREATE TABLE cliente (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    email TEXT NOT NULL,
    nome TEXT NOT NULL,
    listasProdutos TEXT,
    CONSTRAINT FK_listasProdutos 
      FOREIGN KEY (listasProdutos) REFERENCES  produtos(id)
);

CREATE TABLE cliente_listas_produtos (
    cliente_id TEXT references cliente(id),
    listas_produtos_id TEXT references produtos(id),
    primary key (cliente_id, listas_produtos_id)
);*/