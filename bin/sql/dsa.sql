DROP DATABASE IF EXISTS dsa;
CREATE DATABASE dsa;
use dsa;

/* UTILISATEURS */ 
create table users (
iduser int(3) not null  auto_increment,
email varchar (150) unique,
mdp varchar (255),
nom varchar (50),
roles enum ('admin', 'technicien', 'client'),
datemdp DATE, 
constraint pk_user primary key (iduser)
);


create table admin(
    iduser int(3) not null  auto_increment ,
    email varchar (150),
    mdp varchar (255),
    nom varchar (50),
    roles enum ('admin', 'technicien', 'client'),
    datemdp date, 
    prenom varchar(50),
    constraint pk_user primary key (iduser)
);

create table technicien (
    iduser int(3) not null  auto_increment ,
    email varchar (150),
    mdp varchar (255),
    nom varchar (50),
    roles enum ('admin', 'technicien', 'client'),
    datemdp date, 
    prenom varchar(50),
    diplome varchar(50),
    dateEmb date,
    dateDept date,
    constraint pk_user primary key (iduser)
);

create table client (
iduser int(3) not null  auto_increment ,
email varchar (150),
mdp varchar (255),
nom varchar (50),
roles enum ('admin', 'technicien', 'client') default 'client',
datemdp date, 
typeclient enum('particulier', 'professionnel'),
adresse varchar(50),
ville varchar (50),
cp varchar (50), 
telephone int,
constraint pk_user primary key (iduser)
);


create table particulier (
iduser int(3) not null  auto_increment ,
email varchar (150),
mdp varchar (255),
nom varchar (50),
roles enum ('admin', 'technicien', 'client') default 'client',
datemdp date, 
typeclient enum('particulier', 'professionnel') default 'particulier',
adresse varchar(50),
ville varchar (50),
cp varchar (50), 
telephone int,
prenom varchar(50),
constraint pk_user primary key (iduser)
);

create table professionnel (
iduser int(3) not null  auto_increment ,
email varchar (150),
mdp varchar (255),
nom varchar (50),
roles enum ('admin', 'technicien', 'client') default 'client',
datemdp date, 
typeclient enum('particulier', 'professionnel') default 'professionnel',
adresse varchar(50),
ville varchar (50),
cp varchar (50), 
telephone int,
numeroSiret int,
constraint pk_user primary key (iduser)
);

create table produit (
idProduit int auto_increment not null,
nomProduit varchar(25) not null,
prixProduit float (5,2) not null,
description varchar(8000),
quantite int,
constraint pk_produit primary key (idProduit)
);


create table commande(
idcommande int  not null,
iduser int not null,
idproduit int not null,
quantiteproduit int, 
statut enum('en cours', 'validée', 'annulée', 'archivée' ),
dateCommande date ,
tvaCommande varchar(4) ,
totalHT float (9,2),
totalTTC float (9,2),
constraint pk_panier primary key (idcommande, iduser, idproduit),
constraint fk_user foreign key (iduser) references users(iduser),
constraint fk_produit foreign key (idproduit) references produit(idProduit)
);


create table intervention (
idintervention int(3) not null auto_increment,
libelle varchar(50),
dateintervention date,
statut enum('En attente', 'Validée','Annulée', 'Archivée') default 'En attente',
prixHT float,
prixTTC float,
iduser int(3),
idtechnicien int(3),
primary key (idintervention),
foreign key (iduser) references users(iduser),
foreign key (idtechnicien) references technicien(iduser)
) ENGINE=INNODB;


create table grainSel(
salt varchar(100) not null,
constraint pk_salt primary key (salt)
);


create table mdpOublie(
idmdpoublie int auto_increment not null,
question enum ('Quel est le nom de jeune fille de votre mère ?', 'Quel était le nom de votre premier animal de compagnie ?',"Comment s'appelait votre instituteur préféré à l'ecole primaire ?" ),
reponse varchar(255),
email varchar(100) not null,
constraint pk_idmdpoublie primary key (idmdpoublie)
);

