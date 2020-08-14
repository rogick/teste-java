create table escola (
	id_escola integer not null,
	nome character varying(200) not null,
	logradouro character varying(200) ,
	complemento character varying(200) ,
	bairro character varying(200) ,
	cidade character varying(200) ,
	estado character varying(200) ,
	constraint pk_escola primary key (id_escola)
	
);
create table turma (
	id_turma integer not null,
	nome character varying(200) not null,
	capacidade integer,
	id_escola integer not null,
	constraint pk_turma primary key (id_turma),
	constraint fk_turma_escola foreign key (id_turma) references turma(id_turma) on update no action on delete no action
	
);

create table aluno (
	id_aluno integer not null,
	nome character varying(200) not null,
	data_nascimento timestamp,
	id_turma integer,
	constraint pk_aluno primary key (id_aluno),
	constraint fk_aluno_turma foreign key (id_turma) references turma(id_turma) on update no action on delete no action
);

insert into escola values (1, 'Escola 1', 'Rua A, 23', '', 'Centro', 'Rio de Janeiro', 'RJ');
insert into escola values (2, 'Escola 2', 'Rua B, 33', '', 'Centro', 'Rio de Janeiro', 'RJ');

insert into turma values (1, 'Turma 1', 10, 1);
insert into turma values (2, 'Turma 2', 10, 1);
insert into turma values (3, 'Turma 3', 10, 1);

insert into turma values (4, 'Turma A', 10, 2);
insert into turma values (5, 'Turma B', 10, 2);
insert into turma values (6, 'Turma C', 10, 2);

insert into aluno values (1, 'João 1', '2000-01-01', 1);
insert into aluno values (2, 'João 2', '2000-01-01', 1);
insert into aluno values (3, 'João 3', '2000-01-01', 1);

insert into aluno values (4, 'João 4', '2000-01-01', 2);
insert into aluno values (5, 'João 5', '2000-01-01', 2);
insert into aluno values (6, 'João 6', '2000-01-01', 2);
