/**
 * La clase MailItem:

  *Disponga 3 atributos de tipo String llamados from, to y message.
  *Disponga de un constructor que permita crear un objeto MailItem inicializando sus atributos por medio de parámetros.
  *Disponga de 3 métodos getter, uno para cada uno de sus atributos
  *Disponga de un método print que no tenga parámetros y que muestre por pantalla los atributos del objeto.




 * Write a description of class MailItem here.
 * 
 * @author (Miguel) 
 * @version (una version personal)
 */
public class MailItem
{
    // Atributos para mi correo remitente
    private String from;
    // Atributo para mi correo destinatario
    private String to;
    // Atributo para el mensaje
    private String message;

    /**
     *  Constructor que permite crear un objeto MailItem inicializando sus atributos por medio de parámetros.
     */
    public MailItem(String fromA, String toA, String messageA)
    {
        from = fromA;
        to = toA;
        message = messageA;
    }
    
    /**
     * Metodo que nos devuelve el remitente
     */
    public String getFrom()
    {
        return from;
    }
    
    /**
     * Metodo que nos devuelve el destinatario
     */
    public String getTo()
    {
        return to;
    }
    
    /**
     * Metodo que nos devuelve el mensaje
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     *  Método print que muestra por pantalla el mensaje con el remitente y el destinatario.
     */
    
    public void print()
    {
        System.out.println("De: " + from);
        System.out.println("Para: " + to);
        System.out.println("Mensage: " + message);
    }
}
