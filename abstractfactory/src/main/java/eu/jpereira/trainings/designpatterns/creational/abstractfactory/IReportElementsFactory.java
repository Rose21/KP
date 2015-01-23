package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public interface IReportElementsFactory {
	ReportBody createBody();
	ReportHeader createHeader();
	ReportFooter createFooter();

}
