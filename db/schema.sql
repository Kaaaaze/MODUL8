CREATE DATABASE IF NOT EXISTS embg;
USE embg;

DROP TABLE IF EXISTS log_aktivitas;
DROP TABLE IF EXISTS siswa_alergi;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    npsn VARCHAR(8) NOT NULL UNIQUE,
    nama_sekolah VARCHAR(100) NOT NULL,
    role ENUM('admin', 'vendor', 'sekolah') DEFAULT 'sekolah'
);

CREATE TABLE siswa_alergi (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sekolah_id INT NOT NULL,
    nama_siswa VARCHAR(100) NOT NULL,
    jenis_alergi VARCHAR(100) NOT NULL,
    FOREIGN KEY (sekolah_id) REFERENCES user(id) ON DELETE CASCADE
);