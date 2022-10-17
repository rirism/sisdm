package apap.sisdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.sisdm.model.PresensiModel;
import apap.sisdm.repository.PresensiDb;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class PresensiServiceImpl implements PresensiService{
    @Autowired
    PresensiDb presensiDb;

    @Override
    public List<PresensiModel> getListPresensi() {return presensiDb.findAll(); }

    @Override
    public PresensiModel findByIdPresensi(Long idPresensi) {
        Optional<PresensiModel> presensi = presensiDb.findByIdPresensi(idPresensi);
        if (presensi.isPresent()){
            return presensi.get();
        } else return null;
    }

    @Override
    public void addPresensi(PresensiModel presensi) {
        presensiDb.save(presensi);
    }
}