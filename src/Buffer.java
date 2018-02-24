import java.util.ArrayList;
//Gabriel Pinto - 201515275
//Santiago Saenz - 201512416
import com.sun.xml.internal.ws.util.NoCloseOutputStream;
//Gabriel Pinto - 201515275
//Santiago Saenz - 201512416
public class Buffer 
{
	
	/**
	 * Capacidad de almacenamientos del buffer
	 */
	private static int capacidad;
	
	/**
	 * Mensajes en el buffer
	 */
	private static int espera;
	
	/**
	 * Mensajes por enviar
	 */
	private static ArrayList<Mensaje> mensajes;
	
	/**
	 * Número de clientes que están realizando consultas
	 */
	private static int numClientes;

	/**
	 * Constructor del Buffer
	 * @param capaci Capacidad de almacenamiento del buffer
	 * @param clientes Número de clientes 
	 */
	public Buffer (int capaci, int clientes) 
	{
		capacidad = capaci;
		mensajes = new ArrayList<>();
		numClientes = clientes;
		espera = 0;
	}

	/**
	 * funciona de tal manera que si la cantidad de mensajes es igual a la capacidad del buffer
	 * se hace un yield que cede el paso a otro thread, en caso contrario se almacena el mensaje y se notifica a todos.
	 * finalmente  se sincroniza el objeto para que espere en el buffer
	 * @param msg
	 * @throws InterruptedException
	 */
	public synchronized void enviarMensaje(Mensaje msg) throws InterruptedException
	{
		while(mensajes.size() == capacidad){
			Thread.yield();
		}
		
		mensajes.add(msg);
		espera++;
		notify();
		
		synchronized (msg) {
			msg.wait();
		}
	}
	
	/**
	 * Este método evalua si no hay mensajes , por lo que no hace nada. 
	 * En caso de que si haya algo se remueve el mensaje y se responde para el finalmente notifique a todos.
	 * @throws InterruptedException
	 */
	public synchronized void responderMensaje(int id) throws InterruptedException
	{
		while(mensajes.size() == 0){
			wait();
		}
		
		espera--;
		Mensaje mensa = mensajes.remove(0);
		int resp = mensa.getConsulta() + 1;
		mensa.setRespuesta(resp);
		mensa.notify();
	}

	public boolean hayClientes()
	{
		return (numClientes != 0);
	}
	
	public synchronized void terminar(){
		numClientes--;
		if(numClientes == 0)
		{
			System.out.println("Fin");
		}
		
	}

}
