package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

public class XMLReportElementsFactory implements IReportElementsFactory{

	@Override
	public ReportBody createBody() {
		// TODO Auto-generated method stub
		return new XMLReportBody();
	}

	@Override
	public ReportHeader createHeader() {
		// TODO Auto-generated method stub
		return new XMLReportHeader();
	}

	@Override
	public ReportFooter createFooter() {
		// TODO Auto-generated method stub
		return new XMLReportFooter();
	}

}
