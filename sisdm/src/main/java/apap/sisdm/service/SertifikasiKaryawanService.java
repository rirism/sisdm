package apap.sisdm.service;

import apap.sisdm.model.SertifikasiKaryawanModel;

import java.util.List;

public interface SertifikasiKaryawanService {
    List<SertifikasiKaryawanModel> findAllBySertifikasi (Long idSertifikasi);
    List<SertifikasiKaryawanModel> findAllByKaryawan (Long idKaryawan);
    List<SertifikasiKaryawanModel> getListSertifikasiModel ();
}
