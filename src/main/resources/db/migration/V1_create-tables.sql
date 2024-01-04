CREATE DATABASE bilioteca;

create table autor (
                       aut_id bigserial not null,
                       aut_origem varchar(255),
                       aut_nome varchar(255),
                       primary key (aut_id)
);

create table editora (
                         edi_id bigserial not null,
                         edi_nome varchar(255),
                         primary key (edi_id)
);

create table genero (
                        gen_id bigserial not null,
                        gen_nome varchar(255),
                        primary key (gen_id)
);

create table livro (
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