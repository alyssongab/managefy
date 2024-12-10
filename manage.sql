create database managefy;

use managefy;

-- tabela de equipamentos
create table equipamento(
num_tombo int primary key,
equip varchar(100) not null,
marca varchar(100) not null,
modelo varchar(100) not null
);

show tables;

-- ALTERAR A TABELA
alter table equipamento
add column ano_lancamento int;

-- CRIAR
insert into equipamento(equip, marca, modelo)
values
("Notebook", "Acer", "Aspire 5");

-- CONSULTAR GERAL
select equip, marca from equipamento;

-- CONSULTAR DETALHES
select * from equipamento;

-- Alterar
update equipamento
set equip = "Tablet",
	marca = "Samsung",
    modelo = "Tab 3",
    ano_lancamento = 2020
where num_tombo = 1;

-- Deletar
delete from equipamento
where num_tombo = 2;

-- tabela de usuarios (apenas um a principio)
create table usuarios(
matricula int primary key,
senha varchar(32) not null
);

insert into usuarios(matricula, senha)
values
(2024003155, "jsp4341");

select * from usuarios;