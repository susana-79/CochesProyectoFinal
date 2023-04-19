package susana.CochesSpring.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import susana.CochesSpring.Model.Coches;
import susana.CochesSpring.Repositorio.CochesRepositorio;


@RestController
@RequestMapping("/api")
public class CochesControlador {
	@Autowired
	CochesRepositorio cochesRepositorio;
// para que nos salga todo la tabla
	@CrossOrigin
	@GetMapping("/coches2")
	public ResponseEntity<List<Coches>> getAll( @Param("modelo") String modelo,@Param("marca") String marca,@Param("pais") String pais) {
		try {
			System.out.println(modelo);
			List<Coches> coche = cochesRepositorio.findAll();
			if (coche.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			System.out.println(coche);
			return new ResponseEntity(coche, HttpStatus.OK);
		} catch (Exception o) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//encontrar el parametro por el id
	@GetMapping("/coches/{id}")//el id me indica que puede venir algo más
	public ResponseEntity<Coches> getById(@PathVariable("id") int id) {//que si hay una la coge y me la ponga en int id
		Optional<Coches> coches = cochesRepositorio.findById(id);//optional es una caja donde guardar lo que encuentra o no
		if (coches.isPresent()) {//si exicte con el get lo obtengo
			return new ResponseEntity<>(coches.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);// y si no pues not found

		}

	}

	@PostMapping("/coches")//crea un elemento nuevo es decir un Vehiculo nuevo
	public ResponseEntity<Coches> create(@RequestBody Coches coches) {//de donde nos coge los datos y nos lo pasa a coches
		try {
			Coches newCoches = new Coches(0,coches.getModelo(),coches.getMarca(),coches.getPrecio(),coches.getPais(),coches.getCv(),coches.getFotos() );
			newCoches = cochesRepositorio.save(newCoches);
			return new ResponseEntity<>(newCoches, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/coches/{id}")//modificar un elemento  en la tabla
	public ResponseEntity<Coches> update(@PathVariable("id") int id, @RequestBody Coches coches) {// requestBody los datos que nos pasen para que se enganchen en coches

		try {
			Optional<Coches> newCoches = cochesRepositorio.findById(id);
			if (newCoches.isPresent()) {
				Coches updCoches = newCoches.get();
				updCoches.setModelo(coches.getModelo());
				updCoches.setMarca(coches.getMarca());
				updCoches.setPrecio(coches.getPrecio());
				updCoches.setPais(coches.getPais());
				updCoches.setCv(coches.getCv());
				updCoches.setFotos(coches.getFotos());
				updCoches = cochesRepositorio.save(updCoches);
				return new ResponseEntity<>(updCoches, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/coches/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
		try {
			cochesRepositorio.deleteById(id);
			return ResponseEntity.ok(null);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}