alter table intervention 
add reglement enum ("en attente de paiement", "payé partiellement", "payé") default "en attente de paiement";

create table archive_commande as
    select users.*, idcommande, sum(quantiteproduit) as "nbArticle", statut , totalHT, totalTTC, datecommande
        from  users, commande 
        where users.iduser = commande.iduser 
        AND 2 = 0 
        group by idcommande, users.iduser, statut, totalHT, totalTTC, datecommande;



/************* VUE *************/ 
create  or replace view vue_intervention_and_users_enCours as(
    select intervention.* , users.nom as 'nomClient', technicien.nom as 'nomTech' 
    from intervention 
    inner join users on intervention.iduser = users.iduser 
    left join technicien on intervention.idtechnicien = technicien.iduser
    where statut in ("En attente", "Validée")
);

create  or replace view vue_intervention_and_users_archive as(
    select intervention.* , users.nom as 'nomClient', technicien.nom as 'nomTech' 
    from intervention 
    inner join users on intervention.iduser = users.iduser 
    left join technicien on intervention.idtechnicien = technicien.iduser
    where statut in ("Annulée", "Archivée")
);

create or replace view vue_intervention_archive as (
    select * from intervention where statut = "Archivée"
);

create or replace view vue_intervention_annulee as (
    select * from intervention where statut = "Annulée"
);

create or replace view vue_intervention_enAttente as (
    select * from intervention where statut = "En attente"
);

create or replace view vue_intervention_validee as (
    select * from intervention where statut = "Validée"
);


create or replace view  vue_commande_en_cours as (
    select idcommande, iduser, sum(quantiteproduit) as "nbArticle", statut, totalHT, totalTTC, datecommande
    from commande
    where statut  in ('en cours', 'validée') 
    group by idcommande, iduser, statut, totalHT, totalTTC, datecommande
);

create or replace view  vue_commande_archive as (
    select idcommande, iduser, sum(quantiteproduit) as "nbArticle", statut, totalHT, totalTTC, datecommande
    from commande where statut in ('archivée', 'annulée')   
    group by idcommande, iduser, statut, totalHT, totalTTC, datecommande
);

create or replace view vue_commande_enCours as (
    select * from commande where statut = 'en cours'
);

create or replace view vue_commande_archivee as (
    select * from commande where statut = 'archivée'
);

create or replace view vue_commande_annulee as (
    select * from commande where statut = 'annulée'
);

create or replace view vue_commande_validee as (
    select * from commande where statut = 'validée'
);

/*-------------------PROCEDURE --------------------*/

drop procedure if exists gestion_panier;
delimiter  //
create procedure gestion_panier (idpan int, idu int, idprod varchar(25), qtprod int)
begin 
    declare prixprod float; 
    declare HT float;
    declare  TTC float; 
    insert into commande (idcommande, iduser, idproduit, quantiteproduit, statut, dateCommande, tvaCommande) values (idpan, idu, idprod, qtprod, 'en cours', curdate(), '20%');
    select prixProduit from produit where idproduit = idprod  into prixprod ;
    select  totalHT, totalTTC from commande where idcommande = idpan limit 1  into HT, TTC;
    if HT is null then 
        set HT = 0; 
    end if; 
    if TTC is null then 
        set TTC = 0;
    end if; 
    set HT = HT + (prixprod * qtprod);
    set TTC = TTC + (prixprod * qtprod * 1.2); 
    update commande set totalHT = HT, totalTTC = TTC where idcommande = idpan and iduser =idu ;
    update produit set quantite = quantite - qtprod where idproduit = idprod;
end ;
//
delimiter ;

/*-------------------------TRIGGERS --------------  */

/*insert into panier (idpanier, iduser, idproduit, quantiteproduit, statut, dateCommande, montantHT, tvaCommande, montantTTC) values (1, 1, 1, 1, 'en cours', curdate(), '12', '20%', '21'); */

