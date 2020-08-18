# eticaret

Updated Database

-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2019 at 01:53 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eticaret`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosya`
--

CREATE TABLE `dosya` (
  `DosyaID` int(11) NOT NULL,
  `Dosya` longblob NOT NULL,
  `IslemTarihi` datetime NOT NULL,
  `KullaniciId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `KategoriID` int(11) NOT NULL,
  `KategoriAdi` varchar(50) CHARACTER SET latin1 NOT NULL,
  `KategoriKod` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Aciklama` varchar(250) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`KategoriID`, `KategoriAdi`, `KategoriKod`, `Aciklama`) VALUES
(1, 'Güzel Sanatlar', 'GuzelSanatlar', ''),
(2, 'Sosyal Bilimler', 'SosyalBilimler', ''),
(3, 'Fen Bilimleri', 'FenBilimleri', '');

-- --------------------------------------------------------

--
-- Table structure for table `kullanici`
--

CREATE TABLE `kullanici` (
  `kullaniciID` int(11) NOT NULL,
  `KullaniciAdi` varchar(50) CHARACTER SET latin1 NOT NULL,
  `KullaniciRolId` int(11) NOT NULL,
  `MusteriId` int(11) NOT NULL,
  `Sifre` varchar(250) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kullanici`
--

INSERT INTO `kullanici` (`kullaniciID`, `KullaniciAdi`, `KullaniciRolId`, `MusteriId`, `Sifre`) VALUES
(1, 'rabia', 1, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `musteri`
--

CREATE TABLE `musteri` (
  `musteriID` int(11) NOT NULL,
  `Isim` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Soyisim` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Email` varchar(50) CHARACTER SET latin1 NOT NULL,
  `MusteriAdres` varchar(500) CHARACTER SET latin1 NOT NULL,
  `IslemTarihi` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `musteri`
--

INSERT INTO `musteri` (`musteriID`, `Isim`, `Soyisim`, `Email`, `MusteriAdres`, `IslemTarihi`) VALUES
(1, 'Rabia', 'Akta?', 'akt@akt.com', 'Üniversite', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `odemesecenek`
--

CREATE TABLE `odemesecenek` (
  `OdemeSecenekID` int(11) NOT NULL,
  `OdemeSecenekAdi` varchar(50) CHARACTER SET latin1 NOT NULL,
  `OdemeSecenekKod` varchar(50) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `RolID` int(11) NOT NULL,
  `RolAdi` varchar(50) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`RolID`, `RolAdi`) VALUES
(1, 'eTicaretKullanici'),
(2, 'eTicaretYonetici');

-- --------------------------------------------------------

--
-- Table structure for table `siparis`
--

CREATE TABLE `siparis` (
  `SiparisID` int(11) NOT NULL,
  `ToplamTutar` float NOT NULL,
  `SiparisTarihi` datetime NOT NULL,
  `KisiId` int(11) NOT NULL,
  `SiparisDurumId` int(11) NOT NULL,
  `OdemeSecenekId` int(11) NOT NULL,
  `IslemTarihi` datetime NOT NULL,
  `siparisAdres` varchar(250) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `siparisdurum`
--

CREATE TABLE `siparisdurum` (
  `SiparisDurumID` int(11) NOT NULL,
  `SiparisDurumAdi` varchar(50) CHARACTER SET latin1 NOT NULL,
  `siparisDurumKod` varchar(50) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `siparisurun`
--

CREATE TABLE `siparisurun` (
  `SiparisUrunID` int(11) NOT NULL,
  `Adet` int(11) NOT NULL,
  `UrunId` int(11) NOT NULL,
  `SiparisId` int(11) NOT NULL,
  `KullaniciId` int(11) NOT NULL,
  `IslemTarihi` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `StokID` int(11) NOT NULL,
  `UrunId` int(11) NOT NULL,
  `Adet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `urun`
--

CREATE TABLE `urun` (
  `UrunID` int(11) NOT NULL,
  `UrunAdi` varchar(50) CHARACTER SET latin1 NOT NULL,
  `UrunKod` varchar(50) CHARACTER SET latin1 NOT NULL,
  `Aciklama` varchar(250) CHARACTER SET latin1 DEFAULT NULL,
  `EklenmeTarihi` datetime NOT NULL,
  `IslemTarihi` datetime NOT NULL,
  `KullaniciId` int(11) NOT NULL,
  `DosyaId` int(11) DEFAULT NULL,
  `KategoriId` int(11) NOT NULL,
  `UrunAlisFiyat` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `urun`
--

INSERT INTO `urun` (`UrunID`, `UrunAdi`, `UrunKod`, `Aciklama`, `EklenmeTarihi`, `IslemTarihi`, `KullaniciId`, `DosyaId`, `KategoriId`, `UrunAlisFiyat`) VALUES
(1, 'Airbrush Teknolojisi', 'AirbrushTeknolojisi', '', '2019-04-05 16:29:51', '2019-04-05 16:29:51', 1, NULL, 1, 10),
(2, 'Klasik Bake', 'KlasikBake', '', '2019-04-05 16:39:54', '2019-04-05 16:39:54', 1, NULL, 1, 10),
(3, 'S???nmac? Problemi', 'S???nmac?Problemi', '', '2019-04-05 16:41:49', '2019-04-05 16:41:49', 1, NULL, 2, 10),
(4, 'Kültürel Miras?n ?zinde', 'KültürelMiras?n?zinde', '', '2019-04-05 16:43:39', '2019-04-05 16:43:39', 1, NULL, 3, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosya`
--
ALTER TABLE `dosya`
  ADD PRIMARY KEY (`DosyaID`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`KategoriID`);

--
-- Indexes for table `kullanici`
--
ALTER TABLE `kullanici`
  ADD PRIMARY KEY (`kullaniciID`),
  ADD KEY `kullaniciRolId` (`KullaniciRolId`),
  ADD KEY `MusteriId` (`MusteriId`);

--
-- Indexes for table `musteri`
--
ALTER TABLE `musteri`
  ADD PRIMARY KEY (`musteriID`);

--
-- Indexes for table `odemesecenek`
--
ALTER TABLE `odemesecenek`
  ADD PRIMARY KEY (`OdemeSecenekID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`RolID`);

--
-- Indexes for table `siparis`
--
ALTER TABLE `siparis`
  ADD PRIMARY KEY (`SiparisID`),
  ADD KEY `OdemeSecenekId` (`OdemeSecenekId`),
  ADD KEY `KisiId` (`KisiId`),
  ADD KEY `SiparisDurumId` (`SiparisDurumId`);

--
-- Indexes for table `siparisdurum`
--
ALTER TABLE `siparisdurum`
  ADD PRIMARY KEY (`SiparisDurumID`);

--
-- Indexes for table `siparisurun`
--
ALTER TABLE `siparisurun`
  ADD PRIMARY KEY (`SiparisUrunID`),
  ADD KEY `UrunId` (`UrunId`),
  ADD KEY `SiparisId` (`SiparisId`),
  ADD KEY `KullaniciId` (`KullaniciId`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`StokID`),
  ADD KEY `UrunId` (`UrunId`);

--
-- Indexes for table `urun`
--
ALTER TABLE `urun`
  ADD PRIMARY KEY (`UrunID`),
  ADD KEY `KategoriId` (`KategoriId`),
  ADD KEY `KullaniciId` (`KullaniciId`),
  ADD KEY `DosyaId` (`DosyaId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dosya`
--
ALTER TABLE `dosya`
  MODIFY `DosyaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `KategoriID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `kullanici`
--
ALTER TABLE `kullanici`
  MODIFY `kullaniciID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `musteri`
--
ALTER TABLE `musteri`
  MODIFY `musteriID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `odemesecenek`
--
ALTER TABLE `odemesecenek`
  MODIFY `OdemeSecenekID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `RolID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `siparis`
--
ALTER TABLE `siparis`
  MODIFY `SiparisID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `siparisdurum`
--
ALTER TABLE `siparisdurum`
  MODIFY `SiparisDurumID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `siparisurun`
--
ALTER TABLE `siparisurun`
  MODIFY `SiparisUrunID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stok`
--
ALTER TABLE `stok`
  MODIFY `StokID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `urun`
--
ALTER TABLE `urun`
  MODIFY `UrunID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kullanici`
--
ALTER TABLE `kullanici`
  ADD CONSTRAINT `kullanici_ibfk_1` FOREIGN KEY (`MusteriId`) REFERENCES `musteri` (`musteriID`);

--
-- Constraints for table `siparis`
--
ALTER TABLE `siparis`
  ADD CONSTRAINT `siparis_ibfk_1` FOREIGN KEY (`OdemeSecenekId`) REFERENCES `odemesecenek` (`OdemeSecenekID`),
  ADD CONSTRAINT `siparis_ibfk_2` FOREIGN KEY (`KisiId`) REFERENCES `musteri` (`musteriID`),
  ADD CONSTRAINT `siparis_ibfk_3` FOREIGN KEY (`SiparisDurumId`) REFERENCES `siparisdurum` (`SiparisDurumID`);

--
-- Constraints for table `siparisurun`
--
ALTER TABLE `siparisurun`
  ADD CONSTRAINT `siparisurun_ibfk_1` FOREIGN KEY (`UrunId`) REFERENCES `urun` (`UrunID`),
  ADD CONSTRAINT `siparisurun_ibfk_2` FOREIGN KEY (`SiparisId`) REFERENCES `siparis` (`SiparisID`),
  ADD CONSTRAINT `siparisurun_ibfk_3` FOREIGN KEY (`KullaniciId`) REFERENCES `kullanici` (`kullaniciID`);

--
-- Constraints for table `stok`
--
ALTER TABLE `stok`
  ADD CONSTRAINT `stok_ibfk_1` FOREIGN KEY (`UrunId`) REFERENCES `urun` (`UrunID`);

--
-- Constraints for table `urun`
--
ALTER TABLE `urun`
  ADD CONSTRAINT `urun_ibfk_1` FOREIGN KEY (`KategoriId`) REFERENCES `kategori` (`KategoriID`),
  ADD CONSTRAINT `urun_ibfk_2` FOREIGN KEY (`KullaniciId`) REFERENCES `kullanici` (`kullaniciID`),
  ADD CONSTRAINT `urun_ibfk_3` FOREIGN KEY (`DosyaId`) REFERENCES `dosya` (`DosyaID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
