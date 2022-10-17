package apap.sisdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import apap.sisdm.model.*;
import apap.sisdm.service.KaryawanService;
import apap.sisdm.service.SertifikasiKaryawanService;
import apap.sisdm.service.SertifikasiService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KaryawanController {
    @Qualifier("karyawanServiceImpl")
    @Autowired
    private KaryawanService karyawanService;

    @Autowired
    private SertifikasiService sertifikasiService;

    @Autowired
    private SertifikasiKaryawanService sertifikasiKaryawanService;

    @GetMapping({"/karyawan"})
    public String listKaryawan(Model model) {
        List<KaryawanModel> listKaryawan = this.karyawanService.getListKaryawan();
        model.addAttribute("listKaryawan", listKaryawan);
        return "viewall-karyawan";
    }

    @GetMapping({"/karyawan/{idKaryawan}"})
    public String viewDetailKaryawan(@PathVariable Long idKaryawan, Model model) {
        KaryawanModel karyawan = this.karyawanService.findByIdKaryawan(idKaryawan.longValue());
        List<SertifikasiKaryawanModel> listSertifikasiKaryawan = sertifikasiKaryawanService.findAllByKaryawan(idKaryawan.longValue());
        model.addAttribute("karyawan", karyawan);
        model.addAttribute("listSertifikasiKaryawan", listSertifikasiKaryawan);
        return "view-karyawan";
    }

    @GetMapping("/karyawan/{idKaryawan}/hapus")
    public String deleteKaryawan(@PathVariable Long idKaryawan, Model model) {
        KaryawanModel karyawan = karyawanService.findByIdKaryawan(idKaryawan.longValue());
        karyawanService.deleteKaryawan(karyawan);
        model.addAttribute("karyawan", karyawan);
        return "delete-karyawan";
    }

    // Controller untuk filter
    @GetMapping(value = "/filter-sertifikasi")
    public String filterDefault(Model model){
        List<SertifikasiModel> listSertifikasi = sertifikasiService.getListSertifikasi();
        List<KaryawanModel> listKaryawan = karyawanService.getListKaryawan();
        model.addAttribute("listSertifikasi", listSertifikasi);
        model.addAttribute("listKaryawan", listKaryawan);
        return "filter-sertifikasi-default";
    }

    @GetMapping(value = "/filter-sertifikasi", params = {"idSertifikasi"})
    private String filterBySertifikasi(
            @RequestParam(value = "idSertifikasi", required = false) Long idSertifikasi,
            Model model
    ){
        List<SertifikasiModel> listSertifikasi = sertifikasiService.getListSertifikasi();
        List<KaryawanModel> listKaryawan = karyawanService.getListKaryawan();
        List<SertifikasiKaryawanModel> listSertifikasiKaryawan = sertifikasiKaryawanService.findAllBySertifikasi(idSertifikasi.longValue());
        model.addAttribute("listSertifikasi", listSertifikasi);
        model.addAttribute("listKaryawan", listKaryawan);
        model.addAttribute("listSertifikasiKaryawan", listSertifikasiKaryawan);
        return "filter-sertifikasi";
    }

    @GetMapping({"/karyawan/tambah"})
    public String addKaryawanForm(Model model) {
        KaryawanModel karyawan = new KaryawanModel();
        List<SertifikasiKaryawanModel> listSertifikasiKaryawan = this.sertifikasiKaryawanService.getListSertifikasiModel();
        List<SertifikasiKaryawanModel> listSertifikasiKaryawanNew = new ArrayList();
        List<SertifikasiModel> listSertifikasi = sertifikasiService.getListSertifikasi();
        karyawan.setSertifikasiKaryawan(listSertifikasiKaryawanNew);
        karyawan.getSertifikasiKaryawan().add(new SertifikasiKaryawanModel());
        model.addAttribute("karyawan", karyawan);
        model.addAttribute("listSertifikasi", listSertifikasi);
        model.addAttribute("listSertifikasiKaryawan", listSertifikasiKaryawan);
        return "form-add-karyawan";
    }

    @PostMapping(
            value = {"/karyawan/tambah"},
            params = {"addRow"}
    )
    private String addRowSertifikasiMultiple(@ModelAttribute KaryawanModel karyawan, Model model) {
        if (karyawan.getSertifikasiKaryawan() == null || karyawan.getSertifikasiKaryawan().size() == 0) {
            karyawan.setSertifikasiKaryawan(new ArrayList());
        }
        List<SertifikasiModel> listSertifikasi = sertifikasiService.getListSertifikasi();
        List<SertifikasiKaryawanModel> listSertifikasiKaryawan = this.sertifikasiKaryawanService.getListSertifikasiModel();
        listSertifikasiKaryawan.add(new SertifikasiKaryawanModel());
        model.addAttribute("listSertifikasi", listSertifikasi);
        model.addAttribute("listSertifikasiKaryawan", listSertifikasiKaryawan);
        return "form-add-karyawan";
    }
}
