package apap.sisdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.sisdm.model.KaryawanModel;
import apap.sisdm.repository.KaryawanDb;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class KaryawanServiceImpl implements KaryawanService{
    @Autowired
    KaryawanDb karyawanDb;

    @Override
    public List<KaryawanModel> getListKaryawan() {
        return karyawanDb.findAll();
    }

    @Override
    public KaryawanModel findByIdKaryawan(Long idKaryawan) {
        Optional<KaryawanModel> karyawan = karyawanDb.findByIdKaryawan(idKaryawan);
        if (karyawan.isPresent()){
            return karyawan.get();
        } else return null;
    }

    @Override
    public void deleteKaryawan (KaryawanModel karyawan) {
        karyawanDb.delete(karyawan);
    }

    @Override
    public List<KaryawanModel> findAllBySertifikasiKaryawan(Long idSertifikasi) {
        return karyawanDb.findAllBySertifikasiKaryawan(idSertifikasi);
    }

    @Override
    public void addKaryawan(KaryawanModel karyawan) {
        karyawanDb.save(karyawan);
    }
}
