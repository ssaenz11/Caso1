import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


//Gabriel Pinto - 201515275
//Santiago Saenz - 201512416
public class Principal 
{
	/**
	 * El buffer que se utilizará para la tranferencia de mensajes
	 */
	public static Buffer buffer;

	public static void main(String[] args) throws IOException 
	{
		//Se cargan los datos del archivo

		File archivo = new File("./docs/Datos.txt");
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		int numClientes = Integer.parseInt(linea.split(":")[1]);
		linea = lector.readLine();
		int numServers = Integer.parseInt(linea.split(":")[1]);
		linea = lector.readLine();
		int tamBuffer = Integer.parseInt(linea.split(":")[1]);

		linea = lector.readLine();
		lector.close();

		//Se inicializa el buffer
		buffer = new Buffer(tamBuffer, numClientes);

		Servidor ser;
		//Se crean los servidores
		for(int i = 0; i < numServers; i++)
		{ 
			ser = new Servidor(buffer, i);
			ser.start();
		}
		
		int cons;
		Cliente cli;
		//Se crean los clientes 
		for(int i = 0; i < numClientes; i++)
		{
			cons = Integer.parseInt(linea.split(":")[i]);
			cli = new Cliente(cons, buffer, i+1);
			cli.start();
		}

	}

}
