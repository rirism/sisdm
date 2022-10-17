package apap.sisdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import apap.sisdm.model.*;
import apap.sisdm.service.PresensiService;
import apap.sisdm.service.TugasService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class PresensiController {
    @Qualifier("presensiServiceImpl")
    @Autowired
    private PresensiService presensiService;

    @Autowired
    private TugasService tugasService;

    @GetMapping({"/presensi"})
    public String listPresensi(Model model) {
        List<PresensiModel> listPresensi = this.presensiService.getListPresensi();
        model.addAttribute("listPresensi", listPresensi);
        return "viewall-presensi";
    }

    @GetMapping({"/presensi/{idPresensi}"})
    public String viewDetailPresensi(@PathVariable Long idPresensi, Model model) {
        PresensiModel presensi = this.presensiService.findByIdPresensi(idPresensi.longValue());
        List<TugasModel> listTugas = presensi.getListTugas();
        model.addAttribute("presensi", presensi);
        model.addAttribute("listTugas", listTugas);
        return "view-presensi";
    }

    @GetMapping({"/presensi/tambah"})
    public String addPresensi(Model model) {
        PresensiModel presensi = new PresensiModel();
        List<TugasModel> listTugas = this.tugasService.getListTugas();
        List<TugasModel> listTugasNew = new ArrayList();
        presensi.setListTugas(listTugas);
        presensi.getListTugas().add(new TugasModel());
        presensi.setListTugas(new ArrayList());
        presensi.getListTugas().add(new TugasModel());
        model.addAttribute("presensi", presensi);
        model.addAttribute("listTugasExisting", listTugas);
        return "form-add-presensi";
    }

    @PostMapping(
            value = {"/presensi/tambah"},
            params = {"addRow"}
    )
    private String addRowTugasMultiple(@ModelAttribute PresensiModel presensi, Model model) {
        if (presensi.getListTugas() == null || presensi.getListTugas().size() == 0) {
            presensi.setListTugas(new ArrayList());
        }
        presensi.getListTugas().add(new TugasModel());
        List<TugasModel> listTugas = this.tugasService.getListTugas();
        model.addAttribute("presensi", presensi);
        model.addAttribute("listTugasExisiting", listTugas);
        return "form-add-course";
    }

    @PostMapping(
            value = {"/presensi/tambah"},
            params = {"save"}
    )
    public String addPresensiSubmit(@ModelAttribute PresensiModel presensi, Model model) {
        if (presensi.getListTugas() != null) {
            Iterator var3 = presensi.getListTugas().iterator();

            while(var3.hasNext()) {
                TugasModel tugas = (TugasModel) var3.next();
                tugas.setPresensi(presensi);
            }
        }

        this.presensiService.addPresensi(presensi);
        model.addAttribute("presensi", presensi);
        return "add-presensi";
    }
//
//    @PostMapping(
//            value = {"/course/add"},
//            params = {"addRow"}
//    )
//    private String addRowPenyelenggaraMultiple(@ModelAttribute CourseModel course, Model model) {
//        if (course.getListPenyelenggara() == null || course.getListPenyelenggara().size() == 0) {
//            course.setListPenyelenggara(new ArrayList());
//        }
//
//        course.getListPenyelenggara().add(new PenyelenggaraModel());
//        List<PenyelenggaraModel> listPenyelenggara = this.penyelenggaraService.getListPenyelenggara();
//        model.addAttribute("course", course);
//        model.addAttribute("listPenyelenggaraExisting", listPenyelenggara);
//        return "form-add-course";
//    }
//
//    @PostMapping(
//            value = {"/course/add"},
//            params = {"deleteRow"}
//    )
//    private String deleteRowPenyelenggaraMultiple(@ModelAttribute CourseModel course, @RequestParam("deleteRow") Integer row, Model model) {
//        final Integer rowId = Integer.valueOf(row);
//        course.getListPenyelenggara().remove(rowId.intValue());
//        List<PenyelenggaraModel> listPenyelenggara = this.penyelenggaraService.getListPenyelenggara();
//        model.addAttribute("course", course);
//        model.addAttribute("listPenyelenggaraExisting", listPenyelenggara);
//        return "form-add-course";
//    }
}
