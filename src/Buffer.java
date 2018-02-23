import java.util.ArrayList;


public class Buffer 
{
	
	// lista de mensajes que se han enviado
	private ArrayList<Mensaje> mensajes;
	
	// es la capaciadad de almacenamiento del buffer
	private int capacidad;
	
	// usuaris que etsán usando el buffer
	private int numClientes;

	public Buffer ( int n , int clientes) 
	{
		capacidad = n;
		mensajes = new ArrayList<Mensaje>( );
		numClientes=clientes;
	}

	
	/**
	 * funciona de tal manera que si la cantidad de mensajes es igual a la capacidad del buffer
	 * se hace un yield que cede el paso a otro thread, en caso contrario se almacena el mensaje y se notifica a todos.
	 * finalmente  se sincroniza el objeto para que espere en el buffer
	 * @param msg
	 * @throws InterruptedException
	 */
	public synchronized void almacenarMensaje ( Mensaje msg ) throws InterruptedException
	{
		while(mensajes.size() == capacidad){
			Thread.yield();
		}
		mensajes.add(msg);
		notifyAll();

		synchronized (this) { wait();}

	}
	
	/**
	 * Este método evalua si no hay mensajes , por lo que no hace nada. 
	 * En caso de que si haya algo se remueve el mensaje y se responde para el finalmente notifique a todos.
	 * @throws InterruptedException
	 */

	public synchronized void retirarMensaje() throws InterruptedException
	{

		while( mensajes.size() == 0){
			wait();
		}

		Mensaje resp = mensajes.remove(0);
		resp.responder();
		synchronized (this) {notifyAll();}
	}

	public boolean hayClientes()
	{
		return (numClientes == 0);
	}
	
	public void terminar(){
		numClientes--;
	}

}
