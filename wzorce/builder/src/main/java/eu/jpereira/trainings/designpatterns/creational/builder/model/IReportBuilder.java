package eu.jpereira.trainings.designpatterns.creational.builder.model;

public interface IReportBuilder {
	void initialize();
	Report getReport();
	void addCustomerInfo(SaleEntry e);
	void addItemInfo(SaleEntry e);
}
