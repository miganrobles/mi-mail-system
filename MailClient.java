/**
 * La clase MailClient:

 *Disponga de 2 atributos: uno de tipo MailServer llamado server (que representa el servidor asociado con ese cliente) y otro de tipo String 
 *llamado user (que representa la dirección de correo del usuario que usa ese cliente).
   
 *Disponga de un constructor que permita crear un objeto MailClient inicializando sus atributos por medio de parámetros.
    
 *Disponga de un método llamado getNextMailItem que recupere del servidor el siguiente correo (un objeto MailItem) que tenga el usuario y devuelva dicho objeto.
    
 *Disponga de un método llamado printNextMailItem que recupere del servidor el siguiente correo (un objeto MailItem) que tenga el usuario e imprima por 
 *pantalla los datos de dicho mensaje. Si no hay ningun mensaje, que muestre un mensaje por pantalla informando de ello.
    
 *Disponga de un método llamado sendMailItem que reciba 2 parámetros (un String indicando para quién es el mensaje y otro String indicando el contenido del mensaje), 
 *cree un email (objeto MailItem) basándose en la información de dichos parámetros y lo envíe al servidor asociado a ese cliente.



 * Write a description of class MailClient here.
 * 
 * @author (Miguel) 
 * @version (una version personal)
 */
public class MailClient
{
    // Este atributo representa el servidor de correo
    private MailServer server;
    // Este atributo representa la dirección de correo del usuario que usa ese cliente
    private String user;

    /**
     * Constructor para objetos de la clase MailClient que permite crear un objeto MailClient inicializando sus atributos 
     * por medio de parámetros que serán el nombre del servidor(tipo MailServer) y el nombre del usuario(tipo String).
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }
    
    /**
     * Este método recupera del servidor el correo del ususario.
     */ 
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    /**
     * Return how many mail items are waiting for a user.
     * @param who The user to check for.
     * @return How many items are waiting.
     */
    public int howManyMailItems()
    {
        return server.howManyMailItems(user);
    }
    
    /**
     * Método printNextMailItem que recupera del servidor el siguiente correo que tenga el usuario e imprime por 
     * pantalla los datos de dicho mensaje. Si no hay ningun mensaje, muestra un mensaje por pantalla informando de ello.
     */
    public void printNextMailItem()
    {
        MailItem email = getNextMailItem();
        if (email != null) {
            email.print();
        }
        else {
            System.out.println("No tiene ningún mensaje nuevo.");
        }
    }
    
    /**
     * Método sendMailItem que recibe 2 parámetros (un String indicando para quién es el mensaje y otro 
     * String indicando el contenido del mensaje), 
     * crea un email (objeto MailItem) basándose en la información de dichos parámetros y lo envía al servidor asociado a ese cliente.
     */
    public void sendMailItem(String para, String asunto, String mensaje)
    {
        MailItem email = new MailItem(user, para, asunto, mensaje);
        server.post(email);
    }
}
