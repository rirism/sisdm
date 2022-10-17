package apap.sisdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.sisdm.model.SertifikasiKaryawanModel;
import apap.sisdm.repository.SertifikasiKaryawanDb;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SertifikasiKaryawanServiceImpl implements SertifikasiKaryawanService{
    @Autowired
    SertifikasiKaryawanDb sertifikasiKaryawanDb;

    @Override
    public List<SertifikasiKaryawanModel> findAllBySertifikasi(Long idSertifikasi) {
        return sertifikasiKaryawanDb.findAllBySertifikasi(idSertifikasi);
    }

    @Override
    public List<SertifikasiKaryawanModel> findAllByKaryawan(Long idKaryawan) {
        return sertifikasiKaryawanDb.findAllByKaryawan(idKaryawan);
    }

    @Override
    public List<SertifikasiKaryawanModel> getListSertifikasiModel() {
        return sertifikasiKaryawanDb.findAll();
    }
}
