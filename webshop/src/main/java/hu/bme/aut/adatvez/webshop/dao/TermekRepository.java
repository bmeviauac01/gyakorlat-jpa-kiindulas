package hu.bme.aut.adatvez.webshop.dao;

import hu.bme.aut.adatvez.webshop.model.Termek;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TermekRepository extends JpaRepository<Termek, Long>, TermekRepositoryCustom{

	@Query("SELECT t FROM Termek t WHERE t.kategoria.nev=:kategoriaNev")
	List<Termek> findByKategoriaNev(@Param("kategoriaNev") String kategoriaNev);
	
	List<Termek> findByNettoarGreaterThan(double limit);
}
