insert into convenio values (nextval('convenio_sequence'),'Grupo São Jose');
insert into convenio values (nextval('convenio_sequence'),'Santa Casa');
insert into convenio values (nextval('convenio_sequence'),'Unimed');
insert into convenio values (nextval('convenio_sequence'),'Sulamérica');

--Endereço
insert into endereco values (nextval('endereco_sequence'),'Jardim Americano','São José dos Campos',104,'Rua Otávio de Moraes Lopes');
insert into endereco values (nextval('endereco_sequence'),'Jardim Primavera','São José dos Campos',252,'Rua das Tulípas');
insert into endereco values (nextval('endereco_sequence'),'Bairro Aeroporto','Jacareí',15,'Rua dos Louros');

--Especialidade
insert into especialidade values (nextval('especialidade_sequence'),'Cardiologista');
insert into especialidade values (nextval('especialidade_sequence'),'Oftalmologista');
insert into especialidade values (nextval('especialidade_sequence'),'Dermatologista');
insert into especialidade values (nextval('especialidade_sequence'),'Dentista');

--Profissional
insert into profissional values (nextval('profissional_sequence'),123,'Angelo Castanha da Silva',(select id from endereco where bairro='Jardim Americano'));
insert into profissional values (nextval('profissional_sequence'),456,'Marcelo Madureira',(select id from endereco where bairro='Jardim Primavera'));
insert into profissional values (nextval('profissional_sequence'),789,'Marina da Silva',(select id from endereco where bairro='Bairro Aeroporto'));

insert into especialidade_convenios values((select id from especialidade where nome='Cardiologista'),(select id from convenio where nome='Grupo São Jose'));
insert into especialidade_convenios values((select id from especialidade where nome='Oftalmologista'),(select id from convenio where nome='Grupo São Jose'));
insert into especialidade_convenios values((select id from especialidade where nome='Dentista'),(select id from convenio where nome='Grupo São Jose'));
insert into especialidade_convenios values((select id from especialidade where nome='Cardiologista'),(select id from convenio where nome='Santa Casa'));
insert into especialidade_convenios values((select id from especialidade where nome='Dentista'),(select id from convenio where nome='Santa Casa'));
insert into especialidade_convenios values((select id from especialidade where nome='Dermatologista'),(select id from convenio where nome='Santa Casa'));

insert into especialidade_profissionais values((select id from especialidade where nome='Cardiologista'),(select id from profissional where crm=123));
insert into especialidade_profissionais values((select id from especialidade where nome='Cardiologista'),(select id from profissional where crm=456));
insert into especialidade_profissionais values((select id from especialidade where nome='Oftalmologista'),(select id from profissional where crm=789));
insert into especialidade_profissionais values((select id from especialidade where nome='Dentista'),(select id from profissional where crm=123));

insert into profissional_convenios values((select id from profissional where crm=123),(select id from convenio where nome='Grupo São Jose'));
insert into profissional_convenios values((select id from profissional where crm=123),(select id from convenio where nome='Santa Casa'));
insert into profissional_convenios values((select id from profissional where crm=456),(select id from convenio where nome='Grupo São Jose'));
insert into profissional_convenios values((select id from profissional where crm=456),(select id from convenio where nome='Unimed'));
insert into profissional_convenios values((select id from profissional where crm=789),(select id from convenio where nome='Grupo São Jose'));
insert into profissional_convenios values((select id from profissional where crm=789),(select id from convenio where nome='Unimed'));
insert into profissional_convenios values((select id from profissional where crm=456),(select id from convenio where nome='Santa Casa'));
insert into profissional_convenios values((select id from profissional where crm=456),(select id from convenio where nome='Sulamérica'));

insert into profissional_especialidades values((select id from profissional where crm=123),(select id from especialidade where nome='Cardiologista'));
insert into profissional_especialidades values((select id from profissional where crm=456),(select id from especialidade where nome='Cardiologista'));
insert into profissional_especialidades values((select id from profissional where crm=789),(select id from especialidade where nome='Oftalmologista'));
insert into profissional_especialidades values((select id from profissional where crm=123),(select id from especialidade where nome='Dentista'));