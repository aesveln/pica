package co.com.touresbalon.middleware.beans;

public class TransformMesaggesFlF {


    public String transformarArchivoFacturas(String msg) {
        StringBuilder rtn = new StringBuilder();

        System.out.println(msg);
        rtn.append("<invoices>\n");

        rtn.append("<tipoDocumento>" + (msg.substring(3, 6)).trim() + "</tipoDocumento>\n");
        rtn.append("<numeroDocumento>" + msg.substring(6, 21).trim() + "</numeroDocumento>\n");
        rtn.append("<referencia>" + msg.substring(22, 41).trim() + "</referencia>\n");
        rtn.append("<monto>" + msg.substring(42, 56).trim() + "</monto>\n");
        rtn.append("<fecha>" + msg.substring(57, 64).trim() + "</fecha>\n");
        rtn.append("<descripcion>" + msg.substring(65, 114).trim() + "</descripcion>\n");
        rtn.append("<cancelacion>" + msg.substring(114, 115).trim() + "</cancelacion>\n");

        rtn.append("</invoices>\n");
        System.out.println(rtn);
        return rtn.toString();
    }

    public String transformarArchivoRecibos(String msg) {
        StringBuilder rtn = new StringBuilder();

        System.out.println(msg);
        rtn.append("<receipts>\n");
        rtn.append("<tipoDocumento>" + (msg.substring(3, 6)).trim() + "</tipoDocumento>\n");
        rtn.append("<numeroDocumento>" + msg.substring(6, 21).trim() + "</numeroDocumento>\n");
        rtn.append("<referencia>" + msg.substring(22, 41).trim() + "</referencia>\n");
        rtn.append("<monto>" + msg.substring(42, 56).trim() + "</monto>\n");
        rtn.append("<fecha>" + msg.substring(57, 64).trim() + "</fecha>\n");
        rtn.append("<descripcion>" + msg.substring(65, 114).trim() + "</descripcion>\n");
        rtn.append("<cancelacion>" + msg.substring(114, 115).trim() + "</cancelacion>\n");
        rtn.append("</receipts>\n");
        System.out.println(rtn);
        return rtn.toString();
    }

    public String transformarArchivoCuentas(String msg) {
        StringBuilder rtn = new StringBuilder();

        System.out.println(msg);
        rtn.append("<bills>\n");
        rtn.append("<tipoDocumento>" + (msg.substring(3, 6)).trim() + "</tipoDocumento>\n");
        rtn.append("<numeroDocumento>" + msg.substring(6, 21).trim() + "</numeroDocumento>\n");
        rtn.append("<referencia>" + msg.substring(22, 41).trim() + "</referencia>\n");
        rtn.append("<monto>" + msg.substring(42, 56).trim() + "</monto>\n");
        rtn.append("<fecha>" + msg.substring(57, 64).trim() + "</fecha>\n");
        rtn.append("<descripcion>" + msg.substring(65, 114).trim() + "</descripcion>\n");
        rtn.append("<cancelacion>" + msg.substring(114, 115).trim() + "</cancelacion>\n");
        rtn.append("</bills>\n");
        System.out.println(rtn);
        return rtn.toString();
    }
}
