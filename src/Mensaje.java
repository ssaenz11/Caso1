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

	/**
	 * Obtiene el valor de la consulta
	 * @return El valor de la consulta
	 */
	public int getConsulta() {
		return consulta;
	}

	/**
	 * Se define el valor de la consulta
	 * @param consulta El valor a consultar
	 */
	public void setConsulta(int consulta) {
		this.consulta = consulta;
	}

	/**
	 * Se obtiene la respuesta dada por el servidor
	 * @return La respuesta de la consulta
	 */
	public int getRespuesta() {
		return respuesta;
	}

	/**
	 * Se define el valor de la respuesta
	 * @param respuesta El valor de la respuesta
	 */
	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Se obtiene el id del cliente que creó el mensaje
	 * @return Id del cliente
	 */
	public int getIdCliente() {
		return this.idCliente;
	}

	/**
	 * Se define el id del cliente que creó el mensaje
	 * @param id El id del cliente
	 */
	public void setCliente(int id) {
		this.idCliente = id;
	}
		
}
