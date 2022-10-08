package co.edu.misionTic.TecnimecanicaHermanos.controller;


import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import co.edu.misionTic.TecnimecanicaHermanos.domain.*;
import co.edu.misionTic.TecnimecanicaHermanos.services.GeneralServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CrudController {


    private final GeneralServices generalService;

    public CrudController(GeneralServices generalService) {
        this.generalService = generalService;
    }

    // ------------------------------ empleados---------------------------------

    @RequestMapping("/GestionarEmpleados")
    public String gestionarEmpleados(Model model) {
        List<Personas> docentes = generalService.getEmpleados();
        model.addAttribute("estudiantes", docentes);
        return "gestionarEmpleados";
    }

    @RequestMapping("/RegistrarEmpleado")
    public String registrarEmpleado(Model model) {
        return "registrarEmpleado";
    }

    @RequestMapping("/GuardarEmpleado")
    public String guardarEmpleado(Model model, @RequestParam("nb") String nombres, @RequestParam("ap") String apellidos, @RequestParam("nd") String numeroDocumento,
                                  @RequestParam("tf") String telefono, @RequestParam("dc") String direccion, @RequestParam("te") String tipoEmpleado) throws ParseException {
        generalService.registrarEmpleado(nombres, apellidos, numeroDocumento, telefono, direccion, 'E', tipoEmpleado.charAt(0));
        return gestionarEmpleados(model);
    }

    @RequestMapping("/ModificarEmpleado")
    public String modificarEmpleado(Model model, @RequestParam("nd") String idDocente) {
        Personas cliente = generalService.getEmpleadoById(idDocente);
        model.addAttribute("docente", cliente);
        return "modificarEmpleado";
    }

    @RequestMapping("/VerEmpleado")
    public String verEmpleado(Model model, @RequestParam("nd") String idDocente) {
        Personas cliente = generalService.getEmpleadoById(idDocente);
        model.addAttribute("docente", cliente);
        List<OrdenReparacion> reparacions = generalService.getOrdenReparacionByIdEmpleado(cliente.getId_persona());
        model.addAttribute("orden", reparacions);
        return "verEmpleado";
    }

    @RequestMapping("/ActualizarEmpleado")
    public String actualizarEmpleado(Model model, @RequestParam("nb") String nombres, @RequestParam("ap") String apellidos, @RequestParam("nd") String numeroDocumento,
                                     @RequestParam("tf") String telefono, @RequestParam("dc") String direccion, @RequestParam("te") char tipoEmpleado) throws ParseException {
        generalService.actualizarEmpleado(numeroDocumento, nombres, apellidos, telefono, direccion, tipoEmpleado);
        return gestionarEmpleados(model);
    }

    @RequestMapping("/EliminarEmpleado")
    public String eliminarEmpleado(Model model, @RequestParam("nd") String documento) throws ParseException {
        generalService.eliminarEmpleado(documento);
        return "eliminacionEmpleadoExitosa";
    }

    @RequestMapping("/ConfirmacionEliminarEmpleado")
    public String ConfirmacionEliminarEmpleado(Model model, @RequestParam("nd") String documento) throws ParseException {
        Personas cliente = generalService.getEmpleadoById(documento);
        model.addAttribute("numeroDocumento", cliente.getDocumento());
        model.addAttribute("nombreEmpleado", cliente.getNombres());
        model.addAttribute("apellidoEmpleado", cliente.getApellidos());
        return "eliminarEmpleado";
    }

    // ------------------------------ clientes---------------------------------

    @RequestMapping("/GestionarClientes")
    public String gestionarClientes(Model model) {
        List<Personas> clientes = generalService.getClientes();
        model.addAttribute("clientes", clientes);
        return "gestionarClientes";
    }

    @RequestMapping("/RegistrarCliente")
    public String registrarCliente(Model model) {
        return "registrarCliente";
    }

    @RequestMapping("/GuardarCliente")
    public String guardarCliente(Model model, @RequestParam("nb") String nombres, @RequestParam("ap") String apellidos, @RequestParam("nd") String numeroDocumento,
                                 @RequestParam("tf") String telefono, @RequestParam("dc") String direccion) throws ParseException {
        generalService.registrarCliente(nombres, apellidos, numeroDocumento, telefono, direccion, 'C');
        return gestionarClientes(model);
    }

    @RequestMapping("/VerCliente")
    public String verCliente(Model model, @RequestParam("nd") String idDocente) {
        Personas cliente = generalService.getClienteById(idDocente);
        model.addAttribute("clientes", cliente);
        List<Vehiculo> vehiculos = generalService.getVehiculoByIdPersona(cliente.getId_persona() + "");
        model.addAttribute("vehiculos", vehiculos);
        return "verCliente";
    }

    @RequestMapping("/ModificarCliente")
    public String modificarCliente(Model model, @RequestParam("nb") String idDocente) {
        Personas cliente = generalService.getClienteById(idDocente);
        model.addAttribute("docente", cliente);
        return "modificarCliente";
    }

    @RequestMapping("/ActualizarCliente")
    public String actualizarCliente(Model model, @RequestParam("nb") String nombres, @RequestParam("ap") String apellidos, @RequestParam("nd") String numeroDocumento,
                                    @RequestParam("tf") String telefono, @RequestParam("dc") String direccion) throws ParseException {
        generalService.actualizarCliente(numeroDocumento, nombres, apellidos, telefono, direccion);
        gestionarClientes(model);
        return gestionarClientes(model);
    }

    @RequestMapping("/EliminarCliente")
    public String eliminarCliente(Model model, @RequestParam("nd") String documento) throws ParseException {
        generalService.eliminarCliente(documento);
        return "eliminacionClienteExitosa";
    }

    @RequestMapping("/ConfirmacionEliminarCliente")
    public String ConfirmacionEliminarCliente(Model model, @RequestParam("nd") String documento) throws ParseException {
        Personas cliente = generalService.getClienteById(documento);
        model.addAttribute("numeroDocumento", cliente.getDocumento());
        model.addAttribute("nombreCliente", cliente.getNombres());
        model.addAttribute("apellidoCliente", cliente.getApellidos());
        return "eliminarCliente";
    }

    //	----------------------------------servicios----------------------------------------------
    @RequestMapping("/GestionarServicios")
    public String gestionarServicios(Model model) {
        List<Servicios> servicios = generalService.getServicios();
        model.addAttribute("servicios", servicios);
        return "gestionarServicios";
    }

    @RequestMapping("/RegistrarServicio")
    public String registrarServicio(Model model) {
        return "registrarServicio";
    }

    @RequestMapping("/GuardarServicio")
    public String guardarServicio(Model model, @RequestParam("nb") String nombres) throws ParseException {
        generalService.registrarServicio(nombres);
        return gestionarServicios(model);
    }

    @RequestMapping("/ModificarServicio")
    public String modificarServicio(Model model, @RequestParam("nb") String idDocente) {
        Servicios cliente = generalService.getServicioById(idDocente);
        model.addAttribute("docente", cliente);
        return "modificarServicio";
    }

    @RequestMapping("/ActualizarServicio")
    public String actualizarServicio(Model model, @RequestParam("nb") String nombres, @RequestParam("nd") String numeroDocumento) throws ParseException {
        generalService.actualizarServicio(numeroDocumento, nombres);
        gestionarServicios(model);
        return gestionarServicios(model);
    }

    @RequestMapping("/EliminarServicio")
    public String eliminarServicio(Model model, @RequestParam("nd") String documento) throws ParseException {
        generalService.eliminarServicio(documento);
        return "eliminacionServicioExitosa";
    }

    @RequestMapping("/ConfirmacionEliminarServicio")
    public String ConfirmacionEliminarServicio(Model model, @RequestParam("nd") String documento) throws ParseException {
        Servicios cliente = generalService.getServicioById(documento);
        model.addAttribute("numeroDocumento", cliente.getId_servicio());
        model.addAttribute("nombreServicio", cliente.getNombre_servicio());
        return "eliminarServicio";
    }

//	-------------------------------repuestos---------------------------------------------

    @RequestMapping("/GestionarRepuestos")
    public String gestionarRepuestos(Model model) {
        List<Repuestos> docentes = generalService.getRepuestos();
        model.addAttribute("estudiantes", docentes);
        return "gestionarRepuestos";
    }

    @RequestMapping("/RegistrarRepuesto")
    public String registrarRepuesto(Model model) {
        return "registrarRepuesto";
    }

    @RequestMapping("/GuardarRepuesto")
    public String guardarRepuestos(Model model, @RequestParam("nb") String nombres, @RequestParam("cu") String costoUnitario, @RequestParam("ci") String cantidadInventario) throws ParseException {
        generalService.registrarRepuesto(nombres, Integer.parseInt(costoUnitario), Integer.parseInt(cantidadInventario));
        System.out.println("entro");
        return gestionarRepuestos(model);
    }

    @RequestMapping("/ModificarRepuesto")
    public String modificarRepuestos(Model model, @RequestParam("nb") String idDocente) {
        Repuestos cliente = generalService.getRepuestoById(idDocente);
        model.addAttribute("docente", cliente);
        return "modificarRepuesto";
    }

    @RequestMapping("/ActualizarRepuesto")
    public String actualizarRepuesto(Model model, @RequestParam("nb") String nombres, @RequestParam("nd") String numeroDocumento, @RequestParam("cu") String costoUnitario, @RequestParam("ci") String cantidadInventario) throws ParseException {
        generalService.actualizarRepuesto(numeroDocumento, nombres, Integer.parseInt(costoUnitario), Integer.parseInt(cantidadInventario));
        gestionarRepuestos(model);
        return gestionarRepuestos(model);
    }

//	-------------------------------vehiculos---------------------------------------------

    @RequestMapping("/GestionarVehiculos")
    public String gestionarVehiculos(Model model) {
        List<Vehiculo> vehiculos = generalService.getVehiculos();
        model.addAttribute("vehiculos", vehiculos);
        return "gestionarVehiculos";
    }

    @RequestMapping("/RegistrarVehiculo")
    public String registrarVehiculo(Model model) {
        List<Personas> clientes = generalService.getClientes();
        model.addAttribute("clientes", clientes);
        return "registrarVehiculo";
    }

    @RequestMapping("/GuardarVehiculo")
    public String guardarVehiculo(Model model, @RequestParam("pl") String placa, @RequestParam("md") String modelo, @RequestParam("mc") String marca, @RequestParam("cl") String color, @RequestParam("anio") String anio, @RequestParam("dc") String descripcion, @RequestParam("idp") String duenio) throws ParseException {
        Personas cliente = generalService.getClienteById(duenio);
        generalService.registrarVehiculos(placa, modelo, marca, color, Integer.parseInt(anio), descripcion, cliente.getId_persona());
        return gestionarVehiculos(model);
    }

    @RequestMapping("/VerVehiculo")
    public String verVehiculo(Model model, @RequestParam("nd") String idDocente) {
        Vehiculo vehiculo = generalService.getVehiculoById(idDocente);
        List<OrdenReparacion> rep = generalService.getOrdenReparacionByPlaca(vehiculo.getPlaca());
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("reparaciones", rep);
        return "verVehiculo";
    }

    @RequestMapping("/ModificarVehiculo")
    public String modificarVehiculo(Model model, @RequestParam("nd") String idDocente) {
        Vehiculo vehiculo = generalService.getVehiculoById(idDocente);
        model.addAttribute("vehiculo", vehiculo);
        List<Personas> clientes = generalService.getClientes();
        model.addAttribute("clientes", clientes);
        return "modificarVehiculo";
    }

    @RequestMapping("/ActualizarVehiculo")
    public String actualizarVehiculo(Model model, @RequestParam("pl") String placa, @RequestParam("md") String modelo, @RequestParam("mc") String marca, @RequestParam("cl") String color, @RequestParam("anio") String anio, @RequestParam("dc") String descripcion, @RequestParam("idp") String duenio) throws ParseException {
        generalService.actualizarVehiculo(placa, modelo, marca, color, Integer.parseInt(anio), descripcion, Integer.parseInt(duenio));
        gestionarRepuestos(model);
        return gestionarVehiculos(model);
    }

    @RequestMapping("/EliminarVehiculo")
    public String eliminarVehiculo(Model model, @RequestParam("nd") String documento) throws ParseException {
        generalService.eliminarVehiculo(documento);
        return "eliminacionVehiculoExitosa";
    }

    @RequestMapping("/ConfirmacionEliminarVehiculo")
    public String ConfirmacionEliminarVehiculo(Model model, @RequestParam("nd") String documento) throws ParseException {
        Vehiculo cliente = generalService.getVehiculoById(documento);
        model.addAttribute("numeroDocumento", cliente.getPlaca());
        return "eliminarVehiculo";
    }


    // ------------------------------ ordenes---------------------------------

    @RequestMapping("/GestionarOrdenes")
    public String gestionarOrden(Model model) {
        List<OrdenReparacion> docentes = generalService.getOrdene();
        model.addAttribute("estudiantes", docentes);
        return "gestionarOrden";
    }

    @RequestMapping("/RegistrarOrden")
    public String registrarOrden(Model model) {
        List<Personas> clientes = generalService.getEmpleados();
        model.addAttribute("responsables", clientes);
        List<Vehiculo> vehiculos = generalService.getVehiculos();
        model.addAttribute("vehiculos", vehiculos);
        List<Repuestos> repuestos = generalService.getRepuestos();
        model.addAttribute("repuestos", repuestos);
        return "registrarOrden";
    }

    @RequestMapping("/GuardarOrden")
    public String guardarOrden(Model model, @RequestParam("pl") String placa, @RequestParam("dn") String diagnostico,
                               @RequestParam("idr") String responsable) throws ParseException {
        Personas persona = generalService.getEmpleadoByLastName(responsable);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        generalService.registrarOrdenReparacion(diagnostico, dtf.format(now), persona.getId_persona(), placa);
        return gestionarOrden(model);
    }

    @RequestMapping("/ModificarOrden")
    public String modificarOrden(Model model, @RequestParam("nd") String idOrden) {
        OrdenReparacion orden = generalService.getOrdenReparacionById(idOrden);
        model.addAttribute("ordene", orden);
        return "modificarOrden";
    }


    @RequestMapping("/VerOrden")
    public String verOrden(Model model, @RequestParam("nd") String idDocente) {
        OrdenReparacion cliente = generalService.getOrdenReparacionById(idDocente);
        model.addAttribute("docente", cliente);
        return "verOrden";
    }

    @RequestMapping("/ActualizarOrden")
    public String actualizarOrden(Model model, @RequestParam("ido") String idOrden, @RequestParam("dn") String diagnostico) throws ParseException {
        generalService.actualizarOrdenReparacion(Integer.parseInt(idOrden), diagnostico);
        return gestionarOrden(model);
    }

    @RequestMapping("/EliminarOrden")
    public String eliminarOrden(Model model, @RequestParam("nd") String documento) throws ParseException {
        generalService.eliminarOrdenReparacion(documento);
        return "eliminacionOrdenExitosa";
    }

    @RequestMapping("/ConfirmacionEliminarOrden")
    public String ConfirmacionEliminarOrden(Model model, @RequestParam("nd") String documento) throws ParseException {
        OrdenReparacion cliente = generalService.getOrdenReparacionById(documento);
        model.addAttribute("numeroDocumento", cliente.getId_orden());
        return "eliminarOrden";
    }
    // ------------------------------ Reparaciones---------------------------------
    @RequestMapping("/GestionarReparaciones")
    public String gestionarReparaciones(Model model,@RequestParam("nd") int id_Orden) {
        List<Reparacion> reparaciones = generalService.getReparacionesById(id_Orden);
        model.addAttribute("reparaciones", reparaciones);
        OrdenReparacion orden = generalService.getOrdenReparacionByIdOrden(id_Orden);
        model.addAttribute("orden", orden);
        return"gestionarReparaciones";
    }

    @RequestMapping("/RegistrarReparacion")
    public String registrarReparacion(Model model,@RequestParam("nd") int id_Orden) {
        List<Servicios> servicios = generalService.getServicios();
        model.addAttribute("servicios", servicios);
        OrdenReparacion orden = generalService.getOrdenReparacionByIdOrden(id_Orden);
        model.addAttribute("orden", orden);
        return "registrarReparacion";
    }

    @RequestMapping("/GuardarReparacion")
    public String guardarReparacion(Model model, @RequestParam("ct") int costo, @RequestParam("nd") int id_orden,
                               @RequestParam("ids") int id_servicio ,@RequestParam("fh") String fecha ) throws ParseException {
       /* DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();*/
        generalService.registrarReparacion(costo,fecha,id_servicio, id_orden);
        return gestionarReparaciones(model,id_orden);
    }

    @RequestMapping("/ModificarReparacion")
    public String modificarReparacion(Model model, @RequestParam("nd") int idReparacion,@RequestParam("no") int idOrden) {
        Reparacion reparacion = generalService.getReparacionById(idReparacion);
        model.addAttribute("reparacion", reparacion);
        model.addAttribute("orden",idOrden);
        return "modificarReparacion";
    }

    @RequestMapping("/ActualizarReparacion")
    public String actualizarReparacion(Model model, @RequestParam("idr") int idReparacion,
                                  @RequestParam("fh") String fecha, @RequestParam("cr") int costo,@RequestParam("ido") int id_Orden) throws ParseException {
        generalService.actualizarReparacion(idReparacion, fecha, costo, id_Orden);
        return gestionarReparaciones(model,id_Orden);
    }

    @RequestMapping("/EliminarReparacion")
    public String eliminarReparacion(Model model, @RequestParam("nd") int id_reparacion,@RequestParam("ido") int id_Orden) throws ParseException {
        generalService.eliminarReparacion(id_reparacion,id_Orden);
        model.addAttribute("id_orden", id_Orden);
        return "eliminacionReparacionExitosa";
    }

    @RequestMapping("/ConfirmacionEliminarReparacion")
    public String ConfirmacionEliminarReparacion(Model model, @RequestParam("nd") int id_reparacion,@RequestParam("ido") int id_Orden) throws ParseException {
        model.addAttribute("id_reparacion", id_reparacion);
        model.addAttribute("id_orden", id_Orden);
        return "eliminarReparacion";

    }
    // ------------------------------ Repuestos-Reparacion---------------------------------
    @RequestMapping("/GestionarRepuestosAsignados")
    public String GestionarRepuestosAsignados(Model model,@RequestParam("nd") int id_Reparacion, @RequestParam("ido") int id_Orden) {
        List<String>  repuestosUsados  = generalService.getRepuestoReparacionById(id_Reparacion);
        List<Integer>  cantidad  = generalService.getCantidadRepuestosUsados(id_Reparacion);
        List<Integer> ids = generalService.getIdsRepuestosUsados(id_Reparacion);
        System.out.println(repuestosUsados);
        model.addAttribute("cantidad", cantidad);
        model.addAttribute("repuestosUsados", repuestosUsados);
        model.addAttribute("reparacion", id_Reparacion);
        model.addAttribute("ids", ids);
        model.addAttribute("orden", id_Orden);
        return"gestionarRepuestoAsignados";
    }

    @RequestMapping("/RegistrarRepuestoReparacion")
    public String registrarRepuestoReparacion(Model model,@RequestParam("nd") int id_Reparacion,@RequestParam("ido") int id_Orden) {
        List<Repuestos> repuestos = generalService.getRepuestos();
        model.addAttribute("repuestos", repuestos);
        model.addAttribute("reparacion", id_Reparacion);
        model.addAttribute("orden", id_Orden);
        return "registrarRepuestosAReparacion";
    }

    @RequestMapping("/GuardarRepuestoReparacion")
    public String guardarRepuestoReparacion(Model model, @RequestParam("idr") int id_reparacion, @RequestParam("ct") int cantidad,
                                    @RequestParam("idre") int id_repuesto,@RequestParam("ido") int id_Orden) throws ParseException {
       /* DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();*/
        generalService.registrarRepuestoReparacion(cantidad,id_repuesto,id_reparacion,id_Orden);
        return GestionarRepuestosAsignados(model,id_reparacion,id_Orden);
    }
    @RequestMapping("/EliminarRepuestoAsignado")
    public String EliminarRepuestoAsignado(Model model, @RequestParam("nd") int id_repuesto,@RequestParam("idr") int id_reparacion,@RequestParam("ido") int id_orden) throws ParseException {
        generalService.eliminarRepuestoAsignado(id_repuesto, id_reparacion,id_orden);
        model.addAttribute("id_reparacion", id_reparacion);
        model.addAttribute("id_orden", id_orden);
        return "eliminacionRepuestoAsigandoExitoso";
    }

    @RequestMapping("/ConfirmacionEliminarRepuestoAsignado")
    public String ConfirmacionEliminarRepuestoAsignado(Model model, @RequestParam("nd") int id_repuesto,@RequestParam("idr") int id_reparacion,@RequestParam("ido") int id_orden ) throws ParseException {
        model.addAttribute("id_repuesto", id_repuesto);
        model.addAttribute("id_reparacion", id_reparacion);
        model.addAttribute("id_orden", id_orden);
        return "eliminarRepuestoReparacion";

    }
    // ------------------------------ Generar Factura--------------------------------
    @RequestMapping("/GenerarFactura")
    public String generarFactura(Model model, @RequestParam("nd") int idOrden, @RequestParam("pl") String placa) {
        List<Reparacion> reparaciones = generalService.getReparacionesById(idOrden);
        List<String>  nombreRepuestos  = generalService.getNombreRepuestos(idOrden);
        List<Integer>  idReparacion  = generalService.getIdsReparacion(idOrden);
        List<Integer> cantidadRepuesto = generalService.getCantidad(idOrden);
        List<Integer>  costoUnitario  = generalService.getCostoUnitario(idOrden);
        List<Integer> costoTotal = generalService.getCostoTotal(idOrden);
        String ordenNombre =generalService.getOrdenNombre(idOrden);
        String ordenApellido =generalService.getOrdenApellidos(idOrden);
        String ordenDocumento =generalService.getOrdenDocumento(idOrden);
        String ordenDireccion =generalService.getOrdenDireccion(idOrden);
        String ordenTelefono =generalService.getOrdenTelefono(idOrden);
        String ordenFecha =generalService.getOrdenFecha(idOrden);
        String ordenPlaca =generalService.getOrdenPlaca(idOrden);
        String ordenMarca =generalService.getOrdeMarca(idOrden);
        String ordenModelo =generalService.getOrdenModelo(idOrden);
        String mecanico = generalService.getOrdenMecanico(idOrden);
        int total = generalService.getCostoTotalOrden(idOrden);
        model.addAttribute("reparaciones", reparaciones);
        model.addAttribute("orden", idOrden);
        model.addAttribute("nombre", ordenNombre);
        model.addAttribute("apellidos", ordenApellido);
        model.addAttribute("documento", ordenDocumento);
        model.addAttribute("direccion", ordenDireccion);
        model.addAttribute("telefono", ordenTelefono);
        model.addAttribute("fecha", ordenFecha);
        model.addAttribute("placa", ordenPlaca);
        model.addAttribute("marca", ordenMarca);
        model.addAttribute("modelo", ordenModelo);
        model.addAttribute("repuestos", nombreRepuestos);
        model.addAttribute("id_reparaciones", idReparacion);
        model.addAttribute("cantidad", cantidadRepuesto);
        model.addAttribute("costoUnitario", costoUnitario);
        model.addAttribute("costoTotal", costoTotal);
        model.addAttribute("costoTotalOrden",total);
        model.addAttribute("mecanico",mecanico);
        return "factura";
    }

}
