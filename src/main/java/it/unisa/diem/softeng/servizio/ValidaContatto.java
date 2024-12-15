package it.unisa.diem.softeng.servizio;

import it.unisa.diem.softeng.modello.Contatto;

/**
 * @brief La classe ValidaContatto implementa un metodo di validazione di un contatto.
 * @see InterfacciaValidaContatto
 * @see it.unisa.diem.softeng.modello::Contatto
*/
public class ValidaContatto implements InterfacciaValidaContatto  {
    
    /**
      * @copydoc InterfacciaValidaContatto::valida
    */
    @Override
    public boolean valida(Contatto contatto) {
        int lunghezzaNumero = 10;
        
        if(contatto == null)
            throw new IllegalArgumentException("Contatto uguale a 'null'");
        
        if(contatto.getNome().equals("") && contatto.getCognome().equals(""))
            return false;
        
        // Verifica se i numeri di telefono hanno dieci cifre
        if(!contatto.getNumeriTelefono().isEmpty())
            for(String s : contatto.getNumeriTelefono()) {
                if(!s.isEmpty() && s.length() != lunghezzaNumero)
                    return false;
                for(int i = 0; i < s.length(); i++)
                    if(!Character.isDigit(s.charAt(i)))
                        return false;
            }
        
        // Primo pattern: nome utente senza '.'
        String pattern1 = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
        // Secondo pattern: nome utente con '.'
        String pattern2 = "^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
        
        // Verifica se le e-mail sono rispondenti a uno tra i pattern proposti
        if(!contatto.getEmail().isEmpty())
            for(String s : contatto.getEmail())
                if (!s.isEmpty() && !s.matches(pattern1) && !s.matches(pattern2))
                    return false;
            
        return true;
    }
    
}
