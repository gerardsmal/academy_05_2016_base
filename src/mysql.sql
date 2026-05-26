/*
 * int -> Integer
 * decimal -> decimale
 * char -> string di lungezza fissa con max. 255
 * varchar -> string di lunghezza vairiabile con max. 65535
 * text -> string fisso con max. 65535
 * date -> Date yyyy-mm-dd
 * datetime -> date yyyy-mm-dd hh:mm:ss
 * Timestamp -> numero di secondi da l'inizio unix (1970-01-01 00:00:01 UTC; 
 */
drop TABLE dipendenti ;
create table dipendenti (
	id_dipendente int not null auto_increment,
	nome varchar(200) not null,
	cognome varchar(200) not null,
	data_assunzione date not null,
	telefono varchar(10) not null unique,
	mansione varchar(50) not null default 'impiegato',
	stipendio decimal not null check (stipendio >= 1100  and stipendio <= 3500),
	PRIMARY key (id_dipendente)
);

drop table clienti;
create table clienti (
	id_cliento int not null auto_increment,
	denominazione varchar(255) not null,
	p_iva varchar(16) not null unique,
	indirizzo varchar(255) not null,
	telefono varchar(10) not null unique,
	primary key (id_cliento)
);

drop table rapporto_cliente;
create table rapporto_cliente (
	id_rapporto int not null auto_increment,
	descrizione varchar (255),
	id_cliente int not null,
	id_dipendente int not null,
	primary key (id_rapporto),
	foreign key (id_cliente) references clienti (id_cliento ),
	foreign key (id_dipendente) references dipendenti (id_dipendente )
);

insert into dipendenti (nome, cognome, data_assunzione, telefono, stipendio)
	values ("Paolo", "Verdi", "2026-10-10", "34523987", 1500);

select * from dipendenti;	

insert into dipendenti (nome, cognome, data_assunzione, telefono, stipendio)
	values ("Gianni", "Bianco", "2026-10-10", "34523988", 2500);

insert into dipendenti (nome, cognome, data_assunzione, telefono, stipendio)
	values 
	("Anna", "Bluaca", "2025-09-20", "34523980", 1300),
	("Luca", "Gosta", "2026-01-15", "34523001", 1350),
	("Lucia", "Santacruz", "2026-02-20", "34523002", 1400),
	("Enrico", "Durello", "2026-03-10", "34523003", 1500);

insert into clienti (denominazione, p_iva, indirizzo, telefono)
	values
	("una srl", "1111111111111111", "Corso Angelli 21 Torino", "4423003"),
	("due srl", "2222222222222222", "Via Roma 21 Torino", "4423004"),
	("tre srl", "3333333333333333", "Corso Sicarusa 121 Torino", "4423005");

select * from clienti;


insert into dipendenti (nome, cognome, data_assunzione, telefono, mansione, stipendio)
	values 
	("Angela", "Sottenra", "2025-09-20", "34523004", "Team manager",2300),
	("Mauro", "Nearo", "2025-10-20", "34523005", "HR",1600),
	("Agnes", "Dellagrange", "2025-09-20", "34523006", "Team manager",2200),
	("Marco", "Lavvasa", "2025-09-20", "34523007", "Amministrazione",1900);

/*
 * opratori logici
 * 	=, !=
 * 	>, < , <= ,>=
 * IN (valore 1, valore 2)
 * between 
 * like
 * and
 * or 
 * not
 */

select cognome, mansione, stipendio from dipendenti where mansione in ('hr','Team manager') ;
select * from dipendenti;

select distinct mansione from dipendenti;

insert into dipendenti (nome, cognome, data_assunzione, telefono, stipendio)
	values ("Paolo", "Verdi", "2026-10-10", "34523999", 1500);

select  distinct nome,cognome, data_assunzione from dipendenti;

select * from dipendenti where stipendio <= 1300;

delete from dipendenti where stipendio <= 1300;

insert into rapporto_cliente (descrizione, id_cliente, id_dipendente)
  values
  ("rapporto 1", 4, 1),
  ("rapporto 2", 5, 2),
  ("rapport0 3", 6, 6)
  

select * from rapporto_cliente rc 

create table test (
	id int auto_increment,
	tipo int,
	descrizione varchar (256) not null,
	primary key (id)
);

insert into test (tipo, descrizione) values (2, "aaaa"), (3, "bbbb"), (4, "cccc"), (5, "dddd"), (6, "eeeee"), (7, "ffff"), (8, "gggg");

select * from test;

delete from test;

truncate table test;

/*
 * Update
 */
