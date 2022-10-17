package apap.sisdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.sisdm.model.TugasModel;
import apap.sisdm.repository.TugasDb;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TugasServiceImpl implements TugasService{
    @Autowired
    TugasDb tugasDb;

    @Override
    public List<TugasModel> getListTugas() {
        return tugasDb.findAll();
    }

    @Override
    public void addTugas(TugasModel tugas) {
        tugasDb.save(tugas);
    }

    @Override
    public List<TugasModel> findAllByKaryawanAndStatusTugas(Long idKaryawan, Integer statusTugas) {
        return tugasDb.findAllByKaryawanAndStatusTugas(idKaryawan, statusTugas);
    }
}
