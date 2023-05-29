
package utils;




import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Utils {
    

    
    public String formatarDataHora(LocalDateTime dataHora){

            DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return dataHora.format(formatoBrasileiro);
    }
     public String formatarDataHoraSQL(LocalDateTime dataHora){

            DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return dataHora.format(formatoBrasileiro);
    }
     
    public LocalDateTime tolocaldate(String s){
            DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDateTime dateTime = LocalDate.parse(s, parser).atStartOfDay();
        return dateTime;
    }
    
    
    public String formatarMoeda(double x) {
            return String.format("%.2f", x);
    }
    
    
    
}
