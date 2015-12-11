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
    // Atributo donde se almacena el último mensaje
    private MailItem buzon;
    // Este atributo nos va a almecenar si el correo tiene spam
    private boolean spam;

    /**
     * Constructor para objetos de la clase MailClient que permite crear un objeto MailClient inicializando sus atributos 
     * por medio de parámetros que serán el nombre del servidor(tipo MailServer) y el nombre del usuario(tipo String).
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        buzon = null;
        spam = false;
    }

    /**
     * Este método recupera del servidor el correo del ususario.
     */ 
    public MailItem getNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        if (email != null) {
            if (email.getMessage().contains("trabajo")) {
                spam = false;
                buzon = email;
            }
            else if (email.getMessage().contains("regalo") || email.getMessage().contains("promocion")) {
                spam = true;
                email = null;
            }
            else  {
                spam = false;
                buzon = email;
            }
        }
        return email;
    }

    /**
     * Este método imprime por pantalla el número de mensajes que tiene el usuario en el servidor sin leer
     */
    public void howManyMailItems()
    {
        System.out.println("Correos sin leer en el servidor: " + server.howManyMailItems(user));
    }

    /**
     * Este método obtiene del servidor un mensaje para el ususario y envía una respuesta automática
     */
    public void getNextMailItemAndSendAutomaticRespond()
    {
        MailItem email = getNextMailItem();
        if (email != null) {
            sendMailItem(email.getFrom(),"RE: " + email.getSubject() , "Estoy en la oficina.\n" +  email.getMessage());
        }
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
        else if (spam == true) {
            System.out.println("Este correo contiene spam");
        }
        else {
            System.out.println("No tienes ningún mensaje");
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

    /**
     * Este método nos imprime por pantalla el último mensaje recibido
     */
    public void lastMensaje()
    {
        getNextMailItem();
        if (buzon != null) {
            buzon.print();
        }
        else {
            System.out.println("No ha recibido ningún mensaje aún");
        }
    }
} 
