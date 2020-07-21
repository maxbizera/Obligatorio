package Logica;

import java.util.Calendar;

public class Nino {
	//Declaramos atributos//
		private String nombre;
		private int documento;
		private Calendar fechaNacimiento;
		private String servicioMedico;
		private String medicoCabecera;
		private boolean tieneFonasa;
		private Registro[] registros;
		private int cantRegistrosIngresados;
		
	//Constructor uno
		
		public Nino(String nombre, int documento, Calendar fechaNacimiento, String servicioMedico, String medicoCabecera, boolean tieneFonasa,
				Registro[] registros, int cantRegistrosIngresados) {
			super();
			this.nombre = nombre;
			this.documento = documento;
			this.fechaNacimiento = fechaNacimiento;
			this.servicioMedico = servicioMedico;
			this.medicoCabecera = medicoCabecera;
			this.tieneFonasa = tieneFonasa;
			this.registros = registros;
			this.cantRegistrosIngresados = cantRegistrosIngresados;
		}
		
		
		
		//Constructor 2
		
		public Nino(String nombre, int documento, Calendar fechaNacimiento, String servicioMedico, String medicoCabecera, boolean tieneFonasa) {
			super();
			this.nombre = nombre;
			this.documento = documento;
			this.fechaNacimiento = fechaNacimiento;
			this.servicioMedico = servicioMedico;
			this.medicoCabecera = medicoCabecera;
			this.tieneFonasa = tieneFonasa;
			this.registros = null;
			this.cantRegistrosIngresados = 0;
		}
		
		
		
		
		//Getters y setters//

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getDocumento() {
			return documento;
		}

		public void setDocumento(int documento) {
			this.documento = documento;
		}

		public Calendar getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(Calendar fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getServicioMedico() {
			return servicioMedico;
		}

		public void setServicioMedico(String servicioMedico) {
			this.servicioMedico = servicioMedico;
		}

		public String getMedicoCabecera() {
			return medicoCabecera;
		}

		public void setMedicoCabecera(String medicoCabecera) {
			this.medicoCabecera = medicoCabecera;
		}

		public boolean isTieneFonasa() {
			return tieneFonasa;
		}

		public void setTieneFonasa(boolean tieneFonasa) {
			this.tieneFonasa = tieneFonasa;
		}

		public Registro[] getRegistros() {
			return registros;
		}

		public void setRegistros(Registro[] registros) {
			this.registros = registros;
		}

		public int getCantRegistrosIngresados() {
			return cantRegistrosIngresados;
		}

		public void setCantRegistrosIngresados(int cantRegistrosIngresados) {
			this.cantRegistrosIngresados = cantRegistrosIngresados;
		}
		
		
		public int edad ()
		{
			
			Calendar fechaHoy = Calendar.getInstance();
			int diferencia = fechaHoy.get(Calendar.YEAR) - this.fechaNacimiento.get(Calendar.YEAR);
			if (fechaHoy.get(Calendar.MONTH) < this.fechaNacimiento.get(Calendar.MONTH) || (fechaHoy.get(Calendar.MONTH) == this.fechaNacimiento.get(Calendar.MONTH) && fechaHoy.get(Calendar.DAY_OF_MONTH) < this.fechaNacimiento.get(Calendar.DAY_OF_MONTH)) )
			{
				diferencia--;
				
			}
			return diferencia;
			
		}
		
		
		public void agregarRegistro(Registro nuevoRegistro)
		{
			
			this.cantRegistrosIngresados++;
			Registro[] nuevosRegistros = new Registro[this.cantRegistrosIngresados];
			
			for ( int i = 0; i < this.cantRegistrosIngresados -1; i++)
			{
				Registro objeto =  this.registros[i];
				nuevosRegistros[i] = objeto;  
			}
			
			nuevosRegistros[this.cantRegistrosIngresados -1] = nuevoRegistro;
			this.setRegistros(nuevosRegistros);
					
				
		}
		

	
	public String datosNino()
	{
		return "Nombre: " + this.nombre + ", Documento: " + this.documento + "Edad: " + this.edad() + "Servicio Medico: " + this.servicioMedico ;
	}
		
		
		

		
}