create schema if not exists biblioteca;

create table if not exists autor (
                       aut_id bigserial not null,
                       aut_origem varchar(255),
                       aut_nome varchar(255),
                       primary key (aut_id)
);

create table if not exists editora (
                         edi_id bigserial not null,
                         edi_nome varchar(255),
                         primary key (edi_id)
);

create table if not exists genero (
                        gen_id bigserial not null,
                        gen_nome varchar(255),
                        primary key (gen_id)
);

create table if not exists livro (
                       lvr_isbn bigserial not null,
                       lvr_titulo varchar(255),
                       lvr_anopublicacao varchar(255),
                       lvr_autorid bigint,
                       lvr_generoid bigint,
                       lvr_editoraid bigint,
                       primary key (lvr_isbn),
                       foreign KEY (lvr_autorid) references autor (aut_id),
                       foreign KEY (lvr_generoid) references genero (gen_id),
                       foreign KEY (lvr_editoraid) references editora (edi_id)
);

-- Inserts para a tabela 'autor'
INSERT INTO autor (aut_origem, aut_nome) VALUES
('Brasileiro', 'Machado de Assis'),
('Americano', 'Ernest Hemingway'),
('Inglês', 'Jane Austen');

-- Inserts para a tabela 'editora'
INSERT INTO editora (edi_nome) VALUES
('Companhia das Letras'),
('Penguin Random House'),
('HarperCollins');

-- Inserts para a tabela 'genero'
INSERT INTO genero (gen_nome) VALUES
('Ficção'),
('Não Ficção'),
('Romance');

-- Inserts para a tabela 'livro'
INSERT INTO livro (lvr_titulo, lvr_anopublicacao, lvr_autorid, lvr_generoid, lvr_editoraid) VALUES
('Dom Casmurro', '1899', 1, 3, 1),
('O Velho e o Mar', '1952', 2, 1, 2),
('Orgulho e Preconceito', '1813', 3, 3, 3);