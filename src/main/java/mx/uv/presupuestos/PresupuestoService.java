package mx.uv.presupuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresupuestoService {

    @Autowired
    private IPresupuestos repository;

    public Presupuestos getPresupuestoById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Afectacion getAfectacionById(String id) {
        Presupuestos presupuesto = repository.findById(id).orElse(null);
        if (presupuesto != null) {
            Afectacion afectacion = new Afectacion();
            afectacion.setEstado(presupuesto.isEstado());
            return afectacion;
        }
        return null;
    }

    public void savePresupuesto(Presupuestos presupuesto) {
        repository.save(presupuesto);
    }

    public void deletePresupuestoById(String id) {
        repository.deleteById(id);
    }
}
