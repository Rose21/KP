package eu.jpereira.trainings.designpatterns.creational.builder.xml;

import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.model.IReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

public class XMLReportBuilder implements IReportBuilder {

	XMLReportBody reportBody;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		reportBody = new XMLReportBody();
	}

	@Override
	public Report getReport() {
		// TODO Auto-generated method stub
		Report report = new Report();
		report.setReportBody(reportBody);
		reportBody = null;
		return report;
	}

	@Override
	public void addCustomerInfo(SaleEntry saleEntry) {
		// TODO Auto-generated method stub
		reportBody.putContent("<sale><customer><name>");
		reportBody.putContent(saleEntry.getCustomer().getName());
		reportBody.putContent("</name><phone>");
		reportBody.putContent(saleEntry.getCustomer().getPhone());
		reportBody.putContent("</phone></customer>");
		
	}

	@Override
	public void addItemInfo(SaleEntry saleEntry) {
		// TODO Auto-generated method stub
		reportBody.putContent("<items>");
		
		Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
		while ( it.hasNext() ) {
			SoldItem soldEntry= it.next();
			reportBody.putContent("<item><name>");
			reportBody.putContent(soldEntry.getName());
			reportBody.putContent("</name><quantity>");
			reportBody.putContent(soldEntry.getQuantity());
			reportBody.putContent("</quantity><price>");
			reportBody.putContent(soldEntry.getUnitPrice());
			reportBody.putContent("</price></item>");
		}
		reportBody.putContent("</items></sale>");
		
	}

}
