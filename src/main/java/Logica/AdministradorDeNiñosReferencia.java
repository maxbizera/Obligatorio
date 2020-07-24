package Logica;

import Dominio.Paciente;
import Dominio.RepositorioDePacientes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class AdministradorDeNiñosReferencia extends AdministradorDeNiños {
    
    private final RepositorioDePacientes repositorio;
    
    public AdministradorDeNiñosReferencia(RepositorioDePacientes repositorio) {
        this.repositorio = repositorio;
    }
    
    @Override
    public ArrayList<ResumenNiño> listar() {
        ArrayList<ResumenNiño> respuesta = new ArrayList<>();
        this.repositorio.listar().forEach(niño -> {
            Instant now = Instant.now();
            Instant ago = niño.getFechaNacimiento();
            
            long edad = ChronoUnit.YEARS.between(
                    ago.atZone(ZoneId.systemDefault()),
                    now.atZone(ZoneId.systemDefault()));
            
            respuesta.add(new ResumenNiño(niño.getDocumento(), niño.getNombre(), niño.getDocumento(), String.valueOf(edad), niño.getServicioMedico()));
        });
        
        return respuesta;
    }
    
    @Override
    public Niño obtener(String id) throws NiñoNoExistenteException {
        try {
            Paciente paciente = this.repositorio.obtener(id);
            Niño niño = new Niño(
                    paciente.getDocumento(),
                    paciente.getNombre(),
                    paciente.getFechaNacimiento().toString(),
                    paciente.getServicioMedico(),
                    paciente.getMedicoCabecera(),
                    true
            );
            return niño;
        } catch (Dominio.PacienteNoEncontradoException e) {
            throw new NiñoNoExistenteException();
        }
    }
    
    @Override
    public void registrar(Niño niño) {
        /*LocalDate date = LocalDate.parse(niño.getFechaDeNacimiento(), DateTimeFormatter.ofPattern("uuuu-MMM-dd"));
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();*/
        this.repositorio.agregar(new Paciente(niño.getNombre(),
                niño.getDocumento(), Instant.now(),
                niño.getServicioMedico(),
                niño.getMedicoCabezera(),
                niño.getFonasa()
        ));
    }
    
    @Override
    public void eliminar(String id) {
        this.repositorio.eliminar(id);
    }
    
    @Override
    public void modificar(Niño niño) {
        this.repositorio.eliminar(niño.getDocumento());
        this.repositorio.agregar(new Paciente(niño.getNombre(),
                niño.getDocumento(), Instant.now(),
                niño.getServicioMedico(),
                niño.getMedicoCabezera(),
                niño.getFonasa()
        ));
    }
    
}
