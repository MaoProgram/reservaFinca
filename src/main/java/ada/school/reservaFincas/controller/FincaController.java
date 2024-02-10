package ada.school.reservaFincas.controller;

import ada.school.reservaFincas.entity.Finca;
import ada.school.reservaFincas.service.FincaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("finca")
public class FincaController {

    @Autowired
    private FincaService fincaService;

    @GetMapping
    public List<Finca> listar() {
        return fincaService.listar();
    }

    @PostMapping
    public Finca insertar(@RequestBody Finca emp) {
        return fincaService.insertar(emp);
    }

    @PutMapping
    public Finca actualizar(@RequestBody Finca emp) {
        return fincaService.actualizar(emp);
    }

    @DeleteMapping
    public  void  eliminar (@RequestBody Finca emp){
        fincaService.eliminar(emp);
    }

}