package eu.jpereira.trainings.designpatterns.creational.builder.json;

import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.model.IReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

public class JSONReportBuilder implements IReportBuilder {
	
	private JSONReportBody reportBody;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		reportBody = new JSONReportBody();
		
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
		reportBody.addContent("sale:{customer:{");
		reportBody.addContent("name:\"");
		reportBody.addContent(saleEntry.getCustomer().getName());
		reportBody.addContent("\",phone:\"");
		reportBody.addContent(saleEntry.getCustomer().getPhone());
		reportBody.addContent("\"}");
		
	}

	@Override
	public void addItemInfo(SaleEntry saleEntry) {
		// TODO Auto-generated method stub
		reportBody.addContent(",items:[");
		Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
		while ( it.hasNext() ) {
			SoldItem item = it.next();
			reportBody.addContent("{name:\"");
			reportBody.addContent(item.getName());
			reportBody.addContent("\",quantity:");
			reportBody.addContent(String.valueOf(item.getQuantity()));
			reportBody.addContent(",price:");
			reportBody.addContent(String.valueOf(item.getUnitPrice()));
			reportBody.addContent("}");
			if ( it.hasNext() ) {
				reportBody.addContent(",");
			}
			
		}
		reportBody.addContent("]}");
		
	}

}