/* AJOUT USERS */ 

/*
drop trigger if exists archi_client;
delimiter // 
create trigger archi_client
before 
*/

drop trigger if exists ajout_particulier;
delimiter // 
create trigger ajout_particulier
before insert on particulier 
for each row 
begin 
declare user int;
declare grain varchar(100);
select salt into grain from grainSel;
set new.mdp = sha1(concat(new.mdp, grain));
select count(*) into user from users where email = new.email;
if user = 0 then 
    insert into users (email, mdp, roles, nom, datemdp) values (new.email, new.mdp, 'client', new.nom, new.datemdp);
    insert into client (email, mdp, roles, typeclient, nom, datemdp, adresse, ville, cp, telephone) values (new.email, new.mdp, 'client', 'particulier', new.nom, new.datemdp, new.adresse, new.ville, new.cp, new.telephone);
else 
    signal sqlstate '45000'
    set message_text = 'Données déja existantes';
end if;
end // 
delimiter ; 


drop trigger if exists ajout_professionnel;
delimiter // 
create trigger ajout_professionnel
before insert on professionnel 
for each row 
begin 
declare user int;
declare grain varchar(100);
select salt into grain from grainSel;
set new.mdp = sha1(concat(new.mdp, grain));
select count(*) into user from users where email = new.email;
if user = 0 then 
    insert into users (email, mdp, roles, nom, datemdp) values (new.email, new.mdp, 'client', new.nom, new.datemdp);
    insert into client (email, mdp, roles, typeclient, nom, datemdp, adresse, ville, cp, telephone) values (new.email, new.mdp, 'client', 'professionnel', new.nom, new.datemdp, new.adresse, new.ville, new.cp, new.telephone);
else 
    signal sqlstate '45000'
    set message_text = 'Données déja existantes';
end if;
end // 
delimiter ; 

drop trigger if exists ajouter_admin;
delimiter // 
create trigger ajouter_admin
before insert on admin 
for each row 
begin 
declare user int; 
declare grain varchar(100);
select salt into grain from grainSel;
set new.mdp = sha1(concat(new.mdp, grain));
select count(*) into user from users where email = new.email; 
if user = 0 then 
    insert into users (email, mdp, nom, roles, datemdp) values (new.email, new.mdp, new.nom, 'admin', new.datemdp);
else 
    signal sqlstate '45000'
    set message_text = "L'utilisateur existe déja !";
end if; 
end //
delimiter ;  


drop trigger if exists ajouter_tech;
delimiter // 
create trigger ajouter_tech
before insert on technicien 
for each row 
begin 
declare user int; 
declare grain varchar(100);
select salt into grain from grainSel;
set new.mdp = sha1(concat(new.mdp, grain));
select count(*) into user from users where email = new.email; 
if user = 0 then 
    insert into users (email, mdp, nom, roles, datemdp) values (new.email, new.mdp, new.nom, 'technicien', new.datemdp);
else 
    signal sqlstate '45000'
    set message_text = "L'utilisateur existe déja !";
end if; 
end //
delimiter ; 

/* MODIFIER USERS */

drop trigger if exists modifier_particulier;
delimiter // 
create trigger modifier_particulier 
before update on particulier
for each row 
begin 
    declare grain varchar(100);
    select salt into grain from grainSel;
    if new.mdp != old.mdp then
    set new.mdp = sha1(concat(new.mdp, grain));
    end if;
    update users set email = new.email, nom = new.nom, mdp = new.mdp, datemdp = new.datemdp where email = old.email;
    update client set email = new.email, nom = new.nom, mdp = new.mdp, adresse = new.adresse, ville = new.ville, cp = new.cp, telephone = new.telephone, datemdp = new.datemdp  where email = old.email;
end // 
delimiter ; 


