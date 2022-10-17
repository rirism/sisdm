package apap.sisdm.service;

import apap.sisdm.model.PresensiModel;

import java.util.List;

public interface PresensiService {
    List<PresensiModel> getListPresensi();
    PresensiModel findByIdPresensi(Long idPresensi);
    void addPresensi(PresensiModel presensi);
}
