package com.microservicios.operativo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.commons.utils.constants.Messages;
import com.commons.utils.controllers.CommonController;
import com.commons.utils.utils.Response;
import com.microservicios.operativo.models.entities.DetalleOperativo;
import com.microservicios.operativo.models.entities.Operativo;
import com.microservicios.operativo.services.OperativoService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = { "*" })
@RestController
public class OperativoController extends CommonController<Operativo, OperativoService> {

    @PostMapping(path = "/save")
    public ResponseEntity<?> save(@RequestPart(required = false) Operativo operativo,
            @RequestPart(required = false) MultipartFile file) {

        /* » VALIDACIÓN: */
        /* ... */
        operativo.setDetOperativo(this.convertObjXlsxToList(file));

        return ResponseEntity.ok().body(Response.builder().message(Messages.MESSAGE_SUCCESS_LIST_ENTITY)
                .data(Arrays.asList(super.service.save(operativo))).build());
    }

    @GetMapping(path = "/findByNacionalidad/{nacionalidad}")
    public ResponseEntity<?> findByNacionalidad(@PathVariable String nacionalidad) {
        return ResponseEntity.ok().body(super.service.findByNacionalidad(nacionalidad).get());
    }

    private List<DetalleOperativo> convertObjXlsxToList(MultipartFile file) {
        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            List<DetalleOperativo> detOperativoDb = new ArrayList<>();

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                detOperativoDb.add(new DetalleOperativo(row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(),
                        super.service.findByNacionalidad(row.getCell(4).getStringCellValue()).get(),
                        row.getCell(5).getStringCellValue(), row.getCell(6).getStringCellValue(),
                        row.getCell(7).getStringCellValue(), row.getCell(8).getStringCellValue(),
                        row.getCell(9).getStringCellValue(), row.getCell(10).getStringCellValue(),
                        row.getCell(11).getStringCellValue(), row.getCell(12).getStringCellValue(),
                        row.getCell(13).getStringCellValue()));
            }
            return detOperativoDb;
        } catch (IOException e) {
            return null;
        }
    }

}