drop trigger if exists modifier_professionnel;
delimiter // 
CREATE TRIGGER modifier_professionnel
BEFORE UPDATE ON professionnel
FOR EACH ROW
BEGIN
    declare grain varchar(100);
    select salt into grain from grainSel;
    if new.mdp != old.mdp then
    set new.mdp = sha1(concat(new.mdp, grain));
    end if;
    UPDATE users SET email = new.email, nom = NEW.nom, mdp = NEW.mdp, datemdp = new.datemdp WHERE email = OLD.email;
    UPDATE client SET email = NEW.email, nom = NEW.nom, mdp = NEW.mdp, adresse = NEW.adresse, ville = NEW.ville, cp = NEW.cp, telephone = NEW.telephone, datemdp = new.datemdp WHERE email = OLD.email;
END //
delimiter ; 


drop trigger if exists modifier_admin;
delimiter // 
create trigger modifier_admin
before update on admin
for each row 
begin 
    declare grain varchar(100);
    select salt into grain from grainSel;
    if new.mdp != old.mdp then
    set new.mdp = sha1(concat(new.mdp, grain));
    end if;
    UPDATE users SET email = new.email, nom = NEW.nom, mdp = NEW.mdp, datemdp = new.datemdp WHERE email = OLD.email;
end // 
delimiter ;

drop trigger if exists modifier_tech;
delimiter // 
create trigger modifier_tech
before update on technicien
for each row 
begin
    declare grain varchar(100);
    select salt into grain from grainSel;
    if new.mdp != old.mdp then
    set new.mdp = sha1(concat(new.mdp, grain));
    end if;
    UPDATE users SET email = new.email, nom = NEW.nom, mdp = NEW.mdp, datemdp = new.datemdp WHERE email = OLD.email;
end // 
delimiter ;


/* SUPPRIMER USERS */

drop trigger if exists supprimer_user; 
delimiter // 
create trigger supprimer_user 
before delete on users 
for each row 
begin 
    delete from client where email = old.email; 
    delete from particulier where email = old.email; 
    delete from professionnel where email = old.email; 
    delete from  technicien where email = old.email; 
    delete from admin where email = old.email;

    delete commande from commande inner join users on commande.iduser = users.iduser 
    left join particulier on users.email = particulier.email 
    left join professionnel on users.email = professionnel.email 
    left join admin on admin.email = users.email 
    left join technicien t on t.email = users.email 
    where users.iduser = old.iduser;

    delete intervention from intervention inner join users on intervention.iduser = users.iduser 
    left join particulier on users.email = particulier.email 
    left join professionnel on users.email = professionnel.email 
    left join admin on admin.email = users.email 
    left join technicien t on t.email = users.email 
    where users.iduser = old.iduser;

end // 
delimiter ;


/************AJOUT INTERVENTION *****/

drop trigger if exists ajout_intervention;
delimiter // 
create trigger ajout_intervention
before insert on intervention
for each row
begin 
declare controle_date int ; 
declare clientType int; 
select count(*)  into controle_date from intervention where iduser = new.iduser and dateintervention = new.dateintervention;
if controle_date = 0 then
    select count(*) into clientType from client, users where users.email = client.email AND 
    users.iduser = new.iduser and typeclient = 'professionnel'; 
    if clientType = 0 then 
    set new.prixTTC = new.prixHT * 1.20; 
    else set new.prixTTC = Null; 
    end if; 
else 
    signal sqlstate '45000'
    set message_text = 'Impossible de réserver deux intervention le même jour.';
end if; 
end // 
delimiter ;



/*-----------------_____________________INSERT______________________----------*/

