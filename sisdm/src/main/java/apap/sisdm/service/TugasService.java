package apap.sisdm.service;

import apap.sisdm.model.TugasModel;

import java.util.List;

public interface TugasService {
    List<TugasModel> getListTugas();
    void addTugas(TugasModel tugas);
    List<TugasModel> findAllByKaryawanAndStatusTugas (Long idKaryawan, Integer statusTugas);
}
