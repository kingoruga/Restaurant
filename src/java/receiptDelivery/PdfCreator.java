package receiptDelivery;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfCreator {

    public void generatePdfReceipt(List<String> order) throws IOException {
        String DEST = "C:/Receipts/receipt.pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        createPdf(DEST, order);
    }

    private void createPdf(String dest, List<String> order) throws IOException {

        Document document = null;
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            document = new Document(pdf);
            document.add(new Paragraph("Receipt"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Delivery Address:"));
            document.add(new Paragraph(order.get(0)));
            document.add(new Paragraph(order.get(1)));
            document.add(new Paragraph(order.get(2)));
            document.add(new Paragraph(order.get(3)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Price:"));
            document.add(new Paragraph(order.get(4)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Payment method:"));
            document.add(new Paragraph(order.get(5)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Delivery Date and time:"));
            document.add(new Paragraph(order.get(6) + " " + order.get(7)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Food item:"));
            document.add(new Paragraph(order.get(8)));
            document.close();
            
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
