-- ----------------------------
-- Records of karyawan
-- ----------------------------
INSERT INTO `karyawan` VALUES (1, 'yuniar.zulaikha@gmail.com', 2, 'PUSPITA', 'WANI', '1999-02-03');
INSERT INTO `karyawan` VALUES (2, 'jumari83@mustofa.sch.id', 1, 'HUTAPEA', 'LASWI', '1998-06-15');
INSERT INTO `karyawan` VALUES (3, 'yessi@gmail.com', 2, 'PATMASARI', 'YESSI', '1993-07-25');
INSERT INTO `karyawan` VALUES (4, 'anni47@puspita.or.id', 2,'LESTARI', 'ANNI', '2000-12-12');
INSERT INTO `karyawan` VALUES (5, 'hakim@prasetya.org', 1,'HAKIM', 'AKARSANA', '1994-09-20');


-- ----------------------------
-- Records of presensi
-- ----------------------------
INSERT INTO `presensi` VALUES (1, 1, '2022-09-16', '2022-09-16 17:45:08', '2022-09-16 05:45:01', 1);
INSERT INTO `presensi` VALUES (2, 1, '2022-09-16', '2022-09-20 19:46:38', '2022-09-20 05:46:29', 3);
INSERT INTO `presensi` VALUES (3, 0, '2022-09-16', '2022-09-20 20:47:26', '2022-09-20 07:47:09', 4);
INSERT INTO `presensi` VALUES (4, 1, '2022-09-16', '2022-09-20 15:48:08', '2022-09-20 06:47:49', 5);


-- ----------------------------
-- Records of sertifikasi
-- ----------------------------
INSERT INTO `sertifikasi` VALUES (1, 'MANAJEMEN PROYEK');
INSERT INTO `sertifikasi` VALUES (2, 'COBIT 2019');
INSERT INTO `sertifikasi` VALUES (3, 'ASSOCIATE ANDROID DEVELOPER');
INSERT INTO `sertifikasi` VALUES (4, 'TENSORFLOW DEVELOPER CERTIFICATE');
INSERT INTO `sertifikasi` VALUES (5, 'ASSOCIATE CLOUD ENGINEER');


-- ----------------------------
-- Records of tugas
-- ----------------------------
INSERT INTO `tugas` VALUES (1, 'MENGECEK KUALITAS PRODUK BARANG', 'QUALITY CONTROL', 2, 3, 1);
INSERT INTO `tugas` VALUES (2, 'MEMBUAT APLIKASI SURAT ELEKTRONIK', 'PROGRAMMER', 1, 4, 3);
INSERT INTO `tugas` VALUES (3, 'MEMBUAT ADMINISTRASI PEMBELIAN PELANGGAN', 'DOKUMENTASI', 0, 2, 4);
INSERT INTO `tugas` VALUES (4, 'MEMBUAT LAPORAN PEMBELIAN PELANGGAN', 'LAPORAN', 1, 3, 4);
INSERT INTO `tugas` VALUES (5, 'MEMBUAT IKLAN PRODUK PENJUALAN', 'PEMASARAN', 1, 5, 2);

-- ----------------------------
-- Records of sertifikasikaryawan
-- ----------------------------
INSERT INTO `sertifikasikaryawan` (`no_sertifikasi`, `tanggal_pengambilan`, `sertifikasi_id_sertifikasi`, `karyawan_id_karyawan`)VALUES ('12345671234567', '2022-10-11', '1', '1');
INSERT INTO `sertifikasikaryawan` (`no_sertifikasi`, `tanggal_pengambilan`, `sertifikasi_id_sertifikasi`, `karyawan_id_karyawan`) VALUES ('12345671434567', '2022-10-11', '1', '2');
