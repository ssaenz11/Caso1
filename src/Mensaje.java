//Gabriel Pinto - 201515275
//Santiago Saenz - 201512416
public class Mensaje 
{	
	/**
	 * La consulta del mensaje
	 */
	private int consulta;
	
	/**
	 * La respuesta de la consulta
	 */
	private int respuesta;
	
	/**
	 * Id del cliente que envia el mensaje
	 */
	private int idCliente;
	
	/**
	 * El constructor de la clase
	 * @param mens El contenido del mensaje
	 */
	public Mensaje(int mens, int cli)
	{
		consulta = mens;
		idCliente = cli;
	}

	public int getConsulta() {
		return consulta;
	}

	public void setConsulta(int consulta) {
		this.consulta = consulta;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setCliente(int id) {
		this.idCliente = id;
	}
		
}
