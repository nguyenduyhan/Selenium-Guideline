package PageObjects;

import Constant.Constant;

public class BookTicketPage extends GeneralPage {
    public BookTicketPage open(){
        Constant.WEBDRIVER.navigate().to(Constant.BOOK_TICKET_PAGE);
        return this;
    }
}
