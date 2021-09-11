/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.5.62 : Database - plp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`plp` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `plp`;

/*Table structure for table `pelanggan` */

DROP TABLE IF EXISTS `pelanggan`;

CREATE TABLE `pelanggan` (
  `id` int(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `daya` int(255) DEFAULT NULL,
  `layanan` varchar(255) DEFAULT NULL,
  `notelp` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pelanggan` */

insert  into `pelanggan`(`id`,`name`,`alamat`,`daya`,`layanan`,`notelp`,`email`) values 
(123456,'jhon','bukittinggi',1300,'pascabayar','087899123456','jhon@gmail.com'),
(345678,'fox','bukittinggi',1300,'pascabayar','085578345678','fox@gmail.com'),
(765345,'polo','padang panjang',2200,'pascabayar','081274765345','polo@gmail.com'),
(11112222,'bobi','solok',1300,'prabayar','081122987347','bobi@gmail.com'),
(67503488,'gery','padang',900,'prabayar','089877654907','gery@gmail.com'),
(87308764,'edi','payakumbuh',2200,'prabayar','087776498033','edi@gmail.com');

/*Table structure for table `tagihan` */

DROP TABLE IF EXISTS `tagihan`;

CREATE TABLE `tagihan` (
  `id` int(30) NOT NULL,
  `bulan` varchar(255) NOT NULL,
  `tahun` int(30) NOT NULL,
  `tagihan` int(30) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`bulan`,`tahun`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tagihan` */

insert  into `tagihan`(`id`,`bulan`,`tahun`,`tagihan`,`status`) values 
(123456,'april',2021,250000,'active'),
(123456,'februari',2021,350000,'clear'),
(123456,'januari',2021,300000,'clear'),
(123456,'maret',2021,325000,'clear'),
(123456,'mei',2021,370000,'active'),
(345678,'april',2021,400000,'active'),
(345678,'februari',2021,450000,'clear'),
(345678,'januari',2021,420000,'clear'),
(345678,'maret',2021,500000,'active'),
(345678,'mei',2021,550000,'active'),
(765345,'april',2021,900000,'clear'),
(765345,'februari',2021,750000,'clear'),
(765345,'januari',2021,800000,'clear'),
(765345,'maret',2021,700000,'clear'),
(765345,'mei',2021,850000,'active');

/*Table structure for table `transaksi` */

DROP TABLE IF EXISTS `transaksi`;

CREATE TABLE `transaksi` (
  `id` int(20) DEFAULT NULL,
  `orderId` int(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `daya` int(255) DEFAULT NULL,
  `token` int(25) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaksi` */

insert  into `transaksi`(`id`,`orderId`,`name`,`alamat`,`daya`,`token`,`status`) values 
(87308764,12,'edi','payakumbuh',2200,20000,'complete'),
(87308764,14,'edi','payakumbuh',2200,10000,'waiting'),
(87308764,15,'edi','payakumbuh',2200,10000,'waiting'),
(87308764,16,'edi','payakumbuh',2200,100000,'complete'),
(67503488,18,'gery','padang',900,25000,'complete'),
(67503488,20,'gery','padang',900,25000,'complete');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
