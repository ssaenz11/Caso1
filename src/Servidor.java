//Gabriel Pinto - 201515275
//Santiago Saenz - 201512416
public class Servidor extends Thread
{
	/**
	 * El buffer que usará para recolectar los mensajes
	 */
	private static Buffer buffer;
	
	/**
	 * El id del servidor
	 */
	private int idServidor;
	
	/**
	 * El constructor del servidor
	 * @param buff El buffer que se utiliza para los mensajes
	 * @param id El id del servidor
	 */
	public Servidor(Buffer buff, int id)
	{
		buffer = buff;
		idServidor = id;
	}
	
	public void run()
	{
		try {
			while(buffer.hayClientes()){
				buffer.responderMensaje(idServidor);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
