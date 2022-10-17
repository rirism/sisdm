package apap.sisdm.service;

import apap.sisdm.model.KaryawanModel;

import java.util.List;

public interface KaryawanService {
    List<KaryawanModel> getListKaryawan();
    KaryawanModel findByIdKaryawan(Long idKaryawan);
    void deleteKaryawan (KaryawanModel karyawan);
    List<KaryawanModel> findAllBySertifikasiKaryawan(Long idSertifikasi);
    void addKaryawan(KaryawanModel karyawan);
}
