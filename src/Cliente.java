//Gabriel Pinto - 201515275
//Santiago Saenz - 201512416
public class Cliente extends Thread
{
	/**
	 * Consultas que debe realizar el cliente
	 */
	private int consultas;

	/**
	 * El buffer que usará para dejar los mensajes
	 */
	private Buffer buffer;

	/**
	 * El id del cliente
	 */
	private int idCliente;

	/**
	 * Constructor del cliente
	 * @param pConsultas Consultas que debe realizar el cliente
	 * @param buff El buffer que se usará
	 * @param id El id asignado al cliente
	 */
	public Cliente(int pConsultas, Buffer buff, int id)
	{
		consultas = pConsultas;
		buffer = buff;
		idCliente = id;
	}

	public void run()
	{
		for (int i = 0; i < consultas; i++) {
			Mensaje mensaje = new Mensaje(i, idCliente);
			try {	
				if(buffer.enviarMensaje(mensaje))
				{
					synchronized (mensaje) {
						mensaje.wait();
					}			
				}
				System.out.println("Cliente: " + idCliente + " -- Consulta: " + mensaje.getConsulta()  + " -- Respuesta:" + mensaje.getRespuesta());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("El cliente con id: " + idCliente + " terminó sus consultas");
		buffer.terminar();
	}
}
