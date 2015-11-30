public class Test
{
    /** 
     * Metodo que prueba el segundo apartado de la actividad
     * 0170.
     */
    public void test1()
    {
        MailServer gmail = new MailServer();
        MailClient cliente1 = new MailClient(gmail, "pepe@gmail.com");
        MailClient cliente2 = new MailClient(gmail, "maria@gmail.com");
        
        
        System.out.println("Probando cuando no hemos mandando ningun correo");
        System.out.println("##########################");
        cliente2.getNextMailItemAndSendAutomaticRespond();
        cliente1.printNextMailItem();
        System.out.println();
        System.out.println();
        System.out.println("Probando que funciona el metodo getNextMailItemAndSendAutomaticRespond");
        System.out.println("##########################");
        cliente1.sendMailItem("maria@gmail.com","Hola","Hola Maria");
        cliente2.getNextMailItemAndSendAutomaticRespond();
        cliente1.printNextMailItem();
        
       
    }
    
    public void test2()
    {
        System.out.println("Probando que funciona el metodo lastMensaje");
        System.out.println("##########################");
        MailServer gmail = new MailServer();
        MailClient cliente1 = new MailClient(gmail, "pepe@gmail.com");
        MailClient cliente2 = new MailClient(gmail, "maria@gmail.com");
        
        System.out.println("Si no hemos recibido ningún mensaje antes");
        System.out.println("##########################");
        cliente2.lastMensaje();
        System.out.println();
        
        System.out.println();
        System.out.println("Cuando si tenemos o se nos ha enviado un mensaje antes");
        System.out.println("##########################");
        cliente1.sendMailItem("maria@gmail.com","Hola","Hola Maria");
        cliente2.lastMensaje();
    }
}