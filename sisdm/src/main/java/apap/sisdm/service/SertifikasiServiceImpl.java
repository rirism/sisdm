package apap.sisdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.sisdm.model.SertifikasiModel;
import apap.sisdm.repository.SertifikasiDb;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SertifikasiServiceImpl implements SertifikasiService{
    @Autowired
    SertifikasiDb sertifikasiDb;

    @Override
    public List<SertifikasiModel> getListSertifikasi () {return sertifikasiDb.findAll(); }
}
