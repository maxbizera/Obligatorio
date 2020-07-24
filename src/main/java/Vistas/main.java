
import Dominio.Paciente;
import Dominio.RepositorioDePacientes;
import Dominio.RepositorioDePacientesEnMemoria;
import Logica.AdministradorDeNiños;
import Logica.AdministradorDeNiñosReferencia;
import Logica.AdministradorDeRegistro;
import Logica.AdministradorDeRegistroReferencia;
import Logica.NiñoNoExistenteException;
import Vistas.ListaNiños;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileReader file = new FileReader("/home/gcarrillo/Desktop/crunchify.txt");
            JSONParser jsonParser = new JSONParser();
            Object estado = jsonParser.parse(file);
            System.out.println(estado.toString());

            RepositorioDePacientes repositorio = new RepositorioDePacientesEnMemoria(new ArrayList<Paciente>() {

                {
                    add(new Paciente("Guillermo Carrillo", "V18942891", Instant.now(), "HCC", "Krivoy", false));
                    add(new Paciente("Maximiliano Bizera", "V1231231", Instant.now(), "HCC", "Krivoy", false));

                }

            });
            AdministradorDeNiños administradorDeNiño = new AdministradorDeNiñosReferencia(repositorio);
            AdministradorDeRegistro administradorDeRegistro = new AdministradorDeRegistroReferencia(repositorio);

            administradorDeNiño.registrar(new Logica.Niño());
            administradorDeNiño.registrar(new Logica.Niño());
            administradorDeNiño.registrar(new Logica.Niño());

            repositorio.listar().forEach(paciente -> {
                try {
                    System.out.println(administradorDeNiño.obtener(paciente.getId()).getId());
                } catch (NiñoNoExistenteException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            ShutDownTask shutDownTask = new ShutDownTask(estado);
            Runtime.getRuntime().addShutdownHook(shutDownTask);

            new ListaNiños(administradorDeNiño).setVisible(true);
        } catch (IOException | ParseException e) {
            System.exit(0);
        }

    }

    private static class ShutDownTask extends Thread {

        private static FileWriter file;
        private Object estado;

        public ShutDownTask(Object estado) {
            this.estado = estado;
        }

        @Override
        public void run() {
            System.out.println("Performing shutdown");
            this.salvarEstado(estado);
        }

        private static void salvarEstado(Object estado) {
            JSONObject obj = new JSONObject();
            obj.put("Name", "Crunchify.com");
            obj.put("Author", "App Shah");

            JSONArray company = new JSONArray();
            company.add("Company: Facebook");
            company.add("Company: PayPal");
            company.add("Company: Google");
            obj.put("Company List", company);
            try {

                // Constructs a FileWriter given a file name, using the platform's default charset
                file = new FileWriter("/home/gcarrillo/Desktop/crunchify.txt");
                file.write(obj.toJSONString());

            } catch (IOException e) {
            } finally {

                try {
                    file.flush();
                    file.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block

                }
            }
        }

    }

}
