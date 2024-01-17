package ada.school.reservaFincas.repo;

import ada.school.reservaFincas.entity.Finca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//heredar metodos de la clase jpaRepository
@Repository
public interface FincaRepo extends JpaRepository<Finca, Integer> {


}