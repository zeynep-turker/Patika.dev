--test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
CREATE TABLE employee (
  id INTEGER PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  email VARCHAR(100)
);

--Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.
insert into employee (id, name, birthday, email) values (1, 'Amandy', '2005-01-11', 'amapston0@newsvine.com');
insert into employee (id, name, birthday, email) values (2, 'Syd', '2004-04-19', 'steasell1@godaddy.com');
insert into employee (id, name, birthday, email) values (3, 'Fransisco', null, null);
insert into employee (id, name, birthday, email) values (4, 'Guillema', '2002-02-03', 'gbawdon3@epa.gov');
insert into employee (id, name, birthday, email) values (5, 'Yovonnda', '2010-11-21', 'ylasty4@mtv.com');
insert into employee (id, name, birthday, email) values (6, 'Ravi', '2020-06-18', 'rgodsil5@tuttocitta.it');
insert into employee (id, name, birthday, email) values (7, 'Drucie', null, null);
insert into employee (id, name, birthday, email) values (8, 'Kirbie', '2018-01-06', 'kshakesby7@tiny.cc');
insert into employee (id, name, birthday, email) values (9, 'Garv', '2008-09-29', 'gsaurat8@aol.com');
insert into employee (id, name, birthday, email) values (10, 'Elnore', '2011-04-08', 'eoshee9@fotki.com');
insert into employee (id, name, birthday, email) values (11, 'Marie', '2012-07-25', 'mbarretta@xrea.com');
insert into employee (id, name, birthday, email) values (12, 'Avrom', '2006-03-02', 'aharryb@cnn.com');
insert into employee (id, name, birthday, email) values (13, 'Trudie', '2005-04-21', 'thearmonc@privacy.gov.au');
insert into employee (id, name, birthday, email) values (14, 'Gerrie', '2014-08-18', 'gstreightd@youtube.com');
insert into employee (id, name, birthday, email) values (15, 'Merle', '2018-01-07', 'mhosbye@people.com.cn');
insert into employee (id, name, birthday, email) values (16, 'Lacee', '2012-05-03', 'ltoobyf@yellowpages.com');
insert into employee (id, name, birthday, email) values (17, 'Teresina', '2019-02-07', 'tkasherg@blogspot.com');
insert into employee (id, name, birthday, email) values (18, 'Vic', '2016-02-25', 'vhayleh@hibu.com');
insert into employee (id, name, birthday, email) values (19, 'Omero', null, null);
insert into employee (id, name, birthday, email) values (20, 'Dimitri', '2006-09-24', 'danthoneyj@springer.com');
insert into employee (id, name, birthday, email) values (21, 'Mildrid', '2013-03-12', 'mlilbournek@addtoany.com');
insert into employee (id, name, birthday, email) values (22, 'Andy', null, null);
insert into employee (id, name, birthday, email) values (23, 'Sigismondo', null, null);
insert into employee (id, name, birthday, email) values (24, 'Freeland', '2006-09-13', 'ftulln@utexas.edu');
insert into employee (id, name, birthday, email) values (25, 'Katrina', '2015-01-18', 'klarvero@cocolog-nifty.com');
insert into employee (id, name, birthday, email) values (26, 'Darlene', null, null);
insert into employee (id, name, birthday, email) values (27, 'Zara', '2018-04-17', 'zstainfieldq@ning.com');
insert into employee (id, name, birthday, email) values (28, 'Durward', '2001-06-15', 'dfalconertaylorr@yahoo.com');
insert into employee (id, name, birthday, email) values (29, 'Katina', '2001-12-03', 'krushes@cargocollective.com');
insert into employee (id, name, birthday, email) values (30, 'Erena', null, null);
insert into employee (id, name, birthday, email) values (31, 'Corey', null, null);
insert into employee (id, name, birthday, email) values (32, 'Colline', null, null);
insert into employee (id, name, birthday, email) values (33, 'Margalit', '2017-05-18', 'mantosw@scientificamerican.com');
insert into employee (id, name, birthday, email) values (34, 'Silvano', '2017-11-07', 'slawnx@jiathis.com');
insert into employee (id, name, birthday, email) values (35, 'Zachary', null, null);
insert into employee (id, name, birthday, email) values (36, 'Anatole', '2017-12-01', 'aissacsonz@deviantart.com');
insert into employee (id, name, birthday, email) values (37, 'Marcelle', null, null);
insert into employee (id, name, birthday, email) values (38, 'Sylas', '2007-01-11', 'shaggleton11@dmoz.org');
insert into employee (id, name, birthday, email) values (39, 'Renie', '2005-12-07', 'rkinny12@posterous.com');
insert into employee (id, name, birthday, email) values (40, 'Griffith', '2015-05-09', 'gramstead13@amazon.co.uk');
insert into employee (id, name, birthday, email) values (41, 'Ginevra', '2013-05-17', 'gjoriot14@webs.com');
insert into employee (id, name, birthday, email) values (42, 'Selle', '2018-07-13', 'sgrange15@cyberchimps.com');
insert into employee (id, name, birthday, email) values (43, 'Rodd', '2014-12-17', 'rrishworth16@spiegel.de');
insert into employee (id, name, birthday, email) values (44, 'Ingmar', '2020-11-16', 'imcelree17@studiopress.com');
insert into employee (id, name, birthday, email) values (45, 'Courtnay', '2016-05-19', 'cdivell18@acquirethisname.com');
insert into employee (id, name, birthday, email) values (46, 'Mabel', '2001-12-12', 'menoksson19@g.co');
insert into employee (id, name, birthday, email) values (47, 'Arlene', '2004-11-21', 'ascotchforth1a@census.gov');
insert into employee (id, name, birthday, email) values (48, 'Cybill', '2020-05-02', 'cblinder1b@huffingtonpost.com');
insert into employee (id, name, birthday, email) values (49, 'Paddie', null, null);
insert into employee (id, name, birthday, email) values (50, 'Pattin', '2012-04-21', 'paldritt1d@ocn.ne.jp');

--Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
UPDATE employee SET name = 'Zeynep', birthday = '1998-06-16', email = 'zeynep@gmail.com' WHERE id BETWEEN 8 AND 12;
SELECT * FROM employee;

--Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
DELETE FROM employee WHERE id BETWEEN 3 AND 7;
