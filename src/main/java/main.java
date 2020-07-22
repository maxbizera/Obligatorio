
import Dominio.RepositorioDePacientes;
import Dominio.RepositorioDePacientesEnMemoria;
import Logica.AdministradorDeNiños;
import Logica.AdministradorDeNiñosReferencia;
import Logica.AdministradorDeRegistro;
import Logica.AdministradorDeRegistroReferencia;
import Logica.NiñoNoExistenteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria();
        AdministradorDeNiños administradorDeNiño = new AdministradorDeNiñosReferencia(repositorio);
        AdministradorDeRegistro administradorDeRegistro = new AdministradorDeRegistroReferencia(repositorio);
        
        administradorDeNiño.registrar(new Logica.Niño());
        administradorDeNiño.registrar(new Logica.Niño());
        administradorDeNiño.registrar(new Logica.Niño());
        
        System.out.printf("hola mundo %s\n", administradorDeNiño.listar().size());
        repositorio.listar().forEach(paciente -> {
            try {
                System.out.println(administradorDeNiño.obtener(paciente.getId()).getId());
            } catch (NiñoNoExistenteException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
