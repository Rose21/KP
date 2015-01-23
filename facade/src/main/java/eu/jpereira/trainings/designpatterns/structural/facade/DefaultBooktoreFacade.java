package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;

public class DefaultBooktoreFacade implements BookstoreFacade {

	private BookDBService bookService;
	private CustomerDBService customerService;
	private OrderingService orderingService;
	private WharehouseService warehouseService;
	private CustomerNotificationService customerNotificationService;
	
	
	@Override
	public void placeOrder(String customerId, String isbn) {
		// TODO Auto-generated method stub
		Customer customer = customerService.findCustomerById(customerId);
		Book book = bookService.findBookByISBN(isbn);
		Order order = orderingService.createOrder(customer, book);
		
		customerNotificationService.notifyClient(order);
		customerNotificationService.notifyClient(warehouseService.dispatch(order));
			
	}
	
	public void setBookService(BookDBService bookService) {
		this.bookService = bookService;
	}

	public void setCustomerService(CustomerDBService customerService) {
		this.customerService = customerService;
	}
	
	public void setOrderingService(OrderingService orderingService) {
		this.orderingService = orderingService;
	}
	
	public void setWarehouseService(WharehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}
	
	public void setCustomerNotificationService(CustomerNotificationService customerNotificationService) {
		this.customerNotificationService = customerNotificationService;
	}
}
