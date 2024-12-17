CREATE DATABASE bilabonnement;

USE bilabonnement;

-- Tabel for Useradministration
DROP TABLE IF EXISTS Useradministration;
CREATE TABLE Useradministration (
                                    UserID INT AUTO_INCREMENT PRIMARY KEY,
                                    Brugernavn VARCHAR(50) NOT NULL,
                                    Kode VARCHAR(255) NOT NULL
);

-- Tabel for Kunde
DROP TABLE IF EXISTS Kunde;
CREATE TABLE Kunde (
                       KundeID INT AUTO_INCREMENT PRIMARY KEY,
                       Navn VARCHAR(100) NOT NULL,
                       Email VARCHAR(100) NOT NULL,
                       Telefon VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS Tilstand;
CREATE TABLE Tilstand(
                         TilstandID INT AUTO_INCREMENT PRIMARY KEY,
                         TilstandNavn VARCHAR(100) NOT NULL
);

-- Tabel for Bil
DROP TABLE IF EXISTS Bil;
CREATE TABLE Bil (
                     Vognnummer VARCHAR(100) PRIMARY KEY,
                     Maerke VARCHAR(50) NOT NULL,
                     Stelnummer VARCHAR(50) NOT NULL,
                     Model INT NOT NULL,
                     Staalpris DOUBLE,
                     RegAfgift DOUBLE,
                     CO2Udledning DOUBLE,
                     GearType VARCHAR(50),
                     TilstandID INT,
                     FOREIGN KEY(TilstandID) REFERENCES Tilstand(TilstandID)
);

-- Table for Billeder
DROP TABLE IF EXISTS Image;
CREATE TABLE Image(
                      ImageID INT AUTO_INCREMENT PRIMARY KEY,
                      Imageurl VARCHAR(5000),
                      Vognnummer VARCHAR(100),
                      FOREIGN KEY (Vognnummer) REFERENCES Bil(Vognnummer)
);

DROP TABLE IF EXISTS StatusLK;
CREATE TABLE StatusLK(
                         StatusID INT AUTO_INCREMENT PRIMARY KEY,
                         StatusNavn VARCHAR(50) NOT NULL
);

-- Tabel for Lejekontrakt
DROP TABLE IF EXISTS Lejekontrakt;
CREATE TABLE Lejekontrakt (
                              LejekontraktID INT AUTO_INCREMENT PRIMARY KEY,
                              KundeID INT,
                              Vognnummer VARCHAR(100),
                              StartDato DATE NOT NULL,
                              SlutDato DATE NOT NULL,
                              Pris DOUBLE,
                              StatusID INT,
                              FOREIGN KEY (KundeID) REFERENCES Kunde(KundeID),
                              FOREIGN KEY (Vognnummer) REFERENCES Bil(Vognnummer),
                              FOREIGN KEY(StatusID) REFERENCES StatusLK(StatusID)
);

-- Tabel for Skaderapport
DROP TABLE IF EXISTS Skaderapport;
CREATE TABLE Skaderapport (
                              SkadeID INT AUTO_INCREMENT PRIMARY KEY,
                              KundeID INT,
                              Vognnummer VARCHAR(100),
                              Dato DATE NOT NULL,
                              OverkoerteKilometer DOUBLE,
                              CheckAfSkade VARCHAR(255),
                              SkadeBeskrivelse VARCHAR(1000),
                              PrisIAlt DOUBLE,
                              FOREIGN KEY (KundeID) REFERENCES Kunde(KundeID),
                              FOREIGN KEY (Vognnummer) REFERENCES Bil(Vognnummer)
);

-- INSERT INTO Useradministration
INSERT INTO Useradministration (Brugernavn, Kode)
VALUES
    ('DataBruger', 'password123'),
    ('SkadeBruger', 'kode1234'),
    ('ForretningsudviklerBruger3', '123password');

-- INSERT INTO Kunde
INSERT INTO Kunde (Navn, Email, Telefon)
VALUES
    ('Anders Andersen', 'anders@example.com', '12345678'),
    ('Bent Petersen', 'bentp@example.com', '23456789'),
    ('Charlotte Nielsen', 'charlotte@example.com', '34567890'),
    ('Dorte Hansen', 'dorteh@example.com', '45678901'),
    ('Emil Madsen', 'emilm@example.com', '56789012'),
    ('Frederik Jensen', 'frederikj@example.com', '67890123'),
    ('Grethe Sørensen', 'grethes@example.com', '78901234'),
    ('Hans Larsen', 'hansl@example.com', '89012345'),
    ('Ida Olsen', 'idao@example.com', '90123456');

-- INSERT INTO Tilstand
INSERT INTO Tilstand (TilstandNavn)
VALUES
    ('Lejeklar'),
    ('Udlejet'),
    ('Skadet');

-- INSERT INTO Bil
INSERT INTO Bil (Vognnummer, Maerke, Stelnummer, Model, Staalpris, RegAfgift, CO2Udledning, GearType, TilstandID)
VALUES
    ('AB 12345 DK', 'Toyota', 'ABCDEF12345678901', 2021, 2500, 3500, 100.5, 'Automatisk', 2),
    ('AB 23456 DK', 'Volkswagen', 'XYZ987654321ABCDE', 2020, 3000, 40000, 120.2, 'Manuel', 1),
    ('AB 34567 DK', 'Tesla', 'TESLA123456789ABC', 2022, 5000, 4500, 0.0, 'Automatisk', 1),
    ('AB 45678 DK', 'BMW', 'BMW987654321LMNOP', 2019, 4500, 5000, 150.7, 'Automatisk', 3),
    ('AB 56789 DK', 'Mercedes', 'MERC123456789QRST', 2021, 6000, 6000, 130.4, 'Manuel', 2),
    ('SK 67890 DK', 'Audi', 'AUDI123456789XYZ', 2020, 4000, 4500, 110.4, 'Automatisk', 3),
    ('SK 78901 DK', 'Ford', 'FORD123456789ABC', 2019, 2500, 3000, 90.0, 'Manuel', 3),
    ('SK 89012 DK', 'Volvo', 'VOLVO123456789DEF', 2021, 3500, 3800, 105.3, 'Automatisk', 3),
    ('SK 90123 DK', 'Hyundai', 'HYUND123456789GHI', 2022, 3000, 34000, 95.7, 'Manuel', 3);

-- INSERT INTO Image
INSERT INTO Image(Imageurl, Vognnummer)
VALUES
    ('https://images.toyota-europe.com/dk/configurationtype/visual-for-model-selector/product-token/588a0222-3631-4cff-adda-8e4189372e8a/fallback/true/width/390/height/260/scale-mode/3/padding/0,0,-50,30/image-quality/75/exterior-4.png', 'AB 12345 DK'),
    ('https://newcars-media.cdn.semler.io/images//WVGZZZCR4RD018336/frontLeft', 'AB 23456 DK'),
    ('https://static-assets.tesla.com/configurator/compositor?context=design_studio_2?&bkba_opt=1&view=STUD_3QTR&size=1400&model=my&options=$APBS,$DV2W,$INPB0,$PPSW,$PRMY1,$SC04,$MDLY,$WY20P,$MTY13,$STY5S,$CPF0&crop=1400,850,300,130&', 'AB 34567 DK'),
    ('https://find.bmw.dk/_next/image?url=https%3A%2F%2Fprod.cosy.bmw.cloud%2Fministorene%2FcosySec%3FCOSY-EU-100-7331c9Nv2Z7d5yKlHS9P3AKWL2JeiHlZGgpn23HGfvQFz%2525eJE47UAzLekjnW9ZThJPLZf1EoKGZdpkeGhNS4ctE6LVP2KVZb6989RkBzcSktaJJE47BdqfoUwWptvXhFUwkEaagdE7raFx6RCzIhtE6BmudhSId4k9VTCrm7AaCil6JTKGwgYXcjnWqVskbNDOBeagdIhceJnTNB9aWDO2kOHUtWPfbYfvKsd10t9gP050y0wvbHi4TmFR9%2525wc3y%2525eiftxdTgDw178z3lTtECUkdXU7slGAMnQCrXpFhtilZQ6Kom6XRaYWlALQ5nmPX7JagOybQgsnvIT9avCO2B3in1lIjedwO45BDMztIBDeqhk7BZgMLoACeRThJHFlM5hou%2525KXwuDHSfWQtZu%2525V1Pa7IsfNEbnCxb10s9Ol8vE4riIXU4scZwBQ1drxRteaEBZ857MjH0RUgChDYE5GvloqmKgp2XHLyPv6jQ%2525J9k2YDafuJijmqn1SFRDyLOEVxKqTJIsN8eL3uBr0W0JdSeZWEYuzVMRPsSSkNh5byyVA0og9QNNF4Hvi5b0Kc%25252cq74WxfjxyccP81D8LhxbUEqUGD89GsLGbBUiprJp9wGw6Zu6iGptYRSCx667m5VleIYCjlkqOUfFSrdE&w=3840&q=90', 'AB 45678 DK'),
    ('https://assets.oneweb.mercedes-benz.com/iris/iris.png?COSY-EU-100-1713d0VXqNWFqtyO67PobzIr3eWsrrCsdRRzwQZQ9vZbMw3SGtlajtsd2JQcUfpO6XGEubYJ0l36xOB2NznbApRARI5ux4YQC31gFkzNBTkm7jA2jhKViKw%25vq4y9yLRgXDYax%255hrH1ycrn8w0TfoiZBkNM4FAm2Tg95Yn6PDakNSeWHw9tsd8otcUfiX6XGE4JYJ0lgChOB2PzFbAp7ToI5uKMTQmIJwF1Gq6PDL1DSeWvyVtsdPv%25cUfxgVXGE0aBJ0lB4lOBi1aftkV3xb15oOmzV2rbpldCCNZkFu6pFIT9ZxexrlrKE847dvE5jCFcpF&imgt=P27&bkgnd=9&pov=BE040,DZO&uni=cs&im=Crop,rect=(0,0,1450,750),gravity=Center', 'AB 56789 DK'),
    ('https://mediaservice.audi.com/media/fast/H4sIAAAAAAAA_1vzloG1tIiBOTrayfuvpGh6-m1zJgaGigIGBgZGoDhTtNOaz-I_2DhCHsCEtzEwF-SlMwJZKUycmbmJ6an6QD4_I3taTmV-aUkxO0grT7Hr7DNZE0okb7_oe3g5J-iYpKXFXwZWoC4mSSDBvAFI8E0DEhyPGcAkyDyQIEMTiM9kyczAwFoBZEQygAAfX2lRTkFiUWKuXnlmSkmGoIYBkUCY3cU1xNHTJxgA1qqYIukAAAA','SK 67890 DK'),
    ('https://www.gpas-cache.ford.com/guid/188b638d-f310-3729-a4c1-f5ffa5747544.png','SK 78901 DK'),
    ('https://imgd.aeplcdn.com/370x208/n/cw/ec/131131/xc60-exterior-right-front-three-quarter-3.jpeg?isig=0','SK 89012 DK'),
    ('https://assets.hyundai.dk/media/ganebqhj/ioniq-5-n_modeloversigt.jpg?height=302&mode=crop&width=540','SK 90123 DK');

-- INSERT INTO StatusLK
INSERT INTO StatusLK (StatusNavn)
VALUES
    ('Aktiv'),
    ('Afsluttet');

-- INSERT INTO Lejekontrakt
INSERT INTO Lejekontrakt (KundeID, Vognnummer, StartDato, SlutDato, Pris, StatusID)
VALUES
    (1, 'AB 12345 DK', '2023-11-01', '2023-12-01', 5000, 1),
    (2, 'AB 23456 DK', '2023-10-01', '2023-11-01', 6000, 2),
    (3, 'AB 34567 DK', '2023-12-01', '2024-01-01', 7000, 1),
    (4, 'AB 45678 DK', '2023-09-15', '2023-10-15', 8000, 2),
    (5, 'AB 56789 DK', '2023-11-15', '2023-12-15', 7500, 1),
    (6, 'Sk 67890 DK', '2023-10-01', '2023-10-15', 4000, 2),
    (7, 'SK 78901 DK', '2023-09-01', '2023-09-10', 3000, 2),
    (8, 'SK 89012 DK', '2023-08-15', '2023-08-30', 5000, 2),
    (9, 'SK 90123 DK', '2023-07-01', '2023-07-15', 3500, 2);

-- INSERT INTO Skaderapport
INSERT INTO Skaderapport (KundeID, Vognnummer, Dato, OverkoerteKilometer, CheckAfSkade, SkadeBeskrivelse, PrisIAlt)
VALUES
    (4, 'AB 45678 DK', '2023-10-05', 2000, 'FDM', 'Der er en revne på bilens forrude, som kræver udskiftning', 5000),
    (6, 'SK 67890 DK', '2023-10-16', 2500, 'FDM', 'Stor bule på højre side af bilen, kræver reparation', 8000),
    (7, 'SK 78901 DK', '2023-09-11', 3000, 'bilabbonoment', 'Skader på baglygterne efter mindre sammenstød', 3000),
    (8, 'SK 89012 DK', '2023-08-31', 1500, 'FDM', 'Flænge i højre fordæk, skal udskiftes', 2000),
    (9, 'SK 90123 DK', '2023-07-16', 1000, 'bilabbonoment', 'Ridser på begge sidespejle, kræver maling', 2500);

-- forspørgelse som viser bil informationerne i webapplikationen
SELECT
    Bil.Vognnummer,
    Bil.Maerke,
    Bil.Stelnummer,
    Bil.Model,
    Bil.Staalpris,
    Bil.RegAfgift,
    Bil.CO2Udledning,
    Bil.GearType,
    Tilstand.TilstandNavn AS Tilstand,
    Image.Imageurl
FROM
    Bil
        LEFT JOIN
    Tilstand ON Bil.TilstandID = Tilstand.TilstandID
        LEFT JOIN
    Image ON Bil.Vognnummer = Image.Vognnummer;

-- forspørgelse som viser lejekontrakt informationerne i webapplikationen
SELECT
    Image.Imageurl,
    Lejekontrakt.LejekontraktID,
    Lejekontrakt.StartDato,
    Lejekontrakt.SlutDato,
    Lejekontrakt.Pris,
    Bil.Vognnummer,
    Kunde.Navn,
    Kunde.Email,
    Kunde.Telefon,
    StatusLK.StatusNavn AS Status
FROM
    Lejekontrakt
        LEFT JOIN
    Bil ON Lejekontrakt.Vognnummer = Bil.Vognnummer
        LEFT JOIN
    Kunde ON Lejekontrakt.KundeID = Kunde.KundeID
        LEFT JOIN
    Image ON Bil.Vognnummer = Image.Vognnummer
        LEFT JOIN
    StatusLK ON Lejekontrakt.StatusID = StatusLK.StatusID;

-- forspøgelse som henter informationer fra skaderapport
SELECT
    SkadeID,
    Vognnummer,
    Dato,
    OverkoerteKilometer,
    CheckAfSkade,
    SkadeBeskrivelse,
    PrisIAlt
FROM
    Skaderapport;





