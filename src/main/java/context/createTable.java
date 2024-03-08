package context;

public class createTable {
//	CREATE TABLE product
//	(
//		id int PRIMARY KEY AUTO_INCREMENT,
//	    name varchar(200),
//	    price float,
//	    status int
//	);




  create database DB_JSPServlet_Exam01;
go
use  DB_JSPServlet_Exam01;
go
create table TblProject
(
	ProJId varchar(20) not null primary key ,
	ProJName nvarchar(200),
	Company nvarchar(100),
	Language  nvarchar(50),
	TotalDevs int
);
go
insert into TblProject(ProJId, ProJName, Company, Language, TotalDevs) values ('Prj01', 'Production schedule management software', 'FPT Software', 'Java Web', 30);
insert into TblProject(ProJId, ProJName, Company, Language, TotalDevs) values ('Prj02', 'Human resource management software', 'USol', 'ASP.NET MVC', 20);
insert into TblProject(ProJId, ProJName, Company, Language, TotalDevs) values ('Prj03', 'Enterprise management software', 'Luvina', 'Java Web', 50);
insert into TblProject(ProJId, ProJName, Company, Language, TotalDevs) values ('Prj04', 'Customer management software', 'Luvina', 'Java Web', 20);



select * from TblProject;
}
