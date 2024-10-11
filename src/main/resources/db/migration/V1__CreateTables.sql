
CREATE TABLE assunto (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255)
);

CREATE TABLE autor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255)
);

CREATE TABLE livro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255),
    editora VARCHAR(255),
    edicao INT,
    anopublicacao VARCHAR(255)
);

CREATE TABLE livro_autor (
    livro_id INT,
    autor_id INT,
    PRIMARY KEY (livro_id, autor_id),
    FOREIGN KEY (livro_id) REFERENCES livro(id),
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);

CREATE TABLE livro_assunto (
    livro_id INT,
    assunto_id INT,
    PRIMARY KEY (livro_id, assunto_id),
    FOREIGN KEY (livro_id) REFERENCES livro(id),
    FOREIGN KEY (assunto_id) REFERENCES assunto(id)
);