/*** PRODUITS ******/
insert into produit (nomProduit, prixProduit, description, quantite) values ('pneu', 250, '- Neuf comme usé, ce pneu offre un freinage remarquable sur routes mouillées..
- Adhérence exceptionnelle sur sol mouillé.
- Une consommation moindre et un kilométrage supérieur de 20 % par rapport à son prédécesseur.', 10);
insert into produit (nomProduit, prixProduit, description, quantite ) values ('phare', 150, "Le projecteur de complément antibrouillard VALEO permet d'apporter un complément d'éclairage. Les projecteurs antibrouillard contribuent à une amélioration de la sécurité en améliorant la visibilité de l'automobiliste. Ceux-ci procurent un éclairage uniforme sur toute la largeur de la route, fournissant ainsi un large faisceau de lumière pour une conduite plus sûre, adaptée aux conditions climatiques extrêmes.", 10);
insert into produit (nomProduit, prixProduit, description, quantite ) values ('siege', 125, "Ce siège-auto rotatif avec système Isofix offre un confort optimal à la fois aux parents et aux enfants, et peut être utilisé dos ou face à la route. Grâce à sa rotation latérale côté portière, l’installation de votre enfant est plus facile. Son design élégant et moderne vous séduira et la sécurité garantira un voyage en toute tranquillité.
", 3);
insert into produit (nomProduit, prixProduit, description, quantite ) values ('siege2', 130, "Ce siège-auto rotatif avec système Isofix offre un confort optimal à la fois aux parents et aux enfants, et peut être utilisé dos ou face à la route. Grâce à sa rotation latérale côté portière, l’installation de votre enfant est plus facile. Son design élégant et moderne vous séduira et la sécurité garantira un voyage en toute tranquillité.
", 6);
insert into produit (nomProduit, prixProduit, description, quantite ) values ('parchoc', 65, "Un pare-chocs est un élément de carrosserie en métal ou en plastique situé devant et derrière une voiture. Il permet d'atténuer les dégâts en cas de collision avec un autre véhicule ou objet. Orthographe simplifiée : pare-choc.", 7);
insert into produit (nomProduit, prixProduit, description, quantite ) values ('moteur', 850, "Le moteur Gaposa Rapido LP6090/TMM avec parachute et électrofrein incorporés motorise parfaitement les portes industrielles rapides, il a une force de 60 newtons, une puissance de 950 W et une vitesse de 90 tours minute.
Moteur Rapido Gaposa avec commande de secours manivelle standard possédant des fins de course mécaniques.", 50);
insert into produit (nomProduit, prixProduit, description, quantite ) values ('jante', 175, "La jante Spike est une jante de haute qualité, elle fait partie de la gamme INFINY. Intemporelle, cette jante vous séduira avec ses 10 doubles branches. Son design lui confère une allure élégante et sportive.
Les photos de nos jantes aluminium ne tiennent pas compte de la typologie de votre véhicule. Elles peuvent être présentées en 4 ou 5 trous. Pour vérifier que la jante dispose bien du nombre de trous souhaité, nous vous invitons à consulter dans le tableau ci-dessous les caractéristiques de cette jante.
", 5);
insert into produit (nomProduit, prixProduit, description, quantite ) values ('essuie-glace', 35, "Les essuie-glaces plats BOSCH Clearview permettent de remplacer les balais d'essuie-glaces métalliques et d’améliorer les performances d’essuyage : une visibilité optimale pour une sécurité maximale. Les 2 raidisseurs de haute technologie en acier Evodium répartissent la pression exercée par le bras d'essuyage de manière uniforme d’un bout à l’autre de l’essuie-glace.
Les essuies-glaces BOSCH Clearview sont particulierement facile et rapide à monter. Pour faciliter le montage, le balai est vendu avec 1 adaptateur prémonté", 5);

/*** USER ******/
insert into grainSel values('9876512347654238743656');

insert into admin (email, mdp, roles, nom) values ('admin@gmail.com', 'admin', 'admin', 'admin');
insert into particulier (email, mdp, roles, nom) values ('client@gmail.com', 'client', 'client', 'Jean');
insert into technicien (email, mdp, roles, nom) values ('tech@gmail.com', 'tech', 'technicien', 'Mathieu');
INSERT INTO particulier (email, mdp, roles, nom) VALUES ('Alice@gmail.com', 'password1', 'client', 'Alice');
INSERT INTO technicien (email, mdp, roles, nom) VALUES ('Bob@gmail.com', 'password2', 'technicien', 'Bob');
INSERT INTO admin (email, mdp, roles, nom) VALUES ('Charlie@gmail.com', 'password3', 'admin', 'Charlie');
INSERT INTO particulier (email, mdp, roles, nom) VALUES ('David@gmail.com', 'password4', 'client', 'David');
INSERT INTO technicien (email, mdp, roles, nom) VALUES ('Emily@gmail.com', 'password5', 'technicien', 'Emily');
INSERT INTO particulier (email, mdp, roles, nom) VALUES ('Frank@gmail.com', 'password1', 'client', 'Frank');
INSERT INTO technicien (email, mdp, roles, nom) VALUES ('George@gmail.com', 'password2', 'technicien', 'George');
INSERT INTO particulier (email, mdp, roles, nom) VALUES ('Isabelle@gmail.com', 'password4', 'client', 'Isabelle');
INSERT INTO technicien (email, mdp, roles, nom) VALUES ('Jack@gmail.com', 'password5', 'technicien', 'Jack');

INSERT INTO professionnel (email, mdp, roles, nom, adresse, ville, cp, telephone, numeroSiret) VALUES ('professionnel1@gmail.com', 'password1', 'admin', 'Nom1', 'Adresse1', 'Ville1', 'CP1', '0123456789', '123456789');
INSERT INTO professionnel (email, mdp, roles, nom, adresse, ville, cp, telephone, numeroSiret) VALUES ('professionnel2@gmail.com', 'password2', 'technicien', 'Nom2', 'Adresse2', 'Ville2', 'CP2', '0123456780', '123456780');
INSERT INTO professionnel (email, mdp, roles, nom, adresse, ville, cp, telephone, numeroSiret) VALUES ('professionnel3@gmail.com', 'password3', 'client', 'Nom3', 'Adresse3', 'Ville3', 'CP3', '0123456781', '123456781');
INSERT INTO professionnel (email, mdp, roles, nom, adresse, ville, cp, telephone, numeroSiret) VALUES ('professionnel4@gmail.com', 'password4', 'admin', 'Nom4', 'Adresse4', 'Ville4', 'CP4', '0123456782', '123456782');
INSERT INTO professionnel (email, mdp, roles, nom, adresse, ville, cp, telephone, numeroSiret) VALUES ('professionnel5@gmail.com', 'password5', 'technicien', 'Nom5', 'Adresse5', 'Ville5', 'CP5', '0123456783', '123456783');


/*** COMMANDES ******/
INSERT INTO commande (idcommande, iduser, idproduit, quantiteproduit, statut, dateCommande, tvaCommande ) 
VALUES (1, 1, 1, 2, 'en cours', '2022-01-01', '19.6');
INSERT INTO commande (idcommande, iduser, idproduit, quantiteproduit, statut, dateCommande, tvaCommande ) 
VALUES (1, 1, 2, 4, 'en cours', '2022-01-01', '19.6');
INSERT INTO commande (idcommande, iduser, idproduit, quantiteproduit, statut, dateCommande, tvaCommande ) 
VALUES (1, 1, 3, 1, 'en cours', '2022-01-01', '19.6');
INSERT INTO commande (idcommande, iduser, idproduit, quantiteproduit, statut, dateCommande, tvaCommande ) 
VALUES (1, 1, 4, 5, 'en cours', '2022-01-01', '19.6');
INSERT INTO commande (idcommande, iduser, idproduit, quantiteproduit, statut, dateCommande, tvaCommande ) 
VALUES (2, 2, 2, 1, 'validée', '2022-02-01', '19.6');
INSERT INTO commande (idcommande, iduser, idproduit, quantiteproduit, statut, dateCommande, tvaCommande) 
VALUES (3, 3, 3, 3, 'annulée', '2022-03-01', '19.6');

insert into intervention (libelle, dateintervention, iduser) values ('reparation', curdate(), 2);


