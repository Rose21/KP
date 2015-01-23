package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;

public class JSONReportElementsFactory implements IReportElementsFactory{

	@Override
	public ReportBody createBody() {
		// TODO Auto-generated method stub
		return new JSONReportBody();
	}

	@Override
	public ReportHeader createHeader() {
		// TODO Auto-generated method stub
		return new JSONReportHeader();
	}

	@Override
	public ReportFooter createFooter() {
		// TODO Auto-generated method stub
		return new JSONReportFooter();
	}

}