update dipendenti set nome = 'Mirko' , cognome = 'Ilbello' where id_dipendente = 2;

select * from dipendenti where mansione  = 'capo';

update dipendenti  set mansione = 'capo' where mansione  = 'Team manager';

/*
 * order by
 */
select * from dipendenti order by stipendio desc;

create table uffici (
	id_ufficio int auto_increment,
	nome_ufficio varchar(50) not null,
	primary key (id_ufficio )

);

insert into uffici (nome_ufficio) values
	("Amministrazione"),
	("Vendite"),
	("Produzione"),
	("Tecnico")
	
select * from uffici;

/*
 * alter table
 */
select * from rapporto_cliente rc 


alter table rapporto_cliente 
	add column prova varchar(50);

update rapporto_cliente rc set prova = 'test'

alter table rapporto_cliente 
	modify prova varchar(50) after id_rapporto
	
alter table rapporto_cliente 
	modify prova varchar(50) not null;

alter table rapporto_cliente 
	drop column prova

alter table rapporto_cliente 
	modify prova int
	
alter table test rename academy_test;

alter table dipendenti 
	add column id_ufficio int;

delete from dipendenti where id_dipendente = 11
select * from dipendenti;

update dipendenti set id_ufficio = 1 where id_dipendente in (1, 6, 8);
update dipendenti set id_ufficio = 4 where id_dipendente in (5, 7, 2);
update dipendenti set id_ufficio = 2 where id_dipendente in (4, 9, 10);

insert into dipendenti (nome, cognome, data_assunzione, telefono, stipendio)
	values ("Pino", "Senzauffico", "2026-10-10", "345238881", 1400);

insert into dipendenti (nome, cognome, data_assunzione, telefono, stipendio)
	values ("Alice", "Senzauffico", "2026-10-10", "345238882", 1550);

/*
 * join
 */
select d.id_dipendente,  d.nome, d.cognome, u.nome_ufficio  from dipendenti d
	inner join uffici u on d.id_ufficio = u.id_ufficio 

	
select d.id_dipendente,  d.nome, d.cognome, u.nome_ufficio  from dipendenti d
	left join uffici u on d.id_ufficio = u.id_ufficio 

select d.id_dipendente,  d.nome, d.cognome, u.nome_ufficio  from dipendenti d
	right join uffici u on d.id_ufficio = u.id_ufficio 
	
-- full join
select d.id_dipendente,  d.nome, d.cognome, u.nome_ufficio  from dipendenti d
	left join uffici u on d.id_ufficio = u.id_ufficio 
union
select d.id_dipendente,  d.nome, d.cognome, u.nome_ufficio  from dipendenti d
	right join uffici u on d.id_ufficio = u.id_ufficio 

/*
 * like
 * S% inizia con S
 * %a finische con a
 * "S%_o%" 
 * %o%  contiene o
 */	
	
select 	d.id_dipendente,  d.nome, d.cognome  from dipendenti d
	where d.cognome  like 'S%';

select 	d.id_dipendente,  d.nome, d.cognome  from dipendenti d
	where d.cognome  like '%a';
	
select 	d.id_dipendente,  d.nome, d.cognome  from dipendenti d
	where d.cognome  like "S%_o%"
	
select 	d.id_dipendente,  d.nome, d.cognome  from dipendenti d
	where d.cognome  like '%o%';
	
/*
 * foreign key per dipendenti
*/


alter table dipendenti
	add constraint id_ufficio foreign key (id_ufficio) references uffici (id_ufficio )

delete from uffici where id_ufficio = 1;

/*
 * group by
 */

select  u.nome_ufficio, count(d.id_dipendente ) as totale_dipendente from uffici u 
	left join dipendenti d 
		on u.id_ufficio = d.id_ufficio 
		GROUP by u.nome_ufficio 
		HAVING totale_dipendente = 0;

/*
 * view
 */

create  or REPLACE view dipendente_view as
	select d.id_dipendente,  d.nome, d.cognome, u.nome_ufficio , d.stipendio from dipendenti d
	left join uffici u on d.id_ufficio = u.id_ufficio 

select * from dipendente_view dv  where dv.stipendio >= 2000 and dv.nome_ufficio = 'Tecnico';

