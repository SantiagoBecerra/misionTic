/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.misionTic.TecnimecanicaHermanos.repository;

import java.util.List;

import co.edu.misionTic.TecnimecanicaHermanos.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface GeneralRepositoryVehiculos extends JpaRepository<Vehiculo, Integer>{
	
  //  -------------------------------Vehiculos---------------------------------------
    
    @Query(value= "SELECT * FROM vehiculos ORDER BY placa",nativeQuery = true)
    public List<Vehiculo> getVehiculos();
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value= " INSERT INTO vehiculos(placa,modelo,marca,color,anio,descripcion,id_persona) VALUES(?,?,?,?,?,?,?)",nativeQuery = true)
    public void registrarVehiculo(String placa,String modelo,String marca,String color,int anio,String descripcion,int cliente);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "DELETE FROM vehiculos WHERE placa LIKE ?",nativeQuery = true)
	public void eliminarVehiculo(String isServicio);
    
    @Query(value= "SELECT * FROM vehiculos WHERE placa LIKE ?1 ",nativeQuery = true)
	public Vehiculo getVehiculoById(String id);
    
    @Query(value= "SELECT * FROM vehiculos WHERE id_persona = ?1 ",nativeQuery = true)
	public List<Vehiculo> getVehiculoByIdPersona(String id);
    
    @Modifying
    @org.springframework.transaction.annotation.Transactional
	@Query(value = "UPDATE vehiculos SET modelo= ?2,marca= ?3,color= ?4,anio= ?5,descripcion= ?6 WHERE placa LIKE ?1",nativeQuery = true)
	public void actualizarVehiculo(String placa,String modelo,String marca,String color,int anio,String descripcion,int cliente);
    
}








