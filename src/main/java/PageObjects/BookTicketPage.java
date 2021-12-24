package PageObjects;

import Constant.Constant;

public class BookTicketPage extends GeneralPage {
    public BookTicketPage bookTicket(){
        Constant.WEBDRIVER.navigate().to(Constant.BOOK_TICKET_PAGE);
        return this;
    }
}
