-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2024 at 03:55 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `ISBN` varchar(20) NOT NULL,
  `Judul` varchar(200) NOT NULL,
  `Jenis` varchar(10) NOT NULL,
  `Penulis` varchar(100) NOT NULL,
  `Penerbit` varchar(100) NOT NULL,
  `Tahun_terbit` varchar(10) NOT NULL,
  `Halaman` varchar(10) NOT NULL,
  `Rak` varchar(10) NOT NULL,
  `Stok` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`ISBN`, `Judul`, `Jenis`, `Penulis`, `Penerbit`, `Tahun_terbit`, `Halaman`, `Rak`, `Stok`) VALUES
('1', 'Cara menjadi kaya', 'Fiksi', 'Dimas', 'Gramedia', '2024', '1000', '1', '10');

-- --------------------------------------------------------

--
-- Table structure for table `datadenda`
--

CREATE TABLE `datadenda` (
  `id_denda` int(200) NOT NULL,
  `nama_pengunjung` varchar(200) NOT NULL,
  `nama_pegawai` varchar(200) NOT NULL,
  `tgl_pengembalian` date NOT NULL,
  `telat_pengembalian` varchar(200) NOT NULL,
  `harga_denda` varchar(200) NOT NULL,
  `judul_buku` varchar(200) NOT NULL,
  `tglpinjam_sblmnya` date NOT NULL,
  `tglkembali_sblmnya` date NOT NULL,
  `tgl_input` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datadenda`
--

INSERT INTO `datadenda` (`id_denda`, `nama_pengunjung`, `nama_pegawai`, `tgl_pengembalian`, `telat_pengembalian`, `harga_denda`, `judul_buku`, `tglpinjam_sblmnya`, `tglkembali_sblmnya`, `tgl_input`) VALUES
(1, 'Danar Mukti', 'Ahmad rafiq', '2024-12-02', '28 Hari', 'Rp1.400.000,00', 'Cara menjadi kaya', '2024-11-28', '2024-12-31', '2024-12-02 15:57:55'),
(2, 'Pilih Nama Pengunjung', 'Pilih Nama Pegawai', '2025-12-31', '0 Hari', 'Rp0,00', 'Cara menjadi kaya', '2024-11-28', '2024-12-31', '2024-12-02 15:58:29');

-- --------------------------------------------------------

--
-- Table structure for table `datapeminjaman`
--

CREATE TABLE `datapeminjaman` (
  `id` int(11) NOT NULL,
  `id_buku` varchar(20) NOT NULL,
  `judul` varchar(200) NOT NULL,
  `id_pengunjung` int(50) NOT NULL,
  `Nama_pengunjung` varchar(100) NOT NULL,
  `id_pustakawan` varchar(30) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_pengembalian` date NOT NULL,
  `tgl_input` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapeminjaman`
--

INSERT INTO `datapeminjaman` (`id`, `id_buku`, `judul`, `id_pengunjung`, `Nama_pengunjung`, `id_pustakawan`, `tanggal_pinjam`, `tanggal_pengembalian`, `tgl_input`) VALUES
(1, '1', 'Cara menjadi kaya', 1, 'Danar Mukti', '1', '2024-11-28', '2024-11-30', '2024-12-02 15:56:36');

-- --------------------------------------------------------

--
-- Table structure for table `datapengembalian`
--

CREATE TABLE `datapengembalian` (
  `id_peminjaman` varchar(100) NOT NULL,
  `nama_pengunjung` varchar(100) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `tanggal_peminjaman` date NOT NULL,
  `tanggal_pengembaliann` date NOT NULL,
  `tgl_input` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapengembalian`
--

INSERT INTO `datapengembalian` (`id_peminjaman`, `nama_pengunjung`, `judul_buku`, `tanggal_peminjaman`, `tanggal_pengembaliann`, `tgl_input`) VALUES
('1', '1', 'Cara menjadi kaya', '2024-11-28', '2024-12-31', '2024-12-02 15:57:22');

-- --------------------------------------------------------

--
-- Table structure for table `datapengunjung`
--

CREATE TABLE `datapengunjung` (
  `id` int(50) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `usia` varchar(50) NOT NULL,
  `category_age` varchar(200) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `phone` int(50) NOT NULL,
  `tanggal` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapengunjung`
--

INSERT INTO `datapengunjung` (`id`, `nama`, `usia`, `category_age`, `alamat`, `phone`, `tanggal`) VALUES
(1, 'Danar aja', '19', 'dewasa', 'jl komini 45', 98956321, '2024-12-05 15:52:22');

-- --------------------------------------------------------

--
-- Table structure for table `pustakawan`
--

CREATE TABLE `pustakawan` (
  `kd_anggota` varchar(30) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `notelp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pustakawan`
--

INSERT INTO `pustakawan` (`kd_anggota`, `nama`, `alamat`, `notelp`) VALUES
('1', 'Ahmad rafiq', 'jl babelan', '0896531354');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexes for table `datadenda`
--
ALTER TABLE `datadenda`
  ADD PRIMARY KEY (`id_denda`);

--
-- Indexes for table `datapeminjaman`
--
ALTER TABLE `datapeminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `datapengunjung`
--
ALTER TABLE `datapengunjung`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datadenda`
--
ALTER TABLE `datadenda`
  MODIFY `id_denda` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `datapeminjaman`
--
ALTER TABLE `datapeminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `datapengunjung`
--
ALTER TABLE `datapengunjung`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
