-- Table Address
CREATE TABLE Address (
    idAdress SERIAL PRIMARY KEY,
    Street VARCHAR(255),
    City VARCHAR(100),
    State VARCHAR(100),
    PostalCode VARCHAR(20),
    Country VARCHAR(100)
);

-- Table Utilisateur (User)
CREATE TABLE Utilisateur (
    idUtilisateur SERIAL PRIMARY KEY,
    Surname VARCHAR(100),
    Firstname VARCHAR(100),
    Email VARCHAR(100),
    PhoneNumber VARCHAR(20),
    DateOfBirth DATE,
    Password VARCHAR(255),
    AddressId INT,
    FOREIGN KEY (AddressId) REFERENCES Address(idAdress)
);

-- Table Agency
CREATE TABLE Agency (
    idAgency SERIAL PRIMARY KEY,
    PhoneNumber VARCHAR(20)
);

-- Table MessageClient
CREATE TABLE MessageClient (
    idMessage SERIAL PRIMARY KEY,
    Type VARCHAR(50),
    contenu TEXT,
    date DATE,
    UtilisateurId INT,
    FOREIGN KEY (UtilisateurId) REFERENCES Utilisateur(idUtilisateur)
);

-- Table Reservation
CREATE TABLE Reservation (
    idReservation SERIAL PRIMARY KEY,
    StartDate DATE,
    EndDate DATE,
    DepartureCity VARCHAR(100),
    ArrivalCity VARCHAR(100),
    TotalPrice FLOAT,
    Statut VARCHAR(50),
    UtilisateurId INT,
    FOREIGN KEY (UtilisateurId) REFERENCES Utilisateur(idUtilisateur)
);

-- Table Car
CREATE TABLE Car (
    idCar SERIAL PRIMARY KEY,
    Model VARCHAR(100),
    Category VARCHAR(50),
    Availability BOOLEAN,
    PricePerDay FLOAT,
    Seats INT,
    AvailableFrom DATE,
    AgencyId INT,
    FOREIGN KEY (AgencyId) REFERENCES Agency(idAgency)
);