/*
 * Date
 * pattern di formatazione data
 * %a	Abbreviated weekday name (Sun to Sat)
 * %b	Abbreviated month name (Jan to Dec)
 * %c	Numeric month name (0 to 12)
 * %D	Day of the month as a numeric value, followed by suffix (1st, 2nd, 3rd, ...)
 * %d	Day of the month as a numeric value (01 to 31)
 * %f	Microseconds (000000 to 999999)
 * %H	Hour (00 to 23)
 * %h	Hour (00 to 12)
 * %i	Minutes (00 to 59)
 * %j	Day of the year (001 to 366)
 * %M	Month name in full (January to December)
 * %m	Month name as a numeric value (00 to 12)
 * %p	AM or PM
 * %r	Time in 12 hour AM or PM format (hh:mm:ss AM/PM)
 * %S	Seconds (00 to 59)
 * %T	Time in 24 hour format (hh:mm:ss)
 * %U	Week where Sunday is the first day of the week (00 to 53)
 * %Y	Year as a numeric, 4-digit value
 * %u	Week where Monday is the first day of the week (00 to 53)
 * %W	Weekday name in full (Sunday to Saturday)
 * %w	Day of the week where Sunday=0 and Saturday=6
 * %Y	Year as a numeric, 4-digit value
 * %y	Year as a numeric, 2-digit value * 
 */
drop table prova_data;
create  table prova_data (
	id int primary key  auto_increment,
	nome varchar(250),
	data_nascita DATE not null,
	data_inserimento DateTime default current_timestamp,
	data_modifica DateTime default CURRENT_TIMESTAMP on update current_timestamp 
)

INSERT into prova_data (nome, data_nascita)
	values ("Luca" , "1980-02-27")
INSERT into prova_data (nome, data_nascita)
	values ("Paola" , "2006-12-18")

	
select * from prova_data;	

update prova_data set data_nascita = '1970-02-27' where id = 1;

select  nome,  DATE_FORMAT(data_nascita, "%a %d/%m/%y" )  as nascita, 
		DATE_FORMAT(data_modifica, "%d/%m/%y %T" ) as aggiornato from prova_data
		where date(data_modifica) = CURDATE();

SELECT * from dipendente_view dv ;

drop table dipendente_generate;
create table dipendente_generate (
	id int primary key  auto_increment,
	nome varchar(200) not null,
	cognome varchar(200) not null,
	nome_ufficio varchar(50)
)


insert into dipendente_generate (nome, cognome, nome_ufficio) 
	(select nome, cognome, nome_ufficio from dipendente_view)

select * from dipendente_generate;

select * from cso_2_0.commune c where nome = 'BRIONE';

drop table comune;
create table comune (
	id int primary key  auto_increment,
	nome varchar(250) ,
	code varchar(4) ,
	province varchar(3)
)

INSERT into comune (code , nome, province)
	(select code , nome, province  from cso_2_0.commune);

select count(*) from comune;

alter table dipendenti
	add column code varchar(4);

select * from comune where code = 'c000'

select d.* , u.nome_ufficio , c.nome , c.province   from dipendenti d 
	join uffici u  on d.id_ufficio = u.id_ufficio 
    left join comune c on c.code = d.code 

/*
 * esempio con lateral (problema code non é sempre univoco)
 */    
select d.* , u.nome_ufficio , c.nome , c.province   from dipendenti d 
	join uffici u  on d.id_ufficio = u.id_ufficio 
    left join lateral(
    	select code, nome, province from comune where d.code = code limit 1) as c on true;
/*
 * esempio senza lateral
 */    
select d.*, u.nome_ufficio, c.nome, c.province from dipendenti d
 join uffici u  on d.id_ufficio = u.id_ufficio
 left join comune c on c.id = (
        select c2.id from comune c2 where c2.code = d.code limit 1
    );

/*
 * index 
 */
create index idx_code on comune(code);	


/*
 * tabella temporary
*/
create temporary table dipendenti_temporary (
	id int primary key  auto_increment,
	nome varchar(200) not null,
	cognome varchar(200) not null,
	nome_ufficio varchar(50),
	stipendio decimal not null check (stipendio >= 1100  and stipendio <= 3500)
)

insert into dipendenti_temporary
	(nome, cognome, nome_ufficio, stipendio) 
	(select nome, cognome, nome_ufficio, stipendio from dipendente_view)
	
select * from dipendenti_temporary where stipendio >= 1500


select rc.id_rapporto , rc.descrizione as rapporto,c.denominazione as nome_cliente, d.nome, d.cognome, d.telefono ,u.nome_ufficio , c.nome as comune
	 from rapporto_cliente rc 
		JOIN clienti c on rc.id_cliente = c.id_cliento
		join dipendenti d on rc.id_dipendente = d.id_dipendente 
		left join uffici u  on d.id_ufficio = u.id_ufficio 
		left join lateral(
    		select c2.code, c2.nome, c2.province from comune c2 where d.code = c2.code limit 1) as c on true;
