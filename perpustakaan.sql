-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Bulan Mei 2024 pada 21.23
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

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
-- Struktur dari tabel `buku`
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
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`ISBN`, `Judul`, `Jenis`, `Penulis`, `Penerbit`, `Tahun_terbit`, `Halaman`, `Rak`, `Stok`) VALUES
('1', 'bobosiang', 'Fiksi', 'dimas', 'gramedia', '2024', '100', '5', '6'),
('2', 'Malam Indah', 'Fiksi', 'Ahmad Supardi', 'Gramedia', '2024', '120', '6', '0');

-- --------------------------------------------------------

--
-- Struktur dari tabel `databuku`
--

CREATE TABLE `databuku` (
  `id` int(11) NOT NULL,
  `namabuku` varchar(200) NOT NULL,
  `karyaPenulis` varchar(200) NOT NULL,
  `peminjaman` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `databuku`
--

INSERT INTO `databuku` (`id`, `namabuku`, `karyaPenulis`, `peminjaman`) VALUES
(6, 'cxvxv', 'dasfsdf', 'asdasd'),
(8, 'sdfdsf', 'qweqwe', 'qweqweqwe'),
(9, 'klfdgjdfkljg', 'wrwer', 'sfdsfdsf');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapegawai`
--

CREATE TABLE `datapegawai` (
  `id` int(11) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `umur` int(50) NOT NULL,
  `jenis kelamin` varchar(20) NOT NULL,
  `tglahir` varchar(200) NOT NULL,
  `jabatan` varchar(200) NOT NULL,
  `telp` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `datapegawai`
--

INSERT INTO `datapegawai` (`id`, `nama`, `umur`, `jenis kelamin`, `tglahir`, `jabatan`, `telp`) VALUES
(1, 'Danar Mukti Wibowo', 21, 'Laki-laki', '15 April 2003', 'HRD', '089537705121'),
(2, 'Rafli Ferianda', 100, 'Laki-laki', '23 April 1924', 'HRD', '089654321849');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapeminjaman`
--

CREATE TABLE `datapeminjaman` (
  `id` int(11) NOT NULL,
  `id_buku` varchar(20) NOT NULL,
  `id_pengunjung` int(50) NOT NULL,
  `id_pustakawan` varchar(30) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_pengembalian` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `datapeminjaman`
--

INSERT INTO `datapeminjaman` (`id`, `id_buku`, `id_pengunjung`, `id_pustakawan`, `tanggal_pinjam`, `tanggal_pengembalian`) VALUES
(1, '1', 6, '0909', '2024-05-30', '2024-05-31'),
(2, '2', 5, '12', '2024-05-30', '2024-05-31');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapengunjung`
--

CREATE TABLE `datapengunjung` (
  `id` int(50) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `phone` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `datapengunjung`
--

INSERT INTO `datapengunjung` (`id`, `nama`, `alamat`, `phone`) VALUES
(5, 'danar', 'jl kemana?', 507),
(6, 'mukti', 'jl kemana aja yg penting sama kamu', 895655454);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pustakawan`
--

CREATE TABLE `pustakawan` (
  `kd_anggota` varchar(30) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `notelp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pustakawan`
--

INSERT INTO `pustakawan` (`kd_anggota`, `nama`, `alamat`, `notelp`) VALUES
('12', 'rafiq', 'babelan', '089832463724'),
('0909', 'ahmad', 'bekasi', '089510167062'),
('1', 'rafiq al qornain', 'babelan city', '0656498321');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indeks untuk tabel `databuku`
--
ALTER TABLE `databuku`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `datapegawai`
--
ALTER TABLE `datapegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `datapeminjaman`
--
ALTER TABLE `datapeminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `datapengunjung`
--
ALTER TABLE `datapengunjung`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `databuku`
--
ALTER TABLE `databuku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `datapegawai`
--
ALTER TABLE `datapegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `datapeminjaman`
--
ALTER TABLE `datapeminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `datapengunjung`
--
ALTER TABLE `datapengunjung`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
