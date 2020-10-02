
package Banco.Core.Domain;

import java.util.Date;




public interface IServicioFinanciero {

    /**
     *
     * @param valor
     * @param ciudad
     * @param fecha
     * @return 
     */
    
    abstract String Consignar(double valorConsignacion, String ciudad, Date fecha);
    abstract String retirar(double valorRetirar,  String ciudad, Date fecha);
}
