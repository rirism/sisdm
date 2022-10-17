package apap.sisdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import apap.sisdm.model.KaryawanModel;
import apap.sisdm.model.TugasModel;
import apap.sisdm.service.KaryawanService;
import apap.sisdm.service.TugasService;

import java.util.List;

@Controller
public class TugasController {
    @Qualifier("tugasServiceImpl")
    @Autowired
    private TugasService tugasService;

    @Autowired
    private KaryawanService karyawanService;

    @GetMapping("/tambah-tugas")
    public String formTambahTugas(Model model) {
        TugasModel tugas = new TugasModel();
        model.addAttribute ( "tugas", tugas);
        return "form-add-tugas";
    }

    @PostMapping(value = "/tambah-tugas")
    public String tambahTugas(
            @ModelAttribute TugasModel tugas,
            Model model
    ){
        tugasService.addTugas(tugas);
        model.addAttribute("tugas",tugas);
        return "submit-add-tugas";
    }

    // Controller untuk filter
    @GetMapping(value = "/filter-tugas")
    public String filterTugasDefault(Model model){
        List<KaryawanModel> listKaryawan = karyawanService.getListKaryawan();
        List<TugasModel> listTugas = tugasService.getListTugas();
        model.addAttribute ( "listKaryawan", listKaryawan);
        model.addAttribute ( "listTugas", listTugas);
        return "filter-tugas-default";
    }


    @GetMapping(value = "/filter-tugas", params = {"idKaryawan", "statusTugas"})
    public String filterTugas(
            @RequestParam(value = "idKaryawan", required = false) Long idKaryawan,
            @RequestParam(value = "statusTugas", required = false) Integer statusTugas,
            Model model
    ){
        List<KaryawanModel> listKaryawan = karyawanService.getListKaryawan();
        List<TugasModel> listTugas = tugasService.findAllByKaryawanAndStatusTugas(idKaryawan.longValue(), statusTugas);
        model.addAttribute ( "listKaryawan", listKaryawan);
        model.addAttribute ( "listTugas", listTugas);
        return "filter-tugas";
    }
}
